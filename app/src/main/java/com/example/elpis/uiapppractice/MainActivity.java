package com.example.elpis.uiapppractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    /*
    private int paintColor = 0xFFFFFF;
    private Path drawPath;
    Paint drawPaint,canvasPaint;
    Bitmap canvasBitmap;
    Canvas drawCanvas;
    */
    DrawView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.BLACK);
        setContentView(drawView);

        //setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
/*
        drawPath = new Path();

        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(10);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);


        canvasPaint = new Paint(Paint.DITHER_FLAG);

        drawPath.moveTo(10, 10);
        drawPath.lineTo(100, 200);

        canvasBitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);

        drawCanvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        drawCanvas.drawPath(drawPath, drawPaint);
*/
    }
/*
    protected void onDraw(Canvas canvas) {
    //draw view
        //canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    public boolean onTouchEvent(MotionEvent event) {
    //detect user touch
        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                //drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                break;
            default:
                return false;
        }
        //invalidate();
        return true;
    }
    */
}
