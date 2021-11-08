import puzzles.PuzzleLoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Author: Jeremy Stiff
 * Description: This class stores the HashMap and will retrieve data when needed.
 */

public class Storage implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 5761208788754196741L;
	private HashMap<Integer, Rooms> map = new HashMap<Integer, Rooms>();

	private ArrayList<Items> items = new ArrayList<Items>(); //Author: Kelan McNally
	private Player player = new Player(20, 2);


	//Author: Jeremy Stiff
	public void setMap(HashMap<Integer, Rooms> map) {
		this.map = map;
	}

	


	//Author: Kelan McNally
	public void setItems(ArrayList<Items> items) {
		this.items = items;
	}



	//Jeremy Stiff

	public void setPlayer(Player player) {
		this.player = player;
	}

	//Author: Jeremy Stiff
	public Rooms currentRoom() {
		return getRoom(player.getPlayerLocation());

	}

	//Author: Jeremy Stiff
	public Rooms getRoom(Rooms room) {
		return map.get(room.getRoomID());
	}

	// Author: Jeremy Stiff
	public Player getPlayer() {
		return player;
	}

	//Author: Jeremy Stiff
	public Rooms getRoom(int id) {
		return map.get(id);
	}

	

	//Author: Kelan McNally
	public Items getItem(Items item) {
		return items.get(item.getItemID());
	}
	
	//Author: Kelan McNally
	public Items getItem(int id) {
		return items.get(id);
	}
	
	//Author: Kelan McNally
	public ArrayList<Items> getItems(){
		return items;
	}


	//Jeremy Stiff

	public HashMap<Integer, Rooms> getMap() {
		return map;

	}

	public void assignPuzzle() {
		PuzzleLoader puzzleLoader = new PuzzleLoader();
		puzzleLoader.loadFile().forEach((key, value) -> {
			Rooms room = this.getRoom(key);
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
