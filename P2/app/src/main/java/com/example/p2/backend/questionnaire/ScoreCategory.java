package com.example.p2.backend.questionnaire;

public class ScoreCategory {

    private String categoryName;

    private int categoryScoreCount;

    private int categoryScoreMaximum;

    private int MAX_ANSWER_WEIGHT = 4;

    public ScoreCategory(String categoryName){
        this.categoryName = categoryName;
        categoryScoreCount = 0;
        categoryScoreMaximum = 0;
    }

    public String getCategoryName(){
        return categoryName;
    }

    public void increaseCount(int numberToAdd){
        categoryScoreCount += numberToAdd;
        categoryScoreMaximum += MAX_ANSWER_WEIGHT;
    }

    public void decreaseCount(int numberToTake){
        categoryScoreCount -= numberToTake;
    }

    public int getCategoryScoreCount(){
        return categoryScoreCount;
    }

    public int getCategoryScoreMaximum(){
        return categoryScoreMaximum;
    }

}
