package com.example.p2.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.p2.backend.questionnaire.*;
import com.example.p2.R;

import java.util.ArrayList;

public class Q extends AppCompatActivity{


    Test test = new AnTI_Test().getTest();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q);

        defineButtons();
    }

    protected void onResume(){
        super.onResume();
        displayQuestions();
    }

    public void displayQuestions() {
        TextView question = findViewById(R.id.questions);
        String newQuestion = test.getCurrentQuestion().getTextQuestion();
        System.out.print(newQuestion);
        question.setText(newQuestion);

        TextView questionNumber = findViewById(R.id.questionNumber);
        int number = test.getCurrentQuestion().getQuestionNumber();
        String numberText = number + "/" + test.getNumberOfQuestions();
        questionNumber.setText(numberText);
    }

    public void defineButtons(){

        Button answer1 = findViewById(R.id.buttonAnswer1);
        Button answer2 = findViewById(R.id.buttonAnswer2);
        Button answer3 = findViewById(R.id.buttonAnswer3);
        Button answer4 = findViewById(R.id.buttonAnswer4);
        Button submitButton = findViewById(R.id.submit);
        submitButton.setVisibility(Button.INVISIBLE);

        answer1.setOnClickListener(buttonClickListener);
        answer2.setOnClickListener(buttonClickListener);
        answer3.setOnClickListener(buttonClickListener);
        answer4.setOnClickListener(buttonClickListener);
        submitButton.setOnClickListener(buttonClickListener);

        ArrayList<QuestionAnswerOption> answers = test.getCurrentQuestion().getQuestionAnswerOptions().getAnswerOptions();

        answer1.setText(answers.get(0).getAnswerOptionText());
        answer2.setText(answers.get(1).getAnswerOptionText());
        answer3.setText(answers.get(2).getAnswerOptionText());
        answer4.setText(answers.get(3).getAnswerOptionText());
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.buttonAnswer1:
                    //startActivity(new Intent(Q.this, Q.class));
                    //finish();
                    test.getCurrentQuestion().setAnswer( test.getCurrentQuestion().getQuestionAnswerOptions().getAnswerOptions().get(0));
                    if(findViewById(R.id.submit).getVisibility() == Button.INVISIBLE) {
                        findViewById(R.id.submit).setVisibility(Button.VISIBLE);
                    }
                    break;
                case R.id.buttonAnswer2:
                    //startActivity(new Intent(Q.this, Result.class));
                    //finish();
                    test.getCurrentQuestion().setAnswer( test.getCurrentQuestion().getQuestionAnswerOptions().getAnswerOptions().get(1));
                    if(findViewById(R.id.submit).getVisibility() == Button.INVISIBLE) {
                        findViewById(R.id.submit).setVisibility(Button.VISIBLE);
                    }
                    break;
                case R.id.buttonAnswer3:
                    //startActivity(new Intent(Q.this, Profile.class));
                    //finish();
                    test.getCurrentQuestion().setAnswer( test.getCurrentQuestion().getQuestionAnswerOptions().getAnswerOptions().get(2));
                    if(findViewById(R.id.submit).getVisibility() == Button.INVISIBLE) {
                        findViewById(R.id.submit).setVisibility(Button.VISIBLE);
                    }
                    break;
                case R.id.buttonAnswer4:
                    //startActivity(new Intent(Q.this, About.class));
                    //finish();
                    test.getCurrentQuestion().setAnswer( test.getCurrentQuestion().getQuestionAnswerOptions().getAnswerOptions().get(3));
                    if(findViewById(R.id.submit).getVisibility() == Button.INVISIBLE) {
                        findViewById(R.id.submit).setVisibility(Button.VISIBLE);
                    }
                    break;
                case R.id.submit:
                    //test.submitQuestionAnswer(category, answerWeight);
                    test.nextQuestion();
                    break;
            }
        }
    };


}
