package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2019
 *
 * Inky is one of the Ghosts: Inky is a baby blue ghost who, in the original arcade game, has a fickle mood. He can be unpredictable.
 * Sometimes he chases Pac-Man aggressively like Blinky; other times he jumps ahead of Pac-Man as Pinky would.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Inky extends Ghost {

    static final Pos START_POS = new Pos(15 * Maze.offsetW,23 * Maze.offsetH);
    int timer = 40;

    Inky(){
        super(START_POS);
    }

    /*
     * Author: Rui Chen
     * Date: 18/10/2018
     */
    @Override
    void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLUE);
        super.onDraw(canvas, paint);
    }

    /*
     * Authors: Rui Chen, Chucheng Qian, Ruiyi Sun
     * Date: 17/10/2018
     * add some code to move Inky
     */
    void step(PacMan pacMan) {
        super.step(pacMan);
        if(!blueMode) getMove(AI.movingAI(pacMan.pos, this.pos, probingPos, "chasing"));
    }
}

