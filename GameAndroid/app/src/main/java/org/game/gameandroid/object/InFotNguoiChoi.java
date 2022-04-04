package org.game.gameandroid.object;

import android.content.Context;
import android.content.SharedPreferences;

public class InFotNguoiChoi {
    public float tienNguoiChoi = 10.0f;

    private String tenFileLuuTru = "gameInFor";
    private Context ct;

    public InFotNguoiChoi(Context ct) {
        this.ct = ct;
    }

    public void getData(){
        SharedPreferences preferences = ct.getSharedPreferences(tenFileLuuTru, Context.MODE_PRIVATE);
        tienNguoiChoi = preferences.getFloat("tienNguoiChoi", 100.0f);
    }
    public void setData(){
        SharedPreferences preferences = ct.getSharedPreferences(tenFileLuuTru, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putFloat("tienNguoiChoi", tienNguoiChoi);
        editor.apply();
    }
}
