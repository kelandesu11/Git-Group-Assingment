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
	private TextLoader loader = new TextLoader();
	private HashMap<Integer, Rooms> map = new HashMap<Integer, Rooms>();
	
	//Author: Jeremy Stiff
	public void setMap(HashMap<Integer, Rooms> map) {
		this.map = map;
	}
	
	//Author: Jeremy Stiff
	public Rooms getRoom(Rooms room) {
		return map.get(room.getRoomID());
	}
	
	//Author: Jeremy Stiff
	public Rooms getRoom(int id) {
		return map.get(id);
	}
	
	//Author: Jeremy Stiff
	public void loadFile() {
		setMap(loader.loadFile());
	}
	
	public void saveFile() {
		loader.writeStorage(this);
	}
	
	@Override
	//Author: Jeremy Stiff
	public String toString() {
		return map.toString();
	}

}
