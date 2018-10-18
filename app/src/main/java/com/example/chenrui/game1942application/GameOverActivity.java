package com.example.chenrui.game1942application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
    public static final String EXTRA_MESSAGE ="com.example.chenrui.game1942application.MESSAGE";


    /*
     * Author: ChuCheng Qian
     * Date: 18/10/2018
     */
    public void backButtonPressed(View view) {
        Log.d("gameover", "back button pressed");

        finish();
    }

    /*
     * Author: ChuCheng Qian
     * Date: 18/10/2018
     */
    public void rankButtonPressed(View view) {
        Log.d("gameover", "rank button pressed");

        Intent intent = new Intent(this, RankActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
