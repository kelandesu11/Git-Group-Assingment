import java.util.HashMap;

public class Storage {
	
	private HashMap<Integer, Rooms> map = new HashMap<Integer, Rooms>();
	
	public void setMap(HashMap<Integer, Rooms> map) {
		this.map = map;
	}
	
	public Rooms getRoom(Rooms room) {
		return map.get(room.getRoomID());
	}
	
	public Rooms getRoom(int id) {
		return map.get(id);
	}

}
