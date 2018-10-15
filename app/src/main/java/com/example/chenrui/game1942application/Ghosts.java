package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Author: Rui Chen
 * Date: 2018/10/14
 */

class Ghosts extends ArrayList<Ghost>{

    /*
     * Author: Rui Chen
     * Date: 14/10/2018
     */
    Ghosts() {
        this.add(new Blinky(new Pos(Game.START_POS_Ghosts)));
        this.add(new Clyde(new Pos(Game.START_POS_Ghosts)));
        this.add(new Inky(new Pos(Game.START_POS_Ghosts)));
        this.add(new Pinky(new Pos(Game.START_POS_Ghosts)));
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
