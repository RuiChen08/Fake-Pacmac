package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Author: Rui Chen
 * Date: 2018/9/14
 */

public class Bomb implements Movable {
    Pos pos;
    int x_speed;
    int y_speed;

    /*
     * Authors: Rui Chen
     */
    public Bomb() {
        //Todo
    }

    /*
     * Authors: Rui Chen
     */
    @Override
    public void onDraw(Canvas canvas, Paint paint) {
        //Todo: We could either represent the bomb by an image or a circle.
    }

    /*
     * Authors: Rui Chen
     */
    @Override
    public void step() {
        pos.x += x_speed;
        pos.y += y_speed;
    }
}
