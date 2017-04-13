package com.aotome202.lostjason.e202project.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.aotome202.lostjason.e202project.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LostJason on 2017/4/11.
 */

public class Setting_Device_Sub_Activity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_setting_sub_device);


    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
