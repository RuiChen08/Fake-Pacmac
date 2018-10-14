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
     * fill the step method
     * draw the red ghost
     *
     * @Problem tried to use bitmap to paint the red ghost,but the "getresource" method cannot be used in normal java class(非activity)？.
     *
     * @author Chucheng Qian
     * @Date 14/10/2018
     */



    Blinky(Pos pos){
        super(pos);
    }


    static final float STEP = 0.005f;




    // Bitmap myImage;

    @Override
    void onDraw(Canvas canvas, Paint paint) {
        /*myImage = BitmapFactory.decodeResource(getResources(),R.drawable.blob);

        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setStrokeWidth(10.0f);
        canvas.drawBitmap(myImage, pos.x, pos.y, p);*/
        super.onDraw(canvas, paint);

        paint.setColor(Color.RED);
        canvas.drawCircle(pos.x * canvas.getWidth(), pos.y * canvas.getHeight(), canvas.getHeight() * 0.025f, paint);


    }

    /*private Resources getResources() {

        Resources mResources = null;
        mResources = getResources();
        return mResources;
    }*/

    void step(Pos pacManPos) {
        super.step(pacManPos);

        if (AI.chasing(pacManPos, this.pos) == Pos.Direction.Up) {
            pos.y -= STEP;}
        else if (AI.chasing(pacManPos, this.pos) == Pos.Direction.Down) {
            pos.y += STEP;}
        else if (AI.chasing(pacManPos, this.pos) == Pos.Direction.Right) {
            pos.x += STEP;}
        else if (AI.chasing(pacManPos, this.pos) == Pos.Direction.Left) {
            pos.x -= STEP;}

        /*if(ai.chasing(pos_default,pos)== Pos.Direction.Up){
            pos.y -= 0.005f;
        }
       /* else if(ai.chasing(pos,pos_default)== Pos.Direction.Down){
            pos.y += 0.005f;
        }
        else if(ai.chasing(pos,pos_default)== Pos.Direction.Right){
            pos.x += 0.005f;
        }
        else if(ai.chasing(pos,pos_default)== Pos.Direction.Left){
            pos.x -= 0.005f;
        }*/
            //Todo, Considering there are different AI for each ghost.

        }
    }


