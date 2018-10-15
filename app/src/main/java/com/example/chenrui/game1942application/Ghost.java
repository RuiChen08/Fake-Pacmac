package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen,Chucheng Qian, Ruiyi Sun
 * Date: 14/10/2018
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

abstract class Ghost {

    float STEP;
    static final float Radius = PacMan.Radius;
    static final int timeInBlue = 500;

    boolean blueMode = false;
    int time = timeInBlue;
    Pos pos;

    Ghost(Pos pos){
        this.pos = pos;
    }

    /*
     * Authors: Rui Chen,Chucheng Qian, Ruiyi Sun
     * Date: 14/10/2018
     */
    void onDraw(Canvas canvas, Paint paint) {
        if (blueMode){
            paint.setColor(Color.BLUE);
            blueMode = time-- != 0;
        }
        canvas.drawCircle(pos.x * canvas.getWidth(), pos.y * canvas.getHeight(), Radius * canvas.getHeight(), paint);
    }

    /*
     * Authors: Rui Chen,Chucheng Qian, Ruiyi Sun
     * Date: 14/10/2018
     */
    void step(Pos pacManPos) {
        if (pos.getDistance(pacManPos) <= PacMan.Radius + Radius) PacMan.life--;
        if(blueMode) getMove(pacManPos.getDirection(this.pos));
    }

    /*
     * Author: Rui Chen
     * Date: 15/10/2018
     *
     * Common-Used codes
     */
    void getMove(Pos.Direction direction){
        if (direction == Pos.Direction.Up) {
            pos.y -= STEP;}
        else if (direction == Pos.Direction.Down) {
            pos.y += STEP;}
        else if (direction == Pos.Direction.Right) {
            pos.x += STEP;}
        else if (direction == Pos.Direction.Left) {
            pos.x -= STEP;}
    }
}
