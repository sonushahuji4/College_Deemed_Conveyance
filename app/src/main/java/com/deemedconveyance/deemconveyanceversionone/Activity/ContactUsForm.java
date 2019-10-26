package com.deemedconveyance.deemconveyanceversionone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.deemedconveyance.deemconveyanceversionone.R;
import com.deemedconveyance.deemconveyanceversionone.Singleton.MySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.deemedconveyance.deemconveyanceversionone.Constant.Constants.URL_Request_ContactUs;
import static com.deemedconveyance.deemconveyanceversionone.Constant.Constants.URL_Request_Registeration;

public class ContactUsForm extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener
{
    EditText name,surname,email,mobile,societyname,address,pincode,noofmembers;
    Spinner country_s,state,city;
    Button form_submit;
    AlertDialog.Builder builder;
    private ProgressDialog progressDialog;
    String country_selected,state_selected,city_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_form);


        builder = new AlertDialog.Builder(ContactUsForm.this);
        progressDialog = new ProgressDialog(ContactUsForm.this);

        name=(EditText) findViewById(R.id.name);
        surname=(EditText) findViewById(R.id.surname);
        email=(EditText) findViewById(R.id.email);
        mobile=(EditText) findViewById(R.id.mobile);
        societyname=(EditText) findViewById(R.id.societyname);
        address=(EditText) findViewById(R.id.address);
        pincode=(EditText) findViewById(R.id.pincode);
        noofmembers=(EditText) findViewById(R.id.noofmembers);

        country_s = (Spinner) findViewById(R.id.country_s);
        state = (Spinner) findViewById(R.id.state);
        city = (Spinner) findViewById(R.id.city);

        form_submit = (Button) findViewById(R.id.form_submit);

        progressDialog = new ProgressDialog(this);

        form_submit.setOnClickListener(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.country,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country_s.setAdapter(adapter);
        country_s.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> stateadapter = ArrayAdapter.createFromResource(this,R.array.state,android.R.layout.simple_spinner_dropdown_item);
        stateadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(stateadapter);
        state.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> cityadapter = ArrayAdapter.createFromResource(this,R.array.city,android.R.layout.simple_spinner_dropdown_item);
        cityadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(cityadapter);
        city.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v)
    {
        final String firstname = name.getText().toString().trim();
        final String Surname = surname.getText().toString().trim();
        final String Email = email.getText().toString().trim();
        final String Mobile = mobile.getText().toString().trim();
        final String societyName = societyname.getText().toString().trim();
        final String Address = address.getText().toString().trim();
        final String pinCode = pincode.getText().toString().trim();
        final String members = noofmembers.getText().toString().trim();

        if(firstname.equals("") || Surname.equals("") || Email.equals("") || email.equals("") || Mobile.equals("") || societyName.equals("") || Address.equals("") || pinCode.equals("") || members.equals(""))
        {
            builder.setTitle("Parameter missing");
            builder.setMessage("Fill all the details");
            displayAlert("parametermissing");
        }
        else
        {
            StringRequest stringRequest = new StringRequest(Request.Method.POST,URL_Request_ContactUs,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response)
                        {


                            try
                            {
                                // JSONObject { "name":"Somya", "age":25, "car":null } ...getting data in this format
                                // JSONArray [ {"Ford"},{ "BMW"} "Fiat" ]

                                JSONObject jsonObject= new JSONObject(response);
                                String status = jsonObject.getString("status");
                                String message = jsonObject.getString("message");

                                progressDialog.setMessage("Please wait..");
                                progressDialog.show();

                                if(status.equals("true") && message.equals("successful"))
                                {
                                    JSONObject data = jsonObject.getJSONObject("data");
                                    progressDialog.dismiss();
                                    builder.setTitle("Successfull");
                                    builder.setMessage("You have successfully registered");
                                    displayAlert("successfull");

                                }
                                else
                                {
                                    progressDialog.dismiss();
                                    Toast.makeText(ContactUsForm.this,"error in josnobject format",Toast.LENGTH_LONG).show();
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
                            if (error instanceof NetworkError) {
                            } else if (error instanceof ServerError) {
                            } else if (error instanceof AuthFailureError) {
                            } else if (error instanceof ParseError) {
                            } else if (error instanceof NoConnectionError) {
                            } else if (error instanceof TimeoutError) {
                                Toast.makeText(getApplicationContext(),
                                        "Oops. Timeout error!",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError
                {
                    Map<String,String> param = new HashMap<>();

                    param.put("firstname",firstname);
                    param.put("surname",Surname);
                    param.put("email_id",Email);
                    param.put("mobile_no",Mobile);
                    param.put("society_name",societyName);
                    param.put("address", Address);
                    param.put("country", country_selected);
                    param.put("state",state_selected);
                    param.put("city", city_selected);
                    param.put("pincode",pinCode);
                    param.put("no_of_members", members);
                    return param;
                }
            };
            MySingleton.getInstance(ContactUsForm.this).addToRequestQueue(stringRequest);

        }
    }

    private void displayAlert(String input_error)
    {
        if(input_error =="successfull")
        {
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    name.setText("");
                    surname.setText("");
                    email.setText("");
                    mobile.setText("");
                    societyname.setText("");
                    address.setText("");
                    pincode.setText("");
                    noofmembers.setText("");

                    Intent intent = new Intent(ContactUsForm.this,MainActivity.class);
                    startActivity(intent);
                    //finish();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        if(input_error =="parametermissing")
        {
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {

                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if(parent.getId()==R.id.country_s)
        {
            country_selected=parent.getItemAtPosition(position).toString();
        }
        if(parent.getId()==R.id.state)
        {
            state_selected=parent.getItemAtPosition(position).toString();
        }
        if(parent.getId()==R.id.city)
        {
            city_selected=parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
