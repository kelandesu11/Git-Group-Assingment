/**
 * @dkilbert Jeremy Edit 11/3/21: Added Entity parent class
 */

public class Monsters implements Entity {
	private String name;
	private String description;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Monsters(String name, String description, int id, int health, int damage) {
		super(health, damage);
		this.name = name;
		this.description = description;
		this.id = id;
	}

}
