package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 22/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

class Game {

    static final Pos START_POS= new Pos(0.5f,0.5f);
    static final float[] dxs = {0.1f, 0.2f, 0.3f};
    static final float[] dys = {0.1f, 0.2f, 0.3f};
    static final float[] pxs = {0.4f, 0.5f, 0.6f};
    static final float[] pys = {0.4f, 0.5f, 0.6f};

    private Ghost[] ghosts = new Ghost[4];
    private PacMan pacman = new PacMan();
    private Foods foods;

    Game() {
        /**
         * set a default position for ghost
         * @author Chucheng Qian
         * @Date 3/10/2018
         */
        ghosts[0] = new Blinky(START_POS);
        ghosts[1] = new Clyde(START_POS);
        ghosts[2] = new Inky(START_POS);
        ghosts[3] = new Pinky(START_POS);
        foods = new Foods(dxs, dys, dxs.length, pxs, pys, pxs.length);

    }


    void onDraw(Canvas canvas, Paint paint) {
        pacman.onDraw(canvas, paint);
        for (Ghost g : ghosts)
            g.onDraw(canvas, paint);
        foods.onDraw(canvas, paint);
    }

    void step() {
        for (Ghost g : ghosts)
            g.step();

    }

    void move(Pos.Direction direction){
        pacman.move(direction);

    }

/*Author:Ruiyi Sun
* Date : 23/09/2018
* update the arraylist 'Foods'
*********one problem is that the distance can not be specify because of the unknown radius ****************
 */
    public void update()  {
        for(int i=0;i<foods.size();i++){
            Food f = foods.get(i);
            double distance = Math.sqrt(Math.pow(pacman.pos.x - f.x, 2) + Math.pow(pacman.pos.y - f.y, 2));
            //ToDo : specify the radius to get the best destance
            if (distance <= 0.001f) {
                foods.remove(f);
                i --;
            }
        }
    }
}
