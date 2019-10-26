package com.deemedconveyance.deemconveyanceversionone.SharedPreferenceManager;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager
{
    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME="sharepre";
    private static final String KEY_MOBILE="mobile";
    private static final String KEY_EMAIL="emial";
    private static final String KEY_FULLNAME="fullname";
    private static final String KEY_PPROFILEIMG="profileimg";
    //private static final String KEY_ACCESS_KEY="accesskey";
    private static final String KEY_USER_ID="userid";

    private SharedPrefManager(Context context)
    {
        mCtx= context;
    }

    public static synchronized  SharedPrefManager getmInstance(Context context)
    {
        if(mInstance == null)
        {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(int id,String mobile,String email,String fullname,String profileimg)
    {
        SharedPreferences sharedPreferences= mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putInt(KEY_USER_ID,id);
        editor.putString(KEY_MOBILE,mobile);
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_FULLNAME,fullname);
        editor.putString(KEY_PPROFILEIMG,profileimg);
        editor.apply();
        return true;
    }

    public boolean isLoggedIn()
    {
        SharedPreferences sharedPreferences= mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_MOBILE,null)!=null)
        {
            return true;
        }
        return false;
    }
    public boolean logout()
    {
        SharedPreferences sharedPreferences= mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}

