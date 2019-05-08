package com.example.p2.backend.questionnaire;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {

    private String textQuestion;

    private ScoreCategory category;

    private QuestionAnswerOptions questionAnswerOptions;

    private int answerWeight;

    private int questionNumber;


    public Question(String textQuestion, ScoreCategory category, QuestionAnswerOptions questionAnswerOptions, int questionNumber){
        this.textQuestion = textQuestion;
        this.category = category;
        this.questionAnswerOptions = questionAnswerOptions;
        answerWeight = 0;
        this.questionNumber = questionNumber;
    }


    public int setAnswer(QuestionAnswerOption answerOption){
        return answerOption.getAnswerOptionWeight();
    }

    public ScoreCategory getCategory(){
        return category;
    }

    public String getTextQuestion(){
        return textQuestion;
    }

    public int getAnswerWeight(){
        return answerWeight;
    }

    public QuestionAnswerOptions getQuestionAnswerOptions(){
        return questionAnswerOptions;
    }

    public boolean isAnswered(){
        return (answerWeight != 0);
    }

    public int getQuestionNumber(){
        return questionNumber;
    }



    protected Question(Parcel in) {
        textQuestion = in.readString();
        category = (ScoreCategory) in.readValue(ScoreCategory.class.getClassLoader());
        questionAnswerOptions = (QuestionAnswerOptions) in.readValue(QuestionAnswerOptions.class.getClassLoader());
        answerWeight = in.readInt();
        questionNumber = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(textQuestion);
        dest.writeValue(category);
        dest.writeValue(questionAnswerOptions);
        dest.writeInt(answerWeight);
        dest.writeInt(questionNumber);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}