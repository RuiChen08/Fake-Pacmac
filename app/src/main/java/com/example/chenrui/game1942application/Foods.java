package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Author: Rui Chen
 * Date: 2018/9/22
 */

public class Foods extends ArrayList<Food> {

    /**
     * add a int to store the mark
     * Author: Chcuheng Qian
     * Date: 14/10/2018
     */

    int mark=0;

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

    /*
     * Author: Weiwei Liang,Ruiyi Sun
     * Date : 08/10/2018
     */
    boolean step(Pos pos, float radius) {
        Iterator<Food> i = iterator();
        boolean eatPowerPellet = false;
        while (i.hasNext()){
            Food f = (Food) i.next();
            if (pos.getDistance(f.pos) <= radius) {
                if(f instanceof PowerPellet){
                    eatPowerPellet = true;
                }
                i.remove();
            }
        }
        return eatPowerPellet;
    }
}
