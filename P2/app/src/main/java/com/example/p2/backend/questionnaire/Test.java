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
        this.categories = categories;
        calculateTotalScore();
        score = new Score(categories);
        for (Question question : questions){
            question.setTest(this);
        }
        currentQuestionNumber = 0;
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
        return questions.get(currentQuestionNumber);
    }

    public int getNumberOfQuestions(){
        return questions.size();
    }


    public void submitQuestionAnswer(ScoreCategory scoreCategory, int weight){
        score.addScore(scoreCategory, weight);
    }

    private void calculateTotalScore(){

    }

    private void calculateScore(){

    }

    public Score getScore(){
        return score;
    }

    public boolean isCompleted(){
        return testIsCompleted;
    }

    public ArrayList<Question> getQuestions(){
        return questions;
    }


}
