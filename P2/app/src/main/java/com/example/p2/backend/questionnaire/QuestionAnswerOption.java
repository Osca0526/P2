package com.example.p2.backend.questionnaire;

public class QuestionAnswerOption{

    private String answerOptionText;

    private int answerOptionWeight;

    public QuestionAnswerOption(String answerOptionText, int answerOptionWeight){
        this.answerOptionText = answerOptionText;
        this.answerOptionWeight = answerOptionWeight;
    }

    public String getAnswerOptionText(){
        return answerOptionText;
    }

    public int getAnswerOptionWeight(){
        return answerOptionWeight;
    }

}