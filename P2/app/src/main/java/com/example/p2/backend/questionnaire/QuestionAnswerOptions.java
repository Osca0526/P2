package com.example.p2.backend.questionnaire;

import java.util.ArrayList;

public class QuestionAnswerOptions {

    private ArrayList<QuestionAnswerOption> answerOptions;

    public QuestionAnswerOptions(ArrayList<QuestionAnswerOption> answerOptions){
        this.answerOptions = answerOptions;
    }

    public ArrayList<QuestionAnswerOption> getAnswerOptions() {
        return answerOptions;
    }

}
