import java.io.Serial;
import java.io.Serializable;

public class Player extends Entity implements Serializable {
	/**
	 * Author: Kelan McNally
	 */
	@Serial
	private static final long serialVersionUID = -3815529920572909198L;
	Room room = new Room();
	private int roomID = 1;
	private int previousRoomID = -1;
	private Item equippedItem = null;

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
		return previousRoomID;
	}

	//Jeremy Stiff
	public void setPreviousRoom(int previousRoomID) {
		this.previousRoomID = previousRoomID;
	}

	// SK
	public Item getEquippedItem() {
		return equippedItem;
	}

	// SK
	public void setEquippedItem(Item equippedItem) {
		this.equippedItem = equippedItem;
	}
}
