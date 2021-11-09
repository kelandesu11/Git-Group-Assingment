import java.io.Serial;
import java.io.Serializable;

public class Entity implements Serializable {

	/**
	 * Author: Jeremy Stiff
	 */
	@Serial
	private static final long serialVersionUID = 2990802055767788458L;
	private double health;
	private double damage;

	public Entity(int health, int damage) {
		this.health = health;
		this.damage = damage;
	}

	public Entity() {
	}

	//Jeremy Stiff
	public double getHealth() {
		return health;
	}

	//Jeremy Stiff
	public void setHealth(double health) {
		this.health = health;
	}

	//Jeremy Stiff
	public void updateHealth(int health) {
		this.health += health;
	}

	public void decreaseHealth(int health) {
		this.health -= health;
	}

	public double getDamage() {
		return damage;
	}

	//Jeremy Stiff
	public void setDamage(double damage) {
		this.damage = damage;
	}

	public void updateDamage(int damage) {
		this.damage += damage;
	}

	public void decreaseDamage(int damage) {
		this.damage -= damage;
	}

}
