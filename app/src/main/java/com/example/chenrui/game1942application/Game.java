package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 22/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Paint;

class Game {

    static int mark = 0;

    static final Pos START_POS= new Pos(0.5f,0.5f);
    static final Pos START_POS_Ghosts= new Pos(0.9f,0.9f);
    static final float[] dxs = {0.1f, 0.2f, 0.3f};
    static final float[] dys = {0.1f, 0.2f, 0.3f};
    static final float[] pxs = {};
    static final float[] pys = {};

    private Ghosts ghosts;
    private PacMan pacman;
    private Foods foods;

    /*
     * set an initial position for ghost
     * @author Chucheng Qian, Rui Chen
     * @Date 14/10/2018
     */
    Game() {
        ghosts = new Ghosts();
        pacman = new PacMan(new Pos(START_POS));
        foods = new Foods(dxs, dys, dxs.length, pxs, pys, pxs.length);
    }


    /* Authors: Ruiyi Sun, Weiwei Liang, Rui Chen
     * Date: 14/10/2018
     */
    void onDraw(Canvas canvas, Paint paint) {
        ghosts.onDraw(canvas, paint);
        pacman.onDraw(canvas, paint);
        foods.onDraw(canvas, paint);
    }

    /* Authors: Ruiyi Sun, Weiwei Liang,Chucheng Qian, Rui Chen
     * Date: 14/10/2018
     */
    void step() {
        if(foods.step(pacman.pos, PacMan.Radius)){
            ghosts.inBlue();
        }
        ghosts.step(pacman.pos);
        pacman.step();
    }

    void move(Pos.Direction direction){
        pacman.changeDirection(direction);
    }
}
