package com.example.chenrui.game1942application;

import org.junit.Test;

import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


/*
 * white box test
 * Authors: Chucheng Qian
 * Date: 18/10/2018
 */
public class GhostTest {


    /*
     * Author: Rui Chen
     * Date: 18/10/2018
     */
    @Test
    public void getDirectionTest() throws Exception {
        Ghosts gs = new Ghosts();
        Random random = new Random();
        for (int c = 0; c < 5000; c++) {
            int i = random.nextInt(4);
            switch (i) {

                // Randomly testing for different direction
                case 0:
                    for (Ghost g : gs) {
                        Pos ppos = new Pos(g.pos);
                        if (Maze.MAZE[(int) (g.pos.y / (2 * Maze.offsetH)) - 1][(int) (g.pos.x / (2 * Maze.offsetW))] != 3) {
                            g.getMove(Pos.Direction.Up);
                            assertEquals(ppos.x, g.pos.x);
                            assertEquals(ppos.y - 2 * Maze.offsetH, g.pos.y);
                        }
                    }
                    break;
                case 1:
                    for (Ghost g : gs) {
                        Pos ppos = new Pos(g.pos);
                        if (Maze.MAZE[(int) (g.pos.y / (2 * Maze.offsetH)) + 1][(int) (g.pos.x / (2 * Maze.offsetW))] != 3) {
                            g.getMove(Pos.Direction.Down);
                            assertEquals(ppos.x, g.pos.x);
                            assertEquals(ppos.y + 2 * Maze.offsetH, g.pos.y);
                        }
                    }
                case 2:
                    for (Ghost g : gs) {
                        Pos ppos = new Pos(g.pos);
                        if (Maze.MAZE[(int) (g.pos.y / (2 * Maze.offsetH))][(int) (g.pos.x / (2 * Maze.offsetW)) - 1] != 3) {
                            g.getMove(Pos.Direction.Left);
                            assertEquals(ppos.x - 2 * Maze.offsetW, g.pos.x);
                            assertEquals(ppos.y, g.pos.y);
                        }
                    }
                    break;
                case 3:
                    for (Ghost g : gs) {
                        Pos ppos = new Pos(g.pos);
                        if (Maze.MAZE[(int) (g.pos.y / (2 * Maze.offsetH))][(int) (g.pos.x / (2 * Maze.offsetW)) + 1] != 3) {
                            g.getMove(Pos.Direction.Right);
                            assertEquals(ppos.x + 2 * Maze.offsetW, g.pos.x);
                            assertEquals(ppos.y, g.pos.y);
                        }
                    }
                    break;
            }
        }
    }
}
