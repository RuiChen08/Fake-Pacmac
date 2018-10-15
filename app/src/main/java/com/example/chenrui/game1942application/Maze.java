package com.example.chenrui.game1942application;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

/**
 * Author: Rui Chen, Ruiyi Sun, Weiwei Liang
 * Date: 2018/10/12
 */

abstract class Maze{

    static short[][] maze = new short[][] {
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 3, 3, 1, 3, 3, 1, 3, 3, 3, 1, 3},
            {3, 1, 3, 1, 1, 1, 3, 3, 1, 1, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 1, 3, 3, 1, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 1, 1, 1, 1, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 3},
            {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
            {3, 1, 3, 1, 3, 3, 0, 0, 3, 3, 1, 3, 1, 3},
            {3, 1, 3, 1, 3, 0, 0, 0, 0, 3, 1, 3, 1, 3},
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
    static float widthSize = maze[0].length;
    static float heightSize = maze.length;
    static float offsetW = 1 / (2 * widthSize);
    static float offsetH = 1 / (2 * heightSize);

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
                    case 3:
                        paint.setColor(Color.BLUE);
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
    static void step(Pos pos) {
    }
}
