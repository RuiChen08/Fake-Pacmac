package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 22/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

class Game {

    static int mark = 0;

    static final Pos START_POS= new Pos(0.5f,0.5f);
    static final Pos START_POS_Ghosts= new Pos(0.9f,0.9f);
    static int ScreenWidth;
    static int ScreenHeight;

    private Ghosts ghosts;
    private PacMan pacman;
    private Maze maze;

    /*
     * set an initial position for ghost
     * @author Chucheng Qian, Rui Chen
     * @Date 14/10/2018
     */
    Game(int widthPixels, int heightPixels) {
        ScreenHeight = heightPixels;
        ScreenWidth = widthPixels;
        ghosts = new Ghosts();
        pacman = new PacMan(new Pos(START_POS));
        maze = new Maze();
    }


    /* Authors: Ruiyi Sun, Weiwei Liang, Rui Chen
     * Date: 14/10/2018
     */
    void onDraw(Canvas canvas, Paint paint) {
        ghosts.onDraw(canvas, paint);
        pacman.onDraw(canvas, paint);
        maze.onDraw(canvas, paint);
    }

    /* Authors: Ruiyi Sun, Weiwei Liang,Chucheng Qian, Rui Chen
     * Date: 14/10/2018
     */
    void step() {
        ghosts.step(pacman.pos);
        pacman.step();
        maze.step(pacman.pos);
        //maze.step(pacman.pos);
    }

    void move(Pos.Direction direction){
        pacman.changeDirection(direction);
    }
}
