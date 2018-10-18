package com.example.chenrui.game1942application;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.nfc.tech.NfcA;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

/**
 * Author: Rui Chen, Ruiyi Sun, Weiwei Liang
 * Date: 2018/10/12
 */

class Maze{

    static final short[][] MAZE = new short[][] {
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
            {3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3},
            {3, 1, 3, 3, 3, 1, 3, 3, 1, 3, 3, 3, 1, 3},
            {3, 1, 3, 2, 1, 1, 3, 3, 1, 1, 2, 3, 1, 3},
            {3, 1, 3, 1, 3, 1, 3, 3, 1, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 1, 1, 1, 1, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 1, 3, 3, 4, 4, 3, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 0, 0, 0, 0, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 3},
            {3, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 3},
            {3, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 1, 1, 1, 1, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 1, 3, 3, 1, 3, 1, 3, 1, 3},
            {3, 1, 3, 2, 1, 1, 3, 3, 1, 1, 2, 3, 1, 3},
            {3, 1, 3, 3, 3, 1, 3, 3, 1, 3, 3, 3, 1, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 3},
            {3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3},
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
    };
    static short[][] maze = new short[MAZE.length][MAZE[0].length];
    static float widthSize = maze[0].length;
    static float heightSize = maze.length;
    static float offsetW = 1 / (2 * widthSize);
    static float offsetH = 1 / (2 * heightSize);

    {
        /* This is ugly codes
         * You might be able to found a better way without big refactoring, if you can. Please change it.
         */
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[0].length; c++) maze[r][c] = MAZE[r][c];
        }
    }

    /*
     * Author: Rui Chen
     * Date: 15/10/2018
     */
    static void onDraw(Canvas canvas, Paint paint) {
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[0].length; c++) {
                switch (maze[r][c]) {
                    case 1:
                        Food.drawPacDot(canvas, paint, offsetW + c / widthSize, offsetH + r / heightSize);
                        break;
                    case 2:
                        Food.drawPowerPellet(canvas, paint, offsetW + c / widthSize, offsetH + r / heightSize);
                        break;
                    case 3:
                        paint.setColor(Color.BLUE);
                        canvas.drawRect(c / widthSize * canvas.getWidth(), r / heightSize * canvas.getHeight(),
                                (2 * offsetW + c / widthSize) * canvas.getWidth(), (2 * offsetH + r / heightSize) * canvas.getHeight(), paint);
                        break;
                    case 4:
                        paint.setColor(Color.GREEN);
                        canvas.drawRect(c / widthSize * canvas.getWidth(), r / heightSize * canvas.getHeight(),
                                (2 * offsetW + c / widthSize) * canvas.getWidth(), (2 * offsetH + r / heightSize) * canvas.getHeight(), paint);
                }
            }
        }
    }

    /*
     * Author: Rui Chen
     * Date: 15/10/2018
     */
    static boolean step(Pos pos) {
        int v = maze[(int) (pos.y / (2 * Maze.offsetH))][(int) (pos.x / (2*Maze.offsetW))];
        maze[(int) (pos.y / (2 * Maze.offsetH))][(int) (pos.x / (2*Maze.offsetW))] = 0;
        if (v == 1) Game.mark += 1;
        if (v == 2) Game.mark += 5;
        return v == 2;
    }
}
