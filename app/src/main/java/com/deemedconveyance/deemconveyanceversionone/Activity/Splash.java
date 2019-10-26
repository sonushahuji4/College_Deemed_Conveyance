package com.deemedconveyance.deemconveyanceversionone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.deemedconveyance.deemconveyanceversionone.R;
import com.deemedconveyance.deemconveyanceversionone.SharedPreferenceManager.SessionManager;

public class Splash extends AppCompatActivity {

    // Session Manager Class
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Session class instance
        session = new SessionManager(getApplicationContext());

        ImageView imageView = findViewById(R.id.flashScreenIconDemo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imageView.startAnimation(animation);


        Thread timer = new Thread(){

            @Override
            public void run() {

                try
                {
                    sleep(2000);

                    if(session.checkLogin())
                    {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                        super.run();

//                        Intent intent = new Intent(getApplicationContext(), HomeDashboard.class);
//                        startActivity(intent);
//                        finish();
//                        super.run();
                    }




                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                    //Toast.makeText(MainActivity.this,"Your Message", Toast.LENGTH_LONG).show();
                }

            }
        };
        timer.start();
    }
}
