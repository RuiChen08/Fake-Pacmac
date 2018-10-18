package com.example.chenrui.game1942application;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

/*
 * Authors: Rui Chen
 * Date: 22/09/2018
 */

public class GameView extends View implements Runnable, View.OnTouchListener, Observer{

    //This field records the position when screen was touched. (namely ACTION_DOWN)
    Pos pre_pos;
    Pos post_pos;

    Paint paint;
    Game game;
    Observer observer;
    boolean finished = false;

    /*
     * Authors: Rui Chen
     * Date: 14/09/2018
     */
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        game = new Game(metrics.heightPixels, metrics.widthPixels, this);
        setOnTouchListener(this);
        this.postDelayed(this, 500);
        // This is for resolving the acceleration problem
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    /*
     * Authors: Rui Chen
     * Date: 14/09/2018
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        game.onDraw(canvas, paint);
    }

    /*
     * Author: Rui Chen
     * Date: 22/09/2018
     *
     * Pass Direction to game so that pac-man could changeDirection
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
        if (pre_pos != null && post_pos != null){
            game.move(pre_pos.getDirection(post_pos));
        }
        return true;
    }

    /*
     * Author: Rui Chen
     * Date: 18/10/2018
     */
    @Override
    public void run() {
        if (!finished) {
            game.step();
            this.invalidate();
            this.postDelayed(this, 500);
        }
    }


    /*
     * Author: ChuCheng Qian
     * Date: 18/10/2018
     */
    void registerObserver(Observer observer) {
        this.observer = observer;
    }

    /*
     * Author: ChuCheng Qian
     * Date: 18/10/2018
     */
    @Override
    public void update() {
        finished = true;
        observer.update();
    }

}
