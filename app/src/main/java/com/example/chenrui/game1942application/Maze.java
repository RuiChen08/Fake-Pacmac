package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Author: Rui Chen, Ruiyi Sun, Weiwei Liang
 * Date: 2018/10/12
 */

public class Maze {

    private float widthSize;
    private float heightSize;
    private float offsetW;
    private float offsetH;
    short[][] maze = new short[][] {
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 3, 1, 1, 3, 3, 1, 1, 3, 3, 1, 3},
            {3, 1, 3, 1, 1, 1, 3, 3, 1, 1, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 1, 3, 3, 1, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 1, 1, 1, 1, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 1, 3, 3, 1, 1, 3, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 1, 1, 1, 1, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 1, 1, 1, 1, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 1, 3, 3, 1, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 1, 1, 3, 3, 1, 1, 1, 3, 1, 3},
            {3, 1, 3, 3, 3, 1, 3, 3, 1, 3, 3, 3, 1, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
    };

    Maze() {
        this.heightSize = maze.length;
        this.widthSize = maze[0].length;
        offsetW = (Game.ScreenWidth - widthSize * 2 * PacMan.Radius * Game.ScreenHeight) / (2 * Game.ScreenWidth);  // This is adjustment is for screen width
    }

    void onDraw(Canvas canvas, Paint paint){
        for (int r = 0; r < maze.length; r++){
            for (int c = 0; c < maze[0].length; c++){
                switch (maze[r][c]){
                    case 1:
                        Food.drawPacDot(canvas, paint, new Pos(offsetW + c / widthSize, PacMan.Radius + r / heightSize));
                        break;
                    case 2:
                }
            }
        }
    }

    /*
     * Author: Rui Chen
     * Date: 15/10/2018
     */
    public void step(Pos pos) {
    }
}
