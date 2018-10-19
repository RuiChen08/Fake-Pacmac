package com.example.chenrui.game1942application;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class RankActivity extends AppCompatActivity {

    TextView textView;
    String message;

    /**
     * @author Chucheng Qian(u6451847)
     * @Date 17/10/2018
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        Intent intent = getIntent();
        message = intent.getStringExtra(GameOverActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textView4);
        textView.setText(names(result()));

        TextView textView2 = findViewById(R.id.textView5);
        textView2.setText(marks(result()));
    }

    /**
     * @author Chucheng Qian(u6451847), Rui Chen(u5958754)
     * @Date 17/10/2018
     */
    public ArrayList<RankBoard> result(){
        String path = this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS) + "/RankData";
        File f = new File(path);
        if(!f.exists()){
            RankBoard.create(path);
        }

        RankBoard data = new RankBoard(message, Game.mark);
        //RankBoard data1 = new RankBoard("Hugh",Game.mark);

        data.save(path);
        //data1.save("RankData.xml");

        ArrayList<RankBoard> dataload = RankBoard.load(path);
        return dataload;
    }


    /**
     * @author Chucheng Qian(u6451847)
     * @Date 17/10/2018
     */
    public String names (ArrayList<RankBoard> dataload){
        String namess="";
        for (int i =0;i<dataload.size();i++){
            namess += "\n" + dataload.get(i).name + "\n";
        }
        return namess;
    }

    /**
     * @author Chucheng Qian(u6451847)
     * @Date 17/10/2018
     */
    public String marks (ArrayList<RankBoard> dataload){
        String namess="";
        for (int i =0;i<dataload.size();i++){
            namess += "\n" + dataload.get(i).mark + "\n";
        }
        return namess;
    }

    /**
     * @author Chucheng Qian(u6451847)
     * @Date 17/10/2018
     */
    public void back2ButtonPressed(View view) {
        Log.d("back", "back button pressed");
        finish();
    }
}
