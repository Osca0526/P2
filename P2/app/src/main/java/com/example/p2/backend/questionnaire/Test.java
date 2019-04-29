package com.example.p2.backend.questionnaire;

import java.util.ArrayList;

public class Test {

    private ArrayList<Question> questions;

    private Score score;

    private ArrayList<ScoreCategory> categories;

    private int currentQuestionNumber;

    private boolean testIsCompleted;

    public Test(ArrayList<Question> questions, ArrayList<ScoreCategory> categories){
        this.questions = questions;
        calculateTotalScore();
        score = new Score(categories);
        for (Question question : questions){
            question.setTest(this);
        }
        currentQuestionNumber = 1;
        testIsCompleted = false;
    }

    public void startTest(){

    }

    public void nextQuestion(){
        currentQuestionNumber++;
        if (currentQuestionNumber <= questions.size()){
            testIsCompleted = true;
            calculateScore();
        }
    }

    public Question getCurrentQuestion(){
        if (!testIsCompleted){
            return questions.get(currentQuestionNumber);
        }else{
            return null;
        }
    }


    public void submitQuestionAnswer(ScoreCategory scoreCategory, int weight){
        score.addScore(scoreCategory, weight);
    }

    private void calculateTotalScore(){

    }

    private void calculateScore(){

    }

    public Score getScore(){
        if (testIsCompleted){
            return score;
        }else{
            return null;
        }
    }

    public boolean isCompleted(){
        return testIsCompleted;
    }


}
