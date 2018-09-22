package com.example.chenrui.game1942application;

/**
 * Author: Rui Chen
 * Date: 2018/9/22
 */

public class AI {

    Pos.Direction chasing(){
        //Todo, this is for ghost like Blinky that will chase pac-man
        return Pos.Direction.Down;
    }

    Pos.Direction positionInFront(){
        //Todo, this is for ghost like Pinky
        return Pos.Direction.Down;
    }

}
