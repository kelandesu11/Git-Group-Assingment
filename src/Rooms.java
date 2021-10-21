public class Rooms {
	private int roomID = -1;
	private String roomName = "Empty";
	private String roomDesc = "This is an empty Rooms class";
	private int north = -1;
	private int east = -1;
	private int south = -1;
	private int west = -1;
	private boolean visitedRoom = false;
	
	public Rooms(int roomID, String roomName, String roomDesc, int north, int east, int south, int west) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomDesc = roomDesc;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}
	
	public Rooms() {
		
	}
	
	public int getRoomID() {
		return roomID;
	}
	
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public String getRoomDesc() {
		return roomDesc;
	}
	
	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}
	
	public int getNorth() {
		return north;
	}
	
	public void setNorth(int north) {
		this.north = north;
	}
	
	public int getSouth() {
		return south;
	}
	
	public void setSouth(int south) {
		this.south = south;
	}
	
	public int getEast() {
		return east;
	}
	
	public void setEast(int east) {
		this.east = east;
	}
	
	public int getWest() {
		return west;
	}
	
	public void setWest(int west) {
		this.west = west;
	}
	
	public boolean getVisitedRoom() {
		return visitedRoom;
	}
	
	public void setVisitedRoom(boolean visitedRoom) {
		this.visitedRoom = visitedRoom;
	}
}
