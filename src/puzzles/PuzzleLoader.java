package puzzles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class PuzzleLoader implements LoaderInterface {

    public MiniGame getMiniGame(String gameName) {
        gameName = gameName.toLowerCase();
        return switch (gameName) {
            case "dice rolling" -> new DiceRolling();
            case "hangman" -> new HangMan();
            case "word spell" -> new WordSpell();
            case "left and right" -> new LeftAndRight();
            case "who game", "the riddles" -> new QuestionAnswer();
            case "treasure chests" -> new TreasureChests();
            default -> null;
        };

    }

    @Override
    public HashMap<Integer, Puzzle> loadFile(String fileName) {
        File file;
        Scanner scannerIn = new Scanner(System.in);
        HashMap<Integer, Puzzle> puzzleHashMap = new HashMap<>();
        try {
            file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    Puzzle tempPuzzle = new Puzzle();
                    tempPuzzle.setId(Integer.parseInt(line));
                    tempPuzzle.setName(scanner.nextLine());
                    tempPuzzle.setDescription(scanner.nextLine());
                    tempPuzzle.setHealthPoints(Integer.parseInt(scanner.nextLine()));
                    tempPuzzle.setRoomId(Integer.parseInt(scanner.nextLine()));

                    MiniGame miniGame = getMiniGame(tempPuzzle.getName());
                    if (miniGame != null) {
                        tempPuzzle.setMiniGame(miniGame);
                        miniGame.setCorrectAnswer(scanner.nextLine());
                    } else {
                        scanner.nextLine();
                    }
                    puzzleHashMap.put(tempPuzzle.getRoomId(), tempPuzzle);
                }

                // Store the puzzle in with roomID as the Key


            }

        } catch (FileNotFoundException e) {
            System.out.print("Invalid File name. New file name:");
            loadFile(scannerIn.nextLine());
        }
        return puzzleHashMap;
    }

    public HashMap<Integer, Puzzle> loadFile() {
        return this.loadFile("Puzzle.txt");
    }
}
