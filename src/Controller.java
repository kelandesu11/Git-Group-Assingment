import java.util.Scanner;
public class Controller {
	
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		DataManagement model = new DataManagement();
		
		model.newGame();
		
		for (System.out.println(model.getPlayerRoom().toString()), model.prompt(); scan.hasNextLine(); model.prompt()) {
			
			String input = scan.nextLine().replaceAll("\n", "").toLowerCase();
			
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
			else if (input.equals("x") || input.equals("exit"))
				System.exit(0);
			
		}
	}
		
}


