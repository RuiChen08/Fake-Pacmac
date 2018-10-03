package com.example.chenrui.game1942application;

/**
 * Author: Rui Chen
 * Date: 2018/9/22
 */

public class AI {

    /**
     * Add basic code for direction guide（chasing）
     *
     * @Problem trying to use Dijkstra but it is hard if we use the wall to constrain the pacman istead of fixed road
     * however, the chasing part may not require a complex ai as in the real game,the ghost is just chasing the pacman stupidly..
     *
     * @author Chucheng Qian
     * @Date 3/10/2018
     */

    Pos.Direction chasing(Pos posPacman ,Pos posGhost){
        Pos.Direction d =posGhost.getDirection(posPacman);

        //Todo, this is for ghost like Blinky that will chase pac-man
        return d;
    }

    Pos.Direction positionInFront(){
        //Todo, this is for ghost like Pinky
        return Pos.Direction.Down;
    }

}
