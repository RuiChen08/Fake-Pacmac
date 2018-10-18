package com.example.chenrui.game1942application;

import org.junit.Test;

import java.util.Random;

import static com.example.chenrui.game1942application.Maze.MAZE;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


/*
 * white box test
 * Authors: Chucheng Qian
 * Date: 18/10/2018
 */
public class BasicfuctionsTest {


    @Test
    public void mazeStep_test() throws Exception {

       { for (int r = 0; r < Maze.maze.length; r++) {
            for (int c = 0; c < Maze.maze[0].length; c++) Maze.maze[r][c] = MAZE[r][c];
        }
        }
        Maze maze=new Maze();

        Pos p =new Pos(0.2f,0.3f);
        maze.step(p);
        assertTrue("The mark should be 1 but is "+Game.mark,Game.mark==1);

        Pos p2 =new Pos(0.1f,0.05f);
        maze.step(p2);
        assertTrue("The mark should be 5 but is "+Game.mark,Game.mark==6);


    }

    @Test
    public void noDot_test() throws Exception {
        Maze maze=new Maze();
        assertTrue("There should be dots,but returns noDots==false",maze.noDots()==false);
        Maze.maze=new short[MAZE.length][MAZE[0].length];
        assertTrue("There should be no dots,but returns noDots==true" ,maze.noDots()==true);
        }

    @Test
    public void getMoveTest() throws Exception {
        Clyde g = new Clyde();
        g.pos.x=1.0f;
        g.pos.y=1.0f;
        g.getMove(Pos.Direction.Up);
        g.getMove(Pos.Direction.Up);
        assertEquals(1.0f, g.pos.x);
        assertEquals(1.0f, g.pos.y);

        g.pos.x=0.05f;
        g.pos.y=0.2f;
        g.getMove(Pos.Direction.Left);

        assertEquals(0.05f, g.pos.x);
        assertEquals(0.2f, g.pos.y);

        g.getMove(Pos.Direction.Right);
        assertEquals(0.12142858f, g.pos.x);
        assertEquals(0.2f, g.pos.y);

        g.getMove(Pos.Direction.Down);
        assertEquals(0.12142858f, g.pos.x);
        assertEquals(0.24000001f, g.pos.y);

        g.pos.x=0.12f;
        g.pos.y=0.00f;
        g.getMove(Pos.Direction.Right);
        assertEquals(0.12f, g.pos.x);
        assertEquals(0.00f, g.pos.y);

    }



}
