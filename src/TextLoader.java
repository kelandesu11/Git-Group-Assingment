import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Author: Jeremy Stiff
 * Date: 9/18/21
 * The purpose of this class is to load room data from a text file into a hash map
 * and pass it onto the Storage class.
 */
public class TextLoader {
	

	private Scanner scanin = new Scanner(System.in);
	private Scanner scanfile;
	private File file;
	

	public TextLoader() {
	}

	/*This method attempts to load a Room.txt file from the project folder
	 *if it is not found it prompts the user for a file path.
	 *The file path is used to create a file Object and Scanner for the file.
	 */
	public HashMap<Integer, Rooms> loadFile() {
		
		try {
			file = new File("Room.txt");
			scanfile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Enter the Room.txt file path");
			try {
				file = new File(scanin.nextLine());
				scanfile = new Scanner(file);
			} catch (FileNotFoundException e1) {
				System.out.println("Incorrect path");
				loadFile();
			}
		}
		return readFile();
	}
	
	/*
	 * This method reads information on a correctly formatted file into the HashMap.
	 * The correct format is as follows:
	 * ID
	 * Name
	 * Description
	 * North connection
	 * South connection
	 * East connection
	 * West connection
	 */
	public HashMap<Integer, Rooms> readFile() {
		HashMap<Integer, Rooms> map = new HashMap<Integer, Rooms>();
		
			while (scanfile.hasNext()) {
				Rooms temp = new Rooms();
				System.out.println(scanfile.nextLine());
				
		}
			System.out.println(map.toString());
			map.get(1).setVisitedRoom(true);
			return map;
	}

}
