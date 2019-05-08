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
        currentQuestionNumber = 0;
        testIsCompleted = false;
    }

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

    protected Test(Parcel in) {
        if (in.readByte() == 0x01) {
            questions = new ArrayList<>();
            in.readList(questions, Question.class.getClassLoader());
        } else {
            questions = null;
        }
        score = (Score) in.readValue(Score.class.getClassLoader());
        if (in.readByte() == 0x01) {
            categories = new ArrayList<>();
            in.readList(categories, ScoreCategory.class.getClassLoader());
        } else {
            categories = null;
        }
        currentQuestionNumber = in.readInt();
        testIsCompleted = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (questions == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(questions);
        }
        dest.writeValue(score);
        if (categories == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(categories);
        }
        dest.writeInt(currentQuestionNumber);
        dest.writeByte((byte) (testIsCompleted ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Test> CREATOR = new Parcelable.Creator<Test>() {
        @Override
        public Test createFromParcel(Parcel in) {
            return new Test(in);
        }

        @Override
        public Test[] newArray(int size) {
            return new Test[size];
        }
    };
}