
public class Player {
	private static int roomID;
	
	public static int getPlayerLocation() {
		return roomID;
	}
	
	public static void setPlayerLocation(int room) {
		roomID = room;
	}
	
}
