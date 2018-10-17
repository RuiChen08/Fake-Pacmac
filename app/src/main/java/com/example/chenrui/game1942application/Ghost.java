package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen,Chucheng Qian, Ruiyi Sun
 * Date: 14/10/2018
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

abstract class Ghost {

    static final float Radius = PacMan.Radius;
    static final int timeInBlue = 20;

    boolean blueMode = false;
    int time = timeInBlue;
    Pos pos;
    Pos.Direction direction = Pos.Direction.Stay;
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
        canvas.drawCircle(pos.x * canvas.getWidth(), pos.y * canvas.getHeight(), Radius, paint);
    }

    /*
     * Authors: Rui Chen,Chucheng Qian, Ruiyi Sun
     * Date: 14/10/2018
     */
    void step(Pos pacManPos) {
        Pos gg = new Pos(pos.x * Game.ScreenWidth, pos.y*Game.ScreenHeight);
        Pos pp = new Pos(pacManPos.x * Game.ScreenWidth, pacManPos.y*Game.ScreenHeight);
        if (gg.getDistance(pp) <= PacMan.Radius+Radius ){ Game.life--;}
        if(blueMode) getMove(pacManPos.getDirection(this.pos));
    }

    /*
     * Author: Rui Chen,Ruiyi Sun
     * Date: 15/10/2018
     *
     * Common-Used codes
     */
    void getMove(Pos.Direction direction){
        Pos p = new Pos(this.pos);

        if (direction == Pos.Direction.Up) {pos.y -= Maze.offsetH * 2; this.direction = Pos.Direction.Down;}
        else if (direction == Pos.Direction.Down) {pos.y += Maze.offsetH * 2;this.direction = Pos.Direction.Up;}
        else if (direction == Pos.Direction.Right) {pos.x += Maze.offsetW * 2;this.direction = Pos.Direction.Left;}
        else if (direction == Pos.Direction.Left) {pos.x -= Maze.offsetW * 2;this.direction = Pos.Direction.Right;}

        // backing up the original position if current position is inside the wall
        if (Maze.maze[(int) (this.pos.y / (2 * Maze.offsetH))][(int) (this.pos.x / (2*Maze.offsetW))] == 3) {
            this.pos = p;
            changeDirection(direction);
        }
    }
    /*
     * Author: Ruiyi Sun
     * Date: 17/10/2018
     *
     * when the ghost cannot move to the current position, it will change the position
     */

    void changeDirection(Pos.Direction PacManDirection){
        Pos.Direction[] directions = new Pos.Direction[] {Pos.Direction.Up,Pos.Direction.Down ,Pos.Direction.Left,Pos.Direction.Right};
        for(int i = 0;i<directions.length;i++){
            if(PacManDirection != directions[i] && this.direction != directions[i]){
                this.direction = directions[i] ;
                run();
                if(this.direction != Pos.Direction.Stay){
                    break;
                }
            }
        }
    }

    /*Author :Ruiyi Sun
     *Date: 17/10/2018
     *
     * this is just copy and paste the PacMan code If anyone can help me fix this problem!!!!!!!!!!
     *
     */
    void run(){
        //Todo : simplify this code copied from PacMan!!
        Pos p = new Pos(this.pos);

        if (direction == Pos.Direction.Up) pos.y -= Maze.offsetH * 2;
        else if (direction == Pos.Direction.Down) pos.y += Maze.offsetH * 2;
        else if (direction == Pos.Direction.Right) pos.x += Maze.offsetW * 2;
        else if (direction == Pos.Direction.Left) pos.x -= Maze.offsetW * 2;
        // backing up the original position if current position is inside the wall
        if (Maze.maze[(int) (this.pos.y / (2 * Maze.offsetH))][(int) (this.pos.x / (2*Maze.offsetW))] >= 3) {
            this.pos = p;
            this.direction = Pos.Direction.Stay;
        }
    }

}

