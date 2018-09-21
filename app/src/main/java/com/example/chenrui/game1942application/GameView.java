package com.example.chenrui.game1942application;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/*
 * Authors: Rui Chen
 * Date: 22/09/2018
 */

public class GameView extends View implements Runnable, View.OnTouchListener{

    //This field records the position when screen was touched. (namely ACTION_DOWN)
    Pos pre_pos;

    Paint paint;
    Game game;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        game = new Game();
        setOnTouchListener(this);
        this.postDelayed(this, 100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        game.onDraw(canvas, paint);
    }

    /*
     * Author: Rui Chen
     * Date: 22/09/2018
     *
     * Pass Direction to game so that pac-man could move
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //
        // This is a bad implementation. If anyone have a better idea, please implement your version.
        // You should pass a parameter, direction, to game.move method. So that pac-man to perform a movement
        //
        /*if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            pre_pos = new Pos(motionEvent.getX(), motionEvent.getY());

        } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE){
            Pos post_pos = new Pos(motionEvent.getX(), motionEvent.getY());

            //Get which direction where user's finger move to. Four possible case: Up, Down, Right, and Left.
            game.move(pre_pos.getDirection(post_pos));
            this.invalidate();
        }*/
        return true;
    }

    @Override
    public void run() {
        step();
    }

    private void step() {
        game.step();
    }
}
