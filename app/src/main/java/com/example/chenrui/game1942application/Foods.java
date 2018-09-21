package com.example.chenrui.game1942application;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Author: Rui Chen
 * Date: 2018/9/22
 */

public class Foods extends ArrayList<Food> {
    public void onDraw(Canvas canvas, Paint paint) {
        for (Food f : this)
            f.onDraw(canvas, paint);
    }
}
