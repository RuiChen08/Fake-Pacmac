package com.example.chenrui.game1942application;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void getDirection_test() throws Exception {
        assertEquals(new Pos(1.0f, 1.0f).getDirection(new Pos(1.0f, 2.0f)), Pos.Direction.Down);
        // Todo. some auto-generated test, however, it is not a good way for writing testing as we are writing test after implementation
    }

    @Test
    public void aiChasing_test(){
        //Todo
    }

    @Test
    public void aiInFront_test(){
        //Todo
    }
}