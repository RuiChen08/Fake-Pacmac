package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Authors: Rui Chen, Ruiyi Sun
 * Date: 2018/9/22
 */

class PacDot extends Food{
    PacDot(float x, float y) {
        super(x, y, 0.004f);
    }
    public void onDraw(Canvas canvas, Paint paint) {
        super.onDraw(canvas, paint);
        paint.setColor(Color.RED);// the PacDot should be a yellow dot
    }
}
