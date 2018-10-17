package com.example.chenrui.game1942application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/*
 * Authors: Rui Chen,Chucheng Qian
 * Date: 17/10/2018
 */

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        if (Game.life==0){
            Log.d("finish", "game over");

            Intent intent = new Intent(this, GameOverActivity.class);
            startActivity(intent);
        }
    }


}
