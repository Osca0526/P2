package com.example.p2.backend.questionnaire;

import java.util.ArrayList;

public class AnTI_Test {

    /**
     *
     * Anxious Thoughts Inventory (AnTI)
     *
     * Developed by Adrian Wells
     *
     * **/

    private Test test;

    public AnTI_Test(){
        generateTestData();
        //generateEmptyData();
    }

    private void generateTestData(){

        ArrayList<ScoreCategory> scoreCategories = generateScoreCategories();

        ArrayList<Question> questions = generateQuestions(scoreCategories);

        test = new Test(
                questions,
                scoreCategories
        );
    }

    private void generateEmptyData(){
        test = new Test(null, null);
    }

    private ArrayList<ScoreCategory> generateScoreCategories(){
        ArrayList<ScoreCategory> scoreCategories = new ArrayList<>();
        scoreCategories.add(new ScoreCategory("HEALTH"));
        scoreCategories.add(new ScoreCategory("SOCIAL"));
        scoreCategories.add(new ScoreCategory("META"));
        return scoreCategories;
    }

    private ArrayList<Question> generateQuestions( ArrayList<ScoreCategory> scoreCategories ){


        ArrayList<QuestionAnswerOption> options = new ArrayList<>();
        options.add(new QuestionAnswerOption("Almost never", 1));
        options.add(new QuestionAnswerOption("Sometimes", 2));
        options.add(new QuestionAnswerOption("Often", 3));
        options.add(new QuestionAnswerOption("Almost Always", 4));

        QuestionAnswerOptions questionAnswerOptions = new QuestionAnswerOptions(options);

        ArrayList<Question> questions = new ArrayList<>();

        questions.add( new Question(
                "I worry about my appearance.",
                scoreCategories.get(0),
                questionAnswerOptions,
                1
        ) );

        questions.add( new Question(
                "I think I am a failure.",
                scoreCategories.get(2),
                questionAnswerOptions,
                2
        ) );

        questions.add( new Question(
                "When looking to my future I give more thought to the negative things than the positive things that might happen to me.",
                scoreCategories.get(1),
                questionAnswerOptions,
                3
        ) );

        questions.add( new Question(
                "If I experience unexpected physical symptoms, I have a tendency to think the worst possible thing is wrong with me",
                scoreCategories.get(0),
                questionAnswerOptions,
                4
        ) );

        questions.add( new Question(
                " I have thoughts about becoming seriously ill.",
                scoreCategories.get(1),
                questionAnswerOptions,
                5
        ) );

        return questions;
    }


    public Test getTest(){
        return test;
    }

}
