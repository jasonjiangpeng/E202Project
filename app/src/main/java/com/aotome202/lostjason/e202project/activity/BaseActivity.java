package com.aotome202.lostjason.e202project.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.aotome202.lostjason.e202project.R;
import com.aotome202.lostjason.e202project.assist.My_ActivityManager;

/**
 * Created by LostJason on 2017/4/10.
 */

//public class BaseActivity extends AppCompatActivity {
public class BaseActivity extends Activity {
  //  public int status=0;
 public    StatusListen statusListen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //   getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); /*透明状态栏*/
 //  getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); /*透明导航栏*/
        My_ActivityManager.activities.add(this);
      //  statusListen.changestatus();
               if (this instanceof StatusListen){
                   statusListen= (StatusListen) this;
               }

    }
   protected void imgbackall(View view){
       My_ActivityManager.getCurrentAcitvity().finish();
   }
    @Override
    protected void onDestroy() {
        My_ActivityManager.activities.remove(this);
        super.onDestroy();
    }

    interface StatusListen{
        void changestatus(int value);

    }
    protected void inittoolbar() {

        if (getIntent().getStringExtra("data")!=null){
            TextView t = (TextView)findViewById(R.id.toolbartv);
            t.setText(getIntent().getStringExtra("data"));
        }

    }

}
