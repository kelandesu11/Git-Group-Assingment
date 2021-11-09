import java.io.Serializable;

public class Player extends Entity implements Serializable {
	/**
	 * Author: Kelan McNally
	 */
	private static final long serialVersionUID = -3815529920572909198L;
	Rooms room = new Rooms();
	private int roomID = 1;
	private int previousroomid = -1;
	private int health, damage;
	private Items equippedItem = null;

	public Player(int health, int damage) {
		super(health, damage);
	}

	public int getPlayerLocation() {
		return roomID;
	}

	public void setPlayerLocation(int room) {
		roomID = room;
	}

	//Jeremy Stiff
	public int getPreviousRoom() {
		return previousroomid;
	}

	//Jeremy Stiff
	public void setPreviousRoom(int previousroomid) {
		this.previousroomid = previousroomid;
	}

	// SK
	public Items getEquippedItem() {
		return equippedItem;
	}

	// SK
	public void setEquippedItem(Items equippedItem) {
		this.equippedItem = equippedItem;
	}
}
