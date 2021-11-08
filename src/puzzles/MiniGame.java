package puzzles;

import java.io.Serializable;

public interface MiniGame extends Serializable {

    void start();

    boolean isCorrect(String input);

    String getCorrectAnswer();

    void setCorrectAnswer(String correctAnswer);

    void reset();
}
