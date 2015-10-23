package com.example.elpis.uiapppractice;

/**
 * Created by Elpis on 10/23/2015.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.MotionEvent;
import android.graphics.Bitmap;

public class DrawView extends View {
    private Paint drawPaint, canvasPaint;
    //canvas
    private Canvas drawCanvas;
    //canvas bitmap
    private Bitmap canvasBitmap;
    private Path drawPath;
    /* variable for counting two successive up-down events */
    int clickCount = 0;
    /*variable for storing the time of first click*/
    long startTime;

    public DrawView(Context context) {
        super(context);
        drawPath = new Path();
        drawPaint = new Paint();

        drawPaint.setColor(Color.WHITE);

        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //view given size
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_4444);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        // set a point
        canvas.drawPath(drawPath, drawPaint);
        //drawCanvas.drawPoint(touchX, touchY, drawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
    //detect user touch
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                //drawCanvas.drawPoint(touchX, touchY, drawPaint);
                if(clickCount == 0)
                    startTime = System.currentTimeMillis();
                clickCount++;
                break;
            case MotionEvent.ACTION_MOVE:
                //drawCanvas.drawPoint(touchX, touchY, drawPaint);
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                if(clickCount >= 2)
                {
                    long duration =  System.currentTimeMillis() - startTime;
                    if(duration <= 500)
                    {
                        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                       // Toast.makeText(captureActivity.this, "double tap",Toast.LENGTH_LONG).show();
                    }
                    clickCount = 0;
                }
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

}