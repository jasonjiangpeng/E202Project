package com.aotome202.lostjason.e202project.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;


import com.aotome202.lostjason.e202project.R;

/**
 * Created by LostJason on 2017/4/12.
 */

public class Device_Boot extends BaseActivity {
    ImageView img;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_boot);
        img = (ImageView) findViewById(R.id.img);
        int getvalue=getIntent().getIntExtra("device_boot",1);
        if (getvalue==1){
               if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                   setImg(img,R.drawable.device_reset);
               }else {
               setBitmap(img,R.drawable.device_reset);
               }
        }else {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                setImg(img,R.drawable.device_close);
            }else {
                setBitmap(img,R.drawable.device_close);
            }
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setImg(ImageView img,int resId){
        img.setBackground(getDrawable(resId));
    }
    public void setBitmap(ImageView img,int resId){
        Bitmap  bitmap = BitmapFactory.decodeResource(getResources(),resId);
        img.setImageBitmap(bitmap);
        if (bitmap!=null&&!bitmap.isRecycled()){
            bitmap.recycle();
        }
    }
}
