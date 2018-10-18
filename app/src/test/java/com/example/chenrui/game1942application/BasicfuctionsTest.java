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
        System.out.println(Game.mark);


    }

    @Test
    public void noDot_test() throws Exception {
        Maze maze=new Maze();
        assertTrue("There should be dots,but returns noDots==false",maze.noDots()==false);
        Maze.maze=new short[MAZE.length][MAZE[0].length];
        assertTrue("There should be no dots,but returns noDots==true" ,maze.noDots()==true);
        }



}
