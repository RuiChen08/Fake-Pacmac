package com.example.chenrui.game1942application;

import java.util.List;
import java.util.Random;

import static com.example.chenrui.game1942application.Pos.Direction.Down;
import static com.example.chenrui.game1942application.Pos.Direction.Left;
import static com.example.chenrui.game1942application.Pos.Direction.Right;
import static com.example.chenrui.game1942application.Pos.Direction.Stay;
import static com.example.chenrui.game1942application.Pos.Direction.Up;

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
            Random random = new Random();
            int i=random.nextInt(4);
            Pos.Direction[] dd = {Up, Down, Right, Left};
            d= dd[i];
        }else{
            d = posGhost.getDirection(posPacman);
        }

        //Todo, this is for ghost like Blinky that will chase pac-man
        return d;
    }

    Pos.Direction positionInFront(){
        //Todo, this is for ghost like Pinky
        return Down;
    }

}
