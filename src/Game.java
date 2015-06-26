
public class Game {
	public static void main(String[] args) {
		Puzzle p = new Puzzle(10);
		
		p.fillWordHoriz("banana".toUpperCase(), 4, 0);
		
		p.fillWordVert("apples".toUpperCase(), 4, 1);
		
		System.out.println(p.toString());
		
	}
	
	//TODO: handle invalid user input upon accepting (OOB positions)
	// then convert to uppercase
}
