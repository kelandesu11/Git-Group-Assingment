package puzzles;

import java.util.ArrayList;
import java.util.Collections;

public class TreasureChests extends QuestionAnswer {

    @Override
    public void start() {
        ArrayList<Integer> chests = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            chests.add(i);
        }
        Collections.shuffle(chests);
        this.setCorrectAnswer(String.valueOf(chests.get(0)));
        System.out.println("Pick the correct treasure chest: " + chests);
    }
}
