package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2019
 *
 * Blinky is one of the Ghosts: Blinky, is a red ghost who, in the original arcade game, follows behind Pac-Man. He is considered the leader of the ghosts.
 */

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Blinky extends Ghost {

    /**
     * Add the constructor
     * fill the step method(comment because there are bugs while running,it controls the pacman.... )
     *
     * @Problem tried to use bitmap to paint the red ghost,but the "getresource" method cannot be used in normal java class(非activity)？.
     * @Problem need to pass the position of pacman to the ghost class
     *
     *
     * @author Chucheng Qian
     * @Date 3/10/2018
     */



    Blinky(Pos pos){
        super(pos);
    }

    AI ai;
    Pos pos_default =new Pos(5.0f,5.0f);

   // Bitmap myImage;

    @Override
    void onDraw(Canvas canvas, Paint paint) {
        /*myImage = BitmapFactory.decodeResource(getResources(),R.drawable.blob);

        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setStrokeWidth(10.0f);
        canvas.drawBitmap(myImage, pos.x, pos.y, p);*/

        paint.setColor(Color.RED);
        super.onDraw(canvas, paint);
    }

    /*private Resources getResources() {

        Resources mResources = null;
        mResources = getResources();
        return mResources;
    }*/

    @Override
    void step() {
        /*if(ai.chasing(pos,pos_default)== Pos.Direction.Up){
            pos.y -= 0.005f;
        }
        /*else if(ai.chasing(pos,pos_default)== Pos.Direction.Down){
            pos.y += 0.005f;
        }
        else if(ai.chasing(pos,pos_default)== Pos.Direction.Right){
            pos.x += 0.005f;
        }
        else if(ai.chasing(pos,pos_default)== Pos.Direction.Left){
            pos.x -= 0.005f;
        }*/
        //Todo, Considering there are different AI for each ghost.
        super.step();
    }
}
