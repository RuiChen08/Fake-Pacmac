package com.example.chenrui.game1942application;

/**
 * Authors: Rui Chen
 * Date: 2018/9/14
 */

public class Pos {
    double x;
    double y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Pos pos){
        return Math.sqrt(Math.pow(pos.x - this.x, 2.0) + Math.pow(pos.y - this.y, 2.0));
    }

}
