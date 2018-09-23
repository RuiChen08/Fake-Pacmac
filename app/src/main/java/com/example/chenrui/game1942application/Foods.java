package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Author: Rui Chen
 * Date: 2018/9/22
 */

public class Foods extends ArrayList<Food> {

    /*
     * Author: Rui Chen
     * Date: 23/09/2018
     *
     * Parameter: dxs and dys and dsize is for PacDot. pxs, pys and psize is for PowerPellet
     */
    Foods(float[] dxs, float[] dys, int dsize, float[] pxs, float[] pys, int psize) {
        for (int i = 0; i < dsize; i++){
            this.add(new PacDot(dxs[i], dys[i]));
        }
        for (int i = 0; i < psize; i++){
            this.add(new PowerPellet(pxs[i], pys[i]));
        }
    }

    public void onDraw(Canvas canvas, Paint paint) {
        for (Food f : this)
            f.onDraw(canvas, paint);
    }
}
