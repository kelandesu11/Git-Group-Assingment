import java.util.Scanner;

/*
 * Author: Jeremy Stiff
 * Desc: I created this class because without it the controller loop in the main would get out of hand
 */

public class ActionsHandler {

	private Scanner scan = new Scanner(System.in);
	private DataManagement model = new DataManagement();
	private CombatHandler combat;
	String input;

	// Jeremy Stiff
	public void gameLoop() {
		for (System.out.println(model.getPlayerRoom().toString()), model.prompt(); scan.hasNextLine(); model.prompt()) {

			input = scan.nextLine().replaceAll("\n", "").toLowerCase();

			if (input.length() == 0)
				continue;
			Movement();
			if (model.getPlayerRoom().hasMonster() && (input.equals("m") || input.equals("monster")))
				monsterOptions();
			// Things a player can do in a room go here.
		}

	}

	// Jeremy Stiff
	// Starts the game
	public void welcomeMessage() {
		System.out.println("Welcome to the game. Your options are:\n1) New game\n2) Load game\n3) Exit");
		String input = scan.nextLine().replaceAll("\n", "");

		if (input.equals("1"))
			newGame();
		else if (input.equals("2"))
			loadGame();
		else if (input.equals("3"))
			System.exit(0);
		else
			welcomeMessage();
	}

	// Jeremy Stiff
	public void newGame() {
		model.newGame();
	}

	// Jeremy Stiff
	public void loadGame() {
		model.loadSave();
	}

	// Jeremy Stiff
	// This will be dedicated method for movement and will include all checks to see
	// if the movement is legal
	private void Movement() {
		if (input.equals("n") || input.equals("north"))
			model.movePlayerNorth();
		else if (input.equals("s") || input.equals("south"))
			model.movePlayerSouth();
		else if (input.equals("e") || input.equals("east"))
			model.movePlayerEast();
		else if (input.equals("w") || input.equals("west"))
			model.movePlayerWest();
		else if (input.equals("x") || input.equals("exit"))
			Exit();
	}

	// Jeremy Stiff
	private void monsterOptions() {
		System.out.println("1) Attack\n2) Examine\n3) Ignore");
		input = scan.nextLine().replaceAll("\n", "");
		
		if (input.equals("1"))
			combatStart();
		else if (input.equals("2")) {
			System.out.println(model.getPlayerRoom().getMonster().getDescription());
			monsterOptions();
		} else if (input.equals("3"))
			System.out.println("You ignore the monster, but cannot move on");
		else
			monsterOptions();
	}

	// Jeremy Stiff
	// This method will be used if the player decides to start combat with a monster
	private void combatStart() {
		combat = new CombatHandler(model.getPlayer(), model.getPlayerRoom().getMonster());
		combatLoop();
	}

	// Jeremy Stiff
	// This method will be the loop that continues until the fight is over
	private void combatLoop() {
		for (combatPrompt(); isFightGoing(); combatPrompt()) {
			
			if (input.equals("1"))
				combat.attackAction();
			else if (input.equals("2")) {
				// combat.playerInventory();
				// TODO: Implement player inventory and related features.
			} if (combat.getPlayerHealth() <= 0) {
				// TODO Player defeat
			} if (combat.getMonsterHealth() <= 0) {
				model.getPlayerRoom().addMonster(null);
			} else
				continue;
		}
	}

	private boolean isFightGoing() {
		if (combat.getPlayerHealth() > 0 && (model.getPlayerRoom().getMonster() != null || combat.getMonsterHealth() > 0))
			return true;
		return false;
	}

	private void combatPrompt() {
		if (isFightGoing()) {
			System.out.println("Player HP: " + combat.getPlayerHealth());
			System.out.println("Monster HP: " + combat.getMonsterHealth());
			System.out.println("--------------------");
			System.out.println("1) Attack\n2) Inventory");
			input = scan.nextLine().replaceAll("\n", "");
		}
	}

	public void Exit() {
		System.out.println("Would you like to save? y/n");
		input = scan.nextLine().replaceAll("\n", "").toLowerCase();
		if (input.equals("y")) {
			model.saveGame();
			System.exit(0);
		} else if (input.equals("n"))
			System.exit(0);
		else
			gameLoop();
	}
}
