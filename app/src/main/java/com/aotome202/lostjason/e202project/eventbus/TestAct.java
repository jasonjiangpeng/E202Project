package com.aotome202.lostjason.e202project.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.aotome202.lostjason.e202project.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by LostJason on 2017/4/11.
 */

public class TestAct extends Activity {
    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
TextView tv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        tv1= (TextView) findViewById(R.id.tv1);
        MessageEvent messageEvent =new MessageEvent("jas",2561);
        EventBus.getDefault().register(this);
        EventBus.getDefault().post(messageEvent);
     //   Looper.prepare();
        new Thread(new Runnable() {
            @Override
            public void run() {
                 Looper.prepare();
                Handler  ha=new Handler(){

                    @Override
                    public void handleMessage(Message msg) {
                        tv1.setText("222222222222222222222");
                    }
                };
                ha.sendEmptyMessage(0);
                Looper.loop();
            }
        }).start();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void aVoidData(MessageEvent messageEvent){


    }
    public void onClickaa(View view){
        tv1.setText("333333333333333333333");
    }
}
