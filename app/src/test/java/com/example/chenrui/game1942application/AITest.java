package com.example.chenrui.game1942application;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Author: Rui Chen
 * Date: 2018/10/18
 */

public class AITest {

    /*
     *  Author: Ruiyi Sun, Rui Chen
     *  Date: 18/10/2018
     * write some codes to BFS in AI class
     *
     * The maze is assumed to have walls surrounded outsides !!
     * */
    @Test
    public void BSF_Test(){
        //  the branch coverage test
        //1: if player not move ,the ghost will not move
        short[][] maze = new short[][]{
                {3,3,3,3,3,3,3,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,3,3,3,3,3,3,3}
        };
        Pos.Direction bst = AI.BFS(new AI.intPos(2,2), new AI.intPos(2,2) , maze);
        assertTrue("The direction should be expected,but is "+bst, bst == Pos.Direction.Stay);
        // 2: the other test in the branch
        short[][] maze1 = new short[][]{
                {3,3,3,3,3,3,3,3},
                {3,1,1,3,1,1,1,3},
                {3,1,1,3,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,3,3,3,3,3,3,3}
        };
        // this is the Down test
        Pos.Direction bst_1 = AI.BFS(new AI.intPos(1,2), new AI.intPos(2,2) , maze);
        assertTrue("The direction should be expected,but is " + bst_1, bst_1 == Pos.Direction.Down);
        // this is the up test
        Pos.Direction bst_2 = AI.BFS(new AI.intPos(3,2), new AI.intPos(1,2) , maze1);
        assertTrue("The direction should be expected,but is " + bst_2, bst_2 == Pos.Direction.Up);
        // this is the right test
        bst_2 = AI.BFS(new AI.intPos(3,2), new AI.intPos(3,5) , maze1);
        assertTrue("The direction should be expected,but is " + bst_2, bst_2 == Pos.Direction.Right);
        // this is the left test
        bst_2 = AI.BFS(new AI.intPos(3,2), new AI.intPos(3,1) , maze1);
        assertTrue("The direction should be expected,but is " + bst_2, bst_2 == Pos.Direction.Left);
    }

}
