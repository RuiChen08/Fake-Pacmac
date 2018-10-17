package com.example.chenrui.game1942application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class GameOverActivity extends AppCompatActivity {


    /*
     * Authors: Chucheng Qian
     * Date: 17/10/2018
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
    }


    public void backButtonPressed(View view) {
        Log.d("gameover", "back button pressed");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void rankButtonPressed(View view) {
        Log.d("gameover", "rank button pressed");

        Intent intent = new Intent(this, RankActivity.class);
        startActivity(intent);
    }
}
