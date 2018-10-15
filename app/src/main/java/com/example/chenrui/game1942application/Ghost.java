package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen,Chucheng Qian, Ruiyi Sun
 * Date: 14/10/2018
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

abstract class Ghost {

    static final float Radius = PacMan.Radius;
    static final int timeInBlue = 5;

    boolean blueMode = true;
    int time = timeInBlue;
    Pos pos;

    Ghost(Pos pos){
        this.pos = pos;
    }

    /*
     * Authors: Rui Chen,Chucheng Qian, Ruiyi Sun
     * Date: 14/10/2018
     */
    void onDraw(Canvas canvas, Paint paint) {
        if (blueMode){
            paint.setColor(Color.BLUE);
            blueMode = time-- != 0;
        }
        canvas.drawCircle(pos.x * canvas.getWidth(), pos.y * canvas.getHeight(), Radius, paint);
    }

    /*
     * Authors: Rui Chen,Chucheng Qian, Ruiyi Sun
     * Date: 14/10/2018
     */
    void step(Pos pacManPos) {
        if (pos.getDistance(pacManPos) <= PacMan.Radius + Radius) PacMan.life--;
        if(blueMode) getMove(pacManPos.getDirection(this.pos));
    }

    /*
     * Author: Rui Chen
     * Date: 15/10/2018
     *
     * Common-Used codes
     */
    void getMove(Pos.Direction direction){
        Pos p = new Pos(this.pos);

        if (direction == Pos.Direction.Up) pos.y -= Maze.offsetH * 2;
        else if (direction == Pos.Direction.Down) pos.y += Maze.offsetH * 2;
        else if (direction == Pos.Direction.Right) pos.x += Maze.offsetW * 2;
        else if (direction == Pos.Direction.Left) pos.x -= Maze.offsetW * 2;

        // backing up the original position if current position is inside the wall
        if (Maze.maze[(int) (this.pos.y / (2 * Maze.offsetH))][(int) (this.pos.x / (2*Maze.offsetW))] == 3) {
            this.pos = p;
        }
    }
}
