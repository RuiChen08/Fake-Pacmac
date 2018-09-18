package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2018
 */

public class Pos {
    double x;
    double y;

    public Pos(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Pos pos){
        return Math.sqrt(Math.pow(pos.x - x, 2) + Math.pow(pos.y - y, 2));
    }
}
