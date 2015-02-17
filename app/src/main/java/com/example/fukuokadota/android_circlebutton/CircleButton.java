package com.example.fukuokadota.android_circlebutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class CircleButton extends Button {
    Path path = new Path();

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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int size = Math.max(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        path.reset();
        path.addCircle(w / 2, h / 2, 100, Path.Direction.CW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(path);

        super.onDraw(canvas);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        float touchX = event.getX(), touchY = event.getY();
        float r = getWidth() / 2;

        float lenX = (float) Math.pow(touchX - r, 2);
        float lenY = (float) Math.pow(touchY - r, 2);

        if (lenX + lenY <= r * r) {
            // inside circle
            return super.dispatchTouchEvent(event);
        } else {
            // outside circle
            return false;
        }
    }
}
