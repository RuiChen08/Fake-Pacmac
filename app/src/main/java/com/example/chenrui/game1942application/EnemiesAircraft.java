package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Author: Rui Chen
 * Date: 2018/9/14
 */

public class EnemiesAircraft extends ArrayList<EnemyAircraft>{


    /*
     * Author: Rui Chen
     */
    public void onDraw(Canvas canvas, Paint paint) {
        for (EnemyAircraft ea : this)
            ea.onDraw(canvas, paint);
    }

    /*
     * Author: Rui Chen
     */
    public void step() {
        for (EnemyAircraft ea : this)
            ea.step();
    }
}
