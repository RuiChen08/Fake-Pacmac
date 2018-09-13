package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Author: Rui Chen
 * Date: 2018/9/14
 */

public class Game {
    Bombs bombs;
    PlayerAircraft playerAircraft;
    EnemiesAircraft enemiesAircraft;
    Missiles missiles;

    /*
     * Author: Rui Chen
     */
    public void onDraw(Canvas canvas, Paint paint){
        bombs.onDraw(canvas, paint);
        playerAircraft.onDraw(canvas, paint);
        enemiesAircraft.onDraw(canvas, paint);
        missiles.onDraw(canvas, paint);
    }

    /*
     * Author: Rui Chen
     */
    public void step(){
        bombs.step();
        playerAircraft.step();
        enemiesAircraft.step();
        missiles.step();
        //Todo Add bombs, check if aircraft is hit.
    }

    /*
     * Author: Rui Chen
     */
    public void onTouch(){
        //Todo
    }
}
