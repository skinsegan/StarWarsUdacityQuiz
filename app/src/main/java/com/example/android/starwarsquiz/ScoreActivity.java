package com.example.android.starwarsquiz;

/** This is the final screen showing the result in the quiz and saying how well the person did **/

import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreText, summaryText;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

           /** get name and score values from previous activity **/

        int score = getIntent().getIntExtra("SCORE", 0);
        String name = getIntent().getStringExtra("NAME");

        scoreText = (TextView)findViewById(R.id.score_summary);
        summaryText = (TextView)findViewById(R.id.text_summary);

           /** send a toast with the result and send score and a text to the textViews **/

        if (score == 5) {
            Toast. makeText(this, getString(R.string.fiveScore) + ", " + getString(R.string.youScored) + " " + score + " " + getString(R.string.outOf), Toast.LENGTH_SHORT).show();
            scoreText.setText(score + "/5");
            summaryText.setText("Grand Master Jedi " + name + ". Your mastery of The Force rivals Master Yoda's!");
        } else if (score == 4) {
            Toast. makeText(this, getString(R.string.fourScore)  + ", " + getString(R.string.youScored) + " " + score + " " + getString(R.string.outOf), Toast.LENGTH_SHORT).show();
            scoreText.setText(score + "/5");
            summaryText.setText("Master Jedi " + name + ". The Force is strong with you!");
        } else if (score == 3) {
            Toast. makeText(this, getString(R.string.threeScore)  + ", " + getString(R.string.youScored) + " "  + score + " " + getString(R.string.outOf), Toast.LENGTH_SHORT).show();
            scoreText.setText(score + "/5");
            summaryText.setText("Jedi Knight " + name + ". You have a strong command of The Force.");
        } else if (score == 2) {
            Toast. makeText(this, getString(R.string.twoScore)  + ", " + getString(R.string.youScored) + " " + score + " " + getString(R.string.outOf), Toast.LENGTH_SHORT).show();
            scoreText.setText(score + "/5");
            summaryText.setText("Padawan " + name + ". Keep training and someday you may be a great Jedi.");
        } else if (score == 1) {
            Toast. makeText(this, getString(R.string.oneScore) + ", " + getString(R.string.youScored) + " "  + score + " " + getString(R.string.outOf), Toast.LENGTH_LONG).show();
            scoreText.setText(score + "/5");
            summaryText.setText("Youngling " + name + ". You have a long way to go before learning to master The Force.");
        } else {
            Toast. makeText(this, getString(R.string.noScore) + ", " + getString(R.string.youScored) + " " + score + " " + getString(R.string.outOf),Toast.LENGTH_LONG).show();
            scoreText.setText(score + "/5");
            summaryText.setText("I'm sorry " + name + ". I do not sense The Force within you.");
        }

        /** Reset app and start a new quiz **/
        Button resetButton = findViewById(R.id.reset_game_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reset = new Intent(ScoreActivity.this, MainActivity.class);
                finish();
                startActivity(reset);
            }
        });


    }


}
