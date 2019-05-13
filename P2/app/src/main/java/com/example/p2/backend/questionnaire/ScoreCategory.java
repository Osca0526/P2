package com.example.p2.backend.questionnaire;

import android.os.Parcel;
import android.os.Parcelable;

public class ScoreCategory implements Parcelable {

    private String categoryName;

    private int categoryScoreCount;

    private int categoryScoreMaximum;

    private int categoryScoreMinimum;

    private int MAX_ANSWER_WEIGHT = 4;

    private int MIN_ANSWER_WEIGHT = 1;

    private double categoryAverage;

    public ScoreCategory(String categoryName, double average){
        this.categoryName = categoryName;
        categoryScoreCount = 0;
        categoryScoreMaximum = 0;
        categoryScoreMinimum = 0;
        categoryAverage = average;
    }

    public String getCategoryName(){
        return categoryName;
    }

    public void increaseCount(int numberToAdd){
        categoryScoreCount += numberToAdd;
        categoryScoreMaximum += MAX_ANSWER_WEIGHT;
        categoryScoreMinimum += MIN_ANSWER_WEIGHT;
    }

    public void decreaseCount(int numberToTake){
        categoryScoreCount -= numberToTake;
        categoryScoreMaximum -= MAX_ANSWER_WEIGHT;
    }

    public int getCategoryScoreCount(){
        return categoryScoreCount;
    }

    public int getCategoryScoreMaximum(){
        return categoryScoreMaximum;
    }

    public int getCategoryScoreMinimum(){
        return categoryScoreMinimum;
    }

    public double getCategoryAverage() {
        return categoryAverage;
    }

    protected ScoreCategory(Parcel in) {
        categoryName = in.readString();
        categoryScoreCount = in.readInt();
        categoryScoreMaximum = in.readInt();
        MAX_ANSWER_WEIGHT = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categoryName);
        dest.writeInt(categoryScoreCount);
        dest.writeInt(categoryScoreMaximum);
        dest.writeInt(MAX_ANSWER_WEIGHT);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ScoreCategory> CREATOR = new Parcelable.Creator<ScoreCategory>() {
        @Override
        public ScoreCategory createFromParcel(Parcel in) {
            return new ScoreCategory(in);
        }

        @Override
        public ScoreCategory[] newArray(int size) {
            return new ScoreCategory[size];
        }
    };

}