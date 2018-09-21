package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2019
 *
 * Clyde is one of the Ghosts: whose original name is listed as Pokey, is an orange ghost who, in the original arcade game, acts stupid. He will chase after Pac-Man in Blinky's manner, but will wander off to his home corner when he gets too close.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Clyde extends Ghost {

    @Override
    void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.rgb(244, 167, 66)); // the orange one
        super.onDraw(canvas, paint);
    }

    @Override
    void step() {
        super.step();
        //Todo, Considering there are different AI for each ghost.
    }
}
