package com.example.chenrui.game1942application;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/*
 * Author: Ruiyi Sun, Rui Chen
 * Date: 2018/09/22
 */
public class PowerPellet extends Food{

    PowerPellet(float x, float y) {
        super(x, y, 0.008f);
    }

    @Override
    public void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLUE);
        super.onDraw(canvas, paint);
    }
}
