package com.aotome202.lostjason.e202project.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.aotome202.lostjason.e202project.R;
import com.aotome202.lostjason.e202project.assist.Logshow;

/**
 * Created by LostJason on 2017/4/10.
 */

public class CycelView extends View {
    Paint circlepaint;
    Paint fontPaint;
    int  weight;
    int height;
    public CycelView(Context context) {
        super(context);
    }

    public CycelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        circlepaint =getPaint();
        fontPaint =getFontPaint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (circlepaint==null){
            return;
        }

    canvas.drawCircle(weight/2,height/2,200,circlepaint);
  //  canvas.drawText(weight/2,heigh/2,200,circlepaint);
        canvas.drawText("jason",0,20,getFontPaint(20f));
        //fontPaint.breakText()
        Logshow.logShow(fontPaint.measureText("jason")+"");
       // canvas.drawText("j",0,100,getFontPaint(f));
        Logshow.logShow(fontPaint.measureText("j")+"");
    }
   private Paint getPaint(){
       Paint  paint =new Paint();
       paint.setAntiAlias(true);
       paint.setColor(getResources().getColor(R.color.lanse));
       paint.setStyle(Paint.Style.STROKE);
       paint.setStrokeWidth(2f);
       return  paint;
   }
    private Paint getFontPaint(){
        Paint  paint =new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(40f);
        paint.setColor(getResources().getColor(R.color.black));
        return  paint;
    }
    private Paint getcirclePaint(){
        Paint  paint =new Paint();
        paint.setAntiAlias(true);
        /*防止抖动*/

        paint.setDither(true);
        paint.setFilterBitmap(true);
        paint.setColor(getResources().getColor(R.color.hongse));
        return  paint;
    }
    private Paint getFontPaint(float size){
        Paint  paint =new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(size);
        paint.setColor(getResources().getColor(R.color.black));
        return  paint;
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Logshow.logShow("w:"+w+"h"+h+"oldw"+oldw+"oldh"+oldh);
        weight=w;
        height=h;
        super.onSizeChanged(w, h, oldw, oldh);
    }

}
