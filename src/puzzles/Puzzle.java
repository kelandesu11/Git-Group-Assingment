package puzzles;

import java.io.Serial;
import java.io.Serializable;

public class Puzzle implements Serializable {

    @Serial
    private static final long serialVersionUID = 4820643763636391545L;

    private int id;
    private String name;
    private String description;

    private int healthPoints;
    private int roomId;
    private int attemptLeft = 3;

    private boolean solved = false;
//    private String correctAnswer;

    private MiniGame miniGame;

    //Constructors
    public Puzzle() {
    }

    public Puzzle(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // MiniGame Interface start

    public void start() {
        if (this.miniGame != null) {
            this.miniGame.start();
        }
    }

    public boolean isCorrect(String input) {
        if (this.miniGame != null) {
            if (this.miniGame.isCorrect(input)) {
                this.setSolved(true);
            }
        }
        return this.isSolved();
    }

    // Getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public MiniGame getMiniGame() {
        return miniGame;
    }

    public void setMiniGame(MiniGame miniGame) {
        this.miniGame = miniGame;
    }

    public int getAttemptLeft() {
        return attemptLeft;
    }

    public void setAttemptLeft(int attemptLeft) {
        this.attemptLeft = attemptLeft;
    }

    public void decrementAttempt() {
        this.attemptLeft--;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }


    //Custom methods
    public String prompt() {
        return "ID:" + this.getId() + " Name: " + this.getName() + "\nDescription: " + this.getDescription();
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", miniGame=" + miniGame +
                '}';
    }

    public void reset() {
        this.setAttemptLeft(3);
        if (this.miniGame != null) {
            this.miniGame.reset();
        }

    }
}
