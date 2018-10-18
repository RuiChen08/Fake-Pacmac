package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen, Chucheng Qian
 * Date: 14/10/2019
 *
 * Blinky is one of the Ghosts: Blinky, is a red ghost who, in the original arcade game, follows behind Pac-Man. He is considered the leader of the ghosts.
 * In this Game, we draw a dark red circle to make it clear under the red background
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Blinky extends Ghost {

    static Pos START_POSITION = new Pos(11 * Maze.offsetW,23 * Maze.offsetH);

    Blinky() {
        super(START_POSITION);
    }

    /*
     * Authors: Rui Chen, Chucheng Qian
     * Date: 15/10/2019
     */
    @Override
    void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.parseColor("#460000"));
        super.onDraw(canvas, paint);
    }
}


