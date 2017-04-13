package com.aotome202.lostjason.e202project.fragment;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aotome202.lostjason.e202project.R;
import com.aotome202.lostjason.e202project.activity.Device_Boot;
import com.aotome202.lostjason.e202project.activity.Setting_Device_Activity;
import com.aotome202.lostjason.e202project.activity.Setting_Model_Activity;
import com.aotome202.lostjason.e202project.activity.Setting_SSID;
import com.aotome202.lostjason.e202project.activity.Setting_about;
import com.aotome202.lostjason.e202project.assist.ActivityUtils;
import com.aotome202.lostjason.e202project.assist.My_ActivityManager;
import com.aotome202.lostjason.e202project.assist.ShowDialog;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LostJason on 2017/4/10.
 */

public class SettingPageFragment extends Fragment implements View.OnClickListener {
  LinearLayout  manager,ssid,about,model,reset;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
 View s=inflater.inflate(R.layout.fragment_setting, container,false);
        manager= (LinearLayout) s.findViewById(R.id.manager);
        about= (LinearLayout) s.findViewById(R.id.about);
        ssid= (LinearLayout) s.findViewById(R.id.ssid);
        model= (LinearLayout) s.findViewById(R.id.model);
        reset= (LinearLayout) s.findViewById(R.id.reset);
        about.setOnClickListener(this);
        ssid.setOnClickListener(this);
        model.setOnClickListener(this);
        manager.setOnClickListener(this);
        reset.setOnClickListener(this);


        return s;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this.getActivity());
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View vs) {
        switch (vs.getId()){
            case R.id.about:
                ActivityUtils.nextActivity(Setting_about.class,"关于");
                break;
            case R.id.ssid:
                ActivityUtils.nextActivity(Setting_SSID.class,"修改SSID及密码");
                break;
            case R.id.manager:
                ActivityUtils.nextActivity(Setting_Device_Activity.class,"设备管理");
                break;
            case R.id.model:
                ActivityUtils.nextActivity(Setting_Model_Activity.class,"WIFI模式");
                break;
            case R.id.reset:
                ShowDialog.getpopupWindow(My_ActivityManager.getCurrentAcitvity(),dialog ).showAtLocation(vs, Gravity.BOTTOM,100,100);

                break;
        }
    }
    View.OnClickListener  dialog=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           String value= (String) v.getTag();
            if (value.equals("reset")){
                ShowDialog.showDiglog(getActivity(), getResources().getString(R.string.message1), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                          ActivityUtils.nextActivity(Device_Boot.class,1);
                    }
                });

            }else if (value.equals("close")){
                ShowDialog.showDiglog(getActivity(), getResources().getString(R.string.message2), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityUtils.nextActivity(Device_Boot.class,2);
                    }
                });

            }else if (value.equals("cancel")){

                 ShowDialog.closepopupWindow();
            }else {
                return;
            }

        }
    };
}
