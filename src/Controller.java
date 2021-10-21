import java.util.Scanner;
public class Controller {
	
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		DataManagement model = new DataManagement();
		
		model.newGame();
		
		System.out.println(model.toString());
		
		for(System.out.println(model.prompt()); scan.hasNext(); System.out.println(model.prompt())) {
			
			String input = scan.nextLine().replaceAll("\n", "").toLowerCase();
			int[] conn = model.getConnections();
			
			if (input.length() == 0)
				continue;
			else if(input.equals("n") || input.equals("north") && conn[0] != -1)
				model.movePlayerNorth();
			
		}
	}
		
}


