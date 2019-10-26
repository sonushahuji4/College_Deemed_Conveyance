package com.deemedconveyance.deemconveyanceversionone.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.deemedconveyance.deemconveyanceversionone.R;
import com.deemedconveyance.deemconveyanceversionone.SharedPreferenceManager.SessionManager;
import com.deemedconveyance.deemconveyanceversionone.Singleton.MySingleton;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

import static com.deemedconveyance.deemconveyanceversionone.Constant.Constants.URL_LOGIN;


public class Login extends AppCompatActivity implements View.OnClickListener
{

    private TextView linktoregisteration;
    private EditText edit_password,edit_mobile_number;
    private Button but_login;

    private ProgressDialog progressDialog;
    AlertDialog.Builder builder;

    // Session Manager Class
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Session Manager
        session = new SessionManager(getApplicationContext());

        progressDialog = new ProgressDialog(this);
        builder = new AlertDialog.Builder(Login.this);

        linktoregisteration = (TextView) findViewById(R.id.linktoregisteration);
        but_login = (Button) findViewById(R.id.but_login);

        edit_mobile_number=(EditText) findViewById(R.id.edit_mobile_number);
        edit_password=(EditText) findViewById(R.id.edit_password);

        but_login.setOnClickListener(this);
        linktoregisteration.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v == but_login)
        {
            login();
           // startActivity(new Intent(this, MainActivity.class));
            //finish();
        }

        if (v == linktoregisteration) {
            startActivity(new Intent(this, Registeration.class));
            finish();
        }
    }

    private void login()
    {
        final String mobile_number = edit_mobile_number.getText().toString().trim();
        final String password = edit_password.getText().toString().trim();

        if(mobile_number.equals("") || password.equals(""))
        {
            builder.setTitle("Parameter missing");
            builder.setMessage("Fill all the details");
            displayAlert("input_error");
        }
        else
        {
            StringRequest stringRequest = new StringRequest(Request.Method.POST,URL_LOGIN,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response)
                        {

                            try
                            {

                                JSONObject jsonObject= new JSONObject(response);
                                String status = jsonObject.getString("status");
                                String message = jsonObject.getString("message");


                                if(status.equals("true") && message.equals("successful"))
                                {
                                    JSONObject data = jsonObject.getJSONObject("data");

                                    String firstname = data.getString("firstname");
                                    String surname = data.getString("surname");
                                    String mobile = data.getString("contact_number");
                                    String email = data.getString("email_id");
                                    String profileimg = data.getString("user_profile_pic");

                                    session.createLoginSession(mobile,email,firstname+" "+surname,profileimg);
                                   Intent intent = new Intent(Login.this,MainActivity.class);
                                   startActivity(intent);
                                   finish();
                                }
                                else if(status.equals("false") && message.equals("unsuccessful"))
                                {
                                    builder.setTitle("Invalid");
                                    builder.setMessage("Username or Password incorrect");
                                    displayAlert("invalid");
                                    //Toast.makeText(Login.this,"error in josnobject format",Toast.LENGTH_LONG).show();
                                }


                            }
                            catch (JSONException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    },

                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            System.out.println("checking for error in code" +error);
                        }
                    })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError
                {
                    Map<String,String> param = new HashMap<>();

                    param.put("password",password);
                    param.put("contact_number",mobile_number);

                    return param;
                }
            };
                MySingleton.getInstance(Login.this).addToRequestQueue(stringRequest);
        }
    }

    private void displayAlert(String input_error)
    {

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {

                edit_mobile_number.setText("");
                edit_password.setText("");

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
