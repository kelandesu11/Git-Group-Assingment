/**
 * 
 * @author dkilbert
 *
 */
public class Puzzles {
	private int id;
	private String name;
	private String description;
	private int solution;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSolution() {
		return solution;
	}
	public void setSolution(int solution) {
		this.solution = solution;
	}
	@Override
	public String toString() {
		return "Puzzles [id=" + id + ", name=" + name + ", description=" + description + ", solution=" + solution + "]";
	}
	
	
}
