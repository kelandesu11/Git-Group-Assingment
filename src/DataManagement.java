/*
 * Author: Jeremy Stiff
 * Description: This class serves as the model and allows the controller access to all the
 * data and methods it will need to run the game.
 */

public class DataManagement {

	private Storage storage = new Storage();
	private TextLoader loader = new TextLoader();

	public DataManagement() {}

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
		storage.setItems(loader.loadItemFile());
	}
	

	// Author: Jeremy Stiff
	public Rooms getRoom(int id) {
		return storage.getRoom(id);
	}

	// Author: Jeremy Stiff
	public Rooms getPlayerRoom() {
		return storage.getRoom(storage.getPlayer().getPlayerLocation());
	}

	// Author: Jeremy Stiff
	public void movePlayerNorth() {
		if (getPlayerRoom().getNorth() != -1) {
			storage.getPlayer().setPlayerLocation(getPlayerRoom().getNorth());
			System.out.println(getPlayerRoom().toString());
		} else
			System.out.println("Ouch! You walk into a wall!");
	}

	// Author: Jeremy Stiff
	public void movePlayerSouth() {
		if (getPlayerRoom().getSouth() != -1) {
			storage.getPlayer().setPlayerLocation(getPlayerRoom().getSouth());
			System.out.println(getPlayerRoom().toString());
		} else
			System.out.println("Ouch! You walk into a wall!");
	}

	// Author: Jeremy Stiff
	public void movePlayerEast() {
		if (getPlayerRoom().getEast() != -1) {
			storage.getPlayer().setPlayerLocation(getPlayerRoom().getEast());
			System.out.println(getPlayerRoom().toString());
		} else
			System.out.println("Ouch! You walk into a wall!");
	}

	// Author: Jeremy Stiff
	public void movePlayerWest() {
		if (getPlayerRoom().getWest() != -1) {
			storage.getPlayer().setPlayerLocation(getPlayerRoom().getWest());
			System.out.println(getPlayerRoom().toString());
		} else
			System.out.println("Ouch! You walk into a wall!");
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
	
	//Author: Jeremy Stiff
	private String getActions() {
		String actions = "Your available actions are:";
		
		//TODO Code that gathers and returns actions similar to above method.
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

	@Override
	// Author: Jeremy Stiff
	public String toString() {
		return "Player room is " + storage.getPlayer().getPlayerLocation() + "\n" + storage.toString();
	}

}
