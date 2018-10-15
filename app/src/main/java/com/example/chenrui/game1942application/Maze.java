package com.example.chenrui.game1942application;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

/**
 * Author: Rui Chen, Ruiyi Sun, Weiwei Liang
 * Date: 2018/10/12
 */

public class Maze{

    private float widthSize;
    private float heightSize;
    private float offsetW;
    short[][] maze = new short[][] {
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
            {3, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 3},
            {3, 0, 3, 3, 1, 0, 3, 3, 0, 1, 3, 3, 0, 3},
            {3, 1, 3, 1, 0, 1, 3, 3, 0, 1, 0, 3, 1, 3},
            {3, 0, 3, 0, 3, 0, 3, 3, 1, 3, 1, 3, 0, 3},
            {3, 1, 3, 1, 3, 1, 0, 1, 0, 3, 0, 3, 1, 3},
            {3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 1, 3, 0, 3},
            {3, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 3},
            {3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 1, 3, 0, 3},
            {3, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 3},
            {3, 0, 3, 0, 3, 3, 0, 0, 3, 3, 1, 3, 0, 3},
            {3, 1, 3, 1, 3, 0, 0, 0, 0, 3, 0, 3, 1, 3},
            {3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 1, 3, 0, 3},
            {3, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 3},
            {3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 1, 3, 0, 3},
            {3, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 3},
            {3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 1, 3, 0, 3},
            {3, 1, 3, 1, 3, 1, 0, 1, 0, 3, 0, 3, 1, 3},
            {3, 0, 3, 0, 3, 0, 3, 3, 1, 3, 1, 3, 0, 3},
            {3, 1, 3, 1, 0, 1, 3, 3, 0, 1, 1, 3, 1, 3},
            {3, 0, 3, 3, 3, 0, 3, 3, 1, 3, 3, 3, 0, 3},
            {3, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 3},
            {3, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 3},
            {3, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 3},
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
    };
    private Paint paint;

    /*
     * Author: Rui Chen
     * Date: 15/10/2018
     */
    public Maze() {
        this.heightSize = maze.length;
        this.widthSize = maze[0].length;
        offsetW = (Game.ScreenWidth - widthSize * 2 * PacMan.Radius * Game.ScreenHeight) / (2 * Game.ScreenWidth);  // This is adjustment is for screen width
    }

    /*
     * Author: Rui Chen
     * Date: 15/10/2018
     */
    protected void onDraw(Canvas canvas, Paint paint) {
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[0].length; c++) {
                switch (maze[r][c]) {
                    case 1:
                        Food.drawPacDot(canvas, paint, offsetW + c / widthSize, PacMan.Radius + r / heightSize);
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
