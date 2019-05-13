package com.example.p2.frontend;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.p2.R;
import com.example.p2.backend.questionnaire.AnTI_Test;
import com.example.p2.backend.questionnaire.QuestionAnswerOption;
import com.example.p2.backend.questionnaire.Test;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    Test test = new AnTI_Test().getTest();
    ArrayList<Button> answerButtons = new ArrayList<>();
    int answerNumber;
    int[] paths = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10,
            R.drawable.image11,
            R.drawable.image12,
            R.drawable.image13,
            R.drawable.image14,
            R.drawable.image15,
            R.drawable.image16,
            R.drawable.image17,
            R.drawable.image18,
            R.drawable.image19,
            R.drawable.image20,
            R.drawable.image21,
            R.drawable.image22
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        update();
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
        submitButton.setOnClickListener(buttonClickListener);

        //taking the answers from each question
        ArrayList<QuestionAnswerOption> answers = test.getCurrentQuestion().getQuestionAnswerOptions().getAnswerOptions();

        //setting the text of each button and setting the onClick method
        for (int i = 0; i < answerButtons.size(); i++) {
            Button button = answerButtons.get(i);
            button.setText(answers.get(i).getAnswerOptionText());
            button.setOnClickListener(buttonClickListener);
            button.setTextColor(Color.parseColor("#FFFFFF"));
            answerButtons.get(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonquest));
        }

        //adding question text
        TextView question = findViewById(R.id.questions);
        String newQuestion = test.getCurrentQuestion().getTextQuestion();
        question.setText(newQuestion);

        //adding question numbers
        int number = test.getCurrentQuestion().getQuestionNumber();
        int maxNumber = test.getNumberOfQuestions();
        String numberText = number + "/" + maxNumber;
        submitButton.setText(numberText);

        //setting the progress bar
        if (number <= maxNumber && number >= 0) {
            ImageView progressBar = findViewById(R.id.imageViewProgress);
            progressBar.setImageResource(paths[number - 1]);
        }
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
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
                        test.submitQuestionAnswer(test.getCurrentQuestion().getCategory(), test.getCurrentQuestion().setAnswer(test.getCurrentQuestion().getQuestionAnswerOptions().getAnswerOptions().get(answerNumber)));
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
        Button submitButton = findViewById(R.id.submit);
        submitButton.setText(R.string.submit_button);
        for (int y = 0; y < answerButtons.size(); y++) {
            if (y == answerNumber){
                answerButtons.get(y).setTextColor(Color.parseColor("#B8BAFF"));
                answerButtons.get(y).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonquestpressed));
            } else {
                answerButtons.get(y).setTextColor(Color.parseColor("#FFFFFF"));
                answerButtons.get(y).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonquest));
            }
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(TestActivity.this,"There is no way back",Toast.LENGTH_LONG).show();
    }
}
