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


    Pos pos;
    Pos.Direction direction = Pos.Direction.Stay;
    static float radius = 0.025f;
    static int life = 3;

    public PacMan(Pos pos) {
        this.pos = pos;
    }

    void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.rgb(244, 164, 66));
        canvas.drawCircle(pos.x * canvas.getWidth(), pos.y * canvas.getHeight(), canvas.getHeight() * radius, paint);
    }

    /*
     * Author: Rui Chen
     * Date: 12/10/2018
     *
     * Increase the x or y of pac-man's position according to direction. The origin is the left up connor of the canvas.
     */
    void step(){
        switch (this.direction){
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
                break;
            case Stay:
                break;
        }
    }

    /*
     * Author: Rui Chen
     * Date: 12/10/2018
     */
    void changeDirection(Pos.Direction direction){ this.direction = direction; }


}
