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

    static Pos START_POSITION = new Pos(13 * Maze.offsetW,23 * Maze.offsetH);

    Clyde() {
        super(START_POSITION);
    }

    /*
     * Author: Rui Chen
     * Date: 14/10/2019
     */
    @Override
    void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.GREEN); // the orange one
        super.onDraw(canvas, paint);
    }

    /*
     * Authors: Rui Chen, Chucheng Qian
     * Date: 14/10/2019
     */
    void step(PacMan pacMan) {
        super.step(pacMan);
        AI ai = new AI();
        if (!blueMode) getMove(ai.movingAI(pacMan.pos, this.pos, probingPos, "chasing"));
    }
}
