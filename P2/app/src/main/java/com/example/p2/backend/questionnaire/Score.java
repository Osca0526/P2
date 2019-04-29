package com.example.p2.backend.questionnaire;

import java.util.ArrayList;
import java.util.HashMap;

public class Score {

    private HashMap<ScoreCategory, Integer> categoriesMap;

    private int numberOfCategories;

    private boolean isCompleted;

    public Score(ArrayList<ScoreCategory> categories){

        categoriesMap = new HashMap<ScoreCategory, Integer>();

        for (ScoreCategory category : categories){
            categoriesMap.put(category, 0);
        }

        numberOfCategories = categories.size();

        isCompleted = false;

    }

    public void addScore(ScoreCategory category, int answerWeight){
        int previousAnswerWeight = categoriesMap.get(category);
        //categoriesMap.replace(category, previousAnswerWeight + answerWeight);
    }

    public void setScoreCompleted(){
        isCompleted = true;
    }

    public HashMap<ScoreCategory, Integer> getScore(){
        return categoriesMap;
    }

    public void printScore(){
        System.out.println("\n Score: \n" +
                "\n" +
                "\n");
    }

}
