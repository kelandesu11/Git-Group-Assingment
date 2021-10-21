import java.util.Scanner;
public class Controller {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		DataManagement model = new DataManagement();
		
		model.newGame();
		
		System.out.println(model.toString());
	}
		
}


