package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen,Chucheng Qian
 * add constructor,add situation that pacman "die"
 *
 * Date: 19/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

abstract class Ghost {
    /*
     * Authors: Ruiyi Sun
     * Date: 14/10/2018
     */
    Pos pos;
    Ghost(Pos pos){
        this.pos=pos;
    }

    boolean blueMode = false;
    int time = 500;
    void onDraw(Canvas canvas, Paint paint) {
        if (blueMode){
            // Todo, this should be the common-used code
            paint.setColor(Color.BLUE);
            canvas.drawCircle(pos.x * canvas.getWidth(), pos.y * canvas.getHeight(), canvas.getHeight() * 0.025f, paint);
            time--;
            if(time == 0) blueMode = false;
        }else{
            // Todo
        }
    }
    static final float STEP = 0.005f;

    void step(Pos pacManPos) {
        //Todo, there should be common-used code both four ghost
        if(blueMode){
            if (pacManPos.getDirection(this.pos) == Pos.Direction.Up) {
                pos.y += STEP;}
            else if (pacManPos.getDirection(this.pos) == Pos.Direction.Down) {
                pos.y -= STEP;}
            else if (pacManPos.getDirection(this.pos) == Pos.Direction.Right) {
                pos.x -= STEP;}
            else if (pacManPos.getDirection(this.pos) == Pos.Direction.Left) {
                pos.x += STEP;}
        }
    }
}
