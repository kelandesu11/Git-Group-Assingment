public class Item extends Base {
    /**
     * Author: Kelan McNally
     */

    private int damage = -1;
    private int roomID = -1;

    public Item(int id, String name, String description, int damage, int roomID) {
        super(id, name, description);
        this.damage = damage;
        this.roomID = roomID;
    }

    public Item() {
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    @Override
    public String toString() {
        return getName();
    }
}
