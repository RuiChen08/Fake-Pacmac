package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Author: Rui Chen
 * Date: 2018/9/14
 */

public class EnemyAircraft extends Aircraft {

    /*
     * Authors: Rui Chen
     */
    public EnemyAircraft() {
        //Todo: The start point of each enemy aircraft should be outside of the screen. The image of enemy aircraft should be specified
    }

    /*
     * Authors: Rui Chen
     */
    @Override
    public void onDraw(Canvas canvas, Paint paint) {
        //Todo: Specifying the image before calling the parent class.
        super.onDraw(canvas, paint);
    }

    /*
     * Authors: Rui Chen
     */
    @Override
    public void step() {
        super.step();
        //Todo: We could either make the enemy aircraft follow a fixed or a random path
    }
}
