package com.example.p2.backend.questionnaire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Score {

    private HashMap<ScoreCategory, Integer> categoriesMap;

    private int numberOfCategories;

    ArrayList<ScoreCategory> categories;

    private boolean isCompleted;

    public Score(ArrayList<ScoreCategory> categories){

        this.categories = categories;

        categoriesMap = new HashMap<>();

        for (ScoreCategory category : categories){
            categoriesMap.put(category, 0);
        }

        numberOfCategories = categories.size();

        isCompleted = false;

    }

    public void addScore(ScoreCategory category, int answerWeight){
        int previousAnswerWeight = (categoriesMap.get(category) == null) ? 0 : categoriesMap.get(category);
        categoriesMap.replace(category, previousAnswerWeight + answerWeight);
    }

    public void setScoreCompleted(){
        isCompleted = true;
    }

    public HashMap<ScoreCategory, Integer> getScore(){
        return categoriesMap;
    }

    public void printScore(){
        System.out.println("\n Score: \n" +
                "\n Is completed: " + isCompleted);
        printCategories();
    }

    private void printCategories(){

        for (ScoreCategory category : categories){
            System.out.println("---");
            System.out.println(category.getCategoryName());
            System.out.println(categoriesMap.get(category));
            System.out.println("---");
        }
    }

}
