package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 22/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

class Game {

    static final Pos START_POS= new Pos(0.5f,0.5f);

    Ghost[] ghosts = new Ghost[4];
    PacMan pacman = new PacMan();
    Foods foods = new Foods();

    public Game() {
        ghosts[0] = new Blinky();
        ghosts[1] = new Clyde();
        ghosts[2] = new Inky();
        ghosts[3] = new Pinky();
    }

    void onDraw(Canvas canvas, Paint paint) {
        pacman.onDraw(canvas, paint);
        for (Ghost g : ghosts)
            g.onDraw(canvas, paint);
        foods.onDraw(canvas, paint);
    }

    void step() {
        for (Ghost g : ghosts)
            g.step();

    }

    void move(Pos.Direction direction){
        pacman.move(direction);
    }
}
