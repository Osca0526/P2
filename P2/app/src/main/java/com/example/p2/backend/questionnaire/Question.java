package questionnaire;

public class Question {

    private String textQuestion;

    private ScoreCategory category;

    private QuestionAnswerOptions questionAnswerOptions;

    private int answerWeight;

    private Test test;

    public Question(String textQuestion, ScoreCategory category, QuestionAnswerOptions questionAnswerOptions){
        this.textQuestion = textQuestion;
        this.category = category;
        this.questionAnswerOptions = questionAnswerOptions;
        answerWeight = 0;
    }

    public void setTest(Test test){
        this.test = test;
    }

    public void setAnswer(QuestionAnswerOption answerOption){
        answerWeight = answerOption.getAnswerOptionWeight();
        test.submitQuestionAnswer(category, answerWeight);
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

}
