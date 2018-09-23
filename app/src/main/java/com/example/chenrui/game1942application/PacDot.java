package com.example.chenrui.game1942application;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Author: Rui Chen
 * Date: 2018/9/22
 */

/**
 * Author: Ruiyi Sun
 * Date:2018/9/22
 */
class PacDot extends View implements Food{
    float x;
    float y;
    public PacDot(Context context, @Nullable AttributeSet attrs, float x, float y) {
        super(context,attrs);
        this.x = x;
        this.y = y;
    }

    @Override
    public void onDraw(Canvas canvas, Paint paint) {
        // Todo, this should be a point
        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(Color.YELLOW);// the PacDot should be a yellow dot
        float radius = 0.05f * canvas.getWidth();
        canvas.drawCircle(x,y,radius,paint);
    }
}
