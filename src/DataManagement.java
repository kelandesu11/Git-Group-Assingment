/*
 * Author: Jeremy Stiff
 * Description: This class serves as the model and allows the controller access to all the
 * data and methods it will need to run the game.
 */

import java.util.ArrayList;

public class DataManagement {

    ArrayList<Items> inv = new ArrayList<>();
    private Storage storage = new Storage();
    private final TextLoader loader = new TextLoader();

    public DataManagement() {
    }

    // Author: Jeremy Stiff
    public void saveGame() {
        loader.writeStorage(storage);
    }

    // Author: Jeremy Stiff
    public void loadSave() {
        Storage temp = new Storage();
        temp = loader.loadSave();
        storage = temp;
    }

    // Author: Jeremy Stiff
    public void newGame() {
        storage.setMap(loader.loadFile());
        storage.assignPuzzle(); // SK
    }

    // Author: Jeremy Stiff
    public Rooms getRoom(int id) {
        return storage.getRoom(id);
    }

    // Jeremy Stiff
    public Player getPlayer() {
        return storage.getPlayer();
    }

    // Author: Jeremy Stiff
    public Rooms getPlayerRoom() {
        return storage.currentRoom();
    }

    // Author: Jeremy Stiff
    public void movePlayerNorth() {
        if (getPlayerRoom().getNorth() != -1 && (!getPlayerRoom().hasMonster() || getPlayerRoom().getNorth() == getPlayer().getPreviousRoom())) {
            getPlayerRoom().resetPuzzle(); // SK
            storage.getPlayer().setPreviousRoom(getPlayerRoom().getRoomID());
            storage.getPlayer().setPlayerLocation(getPlayerRoom().getNorth());
            System.out.println(getPlayerRoom().toString());
        } else if (getPlayerRoom().getNorth() != -1 && getPlayerRoom().hasMonster())
            System.out.println("You cannot move on until the monster has been defeated");
        else
            System.out.println("Ouch! You walk into a wall!");
    }

    // Author: Jeremy Stiff
    public void movePlayerSouth() {
        if (getPlayerRoom().getSouth() != -1 && (!getPlayerRoom().hasMonster() || getPlayerRoom().getSouth() == getPlayer().getPreviousRoom())) {
            getPlayerRoom().resetPuzzle(); // SK
            storage.getPlayer().setPreviousRoom(getPlayerRoom().getRoomID());
            storage.getPlayer().setPlayerLocation(getPlayerRoom().getSouth());
            System.out.println(getPlayerRoom().toString());
        } else if (getPlayerRoom().getSouth() != -1 && getPlayerRoom().hasMonster())
            System.out.println("You cannot move on until the monster has been defeated");
        else
            System.out.println("Ouch! You walk into a wall!");
    }

    // Author: Jeremy Stiff
    public void movePlayerEast() {
        if (getPlayerRoom().getEast() != -1 && (!getPlayerRoom().hasMonster() || getPlayerRoom().getEast() == getPlayer().getPreviousRoom())) {
            getPlayerRoom().resetPuzzle(); // SK
            storage.getPlayer().setPreviousRoom(getPlayerRoom().getRoomID());
            storage.getPlayer().setPlayerLocation(getPlayerRoom().getEast());
            System.out.println(getPlayerRoom().toString());
        } else if (getPlayerRoom().getEast() != -1 && getPlayerRoom().hasMonster())
            System.out.println("You cannot move on until the monster has been defeated");
        else
            System.out.println("Ouch! You walk into a wall!");
    }

    // Author: Jeremy Stiff
    public void movePlayerWest() {
        if (getPlayerRoom().getWest() != -1 && (!getPlayerRoom().hasMonster() || getPlayerRoom().getWest() == getPlayer().getPreviousRoom())) {
            getPlayerRoom().resetPuzzle(); // SK
            storage.getPlayer().setPreviousRoom(getPlayerRoom().getRoomID());
            storage.getPlayer().setPlayerLocation(getPlayerRoom().getWest());
            System.out.println(getPlayerRoom().toString());
        } else if (getPlayerRoom().getWest() != -1 && getPlayerRoom().hasMonster())
            System.out.println("You cannot move on until the monster has been defeated");
        else
            System.out.println("Ouch! You walk into a wall!");
    }

