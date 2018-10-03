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

public class Inky extends Ghost {

    Inky(Pos pos){
        super(pos);
    }

    @Override
    void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLUE);
        super.onDraw(canvas, paint);
    }

    @Override
    void step() {
        super.step();
        //Todo, Considering there are different AI for each ghost.
    }
}
