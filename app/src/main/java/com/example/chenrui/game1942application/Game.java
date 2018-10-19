package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen(u5958754)
 * Date: 22/09/2018
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Game {

    static int mark;

    static float ScreenWidth;
    static float ScreenHeight;

    Observer observer;

    Ghosts ghosts;
    PacMan pacman;
    Maze maze;

    /*

     * @author Chucheng Qian(u6451847), Rui Chen(u5958754)
     * @Date 14/10/2018
     */
    Game(int heightPixels, int widthPixels, Observer observer) {
        ScreenWidth = widthPixels;
        ScreenHeight = heightPixels;
        ghosts = new Ghosts();
        maze = new Maze();
        pacman = new PacMan();
        this.observer = observer;
        mark = 0;
    }


    /* Authors: Ruiyi Sun(u6233314), Weiwei Liang(u6642464), Rui Chen(u5958754)
     * Date: 14/10/2018
     */
    void onDraw(Canvas canvas, Paint paint) {
        maze.onDraw(canvas, paint);
        pacman.onDraw(canvas, paint);
        ghosts.onDraw(canvas, paint);

        // Drawing the marks and life counter
        Paint pp = new Paint(Color.RED);
        pp.setTextSize(Maze.offsetH * canvas.getHeight());
        canvas.drawText("LIFE:", Maze.offsetW * canvas.getWidth(), Maze.offsetH * canvas.getHeight(), pp);
        canvas.drawText("MARK:",ScreenWidth - Maze.offsetW * canvas.getWidth() * 6, Maze.offsetH * canvas.getHeight(), pp);
        canvas.drawText(""+pacman.life, 3 * Maze.offsetW * canvas.getWidth(),Maze.offsetH * canvas.getHeight(),pp);
        canvas.drawText(""+Game.mark, ScreenWidth - Maze.offsetW * canvas.getWidth() * 3,Maze.offsetH * canvas.getHeight(),pp);
    }

    /* Authors: Ruiyi Sun(u6233314), Weiwei Liang(u6642464),Chucheng Qian(u6451847), Rui Chen(u5958754)
     * Date: 14/10/2018
     */
    void step() {
        if (maze.step(pacman.pos)) ghosts.inBlue();
        ghosts.step(pacman);
        pacman.step();
        if (pacman.life <= 0) observer.update();
        if (maze.noDots()) observer.update();
    }

    /* Authors: Rui Chen(u5958754)
     * Date: 14/10/2018
     */
    void move(Pos.Direction direction){
        pacman.changeDirection(direction);
    }
}

