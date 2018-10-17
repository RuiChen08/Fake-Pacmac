package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 22/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Game {

    static int mark = 0;
    static int life = 3;

    static final Pos START_POS= new Pos(13 * Maze.offsetW,47 * Maze.offsetH);
    static float ScreenWidth;
    static float ScreenHeight;

    private Ghosts ghosts;
    private PacMan pacman;

    /*

     * @author Chucheng Qian, Rui Chen
     * @Date 14/10/2018
     */
    Game(int heightPixels, int widthPixels) {
        ScreenWidth = widthPixels;
        ScreenHeight = heightPixels;
        pacman = new PacMan(new Pos(START_POS));
        ghosts = new Ghosts();
    }


    /* Authors: Ruiyi Sun, Weiwei Liang, Rui Chen
     * Date: 14/10/2018
     */
    void onDraw(Canvas canvas, Paint paint) {
        ghosts.onDraw(canvas, paint);
        pacman.onDraw(canvas, paint);
        Maze.onDraw(canvas, paint);

        // Drawing the marks and life counter
        Paint pp = new Paint(Color.RED);
        pp.setTextSize(40);
        canvas.drawText("LIFE:", Maze.offsetW * canvas.getWidth(), Maze.offsetH * canvas.getHeight(), pp);
        canvas.drawText("MARK:",ScreenWidth - Maze.offsetW * canvas.getWidth() * 6, Maze.offsetH * canvas.getHeight(), pp);
        canvas.drawText(""+Game.life,150 + Maze.offsetW * canvas.getWidth(),Maze.offsetH * canvas.getHeight(),pp);
        canvas.drawText(""+Game.mark, 150 + ScreenWidth - Maze.offsetW * canvas.getWidth() * 6,Maze.offsetH * canvas.getHeight(),pp);
    }

    /* Authors: Ruiyi Sun, Weiwei Liang,Chucheng Qian, Rui Chen
     * Date: 14/10/2018
     */
    void step() {
        ghosts.step(pacman.pos);
        pacman.step();
        if (Maze.step(pacman.pos)) ghosts.inBlue();
    }

    /* Authors: Rui Chen
     * Date: 14/10/2018
     */
    void move(Pos.Direction direction){
        pacman.changeDirection(direction);
    }
}

