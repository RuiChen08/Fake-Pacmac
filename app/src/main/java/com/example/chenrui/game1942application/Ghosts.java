package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Author: Rui Chen(u5958754)
 * Date: 2018/10/14
 */

class Ghosts extends ArrayList<Ghost>{

    /*
     * Author: Rui Chen(u5958754)
     * Date: 14/10/2018
     */
    Ghosts() {
        this.add(new Blinky());
        this.add(new Clyde());
        this.add(new Inky());
        this.add(new Pinky());
    }

    /*
     * Author: Rui Chen(u5958754)
     * Date: 14/10/2018
     */
    void onDraw(Canvas canvas, Paint paint) {
        for (Ghost g : this) g.onDraw(canvas, paint);
    }

    /*
     * Author: Rui Chen(u5958754)
     * Date: 15/10/2018
     */
    void inBlue() {
        for (Ghost g : this) {
            g.blueMode = true;
            g.time = Ghost.timeInBlue;
        }
    }

    /*
     * Author: Rui Chen(u5958754)
     * Date: 15/10/2018
     */
    public void step(PacMan pacMan) {
        for (Ghost g : this) g.step(pacMan);
    }
}
