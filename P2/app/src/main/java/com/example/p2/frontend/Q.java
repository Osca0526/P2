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
        update();
    }

    protected void onResume(){
        super.onResume();
        update();
    }

    public void update() {
        //creating array for the answer buttons
        ArrayList<Button> answerButtons = new ArrayList<>();
        answerButtons.add((Button) findViewById(R.id.buttonAnswer1));
        answerButtons.add((Button) findViewById(R.id.buttonAnswer2));
        answerButtons.add((Button) findViewById(R.id.buttonAnswer3));
        answerButtons.add((Button) findViewById(R.id.buttonAnswer4));

        //creating the button for submitting
        Button submitButton = findViewById(R.id.submit);
        submitButton.setVisibility(Button.INVISIBLE);
        submitButton.setOnClickListener(buttonClickListener);

        //taking the answers from each question
        ArrayList<QuestionAnswerOption> answers = test.getCurrentQuestion().getQuestionAnswerOptions().getAnswerOptions();

        //setting the text of each button and setting the onClick method
        for (int i = 0; i < answerButtons.size(); i++) {
            Button button = answerButtons.get(i);
            button.setText(answers.get(i).getAnswerOptionText());
            button.setOnClickListener(buttonClickListener);
        }

        //adding question text
        TextView question = findViewById(R.id.questions);
        String newQuestion = test.getCurrentQuestion().getTextQuestion();
        question.setText(newQuestion);

        //adding question numbers
        int number = test.getCurrentQuestion().getQuestionNumber();
        TextView questionNumber = findViewById(R.id.questionNumber);
        String numberText = number + "/" + test.getNumberOfQuestions();
        questionNumber.setText(numberText);
        }

    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonAnswer1:
                    manageAnswer(0);
                    break;
                case R.id.buttonAnswer2:
                    manageAnswer(1);
                    break;
                case R.id.buttonAnswer3:
                    manageAnswer(2);
                    break;
                case R.id.buttonAnswer4:
                    manageAnswer(3);
                    break;
                case R.id.submit:
                    if (test.getCurrentQuestion().getQuestionNumber() < test.getNumberOfQuestions()) {
                        test.nextQuestion();
                        update();
                    } else {
                        Intent result = new Intent(Q.this, Result.class);
                        startActivity(result);
                        finish();
                    }
                    break;
            }
        }
    };

    public void manageAnswer(int i){
        test.getCurrentQuestion().setAnswer(test.getCurrentQuestion().getQuestionAnswerOptions().getAnswerOptions().get(i));
        if(findViewById(R.id.submit).getVisibility() == Button.INVISIBLE) {
            findViewById(R.id.submit).setVisibility(Button.VISIBLE);
        }
    }
}
