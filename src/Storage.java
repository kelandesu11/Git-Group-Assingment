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
	private Player player = new Player();
	
	//Author: Jeremy Stiff
	public void setMap(HashMap<Integer, Rooms> map) {
		this.map = map;
	}
	
	//Author: Kelan McNally
	public void setItems(ArrayList<Items> items) {
		this.items = items;
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
	
	public Items getItem(Items item) {
		return items.get(item.getItemID());
	}
	
	public Items getItem(int id) {
		return items.get(id);
	}
	
	@Override
	//Author: Jeremy Stiff
	public String toString() {
		return map.toString();
	}

}
