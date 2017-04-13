package com.aotome202.lostjason.e202project.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import android.os.SystemClock;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aotome202.lostjason.e202project.R;
import com.aotome202.lostjason.e202project.assist.Logshow;
import com.aotome202.lostjason.e202project.assist.My_ActivityManager;
import com.aotome202.lostjason.e202project.assist.ShowDialog;
import com.aotome202.lostjason.e202project.fragment.EtcPageFragment;
import com.aotome202.lostjason.e202project.fragment.HomePageFragment;
import com.aotome202.lostjason.e202project.fragment.MessagePageFragment;
import com.aotome202.lostjason.e202project.fragment.SettingPageFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by LostJason on 2017/4/10.
 */

public class BootActvity extends BaseActivity implements View.OnClickListener, BaseActivity.StatusListen {
    TextView homePage, etcPage, settingPage, messagePage;
    List<TextView> listtext;
    Fragment showFragment;
    LinearLayout maintital;
    TextView tital;
    String[] titalvalue = {"WIFI热点", "ETC", "消息", "设置"};
    int[][] bottomimg = {{R.drawable.home_icon, R.drawable.home_icon_press}, {R.drawable.etc_icon, R.drawable.etc_icon_press},
            {R.drawable.message_icon, R.drawable.message_icon_press}, {R.drawable.set_icon, R.drawable.set_icon_press}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_main);

        //  EventBus.getDefault().post();
        initData();
        initUI();
        initParma();
    }

    @Override
    public void onBackPressed() {

        ShowDialog.showDiglog(My_ActivityManager.getCurrentAcitvity(), "退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                My_ActivityManager.exit();
            }
        });
        //   super.onBackPressed();
    }

    private void initParma() {
        tital.setText(titalvalue[0]);
        statusListen.changestatus(0);
    }

    private void initData() {
        //   ButterKnife.bind(this);
        switchFragment(new HomePageFragment());
    }

    private void initUI() {
        homePage = (TextView) findViewById(R.id.homePage);
        tital = (TextView) findViewById(R.id.tital);
        etcPage = (TextView) findViewById(R.id.etcPage);
        settingPage = (TextView) findViewById(R.id.settingPage);
        messagePage = (TextView) findViewById(R.id.messagePage);
        maintital = (LinearLayout) findViewById(R.id.maintital);
        switchFragment(new HomePageFragment());
        homePage.setOnClickListener(this);
        etcPage.setOnClickListener(this);
        settingPage.setOnClickListener(this);
        messagePage.setOnClickListener(this);
        listtext = new ArrayList<>();
        listtext.add(homePage);
        listtext.add(etcPage);
        listtext.add(messagePage);
        listtext.add(settingPage);


    }

    FragmentTransaction fragmentTransaction;
    Fragment m_frament;

    public void switchFragment(Fragment fragment) {


        if (fragment == null) {
            return;
        }
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.showfragment, fragment);
        fragmentTransaction.commit();
        m_frament = fragment;

    }

    int isStatus = 0;

    @Override
    public void onClick(View v) {
        Fragment f = null;
        switch (v.getId()) {
            case R.id.homePage:
                isStatus = 0;
                f = new HomePageFragment();
                break;
            case R.id.etcPage:
                isStatus = 1;
                f = new EtcPageFragment();
                break;
            case R.id.messagePage:
                isStatus = 2;
                f = new MessagePageFragment();
                break;
            case R.id.settingPage:
                isStatus = 3;
                f = new SettingPageFragment();
                break;
        }


        switchFragment(f);
        statusListen.changestatus(isStatus);
    }

    @Override
    public void changestatus(int value) {
        Logshow.logShow("Sdkint" + value);
        if (value==1){
            maintital.setVisibility(View.GONE);
        }else {
            maintital.setVisibility(View.VISIBLE);
        }
        tital.setText(titalvalue[value]);
       // if (value==)
        for (int a = 0; a < listtext.size(); a++) {

            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
                if (a ==value ) {
                    Drawable drawable = this.getResources().getDrawable(bottomimg[a][1], null);
                    listtext.get(a).setTextColor(getResources().getColor(R.color.lanse, null));
                    listtext.get(a).setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawable, null, null);

                } else {
                    Drawable drawable = this.getResources().getDrawable(bottomimg[a][0], null);
                    listtext.get(a).setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawable, null, null);
                    listtext.get(a).setTextColor(getResources().getColor(R.color.black, null));
                }
            } else {
                if (a == value) {
                    listtext.get(a).setTextColor(getResources().getColor(R.color.lanse));
                    Drawable drawable = this.getResources().getDrawable(bottomimg[a][1]);
                    listtext.get(a).setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawable, null, null);

                } else {
                    listtext.get(a).setTextColor(getResources().getColor(R.color.black));
                    Drawable drawable = this.getResources().getDrawable(bottomimg[a][0]);
                    listtext.get(a).setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawable, null, null);
                }
            }


        }

    }

    @Override
    protected void onDestroy() {
        listtext.clear();
        super.onDestroy();
    }

//ChangeStatus c;

}
