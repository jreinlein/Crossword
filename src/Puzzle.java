public class Puzzle {
	private char[][] grid;
	private int size = 10;
	private String errorMessage = "That word is too long!";
	
	public Puzzle() {
		grid = new char[size][size];
		fill(grid);
	}
	
	public Puzzle(int size) {
		this.size = size;
		grid = new char[size][size];
		fill(grid);
	}
	
	/**
	 * Helps constructors for filling up grid with desired characters (empty spaces)
	 * @param grid
	 */
	private void fill(char[][] grid) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i][j] = ' ';
			}
		}
	}
	
	/**
	 * Returns String representation of the crossword puzzle
	 */
	public String toString() {
		String res = "";
		
		for (int i = 0; i < size; i++) {
			// horizontal rows
			for (int horiz = 0; horiz < size; horiz++) {
				res += "--";
				if (horiz == size - 1)
					res += "-";
			}
			res += "\n";
			// vertical separators
			for (int vert = 0; vert < size; vert++) {
				res += "|" + grid[i][vert];
			}
			res += "|" + "\n";
			
		}
		
		// bottom row
		for (int horiz = 0; horiz < size; horiz++) {
			res += "--";
			if (horiz == size - 1)
				res += "-";
		}
		
		return res;
	}
	
	public void fillWordHoriz(String word, int row, int col) {
		if (row < 0 || row > size - 1 || col < 0 || col > size - 1)
			System.out.println("Invalid position in the puzzle!");
		// TODO check for X's and make much more strict
		if (word.length() + col > size) {
			System.out.println(errorMessage);
		}
		else {
			char[] letters = word.toUpperCase().toCharArray();
			for (int i = 0; i < letters.length; i++) {
				grid[row][col + i] = letters[i];
			}
		}
	}
	
	public void fillWordVert(String word, int row, int col) {
		if (row < 0 || row > size - 1 || col < 0 || col > size - 1)
			System.out.println("Invalid position in the puzzle!");
		if (word.length() + row > size) {
			System.out.println(errorMessage);
		}
		else {
			char[] letters = word.toUpperCase().toCharArray();
			for (int i = 0; i < letters.length; i++) {
				grid[row + i][col] = letters[i];
			}
		}
	}
	
	private boolean validateMove(String word, Puzzle p, boolean isHorizontal) {
		return true;
	}
}
