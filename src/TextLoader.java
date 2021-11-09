import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Author: Jeremy Stiff
 * Date: 9/18/21
 * The purpose of this class is to load room data from a text file into a hash map
 * and pass it onto the Storage class.
 */
public class TextLoader implements Serializable {

	/**
	 *
	 */
	@Serial
	private static final long serialVersionUID = 8578811013575599820L;
	private final Scanner scanin = new Scanner(System.in);
	private HashMap<Integer, Room> map;
	private Scanner scanfile;
	private File file;

	public TextLoader() {
	}

	// Author: Jeremy Stiff
	/*
	 * This method attempts to load a Room.txt file from the project folder if it is
	 * not found it prompts the user for a file path. The file path is used to
	 * create a file Object and Scanner for the file.
	 */
	public HashMap<Integer, Room> loadFile() {

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
	 * Author: Jeremy Stiff This method reads information on a correctly formatted
	 * file into the HashMap. The correct format is as follows: ID Name Description
	 * North connection East connection South connection West connection
	 */
	private HashMap<Integer, Room> readFile() {
		map = new HashMap<Integer, Room>();

		while (scanfile.hasNext()) {
			Room temp = new Room();
			temp.setRoomID(scanfile.nextInt());
			scanfile.nextLine();
			temp.setRoomName(scanfile.nextLine());
			temp.setRoomDesc(scanfile.nextLine().replaceAll("\n", ""));
			temp.setNorth(scanfile.nextInt());
			temp.setSouth(scanfile.nextInt());
			temp.setEast(scanfile.nextInt());
			temp.setWest(scanfile.nextInt());
			map.put(temp.getRoomID(), temp);
		}
		map.get(1).setVisitedRoom(true);


		loadItemFile();
		readItemFile();

		loadMonsterFile();
		readMonsterFile();

		return map;
	}

	/**
	 * Author: Kelan McNally
	 */
	public void loadItemFile() {

		try {
			file = new File("Items.txt");
			scanfile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Enter the Items.txt file path");
			try {
				file = new File(scanin.nextLine());
				scanfile = new Scanner(file);
			} catch (FileNotFoundException e1) {
				System.out.println("Incorrect path");
				loadItemFile();
			}
		}

	}

	/**
	 * Author: Kelan McNally
	 */
	public void readItemFile() {

		while (scanfile.hasNext()) {
			Item item = new Item();
			item.setId(scanfile.nextInt());
			scanfile.nextLine();
			item.setName(scanfile.nextLine());
			item.setDescription(scanfile.nextLine());
			item.setDamage(scanfile.nextInt());
			item.setRoomID(scanfile.nextInt());
			if (map.get(item.getRoomID()) != null) {
				map.get(item.getRoomID()).addItem(item);
			}

		}

	}

	public void readMonsterFile() {

		while (scanfile.hasNext()) {
			String line = scanfile.nextLine();
			if (!line.isEmpty()) {
				Monster monster = new Monster();
				monster.setId(Integer.parseInt(line));
				monster.setName(scanfile.nextLine());
				monster.setDescription(scanfile.nextLine());
				monster.setHealth(Double.parseDouble(scanfile.nextLine()));
				monster.setDamage(Double.parseDouble(scanfile.nextLine()));
				int roomID = Integer.parseInt(scanfile.nextLine());
				if (map.get(roomID) != null) {
					map.get(roomID).addMonster(monster);
				}
			}
		}

	}


	public void loadMonsterFile() {

		try {
			file = new File("Monster.txt");
			scanfile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Enter the Monsters.txt file path");
			try {
				file = new File(scanin.nextLine());
				scanfile = new Scanner(file);
				readMonsterFile();
			} catch (FileNotFoundException e1) {
				System.out.println("Incorrect path");
				loadMonsterFile();
			}
		}

	}


	// Author: Jeremy Stiff
	public void writeStorage(Storage storage) {
		try {
			FileOutputStream fileout = new FileOutputStream(new File("SaveGame.dat"));
			ObjectOutputStream objout = new ObjectOutputStream(fileout);
			objout.writeObject(storage);

		} catch (FileNotFoundException e) {
			System.out.println("File not found?");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Author: Jeremy Stiff
	public Storage loadSave() {
		try {
			FileInputStream in = new FileInputStream("SaveGame.dat");
			ObjectInputStream objin = new ObjectInputStream(in);
			Storage out = (Storage) objin.readObject();
			objin.close();
			System.out.println("Loaded game, current room: " + out.currentRoom().getRoomName());
			return out;
		} catch (FileNotFoundException e) {
			System.out.println("Save game does not exist in game folder.\nInput correct path.");
			try {
				FileInputStream in = new FileInputStream(scanin.nextLine().replaceAll("\n", ""));
				ObjectInputStream objin = new ObjectInputStream(in);
				Storage out = (Storage) objin.readObject();
				objin.close();

				return out;
			} catch (FileNotFoundException e1) {
				System.out.println("Incorrect path");
				loadSave();
			} catch (IOException e2) {
				System.out.print("IO exception ");
			} catch (ClassNotFoundException e3) {
				System.out.println("Class not found");
			}
		} catch (IOException e2) {
			System.out.print("IO exception ");
		} catch (ClassNotFoundException e3) {
			System.out.println("Class not found");
		}
		return new Storage();
	}

}
