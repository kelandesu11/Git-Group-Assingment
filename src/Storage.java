import java.util.HashMap;

/*
 * Author: Jeremy Stiff
 * Description: This class stores the HashMap and will retrieve data when needed.
 */

public class Storage {
	
	private TextLoader loader = new TextLoader();
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
	
	public void loadFile() {
		setMap(loader.loadFile());
	}
	
	@Override
	public String toString() {
		return map.toString();
	}

}
