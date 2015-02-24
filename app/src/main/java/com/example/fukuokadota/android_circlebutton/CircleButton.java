package com.example.fukuokadota.android_circlebutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class CircleButton extends ImageView {
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
        path.addCircle(w / 2, h / 2, 10, Path.Direction.CW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(path);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        double touchX = event.getX(), touchY = event.getY();
        double r = getWidth() / 2;

        double length = Math.hypot(touchX - r, touchY - r);

        if (length <= r * r) {
            // inside circle
            return super.dispatchTouchEvent(event);
        } else {
            // outside circle
            return false;
        }
    }
}
