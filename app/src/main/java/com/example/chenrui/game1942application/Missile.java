package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Author: Rui Chen
 * Date: 2018/9/14
 */

public class Missile implements Movable {

    Pos pos;
    int x_speed;
    int y_speed;
    /*
     * Authors: Rui Chen
     *
     */
    public Missile() {
        //Todo
    }

    /*
     * Authors: Rui Chen
     */
    @Override
    public void onDraw(Canvas canvas, Paint paint) {
        //Todo: We could either represent the missile by an image or a straight line
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
