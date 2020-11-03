package com.abhijit.mvvmdemofirst.domain.pref;


import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import static android.content.Context.MODE_PRIVATE;

@Singleton
public class SharedPref {

    private static String PREF_NAME = "Elaachi";
    private String ISLOGIN = "ISLOGIN";
    private String USER_NAME = "USER_NAME";
    private String USER_EMAIL = "USER_EMAIL";
    private String UID = "UID";
    private String PHONE = "PHONE";
    private String PROFILE_IMAGE = "PROFILE_IMAGE";
    private String TOKEN = "TOKEN";

    private Context mContext;

    @Inject
    public SharedPref(Context mContext) {
        this.mContext = mContext;
    }

    public void setLogin(String isLogin) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(ISLOGIN, isLogin);
        editor.apply();
    }

    public String getLogin() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getString(ISLOGIN, "false");
    }

    public void setUserName(String userName) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(USER_NAME, userName);
        editor.apply();
    }

    public String getUserName() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getString(USER_NAME, "");
    }

    public void setUserEmail(String email) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(USER_EMAIL, email);
        editor.apply();
    }

    public String getUserEmail() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getString(USER_EMAIL, "");
    }

    public void setUID(String uid) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(UID, uid);
        editor.apply();
    }

    public String getUID() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getString(UID, "");
    }

    public void setUserPhone(String phone) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(PHONE, phone);
        editor.apply();
    }

    public String getUserPhone() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getString(PHONE, "");
    }

    public void setUserProfile(String profile) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(PROFILE_IMAGE, profile);
        editor.apply();
    }

    public String getUserProfile() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getString(PROFILE_IMAGE, "");
    }

    public void setToken(String token) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putString(TOKEN, token);
        editor.apply();
    }

    public String getToken() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getString(TOKEN, "");
    }

}