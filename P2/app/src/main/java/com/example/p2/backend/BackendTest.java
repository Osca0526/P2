import questionnaire.*;

public class Main {

    public static void main(String[] args) {

        Test test = new AnTI_Test().getTest();

        test.startTest();

        Question currentQuestion = null;
        QuestionAnswerOptions questionAnswerOptions = null;

        int inputAnswerFromUser = 1; // to be taken from the user, depending on the answer option

        while (!test.isCompleted()){
            currentQuestion = test.getCurrentQuestion();
            questionAnswerOptions = currentQuestion.getQuestionAnswerOptions();
            currentQuestion.setAnswer(questionAnswerOptions.getAnswerOptions().get(inputAnswerFromUser));
        }

        Score testScore = test.getScore();
        testScore.printScore();

    }
}