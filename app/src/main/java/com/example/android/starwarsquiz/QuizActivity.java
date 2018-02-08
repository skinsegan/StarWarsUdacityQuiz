package com.example.android.starwarsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    /*** Variables **/
    int score = 0;
    int quest1 = -1;
    int quest2 = -1;
    int quest4 = -1;
    String q3_answer;

    String name;
    RadioGroup questionOne;
    RadioGroup questionTwo;
    EditText questionThree;
    RadioGroup questionFour;
    CheckBox questionFiveA;
    CheckBox questionFiveB;
    CheckBox questionFiveC;
    CheckBox questionFiveD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questionOne = (RadioGroup) findViewById(R.id.quest_one);
        questionTwo = (RadioGroup) findViewById(R.id.quest_two);
        questionThree = (EditText) findViewById(R.id.quest_three_text);
        questionFour = (RadioGroup) findViewById(R.id.quest_four);
        questionFiveA = (CheckBox) findViewById(R.id.check_one);
        questionFiveB = (CheckBox) findViewById(R.id.check_two);
        questionFiveC = (CheckBox) findViewById(R.id.check_three);
        questionFiveD = (CheckBox) findViewById(R.id.check_four);
        name = getIntent().getStringExtra("NAME");

        /** when submit is clicked, the answers are checked and if all are answered it moves to the summary activity for the result **/

        findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
                if ((quest1 == -1) || (quest2 == -1) || (quest4 == -1) || (q3_answer.equals("")) || (!questionFiveA.isChecked() && !questionFiveC.isChecked()) && !questionFiveB.isChecked() && !questionFiveD.isChecked()) {
                    checkAll();
                } else {
                    Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                    intent.putExtra("NAME", name);
                    intent.putExtra("SCORE", score);
                    startActivity(intent);
                }
            }
        });
    }

    /** this method sends a toast to answer all questions **/
    public void checkAll() {
        Toast.makeText(QuizActivity.this, getString(R.string.selectAnswer), Toast.LENGTH_LONG).show();
        score = 0;
    }

    /** Checking the answers **/
    public void checkAnswers() {

        /** Question 1**/
        quest1 = questionOne.getCheckedRadioButtonId();
        if (quest1 == -1) {
            return;
        } else {
            RadioButton radioButton1 = (RadioButton) questionOne.findViewById(quest1);
            String q1_answer = (String) radioButton1.getText();
            if (q1_answer.equalsIgnoreCase(getString(R.string.ans1a))) {
                score++;
            }
        }

        /** Question 2 **/
        quest2 = questionTwo.getCheckedRadioButtonId();
        if (quest2 == -1) {
            return;
        } else {
            RadioButton radioButton2 = (RadioButton) questionTwo.findViewById(quest2);
            String q2_answer = (String) radioButton2.getText();
            if (q2_answer.equalsIgnoreCase(getString(R.string.ans2b))) {
                score++;
            }
        }

        /** Question 3 **/
        questionThree = (EditText) findViewById(R.id.quest_three_text);
        q3_answer = questionThree.getText().toString();
        if (q3_answer.equalsIgnoreCase(getString(R.string.ans3))) {
            score++;
        }

        /** Question 4 **/
        quest4 = questionFour.getCheckedRadioButtonId();
        if (quest4 == -1) {
            return;
        } else {
            RadioButton radioButton4 = (RadioButton) questionFour.findViewById(quest4);
            String q4_answer = (String) radioButton4.getText();
            if (q4_answer.equalsIgnoreCase(getString(R.string.ans4c))) {
                score++;
            }
        }

        /** Question 5 **/
        if ((questionFiveA.isChecked() && questionFiveC.isChecked()) && (!questionFiveB.isChecked() && !questionFiveD.isChecked())) {
            score++;
        }

    }
}

