package com.example.chenrui.game1942application;

import org.junit.Test;

import java.util.ArrayList;

import static com.example.chenrui.game1942application.RankBoard.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/*
 *White board test
 * Authors: Chucheng Qian, Rui Chen
 * Date: 18/10/2018
 */

public class RankBoardTest {
    public ArrayList<RankBoard> getResults()  {
        RankBoard data1 = new RankBoard("a",10);
        RankBoard data2 = new RankBoard("b",60);
        RankBoard data3 = new RankBoard("c",5);
        RankBoard data4 = new RankBoard("d",600);
        create("RankData.xml");
        data1.save("RankData.xml");
        data2.save("RankData.xml");
        data3.save("RankData.xml");
        data4.save("RankData.xml");

        ArrayList<RankBoard> dataload = load("RankData.xml");

        return dataload;
    }
    @Test
    public void testSavingMutiplePlayer(){
        assertTrue("The number of players stored should be 4,but is "+getResults().size(), getResults().size()==4);

    }
    @Test
    public void testorder(){
        assertTrue("The top1 should be d,but is "+getResults().get(0).name, getResults().get(0).name.equals("d"));
        assertTrue("The second should be b,but is "+getResults().get(1).name, getResults().get(1).name.equals("b"));
        assertTrue("The third should be a,but is "+getResults().get(2).name, getResults().get(2).name.equals("a"));
        assertTrue("The forth should be c,but is "+getResults().get(3).name, getResults().get(3).name.equals("c"));


    }
    @Test
    public void testMark(){
        for (int i =0;i<getResults().size();i++) {
            if(getResults().get(i).name.equals("c")){
                assertTrue("The mark should be 5,but is "+getResults().get(i).mark, getResults().get(i).mark==5);

            }else if(getResults().get(i).name.equals("a")){
                assertTrue("The mark should be 10,but is "+getResults().get(i).mark, getResults().get(i).mark==10);

            }else if
                    (getResults().get(i).name.equals("b")){
                assertTrue("The mark should be 60,but is "+getResults().get(i).mark, getResults().get(i).mark==60);

            }else if
                    (getResults().get(i).name.equals("d"))
                assertTrue("The mark should be 600,but is "+getResults().get(i).mark, getResults().get(i).mark==600);

        }
    }


}

