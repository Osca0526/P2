package com.example.p2.backend.questionnaire;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionAnswerOption implements Parcelable {

    private String answerOptionText;

    private int answerOptionWeight;

    public QuestionAnswerOption(String answerOptionText, int answerOptionWeight){
        this.answerOptionText = answerOptionText;
        this.answerOptionWeight = answerOptionWeight;
    }

    public String getAnswerOptionText(){
        return answerOptionText;
    }

    public int getAnswerOptionWeight(){
        return answerOptionWeight;
    }


    protected QuestionAnswerOption(Parcel in) {
        answerOptionText = in.readString();
        answerOptionWeight = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(answerOptionText);
        dest.writeInt(answerOptionWeight);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<QuestionAnswerOption> CREATOR = new Parcelable.Creator<QuestionAnswerOption>() {
        @Override
        public QuestionAnswerOption createFromParcel(Parcel in) {
            return new QuestionAnswerOption(in);
        }

        @Override
        public QuestionAnswerOption[] newArray(int size) {
            return new QuestionAnswerOption[size];
        }
    };
}