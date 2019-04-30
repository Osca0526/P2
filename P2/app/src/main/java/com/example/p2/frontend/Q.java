package com.example.p2.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.p2.backend.questionnaire.*;
import com.example.p2.R;

public class Q extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q);

        defineButtons();
        displayQuestions();

    }

    protected void onResume(){
        super.onResume();
        displayQuestions();
    }

    public void displayQuestions() {
        Test test = new AnTI_Test().getTest();
        TextView question = findViewById(R.id.textView3);
        String newQuestion = test.getCurrentQuestion().getTextQuestion();
        System.out.print(newQuestion);
        question.setText(newQuestion);
    }



    public void defineButtons(){
        findViewById(R.id.buttonQ1).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonQ2).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonQ3).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonQ4).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonQ1:
                    startActivity(new Intent(Q.this, Q.class));
                    finish();
                    break;
                case R.id.buttonQ2:
                    startActivity(new Intent(Q.this, Result.class));
                    finish();
                    break;
                case R.id.buttonQ3:
                    startActivity(new Intent(Q.this, Profile.class));
                    finish();
                    break;
                case R.id.buttonQ4:
                    startActivity(new Intent(Q.this, About.class));
                    finish();
                    break;
            }
        }
    };
}
