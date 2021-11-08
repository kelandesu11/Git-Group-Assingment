package puzzles;


import java.util.Arrays;

public class HangMan extends QuestionAnswer {

    @Override
    public void start() {
        System.out.println("HINT: It is an animal. Use multiple characters as input. " + ("_ ".repeat(this.getCorrectAnswer().length())));
        char[] correctAns = this.getCorrectAnswer().toCharArray();
        Arrays.sort(correctAns);
        this.setCorrectAnswer(String.valueOf(correctAns));
        System.out.println(this.getCorrectAnswer());
    }

    @Override
    public boolean isCorrect(String input) {

        // TODO: implement partial unmask
        userInput = userInput.concat(input.trim());
        char[] temp = userInput.toCharArray();
        Arrays.sort(temp);

        userInput = String.valueOf(temp);

        return super.isCorrect(userInput);
    }
}
