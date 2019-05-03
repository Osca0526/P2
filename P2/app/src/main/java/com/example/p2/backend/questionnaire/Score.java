package com.example.p2.backend.questionnaire;

import java.util.ArrayList;
import java.util.Locale;

public class Score {

    private int numberOfCategories;

    private ArrayList<ScoreCategory> categories;

    private boolean isCompleted;

    private Locale stringLocale = Locale.getAvailableLocales()[18]; // en_US

    public Score(ArrayList<ScoreCategory> categories){

        this.categories = categories;

        numberOfCategories = categories.size();

        isCompleted = false;

    }

    public void addScore(ScoreCategory category, int answerWeight){
        category.increaseCount(answerWeight);
    }

    public void setScoreCompleted(){
        isCompleted = true;
    }

    public ArrayList<ScoreCategory> getScore(){
        return categories;
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
            System.out.print(category.getCategoryScoreCount());
            System.out.print(" points out of ");
            System.out.println(category.getCategoryScoreMaximum());
            System.out.println("---");
        }
    }

    public String getJSArrayString(){
        String resultString = "['Category', 'Your Score', 'Maximum'],\n";
        for (ScoreCategory category : categories){
            resultString = resultString.concat(String.format(stringLocale,
                    "['%s', %d, %d],\n",
                    category.getCategoryName(), category.getCategoryScoreCount(), category.getCategoryScoreMaximum()));
        }
        return resultString;
    }

    public Locale getStringLocale(){
        return stringLocale;
    }

}
