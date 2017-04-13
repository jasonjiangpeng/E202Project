package com.aotome202.lostjason.e202project.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aotome202.lostjason.e202project.R;

/**
 * Created by LostJason on 2017/4/11.
 */

public class Setting_Model_Activity extends BaseActivity implements View.OnClickListener {
    LinearLayout layout1,layout2;
    ImageView img1,img2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_setting_model);
        inittoolbar();
        layout1= (LinearLayout) findViewById(R.id.layout1);
        layout2= (LinearLayout) findViewById(R.id.layout2);
        img1= (ImageView) findViewById(R.id.img1);
        img2= (ImageView) findViewById(R.id.img2);
        img1.setVisibility(View.GONE);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
         if (v.getId()==R.id.layout1){
             img2.setVisibility(View.GONE);
             img1.setVisibility(View.VISIBLE);

         }else {
             img2.setVisibility(View.VISIBLE);
             img1.setVisibility(View.GONE);
         }
    }
}
