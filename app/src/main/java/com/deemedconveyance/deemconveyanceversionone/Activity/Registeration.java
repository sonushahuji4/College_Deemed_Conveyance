package com.deemedconveyance.deemconveyanceversionone.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.deemedconveyance.deemconveyanceversionone.R;
import com.deemedconveyance.deemconveyanceversionone.SharedPreferenceManager.SessionManager;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.deemedconveyance.deemconveyanceversionone.Constant.Constants.URL_REGISTER;


public class Registeration extends AppCompatActivity {

    private Button btn_regisetr_user,changeimg;
    private ImageView flashScreenIconDemo;
    private EditText edit_firstname, edit_surname, edit_contact_number, edit_email_id, edit_password, edit_confirm_password;
    private RadioGroup gender_options;
    private RadioButton male, female, other;

    ImageView userPhoto;
    private Bitmap bitmap;
    boolean isGenderSelected;
    String stringGenderOptions;


    private ProgressDialog progressDialog;
    AlertDialog.Builder builder;

    // Session Manager Class
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        // Session Manager
        session = new SessionManager(getApplicationContext());

        // initializing Button
        btn_regisetr_user = (Button) findViewById(R.id.btn_regisetr_user);

        // initializing EditText
        edit_firstname = (EditText) findViewById(R.id.edit_firstname);
        edit_surname = (EditText) findViewById(R.id.edit_surname);
        edit_contact_number = (EditText) findViewById(R.id.edit_contact_number);
        edit_email_id = (EditText) findViewById(R.id.edit_email_id);
        edit_password = (EditText) findViewById(R.id.edit_password);
        edit_confirm_password = (EditText) findViewById(R.id.edit_confirm_password);

        // initializing Gender Option
        gender_options = (RadioGroup) findViewById(R.id.gender_options);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        other = (RadioButton) findViewById(R.id.other);

        userPhoto = (ImageView) findViewById(R.id.userPhoto);
        changeimg = (Button) findViewById(R.id.changeimg);

        progressDialog = new ProgressDialog(this);
        builder = new AlertDialog.Builder(Registeration.this);


//        userPhoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                chooseFile();
//            }
//        });
//        btn_regisetr_user.setOnClickListener(this);

        changeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile();
            }
        });

        chooseOptions();// for gender selection

        btn_regisetr_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register(getStringImage(bitmap));
            }
        });
    }

    private void chooseFile() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(intent, 1);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null){
            Uri filepath = data.getData();
            try{
                bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), filepath );
                userPhoto.setImageBitmap(bitmap);

            }
            catch (IOException e){
                e.printStackTrace();
            }

//            UploadPicture(email, getStringImage(bitmap));
        }
    }
    public String getStringImage(Bitmap bitmap) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] imageByteArray = byteArrayOutputStream.toByteArray();
        String encodedImage = Base64.encodeToString(imageByteArray, Base64.DEFAULT);

        return encodedImage;
    }

    private void chooseOptions() {
        gender_options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.male:
                        stringGenderOptions = "male";
                        isGenderSelected = true;
                        System.out.println("gender check" + stringGenderOptions);
                        //register_gender.setError(null);
                        break;

                    case R.id.female:
                        stringGenderOptions = "female";
                        isGenderSelected = true;
                        System.out.println("gender check" + stringGenderOptions);
                        break;

                    case R.id.other:
                        stringGenderOptions = "other";
                        isGenderSelected = true;
                        System.out.println("gender check" + stringGenderOptions);
                        //register_gender.setError(null);
                        break;
                }
            }
        });
    }

//    @Override
//    public void onClick(View v) {
//        if (v == btn_regisetr_user)
//        {
//            register();
//        }
////        if(v==loginlink)
////        {
////            startActivity(new Intent(RegisterationActivity.this,LoginActivity.class));
////            //finish();
////        }
//
//    }

    private void register(final String profile_photo) {
        final String firstname = edit_firstname.getText().toString().trim();
        final String surname = edit_surname.getText().toString().trim();
        final String mobile = edit_contact_number.getText().toString().trim();
        final String email = edit_email_id.getText().toString().trim();
        final String password = edit_password.getText().toString().trim();
        final String conf_password = edit_confirm_password.getText().toString().trim();
        //chooseOptions();// for gender selection

        if (firstname.equals("") || surname.equals("") || mobile.equals("") || email.equals("") || password.equals("") || conf_password.equals("")) {
            builder.setTitle("Parameter missing");
            builder.setMessage("Fill all the details");
            displayAlert("input_error");
        } else {
            if (!(password.equals(conf_password))) {
                builder.setTitle("Error");
                builder.setMessage("Passwords are not matching..");
                displayAlert("input_error");

            } else {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

//                                Intent intent = new Intent(RegisterationActivity.this,LoginActivity.class);
//                                startActivity(intent);
//                                finish();
                                try {
                                    // JSONObject { "name":"Somya", "age":25, "car":null } ...getting data in this format
                                    // JSONArray [ {"Ford"},{ "BMW"} "Fiat" ]

                                    JSONObject jsonObject = new JSONObject(response);
                                    String status = jsonObject.getString("status");
                                    String message = jsonObject.getString("message");
                                    JSONObject data = jsonObject.getJSONObject("data");

                                    if (status.equals("true") && message.equals("successful")) {
                                        Intent intent = new Intent(Registeration.this, Login.class);
                                        startActivity(intent);
                                        //finish();
                                    } else {
                                        Toast.makeText(Registeration.this, "error in josnobject format", Toast.LENGTH_LONG).show();
                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                System.out.println("checking for error in code" + error);
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
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> param = new HashMap<>();

                        param.put("firstname", firstname);
                        param.put("surname", surname);
                        param.put("contact_number", mobile);
                        param.put("email_id", email);
                        param.put("password", password);
                        param.put("gender", stringGenderOptions);
                        param.put("profile_picture", profile_photo);

                        return param;
                    }
                };
//                MySingleton.getInstance(RegisterationActivity.this).addToRequestQueue(stringRequest);
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);

            }
        }

    }

    private void displayAlert(String input_error) {
    }
}
