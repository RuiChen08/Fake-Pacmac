package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Authors: Rui Chen
 * Date: 2018/9/14
 */

public class Missiles extends ArrayList<Missile>{

    /*
     * Authors: Rui Chen
     */
    public void onDraw(Canvas canvas, Paint paint) {
        for (Missile m : this)
            m.onDraw(canvas, paint);
    }

    public void step() {
        for (Missile m : this)
            m.step();
    }
}
