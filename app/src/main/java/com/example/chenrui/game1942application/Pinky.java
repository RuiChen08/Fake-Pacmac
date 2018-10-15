package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2019
 *
 * Pinky is one of the Ghosts: Pinky, is a pink ghost, who is in the original arcade game, positions in front of Pac-Man.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Pinky extends Ghost {

    Pinky(Pos pos){
        super(pos);
    }

    @Override
    void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.rgb(244, 65, 175)); // The pink one
        super.onDraw(canvas, paint);
    }

    /*
     * Authors: Rui Chen, Chucheng Qian
     * Date: 14/10/2019
     */
    void step(Pos pacManPos) {
        super.step(pacManPos);
        if (!blueMode) getMove(AI.chasing(pacManPos, this.pos));
    }
}
