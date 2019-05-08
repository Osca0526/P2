package com.example.p2.backend.questionnaire;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class QuestionAnswerOptions implements Parcelable {

    private ArrayList<QuestionAnswerOption> answerOptions;

    public QuestionAnswerOptions(ArrayList<QuestionAnswerOption> answerOptions){
        this.answerOptions = answerOptions;
    }

    public ArrayList<QuestionAnswerOption> getAnswerOptions() {
        return answerOptions;
    }


    protected QuestionAnswerOptions(Parcel in) {
        if (in.readByte() == 0x01) {
            answerOptions = new ArrayList<QuestionAnswerOption>();
            in.readList(answerOptions, QuestionAnswerOption.class.getClassLoader());
        } else {
            answerOptions = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (answerOptions == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(answerOptions);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<QuestionAnswerOptions> CREATOR = new Parcelable.Creator<QuestionAnswerOptions>() {
        @Override
        public QuestionAnswerOptions createFromParcel(Parcel in) {
            return new QuestionAnswerOptions(in);
        }

        @Override
        public QuestionAnswerOptions[] newArray(int size) {
            return new QuestionAnswerOptions[size];
        }
    };
}