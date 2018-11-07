package edu.cascadia.brianb.mydrawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Edited by Brian Bansenauer on 10/18/15.
 */
public class SimplyDrawnView extends View {

    private Paint mPaint;
    private Path mPath;
    private float mWidth, mHeight;

    public SimplyDrawnView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        mPaint = new Paint();
        mPath = new Path();
     }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE); //draw background

        //Draw line
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(16.0f);
        canvas.drawLine(mWidth, 0, 200, mHeight, mPaint);

        //TODO: Finish drawing red line
        mPaint.setColor(Color.RED); mPaint.setStrokeWidth(10);
        canvas.drawLine(100,100,300, mHeight, mPaint);

        //TODO: Draw green lines
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(20);
        canvas.drawLine(0,50,mWidth,50,mPaint);
        canvas.drawLine(0,100,mWidth,100,mPaint);
        canvas.drawLine(0,150,mWidth,150,mPaint);
        //TODO: Draw Text
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(50);
        mPaint.setTextSize(50);
        canvas.drawText("I am drawing This", 250, 300, mPaint);


        //TODO: Draw Text on a Path
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10);
        mPaint.setTextSize(50);
        Path myPath = new Path();
        myPath.addArc(50, 300, 400,550,0,180);
canvas.drawTextOnPath("Drawing on a path is lots of fun",myPath,10,10, mPaint);


        //TODO: Draw filled, opaque, and open ovals

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        RectF oval = new RectF(500, 1500, 900, 2000);
        canvas.drawOval(oval, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(500);
        RectF ovalFill = new RectF(900, 900, 1200, 1200);
        canvas.drawOval(ovalFill, mPaint);

        //TODO: Draw bee bitmap
        //     HINT: since b is a Drawable, you can use its .draw method, but .setBounds on it first
        Drawable b = getResources().getDrawable(R.drawable.bee,null);
        b.setBounds(150,400,500,700);
        b.draw(canvas);


        //TODO: Add another image to the project (copy and paste to Android Studio res/drawable folder)
        //     and draw it on the screen
      Drawable l = getResources().getDrawable(R.drawable.loki,null);
      l.setBounds(500,600,800,900);
      l.draw(canvas);
    }
}
