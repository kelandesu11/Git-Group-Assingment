import java.util.Scanner;
public class Controller {
	
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		DataManagement model = new DataManagement();
		
		System.out.println("Welcome to the game. Your options are:\n1) New game\n2) Load game\n3 Exit");
		String input = scan.nextLine().replaceAll("\n", "");
		
		//Author: Jeremy Stiff
		if (input.equals("1")) {
			model.newGame();
			for (System.out.println(model.getPlayerRoom().toString()), model.prompt(); scan.hasNextLine(); model.prompt()) {
				
				input = scan.nextLine().replaceAll("\n", "").toLowerCase();
				
				if (input.length() == 0)
					continue;
				else if (input.equals("n") || input.equals("north"))
					model.movePlayerNorth();
				else if (input.equals("s") || input.equals("south"))
					model.movePlayerSouth();
				else if (input.equals("e") || input.equals("east"))
					model.movePlayerEast();
				else if (input.equals("w") || input.equals("west"))
					model.movePlayerWest(); 
				else if (input.equals("x") || input.equals("exit")) {
					System.out.println("Would you like to save? y/n");
					input = scan.nextLine().replaceAll("\n", "").toLowerCase();
					if (input.equals("y")) {
						model.saveGame();
						System.exit(0);
					} else if (input.equals("n"))
						System.exit(0);
					else
						continue;
				}
				
			}
		} else if (input.equals("2")) {
			//TODO Loading
		} else if (input.equals("3"))
			System.exit(0);
		else
			System.out.println("Incorrect input.");
		
	}
		
}


