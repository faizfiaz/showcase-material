package com.showcase.faizfiaz.shape;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;

import com.showcase.faizfiaz.target.Target;


public class RectangleShape implements Shape {

    private boolean fullWidth = false;

    private int width = 0;
    private int height = 0;
    private boolean adjustToTarget = true;
    private boolean b;
    private int rounded;

    private Rect rect;

    public RectangleShape(int width, int height, boolean drawSpotLight) {
        this.width = width;
        this.height = height;
        this.b = drawSpotLight;
        init();
    }

    public RectangleShape(int width, int height, boolean drawSpotLight, int rounded) {
        this.width = width;
        this.height = height;
        this.b = drawSpotLight;
        this.rounded = rounded;
        init();
    }

    public RectangleShape(Rect bounds) {
        this(bounds, false);
    }

    public RectangleShape(Rect bounds, boolean fullWidth) {
        this.fullWidth = fullWidth;
        height = bounds.height();
        if (fullWidth)
            width = Integer.MAX_VALUE;
        else width = bounds.width();
        init();
    }

    public boolean isAdjustToTarget() {
        return adjustToTarget;
    }

    public void setAdjustToTarget(boolean adjustToTarget) {
        this.adjustToTarget = adjustToTarget;
    }

    private void init() {
        rect = new Rect(-width / 2, -height / 2, width / 2, height / 2);
    }

    @Override
    public void draw(Canvas canvas, Paint paint, int x, int y, int padding) {
        if (b) {
            if (!rect.isEmpty()) {
                if (rounded > 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        canvas.drawRoundRect(
                                rect.left + x - padding,
                                rect.top + y - padding,
                                rect.right + x + padding,
                                rect.bottom + y + padding,
                                rounded,
                                rounded,
                                paint
                        );
                    } else {
                        RectF rectf = new RectF(rect.left + x - padding,
                                rect.top + y - padding,
                                rect.right + x + padding,
                                rect.bottom + y + padding);
                        canvas.drawRoundRect(rectf, rounded, rounded, paint);
                    }
                } else {
                    canvas.drawRect(
                            rect.left + x - padding,
                            rect.top + y - padding,
                            rect.right + x + padding,
                            rect.bottom + y + padding,
                            paint
                    );
                }

            }
        }
    }

    @Override
    public void updateTarget(Target target) {
        if (adjustToTarget) {
            Rect bounds = target.getBounds();
            height = bounds.height();
            if (fullWidth)
                width = Integer.MAX_VALUE;
            else width = bounds.width();
            init();
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}