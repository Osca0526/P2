package com.example.p2.backend.questionnaire;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Test implements Parcelable {

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
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(score);
    }

    public Test(Parcel in){
        score = in.readParcelable(Test.class.getClassLoader());
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Test> CREATOR = new Parcelable.Creator<Test>() {
        public Test createFromParcel(Parcel in) {
            return new Test(in);
        }

        public Test[] newArray(int size) {
            return new Test[size];
        }
    };

    public void nextQuestion(){
        if (currentQuestionNumber >= getNumberOfQuestions()){
            testIsCompleted = true;
        } else{
            currentQuestionNumber++;
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
