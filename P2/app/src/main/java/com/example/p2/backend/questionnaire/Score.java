package com.example.p2.backend.questionnaire;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Locale;

public class Score implements Parcelable {

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


    protected Score(Parcel in) {
        numberOfCategories = in.readInt();
        if (in.readByte() == 0x01) {
            categories = new ArrayList<ScoreCategory>();
            in.readList(categories, ScoreCategory.class.getClassLoader());
        } else {
            categories = null;
        }
        isCompleted = in.readByte() != 0x00;
        stringLocale = (Locale) in.readValue(Locale.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numberOfCategories);
        if (categories == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(categories);
        }
        dest.writeByte((byte) (isCompleted ? 0x01 : 0x00));
        dest.writeValue(stringLocale);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Score> CREATOR = new Parcelable.Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel in) {
            return new Score(in);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };
}