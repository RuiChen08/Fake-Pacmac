package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

abstract class Food {

    Pos pos;
    private final float radius;

    Food(float x, float y, float radius) {
        pos = new Pos(x, y);
        this.radius = radius;
    }

    public void onDraw(Canvas canvas, Paint paint) {
        canvas.drawCircle(pos.x * canvas.getWidth(), pos.y*canvas.getHeight(),radius * canvas.getWidth(),paint);
    }

}
