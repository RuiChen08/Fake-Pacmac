package com.example.chenrui.game1942application;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
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
    Pos post_pos;

    Paint paint;
    Game game;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        game = new Game();
        setOnTouchListener(this);
        this.postDelayed(this, 25);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (pre_pos != null && post_pos != null) {
            drawVirtualKeys(canvas);
        }
        game.onDraw(canvas, paint);
    }

    /*
     * Author: Rui Chen
     * Date: 23/09/2018
     *
     * This is about drawing the virtual keys. Basically, it is a large circle and a small circle
     * where the small circle represents the direction
     */
    void drawVirtualKeys(Canvas canvas){
        paint.setColor(Color.GRAY);
        paint.setAlpha(0x40);
        float r = 0.1f * canvas.getWidth();
        canvas.drawCircle(pre_pos.x, pre_pos.y, r, paint);

        float l = (float) pre_pos.getDistance(post_pos);
        // If the small circle is not inside the large circle
        if (l >= r){
            // Adjust the coordinate so that the post pos is inside the large circle
            post_pos.x += (l - r) * (pre_pos.x - post_pos.x) / l;
            post_pos.y += (l - r) * (pre_pos.y - post_pos.y) / l;
        }
        paint.setAlpha(0x80);
        canvas.drawCircle(post_pos.x, post_pos.y, 0.05f * canvas.getWidth(), paint);
    }

    /*
     * Author: Rui Chen
     * Date: 22/09/2018
     *
     * Pass Direction to game so that pac-man could move
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                pre_pos = new Pos(motionEvent.getX(), motionEvent.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                post_pos = new Pos(motionEvent.getX(), motionEvent.getY());
                break;
            case MotionEvent.ACTION_UP:
                pre_pos = null;
                post_pos = null;
        }
        return true;
    }

    @Override
    public void run() {
        if (pre_pos != null && post_pos != null){
            game.move(pre_pos.getDirection(post_pos));
        }
        game.step();
        this.postDelayed(this, 25);
        this.invalidate();
    }
}
