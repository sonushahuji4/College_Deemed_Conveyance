package com.deemedconveyance.deemconveyanceversionone.SharedPreferenceManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


import com.deemedconveyance.deemconveyanceversionone.Activity.Login;

import java.util.HashMap;

import static com.deemedconveyance.deemconveyanceversionone.Constant.Constants.path;

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "user_details";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String MOBILE = "contactNo";
    public static final String EMAIL ="email";
    public static final String FULLNAME ="fullname";
    public static final String PPROFILEIMG ="profileimg";
    // Email address (make variable public to access from outside)
    //public static final String ACCESS_KEY = "accessKey";

    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String mobile, String email, String fullname,String profileimg) {//String profileimg,String accessKey){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing user details in pref
        editor.putString(MOBILE, mobile);
        editor.putString(EMAIL, email);
        editor.putString(FULLNAME, fullname);
        editor.putString(PPROFILEIMG, path+profileimg);
        //editor.putString(ACCESS_KEY, accessKey);


        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public boolean checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, Login.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
            return  false;
        }
        else {
            return true;
        }

    }



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // GET user Details
        user.put(MOBILE, pref.getString(MOBILE, null));
        user.put(EMAIL, pref.getString(EMAIL, null));
        user.put(FULLNAME, pref.getString(FULLNAME, null));
        user.put(PPROFILEIMG, pref.getString(path+PPROFILEIMG, null));
        //user.put(ACCESS_KEY, pref.getString(ACCESS_KEY, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, Login.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void createLoginSession(String photo)
    {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(PPROFILEIMG, photo);


        // commit changes
        editor.commit();
    }
}