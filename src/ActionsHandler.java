import puzzles.Puzzle;

import java.util.Scanner;

/*
 * Author: Jeremy Stiff, Sanju Khanal
 * Desc: I created this class because without it the controller loop in the main would get out of hand
 */

public class ActionsHandler {

	private final Scanner scan = new Scanner(System.in);
	private final DataManagement model = new DataManagement();
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

		switch (input) {
			case "1" -> newGame();
			case "2" -> loadGame();
			case "3" -> System.exit(0);
			default -> welcomeMessage();
		}
	}

	//Jeremy Stiff
	public void newGame() {
		model.newGame();
	}

	//Jeremy Stiff
	public void loadGame() {
		model.loadSave();
	}
	
	//Author: Kelan McNally
	public void itemActions() {
		if (input.equals("i") || input.equals("items"))
			model.getPlayerRoom().displayItems();
		else if (input.equals("p") || input.equals("pickup"))
			model.pickupItem();
		else if (input.equals("d") || input.equals("drop"))
			model.dropItem();
		else if (input.equals("e") || input.equals("equip"))
			model.equipItem();
		else if (input.equals("u") || input.equals("unequip"))
			model.unequipItem();
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
	//Jeremy Stiff
	public void Movement() {
		switch (input) {
			case "n", "north" -> model.movePlayerNorth();
			case "s", "south" -> model.movePlayerSouth();
			case "e", "east" -> model.movePlayerEast();
			case "w", "west" -> model.movePlayerWest();
			case "p", "puzzle", "pe", "puzzle explore", "pi", "puzzle ignore" -> puzzleHandler(input); // SK
			case "x", "exit" -> Exit();
		}

	}

	// SK
	public void puzzleHandler(String input) {
		switch (input) {
			case "p", "puzzle", "ep", "explore puzzle" -> startPuzzle();
			case "ip", "ignore puzzle" -> ignorePuzzle();
		}
	}

	// SK
	public void startPuzzle() {
		if (model.getPlayerRoom().getPuzzle() != null) {
			Puzzle currentPuzzle = model.getPlayerRoom().getPuzzle();
			if (!currentPuzzle.isSolved()) {
				if (currentPuzzle.getAttemptLeft() > 0) {
					model.inspectPuzzle();
					currentPuzzle.start();
					System.out.println("Attempts: " + currentPuzzle.getAttemptLeft());
					while (currentPuzzle.getAttemptLeft() > 0) {
						String answer = scan.nextLine();
						boolean correct = currentPuzzle.isCorrect(answer);
						if (correct) {
							System.out.println("You won!!");
							// Increase the player health on solving the puzzle.
							model.getPlayer().updateHealth(currentPuzzle.getHealthPoints());
							model.getPlayerRoom().setPuzzle(null);
							break;
						}
						currentPuzzle.decrementAttempt();
					}
				}
			} else {
				// if puzzle is already solved - nullify it
				model.getPlayerRoom().setPuzzle(null);
			}
		}
	}

	// SK
	public void ignorePuzzle() {
		// Ignore the puzzle by nullifying it
		if (model.getPlayerRoom().getPuzzle() != null) {
			model.getPlayerRoom().setPuzzle(null);
		}
	}


	//Jeremy Stiff


	public void Exit() {
		System.out.println("Would you like to save? y/n");
		input = scan.nextLine().replaceAll("\n", "").toLowerCase();
		if (input.equals("y")) {
			model.saveGame();
			scan.close();
			System.exit(0);
		} else if (input.equals("n")) {
			scan.close();
			System.exit(0);
		} else
			gameLoop();
	}
}
