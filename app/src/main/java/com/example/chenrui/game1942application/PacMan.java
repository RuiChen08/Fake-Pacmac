package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class PacMan {

    static final Pos START_POS = new Pos(13 * Maze.offsetW,47 * Maze.offsetH);

    Pos pos = new Pos(START_POS);
    Pos.Direction direction = Pos.Direction.Stay;
    float Radius = Math.min(Maze.offsetW * Game.ScreenWidth, Maze.offsetH * Game.ScreenHeight) - 10f;
    int life = 3;

    /*
     * Author: Rui Chen
     * Date: 18/10/2018
     */
    void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.WHITE);
        // In this game, we write the white dot as the PacMan.
        canvas.drawCircle(pos.x * canvas.getWidth(), pos.y * canvas.getHeight(), Radius, paint);
    }

    /*
     * Author: Rui Chen
     * Date: 12/10/2018
     *
     * Increase the x or y of pac-man's position according to direction. The origin is the left up connor of the canvas.
     */
    void step(){

        // Save ths original pos in case getting into the wall.
        Pos p = new Pos(this.pos);

        if (direction == Pos.Direction.Up) pos.y -= Maze.offsetH * 2;
        else if (direction == Pos.Direction.Down) pos.y += Maze.offsetH * 2;
        else if (direction == Pos.Direction.Right) pos.x += Maze.offsetW * 2;
        else if (direction == Pos.Direction.Left) pos.x -= Maze.offsetW * 2;

        // backing up the original position if current position is inside the wall
        if (Maze.MAZE[(int) (this.pos.y / (2 * Maze.offsetH))][(int) (this.pos.x / (2*Maze.offsetW))] >= 3) {
            this.pos = p;
            this.direction = Pos.Direction.Stay;
        }
    }

    /*
     * Author: Rui Chen
     * Date: 12/10/2018
     */
    void changeDirection(Pos.Direction direction){
        if (direction == Pos.Direction.Up && Maze.MAZE[(int) (this.pos.y / (2 * Maze.offsetH)) - 1][(int) (this.pos.x / (2*Maze.offsetW))] < 3) this.direction = direction;
        else if (direction == Pos.Direction.Down && Maze.MAZE[(int) (this.pos.y / (2 * Maze.offsetH)) + 1][(int) (this.pos.x / (2*Maze.offsetW))] < 3) this.direction = direction;
        else if (direction == Pos.Direction.Left && Maze.MAZE[(int) (this.pos.y / (2 * Maze.offsetH))][(int) (this.pos.x / (2*Maze.offsetW)) - 1] < 3) this.direction = direction;
        else if (direction == Pos.Direction.Right && Maze.MAZE[(int) (this.pos.y / (2 * Maze.offsetH))][(int) (this.pos.x / (2*Maze.offsetW)) + 1] < 3) this.direction = direction;
    }

    void reset() { this.pos = new Pos(START_POS);}
}

