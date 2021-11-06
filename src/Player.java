import java.io.Serializable;

public class Player extends Entity implements Serializable{
	/**
	 * Author: Kelan McNally
	 */
	private static final long serialVersionUID = -3815529920572909198L;
	private int roomID = 1;
	private int health, damage;
	
	public Player(int health, int damage) {
		super(health, damage);
	}
	
	public int getPlayerLocation() {
		return roomID;
	}
	
	public void setPlayerLocation(int room) {
		roomID = room;
	}
	
}
