public class DataManagement {
	
	private TextLoader loader = new TextLoader();
	private Storage storage = new Storage();
	
	public void newGame() {
		storage.setMap(loader.loadFile());
	}

}
