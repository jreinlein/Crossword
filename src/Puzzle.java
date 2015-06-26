public class Puzzle {
	private char[][] grid;
	private int size = 10;
	private char invalidSpace = 'X';
	private char emptySpace = ' ';
	
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
	 * Helps constructors for filling up grid with desired characters (emptySpace spaces)
	 * @param grid
	 */
	private void fill(char[][] grid) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i][j] = emptySpace;
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
		if (!isValidMoveHoriz(word, row, col))
			System.out.println("Invalid move! Try again.");
		else {
			char[] letters = word.toCharArray();
			for (int i = 0; i < letters.length; i++) {
				grid[row][col + i] = letters[i];
			}
		}
	}

	public void fillWordVert(String word, int row, int col) {
		if (!isValidMoveVert(word, row, col))
			System.out.println("Invalid move! Try again.");
		else {
			char[] letters = word.toCharArray();
			for (int i = 0; i < letters.length; i++) {
				grid[row + i][col] = letters[i];
			}
		}
	}

	/**
	 * Returns boolean to let you know if move is valid or not. Only works for HORIZONTAL words/moves.
	 */
	private boolean isValidMoveHoriz(String word, int row, int col) {
		// check if word overruns puzzle
		if (word.length() + col > size)
			return false;
		
		char[] letters = word.toCharArray();
		
		for (int i = 0; i < word.length(); i++) {
			char pos = grid[row][col + i];
			// check if word reaches into invalid spaces (X'd out)
			if (pos == invalidSpace)
				return false;
			// check if space is empty or a the same letter
			else if (pos != emptySpace && pos != letters[i])
				return false;
		}
		return true;
	}
	
	/**
	 * Returns boolean to let you know if move is valid or not. Only works for VERTICAL words/moves.
	 */
	private boolean isValidMoveVert(String word, int row, int col) {
		// check if word overruns puzzle
		if (word.length() + row > size)
			return false;
		
		char[] letters = word.toCharArray();
		
		for (int i = 0; i < word.length(); i++) {
			char pos = grid[row + i][col];
			// check if word reaches into invalid spaces (X'd out)
			if (pos == invalidSpace)
				return false;
			// check if space is empty or a the same letter
			else if (pos != emptySpace && pos != letters[i])
				return false;
		}
		return true;
	}
	
}
