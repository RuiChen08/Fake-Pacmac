package com.example.chenrui.game1942application;

/**
 * Author: Rui Chen
 * Date: 2018/9/22
 */

public class AI {

    /**
     * Add basic code for direction guide（chasing）
     *
     * @author Chucheng Qian
     * @Date 14/10/2018
     */

    static Pos.Direction chasing(Pos posPacman ,Pos posGhost){
        Pos.Direction d;
        if(posGhost.getDistance(posPacman)>=0.5f){
            d=Pos.Direction.Up;
        }else{
            d = posGhost.getDirection(posPacman);
        }

        //Todo, this is for ghost like Blinky that will chase pac-man
        return d;
    }

    Pos.Direction positionInFront(){
        //Todo, this is for ghost like Pinky
        return Pos.Direction.Down;
    }

}
