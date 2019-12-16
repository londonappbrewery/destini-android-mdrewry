package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView currQuestion;
    Button topButton;
    Button bottomButton;
    Button restart;
    int sProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sProgress = 1;
        currQuestion = findViewById(R.id.storyTextView);
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);
        restart = findViewById(R.id.restartButton);
        restart.setVisibility(View.INVISIBLE);

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion(true);
            }
        });

        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion(false);
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sProgress = 1;
                currQuestion.setText(R.string.T1_Story);
                topButton.setText(R.string.T1_Ans1);
                bottomButton.setText(R.string.T1_Ans2);
                topButton.setVisibility(View.VISIBLE);
                bottomButton.setVisibility(View.VISIBLE);
                restart.setVisibility(View.INVISIBLE);
            }
        });
    }
    private void updateQuestion(boolean top){
        if(sProgress == 2){
            if(top){
                currQuestion.setText(R.string.T6_End);
                bottomButton.setVisibility(View.INVISIBLE);
                topButton.setVisibility(View.INVISIBLE);
                sProgress = sProgress + 10;
            }
            else{
                currQuestion.setText(R.string.T5_End);
                bottomButton.setVisibility(View.INVISIBLE);
                topButton.setVisibility(View.INVISIBLE);
                sProgress = sProgress + 10;
            }
        }
        if(sProgress == 3){
            if(top){
                currQuestion.setText(R.string.T3_Story);
                topButton.setText(R.string.T3_Ans1);
                bottomButton.setText(R.string.T3_Ans2);
                sProgress = 2;
            }
            else{
                currQuestion.setText(R.string.T4_End);
                bottomButton.setVisibility(View.INVISIBLE);
                topButton.setVisibility(View.INVISIBLE);
                sProgress = sProgress + 10;
            }
        }
        if(sProgress == 1){
            if(top){
                currQuestion.setText(R.string.T3_Story);
                topButton.setText(R.string.T3_Ans1);
                bottomButton.setText(R.string.T3_Ans2);
                sProgress = sProgress + 1;
            }
            else{
                currQuestion.setText(R.string.T2_Story);
                topButton.setText(R.string.T2_Ans1);
                bottomButton.setText(R.string.T2_Ans2);
                sProgress = sProgress + 2;
            }
        }
        if(sProgress > 10){
            restart.setVisibility(View.VISIBLE);
            topButton.setVisibility(View.INVISIBLE);
            bottomButton.setVisibility(View.INVISIBLE);
        }
    }
}
