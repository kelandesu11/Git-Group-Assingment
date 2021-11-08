package puzzles;

public interface MiniGame {

    void start();

    boolean isCorrect(String input);

    String getCorrectAnswer();

    void setCorrectAnswer(String correctAnswer);

    void reset();
}
