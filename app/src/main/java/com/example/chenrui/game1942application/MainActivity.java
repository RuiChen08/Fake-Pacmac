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

    public void startButtonPressed(View view) {
        Log.d("game", "start button pressed");

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    // Showing the rank of previous players, previous players marks should be stored when game is finished
    public void rankButtonPressed(View view) {
        // Todo: Load the xml file for showing the rank
    }
}
