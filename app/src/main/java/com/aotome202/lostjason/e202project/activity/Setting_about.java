package com.aotome202.lostjason.e202project.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.aotome202.lostjason.e202project.R;
import com.aotome202.lostjason.e202project.assist.ActivityUtils;

/**
 * Created by LostJason on 2017/4/11.
 */

public class Setting_about extends BaseActivity  {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Setting_about.this.setContentView(R.layout.fragment_setting_about);
        inittoolbar();

    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
    }


}
