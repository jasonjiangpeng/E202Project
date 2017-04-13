package com.aotome202.lostjason.e202project.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.aotome202.lostjason.e202project.R;

/**
 * Created by LostJason on 2017/4/11.
 */

public class Setting_SSID extends BaseActivity  {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_setting_ssid);
        inittoolbar();

    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
    }


}
