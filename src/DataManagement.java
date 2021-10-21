/*
 * Author: Jeremy Stiff
 * Description: This class serves as the model and allows the controller access to all the
 * data and methods it will need to run the game.
 */

public class DataManagement {
	
	private Storage storage = new Storage();
	private Player player = new Player();
	
	public DataManagement() {
	}
	
	public void newGame() {
		storage.loadFile();
	}
	
	public Rooms getRoom(int id) {
		return storage.getRoom(id);
	}
	public Rooms getPlayerRoom() {
		return storage.getRoom(player.getPlayerLocation());
	}
	
	public void movePlayerNorth() {
		if (getPlayerRoom().getNorth() != -1)
			player.setPlayerLocation(getPlayerRoom().getNorth());
		else
			System.out.println("Ouch! You walk into a wall!");
	}
	
	public void movePlayerSouth() {
		if (getPlayerRoom().getSouth() != -1)
			player.setPlayerLocation(getPlayerRoom().getSouth());
		else
			System.out.println("Ouch! You walk into a wall!");
	}
	
	public void movePlayerEast() {
		if (getPlayerRoom().getEast() != -1)
			player.setPlayerLocation(getPlayerRoom().getEast());
		else
			System.out.println("Ouch! You walk into a wall!");
	}
	
	public void movePlayerWest() {
		if (getPlayerRoom().getWest() != -1)
			player.setPlayerLocation(getPlayerRoom().getWest());
		else
			System.out.println("Ouch! You walk into a wall!");
	}
	
	/*
	 * This method returns an integer array of connections -1 is no connection.
	 * The order of connections is North, East, South, West.
	 */
	public int[] getConnections() {
		int[] connections = {-1, -1, -1, -1};
		connections[0] = getPlayerRoom().getNorth();
		connections[1] = getPlayerRoom().getEast();
		connections[2] = getPlayerRoom().getSouth();
		connections[3] = getPlayerRoom().getWest();
		return connections;
	}
	
	/*
	 * Returns a list of avaliable connections.
	 */
	private String getConnectionsString() {
		int[] connections = getConnections();
		String links = "Your movement options are: ";
		
		if (connections[0] != -1)
			links += "North, ";
		if (connections[1] != -1)
			links += "South, ";
		if (connections[2] != -1)
			links += "East, ";
		if (connections[3] != -1)
			links += "and West.";
		
		return links;
	}
	
	public String prompt() {
		return getConnectionsString();
	}
	
	@Override
	public String toString() {
		return "Player room is " + player.getPlayerLocation() + "\n" + storage.toString();
	}
	
}
