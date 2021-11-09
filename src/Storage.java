import puzzles.PuzzleLoader;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Author: Jeremy Stiff
 * Description: This class stores the HashMap and will retrieve data when needed.
 */

public class Storage implements Serializable {

	/**
	 *
	 */
	@Serial
	private static final long serialVersionUID = 5761208788754196741L;
	private HashMap<Integer, Room> map = new HashMap<Integer, Room>();

	private ArrayList<Item> items = new ArrayList<Item>(); //Author: Kelan McNally
	private Player player = new Player(20, 2);

	//Author: Jeremy Stiff
	public Room currentRoom() {
		return getRoom(player.getPlayerLocation());

	}

	//Author: Jeremy Stiff
	public Room getRoom(Room room) {
		return map.get(room.getRoomID());
	}


	//Jeremy Stiff

	// Author: Jeremy Stiff
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	//Author: Jeremy Stiff
	public Room getRoom(int id) {
		return map.get(id);
	}

	//Author: Kelan McNally
	public Item getItem(Item item) {
		return items.get(item.getId());
	}

	//Author: Kelan McNally
	public Item getItem(int id) {
		return items.get(id);
	}

	//Author: Kelan McNally
	public ArrayList<Item> getItems() {
		return items;
	}

	//Author: Kelan McNally
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public HashMap<Integer, Room> getMap() {
		return map;

	}


	//Jeremy Stiff

	//Author: Jeremy Stiff
	public void setMap(HashMap<Integer, Room> map) {
		this.map = map;
	}

	public void assignPuzzle() {
		PuzzleLoader puzzleLoader = new PuzzleLoader();
		puzzleLoader.loadFile().forEach((key, value) -> {
			Room room = this.getRoom(key);
			if (room != null) {
				room.setPuzzle(value);
			}
		});
	}

	@Override
	//Author: Jeremy Stiff
	public String toString() {
		return map.toString();
	}

}
