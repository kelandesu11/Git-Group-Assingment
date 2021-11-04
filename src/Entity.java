import java.io.Serializable;

public class Entity implements Serializable{

	/**
	 * Author: Jeremy Stiff
	 */
	private static final long serialVersionUID = 2990802055767788458L;
	private int health, damage;
	
	public Entity (int health, int damage) {
		this.health = health;
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
}
