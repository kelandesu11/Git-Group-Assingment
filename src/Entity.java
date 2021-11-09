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

	//Jeremy Stiff
	public int getHealth() {
		return health;
	}

	//Jeremy Stiff
	public void setHealth(int health) {
		this.health = health;
	}

	//Jeremy Stiff
	public void updateHealth(int health) {
		this.health += health;
	}

	public void decreaseHealth(int health) {
		this.health -= health;
	}

	public int getDamage() {
		return damage;
	}

	//Jeremy Stiff
	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void updateDamage(int damage) {
		this.damage += damage;
	}

	public void decreaseDamage(int damage) {
		this.damage -= damage;
	}

}
