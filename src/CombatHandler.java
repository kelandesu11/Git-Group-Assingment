/*
 * Author: Jeremy Stiff
 */
public class CombatHandler {

	private final Player player;
	private final Monster monster;

	public CombatHandler(Player player, Monster monster) {
		this.player = player;
		this.monster = monster;
	}

	// Jeremy Stiff
	public void attackAction() {
		if (monster.getId() == 3 && player.getEquippedItem().getId() == 2) {
			System.out.println("Your sword is extra effective! " + player.getDamage() * 2 + " damage!");
			playerAttack();
			playerAttack();
		} else if (monster.getId() == 6) {
			if (Math.random() > .05) {
				System.out.println("You attack the monster for " + player.getDamage() + " damage!");
				playerAttack();
			} else
				System.out.println("You tremble in fear and miss your attack!");
		} else {
			System.out.println("You attack the monster for " + player.getDamage() + " damage!");
			playerAttack();
		}

		if (monster.getHealth() > 0) {
			if (monster.getId() == 5) {
				System.out.println("The witch poisons you! You will take 1 damage every turn!");
				monsterAttack();
			} else if (monster.getId() == 7) {
				System.out.println("The monster completely exausts itself with a massive attack! " + monster.getDamage()
						+ " damage!");
				monsterAttack();
				monster.setDamage(0);
			} else {
				System.out.println("The monster strikes back for " + monster.getDamage() + " damage!");
				monsterAttack();
			}

		} else if (monster.getHealth() <= 0) {
			if (monster.getId() == 4) {
				System.out.println("The spite of this monster allows it to attack once more before death! "
						+ monster.getDamage() + " damage!");
				monsterAttack();
				System.out.println("Your blow defeats the monster!");
			} else if (monster.getId() == 8) {
				System.out.println("The monster splits apart and a new form emerges!");
				monster.setHealth(1);
			} else
				System.out.println("Your blow defeats the monster!");

		}
	}

	// Author: Jeremy Stiff
	public void playerAttack() {
		monster.setHealth(monster.getHealth() - player.getDamage());
	}

	// Author: Jeremy Stiff
	public void monsterAttack() {
		player.setHealth(player.getHealth() - monster.getDamage());
	}

	// Author: Jeremy Stiff
	// Alternate method to damage player for custom amount
	public void damagePlayer(int damage) {
		player.setHealth(player.getHealth() - damage);
	}

	// Author: Jeremy Stiff
	// Same as above for mosnter
	public void damageMonster(int damage) {
		monster.setHealth(monster.getHealth() - damage);
	}

	// Jeremy Stiff
	public double getPlayerHealth() {
		return player.getHealth();
	}

	// Jeremy Stiff
	public double getMonsterHealth() {
		return monster.getHealth();
	}

}
