package com.aotome202.lostjason.e202project.apputils;

import android.content.Context;
import android.widget.Toast;

import com.example.lostjason.hitrepair.help.Logshow;

/**
 * Created by LostJason on 2017/4/11.
 */

public class Toasts {
    public static  boolean isshowtime=true;
 public    static long startime=0;
    public static  void isShow(Context context,String me){
        Logshow.logShow("time"+isshowtime);
        if (isshowtime){
            isshowtime=false;
            Toast.makeText(context,me, Toast.LENGTH_SHORT).show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    isshowtime=true;
                }
            }).start();
        }

    }
}