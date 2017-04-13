package com.aotome202.lostjason.e202project.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.aotome202.lostjason.e202project.R;
import com.aotome202.lostjason.e202project.assist.ActivityUtils;
import com.aotome202.lostjason.e202project.assist.Logshow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by LostJason on 2017/4/11.
 */

public class Setting_Device_Activity extends BaseActivity  {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_setting_device);
        inittoolbar();

        LinearLayout viewGroup = (LinearLayout) findViewById(R.id.joineee);
       // viewGroup.setClickable(true);
          viewGroup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ActivityUtils.nextActivity(Setting_Device_Activity.this,Setting_Device_Sub_Activity.class);
        }
    });

    }


  /*  public void onClickt(View v){


    }*/


    @Override
    protected void onDestroy() {

        super.onDestroy();
    }


}
