import java.io.Serializable;

public class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3815529920572909198L;
	private int roomID = 1;
	
	public int getPlayerLocation() {
		return roomID;
	}
	
	public void setPlayerLocation(int room) {
		roomID = room;
	}
	
}
