package com.example.chenrui.game1942application;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    /*
     * Authors: Chucheng Qian
     * Date: 14/10/2018
     */

    @Test
    public void getDirection_test() throws Exception {
        assertEquals(new Pos(1.0f, 1.0f).getDirection(new Pos(1.0f, 2.0f)), Pos.Direction.Down);
        assertTrue("The direction should be Right,but is "+new Pos(10.0f, 10.0f).getDirection(new Pos(11.0f, 10.0f)), new Pos(10.0f, 10.0f).getDirection(new Pos(11.0f, 10.0f)) == Pos.Direction.Right);
        assertTrue("The direction should be Left,but is "+new Pos(100.0f, 100.0f).getDirection(new Pos(99.0f, 100.0f)), new Pos(100.0f, 100.0f).getDirection(new Pos(99.0f, 100.0f)) == Pos.Direction.Left);
        assertTrue("The direction should be UP,but is "+new Pos(88.0f, 88.0f).getDirection(new Pos(88.0f, 87.0f)), new Pos(88.0f, 88.0f).getDirection(new Pos(88.0f, 87.0f)) == Pos.Direction.Up);
        assertTrue("The direction should be Left ,but is "+new Pos(79.0f, 68.0f).getDirection(new Pos(22.0f, 22.0f)), new Pos(79.0f, 68.0f).getDirection(new Pos(22.0f, 22.0f)) == Pos.Direction.Left);
        assertTrue("The direction should be Right,but is "+new Pos(100.0f, 110.0f).getDirection(new Pos(120.0f, 120.0f)), new Pos(100.0f, 110.0f).getDirection(new Pos(120.0f, 120.0f)) == Pos.Direction.Right);
    }

    /*@Test
    public void aiChasing_test(){
        assertTrue("The direction should be UP,but is "+AI.chasing(new Pos(1.0f, 1.0f),new Pos(1.0f, 2.0f), probingPos), AI.chasing(new Pos(1.0f, 1.0f),new Pos(1.0f, 2.0f), probingPos) == Pos.Direction.Up);
        //Todo
    }*/
    /*
     *  Author: Ruiyi Sun, Rui Chen
     *  Date: 18/10/2018
     * write some codes to BST in AI class
     *
     * The maze is assumed to have walls surrounded outsides !!
     * */
    @Test
    public void BST_Test() throws ArrayIndexOutOfBoundsException{
        //  the branch coverage test
        //1: if player not move ,the ghost will not move
        short[][] maze = new short[][]{
                {3,3,3,3,3,3,3,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,3,3,3,3,3,3,3}
        };
        Pos.Direction bst = AI.BST(new AI.intPos(2,2), new AI.intPos(2,2) , maze);
        assertTrue("The direction should be expected,but is "+bst, bst == Pos.Direction.Stay);
        // the other test in the branch
        short[][] maze1 = new short[][]{
                {3,3,3,3,3,3,3,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,1,1,1,1,1,1,3},
                {3,3,3,3,3,3,3,3}
        };
        Pos.Direction bst_1 = AI.BST(new AI.intPos(1,2), new AI.intPos(2,2) , maze);
        assertTrue("The direction should be expected,but is " + bst_1, bst_1 == Pos.Direction.Down);
    }

}