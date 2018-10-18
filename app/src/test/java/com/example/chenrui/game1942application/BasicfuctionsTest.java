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
public class BasicfuctionsTest {
    @Test
    public void getDirection_test() throws Exception {
        Clyde g = new Clyde();
        g.pos.x=1.0f;
        g.pos.y=1.0f;
        g.getMove(Pos.Direction.Up);
        assertEquals(1.0f, g.pos.x);
        assertEquals(0.96f, g.pos.y);
        g.getMove(Pos.Direction.Left);
        assertEquals(0.9285714f, g.pos.x);
        assertEquals(0.96f, g.pos.y);
        g.getMove(Pos.Direction.Right);
        assertEquals(1.0f, g.pos.x);
        assertEquals(0.96f, g.pos.y);
        g.getMove(Pos.Direction.Down);
        assertEquals(g.pos.x, 1.0f);
        assertEquals(g.pos.y, 1.0f);

        /*g.pos.x=0.12f;
        g.pos.y=0.00f;
        g.getMove(Pos.Direction.Right);
        System.out.println(g.pos.x);*/

    }
}
