package com.aotome202.lostjason.e202project.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by lenovo on 2017/4/12.
 */

public class RippleView_J1 extends View {
    double  dia=450; //直径
    double rate=2.55f;//百分比
    float    compazation =25; //补偿值
    int weight,height;
    int  phase=8;

    double duandian=0;
    Path path,path2;
//    int length1=120;
 Paint  fontPaint,circlePaint,ripplePaint;
    public RippleView_J1(Context context) {
        this(context,null);



    }

    public RippleView_J1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initParameter();
    }

    private void initParameter() {
     path=new Path();
     path2=new Path();
        circlePaint=getCirclePaint();
        ripplePaint=getripplePaint();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        weight=w;
        height=h;
        super.onSizeChanged(w, h, oldw, oldh);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

drawxy(canvas);
  /*      for (float i = (getWidth()/2)-200; i <(getWidth()/2)+200; i += 10) {
            *//**
             *  y=Asin(ωx+φ)+k
             *  A—振幅越大，波形在y轴上最大与最小值的差值越大
             *  ω—角速度， 控制正弦周期(单位角度内震动的次数)
             *  φ—初相，反映在坐标系上则为图像的左右移动。这里通过不断改变φ,达到波浪移动效果
             *  k—偏距，反映在坐标系上则为图像的上移或下移。
             *//*
            float  y = (float) (8 * Math.cos(ω * i + phase) +getHeight()/2);
            //       y2 = (float) (8 * Math.sin(ω * x + φ));
            path.lineTo(i, y);
            //   mBelowWavePath.lineTo(x, y2);
            //回调 把y坐标的值传出去(在activity里面接收让小机器人随波浪一起摇摆)
            //   mWaveAnimationListener.OnWaveAnimation(y);
        }*/
    //    canvas.drawPath(path,getcPaint());
      // postInvalidateDelayed(300);
        /*y=8*sin(w*Y+y)+10*/
    }
 public void  drawCircle(Canvas canvas){
     canvas.drawColor(Color.WHITE);
     // rate=30;
     float x= (float) (dia*rate/100); //dd变大
     duandian=dia/2-dia*rate/100;
     //  LogShow.logshow(""+Math.sqrt(16));
     double piont=  Math.sqrt(dia*dia/4-duandian*duandian);
     canvas.drawCircle(weight/2,weight/2, (float) (dia/2)+compazation,circlePaint);
     canvas.drawArc(getMiddleRectF((float) piont, (float) duandian),0,180,false,ripplePaint);
 }
    public void  drawCircles(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        // rate=30;
        float x= (float) (dia*rate/100); //dd变大
        duandian=dia/2-dia*rate/100;
        //  LogShow.logshow(""+Math.sqrt(16));
        double piont=  Math.sqrt(dia*dia/4-duandian*duandian);
        canvas.drawCircle(weight/2,weight/2, (float) (dia/2)+compazation,circlePaint);
        canvas.drawArc(getMiddleRectF((float) piont, (float) duandian),0,180,false,ripplePaint);
    }
    public RectF getMiddleRectF(float piont,float dd){
        RectF rectF =new RectF();
        rectF.left=weight/2-piont-1;
        rectF.right=weight/2+piont+1;
        rectF.top= (float) (weight/2+2*dd-dia/2);
        rectF.bottom= (float) (weight/2+dia/2);

        return rectF;
    }
    private Paint getCirclePaint(){
        Paint s=new Paint();
        s.setAntiAlias(true);
        s.setStyle(Paint.Style.STROKE);
        s.setStrokeWidth(2f);
        s.setColor(Color.parseColor("#3F51B5"));
        return s;
    }
    private Paint getripplePaint(){
        Paint s=new Paint();
        s.setAntiAlias(true);
        s.setStyle(Paint.Style.FILL);
        s.setColor(Color.parseColor("#3c7df4"));
        s.setAlpha(120);
        return s;
    }
    private Paint getripplePaint2(){
        Paint s=new Paint();
        s.setAntiAlias(true);
      //  s.alp
        s.setStyle(Paint.Style.FILL);
        s.setColor(Color.parseColor("#3c7df4"));
        s.setAlpha(140);
        return s;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (rate>50){
            rate=2.25f;
        }
        rate+=3;
        invalidate();
        return super.onTouchEvent(event);
    }
    public void drawBSE(Canvas c){
        path.reset();
        path.moveTo(100,100);
        path.quadTo(250,100,500,100);
        c.drawPath(path,ripplePaint);
    }
    int i=10;
    int offset=20;
    public void drawBSES(Canvas c){
        path.reset();
        path.moveTo(100,500);
        path.lineTo(100,480);

   i +=5;
        if (i>100){
            i=10;
        }
        for (int j = 0; j <31 ; j++) {
           // path.quadTo(200+j,380,450+i);
         //   path.quadTo(200,380-i,450+i);
        }


        path.lineTo(800,500);
        c.drawPath(path,ripplePaint);
        postInvalidateDelayed(100);
    }
    double bb;
    public void drawxy(Canvas c){
        path.reset();
        path2.reset();
        path.moveTo(200,330);
        path2.moveTo(200,330);
       bb-=0.1f;
       double w=  2*Math.PI/200;
        for (int j = 200; j <=600 ; j+=10) {
            float y= (float) (8*Math.sin(w*j+bb)+280);
            float y2= (float) (8*Math.cos(w*j+bb)+280);
            path.lineTo(j,y);
            path2.lineTo(j,y2);
        }
            path2.lineTo(600,330);
            path.lineTo(600,330);
        c.drawPath(path,ripplePaint);
        c.drawPath(path2,ripplePaint);
        postInvalidateDelayed(100);
    }
    public void drawRipple(Canvas c,Path path,Path path2,float srcx,float desx,float srcy,Paint paint,float bb ){  //bb的值需要变化 bb-=0.1f;
        path.reset();
        path2.reset();
        path.moveTo(srcx,srcy);
        path2.moveTo(srcx,srcy);
        float xxx=desx-srcx;
      //  bb-=0.1f;
        double w=  2*Math.PI/xxx;
        for (int j = (int) srcx; j <=desx ; j+=10) {
            float y= (float) (8*Math.sin(w*j+bb)+srcy-10);
            float y2= (float) (8*Math.cos(w*j+bb)+srcy-10);
            path.lineTo(j,y);
            path2.lineTo(j,y2);
        }
        path2.lineTo(desx,srcy);
        path.lineTo(desx,srcy);
        c.drawPath(path,paint);
        c.drawPath(path2,paint);
       // postInvalidateDelayed(100);
    }
}
