import java.util.Scanner;
public class Controller {
	
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		DataManagement model = new DataManagement();
		
		model.newGame();
		
		System.out.println(model.toString());
		
		for(int i = 0; i < 100; i ++) {
			System.out.println(model.prompt());
			scan.hasNext();
			if(scan.equals("North")) {
				model.movePlayerNorth();
			}
			else if(scan.equals("East")) {
				model.movePlayerEast();
			}
			else if(scan.equals("South")) {
				model.movePlayerSouth();
			}
			else if(scan.equals("West")) {
				model.movePlayerWest();
			}
			
		}
	}
		
}


