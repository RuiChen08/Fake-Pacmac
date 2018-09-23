package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

abstract class Food {

    private float x;
    private float y;
    private final float radius;

    Food(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void onDraw(Canvas canvas, Paint paint) {
        canvas.drawCircle(x * canvas.getWidth(), y*canvas.getHeight(),radius * canvas.getWidth(),paint);
    }




}
