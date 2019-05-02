package com.example.p2.backend.questionnaire;

public class ScoreCategory {

    private String categoryName;

    private int categoryScoreCount;

    public ScoreCategory(String categoryName){
        this.categoryName = categoryName;
        categoryScoreCount = 0;
    }

    public String getCategoryName(){
        return categoryName;
    }

    public void increaseCount(int numberToAdd){
        categoryScoreCount += numberToAdd;
    }

    public void decreaseCount(int numberToTake){
        categoryScoreCount -= numberToTake;
    }

    public int getCategoryScoreCount(){
        return categoryScoreCount;
    }

}
