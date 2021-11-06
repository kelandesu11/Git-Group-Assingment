
/*
 * Author: Jeremy Stiff
 */
public class CombatHandler {

	private Player player;
	private Monsters monster;
	
	public CombatHandler (Player player, Monsters monster) {
		this.player = player;
		this.monster = monster;
	}
	
	//Author: Jeremy Stiff
	public void playerAttack() {
		monster.setHealth(monster.getHealth() - player.getDamage());
	}
	
	//Author: Jeremy Stiff
	public void monsterAttack() {
		player.setHealth(player.getHealth() - monster.getDamage());
	}
	
	//Author: Jeremy Stiff
	//Alternate method to damage player for custom amount
	public void damagePlayer(int damage) {
		player.setHealth(player.getHealth() - damage);
	}
	
	//Author: Jeremy Stiff
	//Same as above for mosnter
	public void damageMonster(int damage) {
		monster.setHealth(monster.getHealth() - damage);
	}
	
	//Jeremy Stiff
	public int getPlayerHealth() {
		return player.getHealth();
	}
	
	//jeremy Stiff
	public int getMonsterHealth() {
		return monster.getHealth();
	}
}
