import java.util.Scanner;

/*
 * Author: Jeremy Stiff
 * Desc: I created this class because without it the controller loop in the main would get out of hand
 */

public class ActionsHandler {

	private Scanner scan = new Scanner(System.in);
	private DataManagement model = new DataManagement();
	String input;

	//Jeremy Stiff
	public void gameLoop() {
		for (System.out.println(model.getPlayerRoom().toString()), model.prompt(); scan.hasNextLine(); model.prompt()) {

			input = scan.nextLine().replaceAll("\n", "").toLowerCase();

			if (input.length() == 0)
				continue;
			Movement();
			}

		}
	
	//Jeremy Stiff
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

	//Jeremy Stiff
	public void newGame() {
		model.newGame();
	}

	//Jeremy Stiff
	public void loadGame() {
		model.loadSave();
	}

	//Jeremy Stiff
	public void Movement() {
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
