package com.example.chenrui.game1942application;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Author: Rui Chen(u5958754)
 * Date: 2018/10/19
 */

public class IntegratedTest{

    /*
     * Author: Rui Chen(u5958754)
     * Date: 19/10/2018
     */
    @Test
    public void GhostStepTest(){
        Observer ob = new Observer() {
            @Override
            public void update() {
                return;
            }
        };
        PacMan pacMan = new PacMan();
        // It should be 3 at the beginning
        assertTrue("This life of pac man should be 3, but is: " + pacMan.life, pacMan.life == 3);
        Ghosts gs = new Ghosts();
        // Set Radius to possible minimal value as Radius is calculated during run time.
        pacMan.Radius = 0.1f;
        for (Ghost g : gs) g.Radius = 0.1f;
        for (int i = 0; i < 500; i++) {
            for (Ghost g : gs) {
                g.step(pacMan);
            }
        }
        // Judge if the ghost will get to pac-man's position and the life of pac-man should be reduced
        assertTrue("This life of pac man should be less than or equals to 0, but is: " + pacMan.life, pacMan.life <= 0);

        pacMan = new PacMan();
        pacMan.Radius = 0.1f;
        assertTrue("This life of pac man should be 3, but is: " + pacMan.life, pacMan.life == 3);
        for (Ghost g : gs) g.blueMode = true;
        for (int i = 0; i < 500; i++) {
            for (Ghost g : gs) {
                g.step(pacMan);
            }
        }
        // As the blue mode might turn off, should it less than 0
        assertTrue("This life of pac man should be no less than, but is: " + pacMan.life, pacMan.life <= 0);


        pacMan = new PacMan();
        pacMan.Radius = 0.1f;
        assertTrue("This life of pac man should be 3, but is: " + pacMan.life, pacMan.life == 3);

        for (int i = 0; i < 500; i++) {
            gs.inBlue();
            for (Ghost g : gs) {
                g.step(pacMan);
            }
        }
        // As the ghost is always in blue mode, the life should be 3
        assertTrue("This life of pac man should be 3, but is: " + pacMan.life, pacMan.life == 3);
    }

    /*
     * Author: Rui Chen(u5958754)
     * Date: 19/10/2018
     *
     * Automated integration testing for Game states testing. Three different cases.
     */
    @Test
    public void GameFinishTest(){
        final Boolean[] f = {true};
        Observer ob = new Observer() {
            @Override
            public void update() {
                f[0] = false;
            }
        };

        // Randomly testing for different case
        for (int i = 0; i < 1000; i++) {
            f[0] = true;
            Game game = new Game(160, 90, ob);
            //Set the radius to very little value
            game.pacman.Radius = 0.1f;
            for (Ghost g : game.ghosts) g.Radius = 0.1f;
            // Test if the ghost will catch the pac-man
            while (f[0]) {
                game.step();
            }
            // The game should be finished as pac-man was touch by the ghost lots of times
            assertTrue(game.pacman.life <= 0);


            f[0] = true;
            game = new Game(160, 90, ob);
            //Set the radius to very little value
            game.pacman.Radius = 0.1f;
            for (Ghost g : game.ghosts) g.Radius = 0.1f;
            // Test if the ghost will catch the pac-man, and if pac-man will get some marks
            while (f[0]) {
                game.step();
                Random random = new Random();
                int c = random.nextInt(4);
                if (c == 0) game.move(Pos.Direction.Up);
                else if (c == 1) game.move(Pos.Direction.Down);
                else if (c == 2) game.move(Pos.Direction.Right);
                else if (c == 3) game.move(Pos.Direction.Left);
            }
            assertTrue(game.pacman.life <= 0);
            // The game should be finished with some marks as the pac-man randomly moved
            assertTrue(Game.mark > 0);

            f[0] = true;
            Game.mark = 0;
            game = new Game(160, 90, ob);
            //Set the radius to very little value
            game.pacman.Radius = 0.1f;
            for (Ghost g : game.ghosts) g.Radius = 0.1f;
            // Test if the ghost will catch the pac-man, and if pac-man will get some marks
            while (f[0]) {
                game.step();
                game.ghosts.inBlue();
                Random random = new Random();
                int c = random.nextInt(4);
                if (c == 0) game.move(Pos.Direction.Up);
                else if (c == 1) game.move(Pos.Direction.Down);
                else if (c == 2) game.move(Pos.Direction.Right);
                else if (c == 3) game.move(Pos.Direction.Left);
            }
            assertTrue(game.pacman.life == 3);
            assertTrue(Game.mark > 0);
            Game.mark = 0;
        }
    }

}
