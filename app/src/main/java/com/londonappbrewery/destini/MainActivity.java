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
        currQuestion = findViewById(R.id.storyTextView);
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);
        restart = findViewById(R.id.restartButton);
        restart.setVisibility(View.INVISIBLE);
        if(savedInstanceState!=null){
            sProgress = savedInstanceState.getInt("sProgress");
            if(sProgress == 2){
                currQuestion.setText(R.string.T3_Story);
                topButton.setText(R.string.T3_Ans1);
                bottomButton.setText(R.string.T3_Ans2);
            }
            if(sProgress == 3){
                currQuestion.setText(R.string.T2_Story);
                topButton.setText(R.string.T2_Ans1);
                bottomButton.setText(R.string.T2_Ans2);
            }
            if(sProgress>3){
                if(sProgress==4)
                    currQuestion.setText(R.string.T4_End);
                if(sProgress==5)
                    currQuestion.setText(R.string.T5_End);
                if(sProgress==6)
                    currQuestion.setText(R.string.T6_End);
                restart.setVisibility(View.VISIBLE);
                topButton.setVisibility(View.INVISIBLE);
                bottomButton.setVisibility(View.INVISIBLE);
            }
        }
        else
            sProgress = 1;

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
    @Override
    public void onSaveInstanceState(Bundle out){
        super.onSaveInstanceState(out);
        out.putInt("sProgress",sProgress);
    }
    private void updateQuestion(boolean top){
        if(sProgress == 2){
            if(top){
                currQuestion.setText(R.string.T6_End);
                bottomButton.setVisibility(View.INVISIBLE);
                topButton.setVisibility(View.INVISIBLE);
                sProgress = sProgress + 3;
            }
            else{
                currQuestion.setText(R.string.T5_End);
                bottomButton.setVisibility(View.INVISIBLE);
                topButton.setVisibility(View.INVISIBLE);
                sProgress = sProgress + 2;
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
                sProgress = sProgress + 1;
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
        if(sProgress > 3){
            restart.setVisibility(View.VISIBLE);
            topButton.setVisibility(View.INVISIBLE);
            bottomButton.setVisibility(View.INVISIBLE);
        }
    }
}
