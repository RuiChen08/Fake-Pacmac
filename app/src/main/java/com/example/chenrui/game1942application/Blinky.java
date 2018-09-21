package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2019
 *
 * Blinky is one of the Ghosts: Blinky, is a red ghost who, in the original arcade game, follows behind Pac-Man. He is considered the leader of the ghosts.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Blinky extends Ghost {

    @Override
    void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.RED);
        super.onDraw(canvas, paint);
    }

    @Override
    void step() {
        //Todo, Considering there are different AI for each ghost.
        super.step();
    }
}
