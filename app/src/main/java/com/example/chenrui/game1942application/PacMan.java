package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class PacMan {

    // The step of each movement.
    static final float STEP = 0.005f;


    protected Pos pos;
    private float radius = 0.025f;

    PacMan() {
        this.pos = Game.START_POS;

    }

    void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.rgb(244, 164, 66));
        canvas.drawCircle(pos.x * canvas.getWidth(), pos.y * canvas.getHeight(), canvas.getHeight() * radius, paint);
    }

    /*
     * Author: Rui Chen
     * Date: 22/09/2018
     *
     * Increase the x or y of pac-man's position according to direction. The origin is the left up connor of the canvas.
     */
    void move(Pos.Direction direction){
        switch (direction){
            case Up:
                // minus because the left-up connor is the origin
                pos.y -= PacMan.STEP;
                break;
            case Down:
                pos.y += PacMan.STEP;
                break;
            case Left:
                pos.x -= PacMan.STEP;
                break;
            case Right:
                pos.x += PacMan.STEP;
        }
    }


}
