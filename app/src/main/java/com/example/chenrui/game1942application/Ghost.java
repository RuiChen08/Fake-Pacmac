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
    static final int timeInBlue = 20;

    Pos start_position;

    boolean blueMode = false;
    AI.intPos probingPos = new AI.intPos(9, 6);
    int time = timeInBlue;

    Pos pos;
    Pos.Direction direction = Pos.Direction.Stay;

    /*
     * Author: Rui Chen
     * Date: 18/10/2018
     */
    Ghost(Pos start_position){
        this.start_position = start_position;
        this.pos = new Pos(start_position);
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
    void step(PacMan pacMan) {
        Pos pacManPos = pacMan.pos;
        Pos realGhost = new Pos(pos.x * Game.ScreenWidth, pos.y * Game.ScreenHeight);
        Pos realPacman = new Pos(pacManPos.x * Game.ScreenWidth, pacManPos.y * Game.ScreenHeight);
        // in the blue mode the player will not loss life
        AI ai = new AI();
        if (blueMode){
            getMove(ai.movingAI(pacManPos, this.pos, probingPos, "escaping"));
            if (realGhost.getDistance(realPacman) <= PacMan.Radius + Radius) {Game.mark += 10; this.reset();}
        } else {
            getMove(ai.movingAI(pacMan.pos, this.pos, probingPos, "chasing"));
            if (realGhost.getDistance(realPacman) <= PacMan.Radius + Radius) {pacMan.life--; pacMan.reset();}
        }
    }

    void reset() {
        this.pos = new Pos(start_position);
    }

    /*
     * Author: Rui Chen, Ruiyi Sun
     * Date: 15/10/2018
     *
     * Common-Used codes
     */
    void getMove(Pos.Direction direction){
        Pos p = new Pos(this.pos);

        if (direction == Pos.Direction.Up) {pos.y -= Maze.offsetH * 2; this.direction = Pos.Direction.Down;}
        else if (direction == Pos.Direction.Down) {pos.y += Maze.offsetH * 2;this.direction = Pos.Direction.Up;}
        else if (direction == Pos.Direction.Right) {pos.x += Maze.offsetW * 2;this.direction = Pos.Direction.Left;}
        else if (direction == Pos.Direction.Left) {pos.x -= Maze.offsetW * 2;this.direction = Pos.Direction.Right;}

        // backing up the original position if current position is inside the wall
        if (Maze.maze[(int) (this.pos.y / (2 * Maze.offsetH))][(int) (this.pos.x / (2*Maze.offsetW))] == 3) {
            this.pos = p;
        }
    }
}

