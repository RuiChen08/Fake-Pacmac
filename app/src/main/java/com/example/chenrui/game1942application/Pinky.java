package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen(u5958754)
 * Date: 19/09/2019
 *
 * Pinky is one of the Ghosts: Pinky, is a pink ghost, who is in the original arcade game, positions in front of Pac-Man.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Pinky extends Ghost {

    static final Pos START_POS = new Pos(17 * Maze.offsetW,23 * Maze.offsetH);

    Pinky(){super(START_POS);}

    /*
     * Author: Rui Chen(u5958754)
     * Date: 18/10/2018
     */
    @Override
    void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.rgb(244, 65, 175)); // The pink one
        super.onDraw(canvas, paint);
    }
}
