package com.example.watercolor.object;

import android.content.Context;
import android.content.SharedPreferences;

public class StarGame {
    public int Startichluy=100;
    private String fileluutru="GameInfo";
    private Context ct;

    public StarGame(Context ct) {
        this.ct = ct;
    }

    public void getData(){
        SharedPreferences preferences = ct.getSharedPreferences(fileluutru,Context.MODE_PRIVATE);
        Startichluy = preferences.getInt("Startichluy", 100) ;

    }
    public void setData(){
         SharedPreferences preferences = ct.getSharedPreferences(fileluutru,Context.MODE_PRIVATE);
         SharedPreferences.Editor editor = preferences.edit();
         editor.putInt("Startichluy",Startichluy);
         editor.apply();
    }


}
