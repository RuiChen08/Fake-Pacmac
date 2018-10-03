package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Paint;

abstract class Ghost {

    Pos pos;
    Ghost(Pos pos){
        this.pos=pos;
    }

    boolean blueMode = false;

    void onDraw(Canvas canvas, Paint paint) {
        if (blueMode){
            // Todo, this should be the common-used code
        }else{
            // Todo
        }
    }

    void step() {
        //Todo, there should be common-used code both four ghost
    }
}
