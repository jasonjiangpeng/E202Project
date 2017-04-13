package com.aotome202.lostjason.e202project.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.aotome202.lostjason.e202project.R;
import com.aotome202.lostjason.e202project.assist.Logshow;
import com.aotome202.lostjason.e202project.assist.UiUtils;
import com.aotome202.lostjason.e202project.view.CycelView;

/**
 * Created by LostJason on 2017/4/11.
 */

public class Test_Act extends Activity {
    TextView  tv4,tv1;
    ViewStub viewStub;
    boolean isrun=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        tv4= (TextView) findViewById(R.id.tv4);
        tv1= (TextView) findViewById(R.id.tv1);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logshow.logShow("=========================="+ UiUtils.getScreenDensity(Test_Act.this));
                if (isrun){
                //    tv4.setSingleLine(false);
                    isrun=false;

                }else {
                    isrun=true;
                   // tv4.setSingleLine(false);
                }

                tv4.setSingleLine(isrun);
            }
        });
        tv4.setSingleLine(isrun);
        tv4.setEllipsize(TextUtils.TruncateAt.END);

      /*  viewStub =(ViewStub) findViewById(R.id.viewstub);
        viewStub.inflate();*/



      //   views = findViewById(R.id.switchview);


    }
    public void onClick(View view){
       // viewStub.setVisibility(View.GONE);
    /*    viewStub=null;
        if (viewStub==null){
            viewStub =(ViewStub) findViewById(R.id.viewstub);

            viewStub.inflate();
        }*/



    }
}
