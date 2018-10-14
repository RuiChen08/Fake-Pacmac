package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 22/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Paint;

class Game {

    static final Pos START_POS= new Pos(0.5f,0.5f);
    static final Pos START_POS_Ghosts= new Pos(0.9f,0.9f);
    static final float[] dxs = {0.1f, 0.2f, 0.3f};
    static final float[] dys = {0.1f, 0.2f, 0.3f};
    static final float[] pxs = {0.4f, 0.5f, 0.6f};
    static final float[] pys = {0.4f, 0.5f, 0.6f};

    private Ghost[] ghosts = new Ghost[4];
    private PacMan pacman;
    private Foods foods;

    /*
     * set an initial position for ghost
     * @author Chucheng Qian
     * @Date 14/10/2018
     */
    Game() {
        ghosts[0] = new Blinky(new Pos(START_POS_Ghosts.x, START_POS_Ghosts.y));
        ghosts[1] = new Clyde(new Pos(START_POS_Ghosts.x, START_POS_Ghosts.y));
        ghosts[2] = new Inky(new Pos(START_POS_Ghosts.x, START_POS_Ghosts.y));
        ghosts[3] = new Pinky(new Pos(START_POS_Ghosts.x, START_POS_Ghosts.y));
        pacman = new PacMan(new Pos(START_POS.x, START_POS.y));
        foods = new Foods(dxs, dys, dxs.length, pxs, pys, pxs.length);

    }


    /* Authors: Ruiyi Sun, Weiwei Liang
     * Date: 08/10/2018
     */
    void onDraw(Canvas canvas, Paint paint) {
        for (Ghost g : ghosts) g.onDraw(canvas, paint);
        pacman.onDraw(canvas, paint);
        for (Ghost g : ghosts)
            g.onDraw(canvas, paint);
        foods.onDraw(canvas, paint);
    }

    /* Authors: Ruiyi Sun, Weiwei Liang,Chucheng Qian
     * Date: 14/10/2018
     */
    void step() {
        for (Ghost g : ghosts) g.step(pacman.pos);
        foods.step(pacman.pos, pacman.radius);
        pacman.step();
    }

    void move(Pos.Direction direction){
        pacman.changeDirection(direction);

    }
}
