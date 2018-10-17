package com.example.chenrui.game1942application;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class RankActivity extends AppCompatActivity {

    TextView textView;
    String message;

    /**
     * @author Chucheng Qian
     * @Date 17/10/2018
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        Intent intent = getIntent();
        message = intent.getStringExtra(GameOverActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        /*textView = findViewById(R.id.thetextView);
        textView.setText("Hello "+message);
*/
        TextView textView = findViewById(R.id.textView4);
        textView.setText(names(result()));

        TextView textView2 = findViewById(R.id.textView5);
        textView2.setText(marks(result()));
    }

   /* public static void main(String[] args) {
        RankBoard.create("RankData.xml");
        RankBoard data = new RankBoard("Hugh",Game.mark);

        data.save("RankData.xml");
        ArrayList<RankBoard> dataload = RankBoard.load("RankData.xml");


    }*/

    public ArrayList<RankBoard> result (){
        String path = this.getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS) + "/RankData";
        RankBoard.create(path);





        RankBoard data = new RankBoard(message,Game.mark);
        //RankBoard data1 = new RankBoard("Hugh",Game.mark);

        data.save(path);
        //data1.save("RankData.xml");

        ArrayList<RankBoard> dataload = RankBoard.load(path);
        return dataload;
    }


    public String names (ArrayList<RankBoard> dataload){
        String namess="";
        for (int i =0;i<dataload.size();i++){
            namess += "\n" + dataload.get(i).name + "\n";
        }
        System.out.println(namess);
        return namess;
    }

    public String marks (ArrayList<RankBoard> dataload){
        String namess="";
        for (int i =0;i<dataload.size();i++){
            namess += "\n" + dataload.get(i).mark + "\n";
        }
        return namess;
    }









}
