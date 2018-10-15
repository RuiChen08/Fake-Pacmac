package com.example.chenrui.game1942application;

import java.util.Random;

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
        //Todo This is not good enough, looking for better implementation
        /*if(posGhost.getDistance(posPacman)>=0.5f){
            Random random = new Random();
            int i=random.nextInt(4);
            Pos.Direction[] dd = {Pos.Direction.Up, Pos.Direction.Down, Pos.Direction.Right, Pos.Direction.Left};
            d= dd[i];
        }else{*/
            d = posGhost.getDirection(posPacman);
        //}
        return d;
    }

    Pos.Direction positionInFront(){
        //Todo, this is for ghost like Pinky
        return Pos.Direction.Down;
    }

}