    //Author: Kelan McNally
    public void pickupItem() {
        // Only can pick up one item at a time.
        Items firstItem = getPlayerRoom().getItems().get(0);
        if (firstItem != null) {
            inv.add(firstItem);
            System.out.println("You picked up the item!");
        }

    }

    //Author: Kelan McNally
    public void dropItem() {
        System.out.println("You dropped the item!");
        Items equippedItem = getPlayer().getEquippedItem();
        if (equippedItem != null) {
            getPlayerRoom().getItems().add(equippedItem);
            equippedItem.setItemLocation(getPlayerRoom().getRoomID());
        }
    }

    //Author: Kelan McNally
    public void equipItem() {
        // TODO this need to pass an item name as the param to equip that one item
        getPlayerRoom().getItems().forEach(item -> {
            if (inv.contains(item)) {
                System.out.println("You equipped the item!");
                getPlayer().updateHealth(item.getItemEffect());
                getPlayer().updateDamage(item.getItemEffect()); //TODO: change it to item damage points.
            }
        });


//		if(inv.contains(getPlayerRoom().getItems())) {
//		System.out.println("You equipped the item!");
//		getPlayer().setHealth(getPlayer().getHealth() + getPlayerRoom().getItems());
//		else{
//		getPlayer().setDamage(getPlayer().getDamage() + getPlayerRoom().getItems());
//	}
//	}
    }

    //Author: Kelan McNally
    public void unequipItem() {
        Items equippedItem = getPlayer().getEquippedItem();
        if (equippedItem != null) {
            if (getPlayer().getHealth() > 20) {
                System.out.println("You unequipped the item");
                getPlayer().decreaseHealth(equippedItem.getItemEffect());
            } else if (getPlayer().getDamage() > 2) {
                System.out.println("You unequipped the item");
                getPlayer().decreaseDamage(equippedItem.getItemEffect()); // TODO items needs damage points
            }
        }

    }

    /*
     * Author: Jeremy Stiff This method returns an integer array of connections -1
     * is no connection. The order of connections is North, East, South, West.
     */
    public int[] getConnections() {
        int[] connections = new int[4];
        connections[0] = getPlayerRoom().getNorth();
        connections[1] = getPlayerRoom().getSouth();
        connections[2] = getPlayerRoom().getEast();
        connections[3] = getPlayerRoom().getWest();
        return connections;
    }

    /*
     * Author: Jeremy Stiff Returns a list of avaliable connections.
     */
    private String getConnectionsString() {
        int[] connections = getConnections();
        String links = "Your movement options are:";

        if (connections[0] != -1)
            links += " n or North";
        if (connections[1] != -1)
            links += " s or South";
        if (connections[2] != -1)
            links += " e or East";
        if (connections[3] != -1)
            links += " w or West";

        return links;
    }

    // Author: Jeremy Stiff
    private String getActions() {
        String actions = "Your available actions are:";

        // TODO Code that gathers and returns actions similar to above method.
        if (getPlayerRoom().hasMonster())
            actions += " m or Monster";
        if (getPlayerRoom().hasPuzzle())
            actions += " p or Puzzle";
        if (getPlayerRoom().hasItem())
            actions += " i or Item";

        if (actions.equals("Your available actions are:"))
            actions = "There is nothing to do here.";

        return actions;
    }

    // Author: Jeremy Stiff
    public void prompt() {
        System.out.println(getConnectionsString());
        System.out.println(getActions());
        System.out.println("Exit with \"x\" or \"exit\"");
    }

    // Author: Sanju
    public void inspectPuzzle() {
        System.out.println(getPlayerRoom().getPuzzle().prompt());
    }

    @Override
    // Author: Jeremy Stiff
    public String toString() {
        return "Player room is " + storage.getPlayer().getPlayerLocation() + "\n" + storage.toString();
    }

}
