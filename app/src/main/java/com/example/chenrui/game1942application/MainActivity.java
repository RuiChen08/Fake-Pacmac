package com.example.chenrui.game1942application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * Author: Rui Chen
     * Date: 18/10/2018
     */
    public void startButtonPressed(View view) {
        Log.d("game", "start button pressed");

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    /**
     * Author Chucheng Qian
     * Date 17/10/2018
     *
     * Showing the rank of previous players, previous players marks should be stored when game is finished
     */
    public void rankButtonPressed(View view) {
        Log.d("rank", "rank button pressed");

        Intent intent1 = new Intent(this, RankActivity.class);
        startActivity(intent1);

    }
}
