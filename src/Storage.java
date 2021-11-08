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
	private Player player = new Player(20, 2);
	
	//Author: Jeremy Stiff
	public void setMap(HashMap<Integer, Rooms> map) {
		this.map = map;
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
	
	//Jeremy Stiff
	public HashMap<Integer, Rooms> getMap() {
		return map;
	}
	
	@Override
	//Author: Jeremy Stiff
	public String toString() {
		return map.toString();
	}

}
