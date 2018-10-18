package com.example.chenrui.game1942application;

import org.junit.Test;

import java.util.Random;

import static junit.framework.Assert.assertEquals;
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
     * Black box testing, we know the codes
     * */
    @Test
    public void BFS_Test(){
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
                {3,1,1,3,1,1,1,3},
                {3,1,1,3,1,1,1,3},
                {3,1,1,3,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,3,3,3,3,3,3,3}
        };
        // This is a black box testing, it is branch complete
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

    /*
     * Author: Rui Chen
     * Date: 19/10/2018
     */
    @Test
    public void movingAITest(){
        Pos posPacman = new Pos(3 * Maze.offsetW, 3 * Maze.offsetH);
        Pos posGhost = new Pos(3 * Maze.offsetW, 5 * Maze.offsetH);
        AI.intPos probingPos = new AI.intPos(1, 9);

        AI ai = new AI();

        // Going up as the pacman is up to ghost
        Pos.Direction d = ai.movingAI(posPacman, posGhost, probingPos, "chasing");
        assertEquals(Pos.Direction.Up, d);

        posPacman = new Pos(3 * Maze.offsetW, 7 * Maze.offsetH);
        d = ai.movingAI(posPacman, posGhost, probingPos, "chasing");
        assertEquals(Pos.Direction.Down, d);

        posPacman = new Pos(3 * Maze.offsetW, 27 * Maze.offsetH);
        d = ai.movingAI(posPacman, posGhost, probingPos, "chasing");
        assertEquals(Pos.Direction.Down, d);

        posGhost = new Pos(3 * Maze.offsetW, 3 * Maze.offsetH);
        probingPos = new AI.intPos(3, 1);
        d = ai.movingAI(posPacman, posGhost, probingPos, "escaping");
        assertEquals(Pos.Direction.Down, d);

        posPacman = new Pos(3 * Maze.offsetW, 3 * Maze.offsetH);
        d = ai.movingAI(posPacman, posGhost, probingPos, "escaping");
        assertEquals(Pos.Direction.Down, d);
    }


}
