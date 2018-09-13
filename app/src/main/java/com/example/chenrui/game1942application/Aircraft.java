package com.example.chenrui.game1942application;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Authors: Rui Chen
 * Date: 2018/9/14
 */

public abstract class Aircraft implements Movable{

    Bitmap image;

    /*
     * Authors: Rui Chen
     */
    @Override
    public void onDraw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(image, pos.x, pos.y, paint);
        //Todo: Suppose we are gonna to draw the aircraft by images. The bitmap should be initialized in each subclass
    }

    /*
     * Authors: Rui Chen
     */
    @Override
    public void step() {
        //Todo:
    }
}
