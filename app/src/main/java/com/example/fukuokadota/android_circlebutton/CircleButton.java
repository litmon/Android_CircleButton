package com.example.fukuokadota.android_circlebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class CircleButton extends Button {

    public CircleButton(Context context) {
        super(context);
    }

    public CircleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        float touchX = event.getX(), touchY = event.getY();
        float r = getWidth() / 2;

        Point p = new Point();

        float lenX = (touchX - r) * (touchX - r);
        float lenY = (touchY - r) * (touchY - r);

        if (lenX + lenY <= r * r) {
            // inside circle
            Log.d("custom button", "dispatchTouchEvent called: " + true);
            Log.d("custom button", "dispatchTouchEvent eventType: " + event);
            return super.dispatchTouchEvent(event);
        } else {
            // outside circle
            Log.d("custom button", "dispatchTouchEvent called: " + false);
            Log.d("custom button", "dispatchTouchEvent eventType: " + event);
            return false;
        }
    }
}
