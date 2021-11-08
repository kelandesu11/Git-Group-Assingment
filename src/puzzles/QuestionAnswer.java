package puzzles;

public class QuestionAnswer implements MiniGame {

    String correctAnswer;
    String userInput = "";

    @Override
    public void start() {
        System.out.println("Answer the riddle question.");
    }

    @Override
    public boolean isCorrect(String input) {
        return this.correctAnswer.equalsIgnoreCase(input);
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void reset() {
        this.setUserInput("");
    }
}
