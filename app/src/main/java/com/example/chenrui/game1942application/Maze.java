package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Author: Rui Chen
 * Date: 2018/10/12
 */

public class Maze {
    /**
     * Author: Ruiyi Sun
     * Date: 2018/10/14
     * draw a maze that should be like the classic one
     */


    public void onDraw(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLACK);
        float  RECTTHICKNESS = canvas.getHeight() * PacMan.radius *2 ;// this is also the diameter of the PacMan
        float REMINDWIDTH = canvas.getWidth()%RECTTHICKNESS;
        float REMINDHEIGHT = canvas.getHeight()%RECTTHICKNESS;
        // set the outside block
        // this is the left bound
        canvas.drawRect(REMINDWIDTH/2,REMINDHEIGHT/2,REMINDWIDTH/2 + RECTTHICKNESS,canvas.getHeight()-REMINDHEIGHT/2,paint);
        // this is the top bound
        canvas.drawRect(REMINDWIDTH/2,REMINDHEIGHT/2, canvas.getWidth()-REMINDWIDTH/2,REMINDHEIGHT/2 + RECTTHICKNESS,paint);
        // this is the right bound
        canvas.drawRect(canvas.getWidth()-REMINDWIDTH/2-RECTTHICKNESS,REMINDHEIGHT/2,canvas.getWidth()-REMINDWIDTH/2,canvas.getHeight()-REMINDHEIGHT/2,paint);
        // this is the bottom bound
        canvas.drawRect(REMINDWIDTH/2,canvas.getHeight()-REMINDHEIGHT/2,canvas.getWidth()-REMINDWIDTH/2,canvas.getHeight()-REMINDHEIGHT/2-RECTTHICKNESS,paint);
        // this is the ghost center
        paint.setColor(Color.BLACK);
        canvas.drawRect(canvas.getWidth()/2-RECTTHICKNESS*3,canvas.getHeight()/2-RECTTHICKNESS*2,canvas.getWidth()/2+RECTTHICKNESS*3,canvas.getHeight()/2+RECTTHICKNESS*2,paint);
        paint.setColor(Color.WHITE);
        canvas.drawRect(canvas.getWidth()/2-RECTTHICKNESS*2,canvas.getHeight()/2-RECTTHICKNESS,canvas.getWidth()/2+RECTTHICKNESS*2,canvas.getHeight()/2+RECTTHICKNESS,paint);
        canvas.drawRect(canvas.getWidth()/2-RECTTHICKNESS,canvas.getHeight()/2-RECTTHICKNESS*2,canvas.getWidth()/2+RECTTHICKNESS,canvas.getHeight()/2+RECTTHICKNESS*2,paint);

        //draw the other block
        paint.setColor(Color.BLACK);
        canvas.drawRect(REMINDWIDTH/2+RECTTHICKNESS*3,REMINDHEIGHT/2+RECTTHICKNESS*3,REMINDWIDTH/2 + RECTTHICKNESS*8,REMINDHEIGHT/2+RECTTHICKNESS*2,paint);
        canvas.drawRect(REMINDWIDTH/2+RECTTHICKNESS*2,canvas.getHeight()/5,REMINDWIDTH/2+RECTTHICKNESS,canvas.getHeight()*0.5f,paint );
        canvas.drawRect(REMINDWIDTH/2+RECTTHICKNESS*4,REMINDHEIGHT/2+RECTTHICKNESS*5,REMINDWIDTH/2 + RECTTHICKNESS*12,REMINDHEIGHT/2+RECTTHICKNESS*6,paint);
        canvas.drawRect(canvas.getWidth()-(REMINDWIDTH/2+RECTTHICKNESS*2),canvas.getHeight()-REMINDHEIGHT/2-RECTTHICKNESS*3,REMINDWIDTH/2 + RECTTHICKNESS*8,canvas.getHeight()-REMINDHEIGHT/2-RECTTHICKNESS*2,paint);
        canvas.drawRect(canvas.getWidth()-(REMINDWIDTH/2+RECTTHICKNESS*8),canvas.getHeight()-REMINDHEIGHT/2-RECTTHICKNESS*5,REMINDWIDTH/2 + RECTTHICKNESS*2 ,canvas.getHeight()-REMINDHEIGHT/2-RECTTHICKNESS*6,paint);

        canvas.drawRect(canvas.getWidth()-(REMINDWIDTH/2+RECTTHICKNESS*5),canvas.getHeight()-REMINDHEIGHT/2-RECTTHICKNESS*4,REMINDWIDTH/2+ RECTTHICKNESS*2  ,canvas.getHeight()-REMINDHEIGHT/2-RECTTHICKNESS*3,paint);
    }
}
