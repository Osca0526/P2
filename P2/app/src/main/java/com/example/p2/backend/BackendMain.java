package com.example.p2.backend;

import com.example.p2.backend.questionnaire.*;

public class BackendMain {

    public static void main(String[] args) {

        Test test = new AnTI_Test().getTest();

        test.startTest();

        Question currentQuestion = null;
        QuestionAnswerOptions questionAnswerOptions = null;

        int inputAnswerFromUser = 1; // to be taken from the user, depending on the answer option

        int[] inputAnswerFromUserArray = {0, 1, 2, 3, 3, 2, 1, 0, 0, 1, 2, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}; // to be taken from the user

        while (!test.isCompleted()){
            currentQuestion = test.getCurrentQuestion();
            questionAnswerOptions = currentQuestion.getQuestionAnswerOptions();
            currentQuestion.setAnswer(questionAnswerOptions.getAnswerOptions().get(inputAnswerFromUserArray[currentQuestion.getQuestionNumber()]));
            test.nextQuestion();
        }

        Score testScore = test.getScore();
        testScore.printScore();

        System.out.println("done.");

    }
}
