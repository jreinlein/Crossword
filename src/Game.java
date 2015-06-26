
public class Game {
	public static void main(String[] args) {
		Puzzle p = new Puzzle(10);
		
		p.fillWordHoriz("banana", 9, 4);
		
		p.fillWordVert("apples", 4, 1);
		
		System.out.println(p.toString());
		
	}
}
