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

        float lenX = (float)Math.pow(touchX - r, 2);
        float lenY = (float)Math.pow(touchY - r, 2);

        if (lenX + lenY <= r * r) {
            // inside circle
            return super.dispatchTouchEvent(event);
        } else {
            // outside circle
            return false;
        }
    }
}
