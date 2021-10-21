public class Rooms {
	private String roomName, roomDesc, north, south, east, west;
	private int roomID;
	private boolean visitedRoom;
	
	public Rooms(int roomID, String roomName, String roomDesc, String north, String east, String south, String west, boolean visitedRoom) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomDesc = roomDesc;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.visitedRoom = false;
		
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
	
	public String getNorth() {
		return north;
	}
	
	public void setNorth(String north) {
		this.north = north;
	}
	
	public String getSouth() {
		return south;
	}
	
	public void setSouth(String south) {
		this.south = south;
	}
	
	public String getEast() {
		return east;
	}
	
	public void setEast(String east) {
		this.east = east;
	}
	
	public String getWest() {
		return west;
	}
	
	public void setWest(String west) {
		this.west = west;
	}
	
	public boolean getVisitedRoom() {
		return visitedRoom;
	}
	
	public void setVisitedRoom(boolean visitedRoom) {
		this.visitedRoom = visitedRoom;
	}
}
