package com.example.p2.backend.questionnaire;

import java.util.ArrayList;

public class AnTI_Test {

    /**
     *
     * Anxious Thoughts Inventory (AnTI)
     *
     * Developed by Adrian Wells
     *
     *
     *
     * Averages for non-patients taken from:
     *
     *
     * **/

    private Test test;

    public AnTI_Test(){
        generateTestData();
    }

    private void generateTestData(){

        ArrayList<ScoreCategory> scoreCategories = generateScoreCategories();

        ArrayList<Question> questions = generateQuestions(scoreCategories);

        test = new Test(questions, scoreCategories);

    }

    public Test getTest(){
        return test;
    }


    private ArrayList<ScoreCategory> generateScoreCategories(){
        ArrayList<ScoreCategory> scoreCategories = new ArrayList<>();
        scoreCategories.add(new ScoreCategory("SOCIAL", (float) 18.1));
        scoreCategories.add(new ScoreCategory("HEALTH", (float) 8.8));
        scoreCategories.add(new ScoreCategory("META", (float) 11.3));
        return scoreCategories;
    }

    private ArrayList<Question> generateQuestions( ArrayList<ScoreCategory> scoreCategories ){


        ArrayList<QuestionAnswerOption> options = new ArrayList<>();
        options.add(new QuestionAnswerOption("Almost\nNever", 1));
        options.add(new QuestionAnswerOption("Sometimes", 2));
        options.add(new QuestionAnswerOption("Often", 3));
        options.add(new QuestionAnswerOption("Almost\nAlways", 4));

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
                "If I experience unexpected physical symptoms, I have a tendency to think the worst possible thing is wrong with me.",
                scoreCategories.get(0),
                questionAnswerOptions,
                4
        ) );

        questions.add( new Question(
                "I have thoughts about becoming seriously ill.",
                scoreCategories.get(1),
                questionAnswerOptions,
                5
        ) );

        questions.add( new Question(
                "I have difficulty clearing my mind of repetitive thoughts.",
                scoreCategories.get(2),
                questionAnswerOptions,
                6
        ) );

        questions.add( new Question(
                "I worry about having a heart attack or cancer.",
                scoreCategories.get(1),
                questionAnswerOptions,
                7
        ) );

        questions.add( new Question(
                "I worry about saying or doing the wrong things when among strangers.",
                scoreCategories.get(0),
                questionAnswerOptions,
                8
        ) );

        questions.add( new Question(
                "I worry about my abilities not living up to other people’s expectations.",
                scoreCategories.get(0),
                questionAnswerOptions,
                9
        ) );

        questions.add( new Question(
                "I worry about my physical health.",
                scoreCategories.get(1),
                questionAnswerOptions,
                10
        ) );

        questions.add( new Question(
                "I worry that I cannot control my thoughts as well as I would like to.",
                scoreCategories.get(2),
                questionAnswerOptions,
                11
        ) );

        questions.add( new Question(
                "I worry that people don’t like me.",
                scoreCategories.get(0),
                questionAnswerOptions,
                12
        ) );

        questions.add( new Question(
                "I take disappointments so keenly that I can’t put them out of my mind.",
                scoreCategories.get(2),
                questionAnswerOptions,
                13
        ) );

        questions.add( new Question(
                "I get embarrassed easily.",
                scoreCategories.get(0),
                questionAnswerOptions,
                14
        ) );

        questions.add( new Question(
                "When I suffer from minor illnesses such as a rash, I think it is more serious than it really is.",
                scoreCategories.get(1),
                questionAnswerOptions,
                15
        ) );

        questions.add( new Question(
                "Unpleasant thoughts enter my head against my will.",
                scoreCategories.get(2),
                questionAnswerOptions,
                16
        ) );

        questions.add( new Question(
                "I worry about my failures and my weaknesses.",
                scoreCategories.get(0),
                questionAnswerOptions,
                17
        ) );

        questions.add( new Question(
                "I worry about not being able to cope in life as adequately as others seem to.",
                scoreCategories.get(0),
                questionAnswerOptions,
                18
        ) );

        questions.add( new Question(
                "I worry about death.",
                scoreCategories.get(1),
                questionAnswerOptions,
                19
        ) );

        questions.add( new Question(
                "I worry about making a fool of myself.",
                scoreCategories.get(0),
                questionAnswerOptions,
                20
        ) );

        questions.add( new Question(
                "I think I am missing out on things in life because I worry too much.",
                scoreCategories.get(2),
                questionAnswerOptions,
                21
        ) );

        questions.add( new Question(
                "I have repetitive thoughts such as counting or repeating phrases.",
                scoreCategories.get(2),
                questionAnswerOptions,
                22
        ) );


        return questions;
    }

}
