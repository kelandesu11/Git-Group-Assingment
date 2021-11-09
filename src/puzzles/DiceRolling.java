package puzzles;

import java.io.Serial;
import java.util.Random;

public class DiceRolling implements MiniGame {

    @Serial
    private static final long serialVersionUID = 4820643763636391545L;
    String correctAnswer = String.valueOf(rollDice());

    @Override
    public void start() {
        System.out.println("Roll the dice: ");
    }

    @Override
    public boolean isCorrect(String input) {
        try {
            return Integer.parseInt(input) > Integer.parseInt(this.getCorrectAnswer());
        } catch (NumberFormatException numberFormatException) {
            System.out.println("That was not a number");
        }
        return false;
    }

    public int rollDice() {
        Random r = new Random();
        int low = 10;
        int high = 100;
        return r.nextInt(high - low) + low;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void reset() {
        this.setCorrectAnswer(String.valueOf(rollDice()));
    }
}
