package puzzles;

public class LeftAndRight extends QuestionAnswer {

    @Override
    public void start() {
        System.out.println("Pick three consecutive turns: use l for left and r for right");
    }

    @Override
    public boolean isCorrect(String input) {
        return this.correctAnswer.startsWith(input) || this.correctAnswer.endsWith(input);
    }
}
