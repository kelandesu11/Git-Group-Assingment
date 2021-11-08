package puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WordSpell extends QuestionAnswer {

    @Override
    public void start() {
        char[] correctAns = this.getCorrectAnswer().toCharArray();
        ArrayList<Character> arrayList = new ArrayList<>();
        for (char correctAn : correctAns) {
            arrayList.add(correctAn);
        }
        Collections.shuffle(arrayList);
        System.out.println("Connect the letters to make the word: " + arrayList);
    }

    @Override
    public boolean isCorrect(String input) {
        userInput = userInput.concat(input.trim());
        char[] temp = userInput.toCharArray();
        userInput = Arrays.toString(temp);

        return super.isCorrect(userInput);
    }
}
