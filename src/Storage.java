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
<<<<<<< HEAD
	private ArrayList<Items> items = new ArrayList<Items>(); //Author: Kelan McNally
	private Player player = new Player();
=======
	private Player player = new Player(20, 2);
>>>>>>> master
	
	//Author: Jeremy Stiff
	public void setMap(HashMap<Integer, Rooms> map) {
		this.map = map;
	}
	
<<<<<<< HEAD
	//Author: Kelan McNally
	public void setItems(ArrayList<Items> items) {
		this.items = items;
=======
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	//Author: Jeremy Stiff
	public Rooms currentRoom() {
		return getRoom(player.getPlayerLocation());
>>>>>>> master
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
	
<<<<<<< HEAD
	public Items getItem(Items item) {
		return items.get(item.getItemID());
	}
	
	public Items getItem(int id) {
		return items.get(id);
=======
	public HashMap<Integer, Rooms> getMap() {
		return map;
>>>>>>> master
	}
	
	@Override
	//Author: Jeremy Stiff
	public String toString() {
		return map.toString();
	}

}
