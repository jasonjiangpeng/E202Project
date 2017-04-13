package com.aotome202.lostjason.e202project.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
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

public class RippleView_J extends View {
    double  dia=500; //直径
    double rate=2.55f;//百分比
    float    compazation =25; //补偿值
    int weight,height;
  //  int  phase=8;
    float  phaset=0;
    float relength=0;
    Path path,path2;
//    int length1=120;
 Paint  fontPaint,circlePaint,ripplePaint;
    public RippleView_J(Context context) {
        this(context,null);



    }

    public RippleView_J(Context context, @Nullable AttributeSet attrs) {
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
    //    canvas.drawColor(Color.WHITE);
   //  drawxy(canvas);
        drawCircles(canvas);
    }
 public void  drawCircle(Canvas canvas){
     canvas.drawColor(Color.WHITE);
     // rate=30;

     float x= (float) (dia*rate/100); //dd变大
     relength= (float) (dia/2-dia*rate/100);
     //  LogShow.logshow(""+Math.sqrt(16));
     double piont=  Math.sqrt(dia*dia/4-relength*relength);
     canvas.drawCircle(weight/2,weight/2, (float) (dia/2)+compazation,circlePaint);
     canvas.drawArc(getMiddleRectF((float) piont, (float) relength),0,180,false,ripplePaint);
 }
    public void  drawCircles(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        phaset-=-0.1f;
        // rate=30;
        float x= (float) (dia*rate/100); //dd变大
        relength= (float) (dia/2-dia*rate/100);
        //  LogShow.logshow(""+Math.sqrt(16));
        float piont= (float) Math.sqrt(dia*dia/4-relength*relength);
        canvas.drawCircle(weight/2,weight/2, (float) (dia/2)+compazation,circlePaint);
        RectF  rectF =getMiddleRectF(piont,relength);
        canvas.drawArc(rectF,0,180,false,ripplePaint);
        float srx1=rectF.left;
        float srx2=rectF.right;
        float  srcy=rectF.centerY();
        drawRipple(canvas,path,path2,srx1,srx2,srcy,ripplePaint,phaset);
        postInvalidateDelayed(100);
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
        s.setStyle(Paint.Style.FILL);

        s.setColor(Color.parseColor("#3c7df4"));
        s.setAlpha(140);
        return s;
    }
    private Paint getripplePaint(){
        Paint s=new Paint();
        s.setAntiAlias(true);
        s.setStyle(Paint.Style.FILL);
        s.setColor(Color.parseColor("#3c7df4"));
        s.setAlpha(80);
        return s;
    }
    private Paint getripplePaint2(){
        Paint s=new Paint();
        s.setAntiAlias(true);
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
    public void drawText(){

    }
}
