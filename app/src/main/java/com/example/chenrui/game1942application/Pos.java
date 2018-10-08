package com.example.chenrui.game1942application;

/*
 * Authors: Rui Chen
 * Date: 19/09/2018
 */

public class Pos {
    float x;
    float y;

    Pos(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getDistance(Pos pos){
        return (float) Math.sqrt(Math.pow(pos.x - x, 2) + Math.pow(pos.y - y, 2));
    }

    /*
     * Author: Rui Chen
     * Date: 22/09/2018
     *
     * Parameter: The post-pos. Pre-pos is the instance which called this method
     * Return: the direction from pre-pos to post-pos
     */
    Direction getDirection(Pos pos){
        if (pos.x > x && pos.y > y){
            if (pos.x - x > pos.y - y) return Direction.Right;
            else return Direction.Down;
        } else if (pos.x > x && pos.y < y){
            if (pos.x - x > y - pos.y) return Direction.Right;
            else return Direction.Up;
        } else if (pos.x < x && pos.y < y){
            if (x - pos.x > y - pos.y) return Direction.Left;
            else return Direction.Up;
        } else {
            if (x - pos.x > pos.y - y) return Direction.Left;
            else return Direction.Down;
        }
    }

    static enum Direction {
        Up, Down, Right, Left;
    }
}
