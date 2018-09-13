package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Authors: Rui Chen
 * Date: 2018/9/14
 */

public interface Movable{
    Pos pos = null;

    public void onDraw(Canvas canvas, Paint paint);

    //Perform a movement of this movable item
    public void step();
}
