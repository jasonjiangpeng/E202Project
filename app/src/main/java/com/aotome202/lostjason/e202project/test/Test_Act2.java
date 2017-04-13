package com.aotome202.lostjason.e202project.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewStub;
import android.widget.TextView;

import com.aotome202.lostjason.e202project.view.RippleView_J;

/**
 * Created by LostJason on 2017/4/11.
 */

public class Test_Act2 extends Activity {
    TextView  tv4,tv1;
    ViewStub viewStub;
    boolean isrun=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new RippleView_J(this));


    }
}
