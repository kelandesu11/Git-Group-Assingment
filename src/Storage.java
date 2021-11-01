import java.io.Serializable;
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
	private HashMap<Integer, Items> itemMap = new HashMap<Integer, Items>();
	private Player player = new Player();
	
	//Author: Jeremy Stiff
	public void setMap(HashMap<Integer, Rooms> map) {
		this.map = map;
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
	public Items hasItem(Items item) {
		return itemMap.get(item.getItemID());
	}
	
	//Author: Kelan McNally
	public Items hasItem(int id) {
		return itemMap.get(id);
	}
	
	@Override
	//Author: Jeremy Stiff
	public String toString() {
		return map.toString();
	}

}
