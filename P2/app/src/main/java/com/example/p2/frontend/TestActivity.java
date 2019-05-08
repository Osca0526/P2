package com.example.p2.frontend;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.p2.backend.questionnaire.*;
import com.example.p2.R;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity{

    Test test = new AnTI_Test().getTest();
    ArrayList<Button> answerButtons = new ArrayList<>();
    int answerNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        update();
    }

    protected void onResume(){
        super.onResume();
        //update();
    }

    public void update() {
        //creating array for the answer buttons
        answerButtons.clear();
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
            button.setTextColor(Color.parseColor("#FFFFFF"));
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
                    answerNumber = 0;
                    manageAnswer();
                    break;
                case R.id.buttonAnswer2:
                    answerNumber = 1;
                    manageAnswer();
                    break;
                case R.id.buttonAnswer3:
                    answerNumber = 2;
                    manageAnswer();
                    break;
                case R.id.buttonAnswer4:
                    answerNumber = 3;
                    manageAnswer();
                    break;
                case R.id.submit:
                    if (test.getCurrentQuestion().getQuestionNumber() < test.getNumberOfQuestions()) {
                        test.nextQuestion();
                        test.submitQuestionAnswer(test.getCurrentQuestion().getCategory(),test.getCurrentQuestion().setAnswer(test.getCurrentQuestion().getQuestionAnswerOptions().getAnswerOptions().get(answerNumber)));
                        update();
                    } else {
                        Intent result = new Intent(TestActivity.this, ResultActivity.class);
                        result.putExtra("test", test);
                        startActivity(result);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                    }
                    break;
            }
        }
    };

    public void manageAnswer(){
        if(findViewById(R.id.submit).getVisibility() == Button.INVISIBLE) {
            findViewById(R.id.submit).setVisibility(Button.VISIBLE);
        }
        for (int y = 0; y < answerButtons.size(); y++) {
            if (y == answerNumber){
                answerButtons.get(y).setTextColor(Color.parseColor("#000000"));
            } else {
                answerButtons.get(y).setTextColor(Color.parseColor("#FFFFFF"));
            }
        }
    }
}
