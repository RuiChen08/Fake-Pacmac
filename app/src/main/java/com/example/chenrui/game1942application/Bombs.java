package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Author: Rui Chen
 * Date: 2018/9/14
 */

public class Bombs extends ArrayList<Bomb>{

    public void onDraw(Canvas canvas, Paint paint) {
        for (Bomb b : this)
            b.onDraw(canvas, paint);
    }

    public void step() {
        for (Bomb b : this)
            b.step();
    }
}
