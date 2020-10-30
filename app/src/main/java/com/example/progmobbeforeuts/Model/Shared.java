package com.example.progmobbeforeuts.Model;

import android.content.Context;
import android.content.SharedPreferences;

public class Shared {
    private static Shared minst;
    private static Context mct;

    private static final String SHARD_PERFNAME= "preference";
    private static final String KEY_USERNAME= "nimnik";
    private static final String KEY_PASSWORD = "password";

    public Shared(Context context){
        mct = context;
    }

    public static synchronized Shared getInstans(Context context){
        if (minst==null){
            minst=new Shared(context);
        }
        return minst;
    }
    public String getUsername(){
        SharedPreferences sharedPreferences=mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME,null);
    }
    public String getUserPassword(){
        SharedPreferences sharedPreferences=mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PASSWORD,null);
    }
    public boolean userLogin(String name, String password){
        SharedPreferences sharedPreferences= mct.getSharedPreferences(SHARD_PERFNAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, name);
        editor.putString(KEY_PASSWORD, password);
        editor.commit();
        return true;
    }
    public boolean isLogin(){
        SharedPreferences sharedPreferences= mct.getSharedPreferences(SHARD_PERFNAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_USERNAME,null) !=null){
            return true;
        }
        return false;
    }
    public boolean logout(){
        SharedPreferences sharedPreferences=mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}
