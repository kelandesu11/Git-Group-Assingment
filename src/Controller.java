import java.util.Scanner;

public class Controller {

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		ActionsHandler control = new ActionsHandler();

		control.welcomeMessage();
		control.gameLoop();
		
	}

}
