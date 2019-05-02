package com.example.p2.backend;

import com.example.p2.backend.questionnaire.*;

public class BackendMain {

    public static void main(String[] args) {

        Test test = new AnTI_Test().getTest();

        test.startTest();

        Question currentQuestion = null;
        QuestionAnswerOptions questionAnswerOptions = null;

        int inputAnswerFromUser = 1; // to be taken from the user, depending on the answer option

        for (Question question : test.getQuestions() ){
            questionAnswerOptions = question.getQuestionAnswerOptions();
            question.setAnswer(questionAnswerOptions.getAnswerOptions().get(1));
        }


        Score testScore = test.getScore();
        testScore.printScore();

        System.out.println("done.");

    }
}
