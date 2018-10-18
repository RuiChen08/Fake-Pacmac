package com.example.chenrui.game1942application;

import org.junit.Test;

import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class UnitTest {

    /*
     * Authors: Chucheng Qian, Rui Chen,weiwei Liang
     * Date: 18/10/2018
     */
    @Test
    public void getDirection_test() throws Exception {
        assertEquals(new Pos(1.0f, 1.0f).getDirection(new Pos(1.0f, 2.0f)), Pos.Direction.Down);
        assertTrue("The direction should be Right,but is "+new Pos(10.0f, 10.0f).getDirection(new Pos(11.0f, 10.0f)), new Pos(10.0f, 10.0f).getDirection(new Pos(11.0f, 10.0f)) == Pos.Direction.Right);
        assertTrue("The direction should be Left,but is "+new Pos(100.0f, 100.0f).getDirection(new Pos(99.0f, 100.0f)), new Pos(100.0f, 100.0f).getDirection(new Pos(99.0f, 100.0f)) == Pos.Direction.Left);
        assertTrue("The direction should be UP,but is "+new Pos(88.0f, 88.0f).getDirection(new Pos(88.0f, 87.0f)), new Pos(88.0f, 88.0f).getDirection(new Pos(88.0f, 87.0f)) == Pos.Direction.Up);
        assertTrue("The direction should be Left ,but is "+new Pos(79.0f, 68.0f).getDirection(new Pos(22.0f, 22.0f)), new Pos(79.0f, 68.0f).getDirection(new Pos(22.0f, 22.0f)) == Pos.Direction.Left);
        assertTrue("The direction should be Right,but is "+new Pos(100.0f, 110.0f).getDirection(new Pos(120.0f, 120.0f)), new Pos(100.0f, 110.0f).getDirection(new Pos(120.0f, 120.0f)) == Pos.Direction.Right);
        assertTrue("The direction should be Down,but is "+new Pos(100.0f, 110.0f).getDirection(new Pos(100.0f, 90.0f)), new Pos(100.0f, 110.0f).getDirection(new Pos(100.0f, 90.0f)) == Pos.Direction.Up);
        Random random = new Random();
        for (int i = 0; i < 1000; i++){
            String s = "Right";
            int x = random.nextInt(100) + 1;
            int y = random.nextInt(100) + 1;
            // Plussing two here for avoiding identical value
            int z = random.nextInt(100) + 2;
            Pos p1 = new Pos(0, 0);
            Pos p2 = new Pos(x * y, x * (y/z));
            assertTrue("The direction should be " + s + ", but is "+ p1.getDirection(p2), p1.getDirection(p2) == Pos.Direction.Right);

            s = "Left";
            p2 = new Pos(- x * y, x * (y/z));
            assertTrue("The direction should be " + s + ", but is "+ p1.getDirection(p2), p1.getDirection(p2) == Pos.Direction.Left);

            s = "Up";
            p2 = new Pos(x * (y/z), - x * y);
            assertTrue("The direction should be " + s + ", but is "+ p1.getDirection(p2), p1.getDirection(p2) == Pos.Direction.Up);

            s = "Down";
            p2 = new Pos(x * (y/z), x * y);
            assertTrue("The direction should be " + s + ", but is "+ p1.getDirection(p2), p1.getDirection(p2) == Pos.Direction.Down);

        }
    }

    @Test
    public void changeDirection_test(){
        PacMan pc = new PacMan();
        pc.changeDirection(Pos.Direction.Down);
        if (Maze.maze[(int) (pc.pos.y / (2 * Maze.offsetH)) + 1][(int) (pc.pos.x / (2*Maze.offsetW))] < 3){
            assertTrue("The direction should be Down, but is " + pc.direction, pc.direction == Pos.Direction.Down);
        }else if (Maze.maze[(int) (pc.pos.y / (2 * Maze.offsetH)) - 1][(int) (pc.pos.x / (2*Maze.offsetW))] < 3){
            assertTrue("The direction should be Up, but is " + pc.direction, pc.direction == Pos.Direction.Up);

        }else if (Maze.maze[(int) (pc.pos.y / (2 * Maze.offsetH))][(int) (pc.pos.x / (2*Maze.offsetW)) - 1] < 3){
            assertTrue("The direction should be Left, but is " + pc.direction, pc.direction == Pos.Direction.Left);

        }else if (Maze.maze[(int) (pc.pos.y / (2 * Maze.offsetH))][(int) (pc.pos.x / (2*Maze.offsetW)) + 1] < 3){
            assertTrue("The direction should be Right, but is " + pc.direction, pc.direction == Pos.Direction.Right);

        }
    }


    @Test
    public void getMoveTest() throws Exception {
        Clyde g = new Clyde();
        g.pos.x=1.0f;
        g.pos.y=1.0f;
        g.getMove(Pos.Direction.Up);
        g.getMove(Pos.Direction.Up);
        assertEquals(1.0f, g.pos.x);
        assertEquals(0.91999996f, g.pos.y);
        g.getMove(Pos.Direction.Left);
        assertEquals(0.9285714f, g.pos.x);
        assertEquals(0.91999996f, g.pos.y);
        g.getMove(Pos.Direction.Right);
        assertEquals(1.0f, g.pos.x);
        assertEquals(0.91999996f, g.pos.y);
        g.getMove(Pos.Direction.Down);
        assertEquals(g.pos.x, 1.0f);
        assertEquals(g.pos.y, 0.96f);

        /*g.pos.x=0.12f;
        g.pos.y=0.00f;
        g.getMove(Pos.Direction.Right);
        System.out.println(g.pos.x);*/

    }
}