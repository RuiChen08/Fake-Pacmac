package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2018
 *
 * If Pac-Man eat one Power Pellet, all ghosts should turn into 'Blue Mode' for 15 seconds
 */


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
/*
 *Author: Ruiyi Sun
 * Date: 2018/09/22
 * add float x and y
 * finish the onDraw
 */
public class PowerPellet extends View implements Food{
    float x;
    float y;

    public PowerPellet(Context context, @Nullable AttributeSet attrs,float x,float y) {
        super(context, attrs);
        this.x =x;
        this.y = y;
    }

    @Override
    public void onDraw(Canvas canvas, Paint paint) {

        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(Color.BLUE);//PowerPellet should be a blue dot
        float radius = 0.05f * canvas.getWidth();
        canvas.drawCircle(x,y,radius,paint);

    }
}
