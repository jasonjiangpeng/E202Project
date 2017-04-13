package com.aotome202.lostjason.e202project.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by LostJason on 2017/4/12.
 */

public class My_WaveRipple extends View {
    Path  path ;
    private Paint mAboveWavePaint,mBelowWavePaint;

    public My_WaveRipple(Context context) {
        super(context);
    }

    public My_WaveRipple(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        path =new Path();
        mAboveWavePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mAboveWavePaint.setAntiAlias(true);
         mAboveWavePaint.setStyle(Paint.Style.FILL);
        mAboveWavePaint.setColor(Color.BLUE);
        mBelowWavePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBelowWavePaint.setAntiAlias(true);
        mBelowWavePaint.setStyle(Paint.Style.STROKE);
        mBelowWavePaint.setStrokeWidth(2f);
         mBelowWavePaint.setColor(Color.BLACK);
    }
   float chuxiang=0;

  //  float zhouqi=10;
    @Override
    protected void onDraw(Canvas canvas) {
        int x=10;
  /*   // drawRipple(canvas);
        float  w=getWidth()/2;
        float h=getHeight()/2;
        path.reset();
        path.moveTo(w-200,h);
        path.cubicTo(w-200,h,w,h+200,w+200,h);*/
      //  canvas.drawPath(path,mAboveWavePaint);
     //   drawRipple(canvas);
       canvas.drawArc(getRectF(),0,180,false,mBelowWavePaint);
       canvas.drawArc(getRectF2(),0,180,false,mAboveWavePaint);
    }

    public RectF getRectF(){

        RectF rectF =new RectF();
        rectF.left=(getWidth()/2)-200;
        rectF.right=(getWidth()/2)+200;
        rectF.top=(getHeight()/2)-200;
        rectF.bottom=(getHeight()/2)+200;
        return rectF;

    }
    public RectF getRectF2(){

        RectF rectF =new RectF();
        rectF.left=(getWidth()/2)-160;
        rectF.right=(getWidth()/2)+160;
        rectF.top=(getHeight()/2)-240;
        rectF.bottom=(getHeight()/2)+200;

        return rectF;

    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        weight=w;
        height=h;
    }

    private  int invaluidataDelayTime=100;
    private  int weight=0;
    private  int height=0;
    public void drawRipple(Canvas canvas){
        double ω = 2*Math.PI / getWidth();
        path.reset();
        path.moveTo((getWidth()/2)-200,getHeight()/2);
        chuxiang-=0.2f;
        canvas.drawCircle(getWidth()/2,getHeight()/2,200,mBelowWavePaint);

        //    path.moveTo((getWidth()/2)-200,getHeight()/2);
        canvas.drawPath(path,mAboveWavePaint);
        // canvas.dr
        postInvalidateDelayed(invaluidataDelayTime);
    }

    private  Paint fontPaint,circlePaint,ripplePaint;
    public Paint getCirclePaint(){
         Paint  mAboveWavePaint =new Paint();
        mAboveWavePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mAboveWavePaint.setAntiAlias(true);
        mAboveWavePaint.setStyle(Paint.Style.FILL);
        mAboveWavePaint.setColor(Color.BLUE);
        return mAboveWavePaint;

    }

}
