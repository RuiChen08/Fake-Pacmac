package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Author: Rui Chen
 * Date: 2018/10/14
 */

class Ghosts extends ArrayList<Ghost>{

    static final Pos START_POS_Blinky = new Pos(11 * Maze.offsetW,23 * Maze.offsetH);
    static final Pos START_POS_Clyde = new Pos(13 * Maze.offsetW,23 * Maze.offsetH);
    static final Pos START_POS_Inky = new Pos(15 * Maze.offsetW,23 * Maze.offsetH);
    static final Pos START_POS_Pinky = new Pos(17 * Maze.offsetW,23 * Maze.offsetH);

    /*
     * Author: Rui Chen
     * Date: 14/10/2018
     */
    Ghosts() {
        this.add(new Blinky(new Pos(START_POS_Blinky)));
        this.add(new Clyde(new Pos(START_POS_Clyde)));
        this.add(new Inky(new Pos(START_POS_Inky)));
        this.add(new Pinky(new Pos(START_POS_Pinky)));
    }

    /*
     * Author: Rui Chen
     * Date: 14/10/2018
     */
    void onDraw(Canvas canvas, Paint paint) {
        for (Ghost g : this) g.onDraw(canvas, paint);
    }

    /*
     * Author: Rui Chen
     * Date: 15/10/2018
     */
    void inBlue() {
        for (Ghost g : this) {
            g.blueMode = true;
            g.time = Ghost.timeInBlue;
        }
    }

    /*
     * Author: Rui Chen
     * Date: 15/10/2018
     */
    public void step(Pos pos) {
        for (Ghost g : this) g.step(pos);
    }
}
