/* THE GRAND PLAN:
1. Initialize board as character array
2. Convert array to string and print board + instructions
3. Scan for input as a string
4. Based on string, edit board array to include player move
	and bot response
5. Print this edited board array
6. Loop thru steps 3-5 until printed edited board array ends the game
*/
import java.util.Scanner;
import java.util.*;

public class TicTacToe {
	public static void main(String[] args) {
		//Step 1:
		char[][] board = newArray();
		//Step 2:
		System.out.println(toString(board));
		System.out.println("Make your move (center, left, right, top, bottom, topright, etc.)");
		//Step 3:
		Scanner input = new Scanner(System.in);
		for (int z=0; z<5; z++) {
			String str = input.nextLine();
			//Step 4-5:
			board = playerMove(str, board);
			board = bestMove(board);
			System.out.println(toString(playerMove(str, board)));
			if (score(board) == -1) {
				System.out.println("How");
				break;
			}
			if (score(board) == 1) {
				System.out.println("Destroyed");
				break;
			}
		}
	}	

	public static char[][] newArray() {
		char[][] matrix = new char[3][3];
		for (int c=0; c<matrix.length; c++) {
			for (int d=0; d<3; d++) {
				matrix[c][d] = '_';
			}
		}
		return matrix;
	}

	public static char[][] playerMove(String str, char[][] board) {
		char[][] input = board;
		if (str.equals("topleft") && input[0][0] == '_') {
			input[0][0] = 'X';
		}
		if (str.equals("top") && input[0][1] == '_') {
			input[0][1] = 'X';
		}
		if (str.equals("topright") && input[0][2] == '_') {
			input[0][2] = 'X';
		}
		if (str.equals("left") && input[1][0] == '_') {
			input[1][0] = 'X';
		}
		if (str.equals("center") && input[1][1] == '_') {
			input[1][1] = 'X';
		}
		if (str.equals("right") && input[1][2] == '_') {
			input[1][2] = 'X';
		}
		if (str.equals("bottomleft") && input[2][1] == '_') {
			input[2][0] = 'X';
		}
		if (str.equals("bottom") && input[2][1] == '_') {
			input[2][1] = 'X';
		}
		if (str.equals("bottomright") && input[2][2] == '_') {
			input[2][2] = 'X';
		}
		return input;
	}

	public static char[][] bestMove(char[][] board) {
		double bestScore = Double.NEGATIVE_INFINITY;
		int a=0;
		int b=0;
		int[] move = new int[2];
		for (a=0; a<3; a++) {
			for (b=0; b<3; b++) {
				if (board[a][b] == '_') {
					board[a][b] = 'O';
					int score = minimax(board);
					board[a][b] = '_';
					if (score>bestScore) {
						bestScore = score;
						move[0] = a;
						move[1] = b;
					}
				}
			}
		}
		board[move[0]][move[1]] = 'O';
		return board;
	}

	}
	public static int minimax(char[][] board, int depth, boolean maximizingPlayer) {
		if (depth == 0 || gameover == true)
			return 0;
		if (maximizingPlayer) {
			double maxEval = Double.NEGATIVE_INFINITY;

	}

	public static String toString(char[][] arr) {
		String str = "";
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[0].length; j++) {
				str += arr[i][j] + " ";
			}
		str += "\n";
		}
		return str;
	}

	public static int score(char[][] matrix) {
		for (int x=0; x<3; x++) {
			if (matrix[0][x] != '_' && 
				matrix[0][x] == matrix[1][x] &&
				matrix[1][x] == matrix[2][x]) {
				if (matrix[0][x] == 'X') return -1;
				else return 1;
				}
		}
		for (int y=0; y<3; y++) {
			if (matrix[y][0] != '_' &&
				matrix[y][0] == matrix[y][1] &&
				matrix[y][1] == matrix[y][2]) {
				if (matrix[y][0] == 'X') return -1;
				else return 1;
				}
		}
		if (matrix[0][0] != '_' &&
			matrix[0][0] == matrix[1][1] &&
			matrix[1][1] == matrix[2][2]) {
			if (matrix[y][0] == 'X') return -1;
			else return 1;
		}
		if (matrix[2][0] != '_' &&
			matrix[2][0] == matrix[1][1] &&
			matrix[1][1] == matrix[0][2]) {
			if (matrix[y][0] == 'X') return -1;
			else return 1;
		}
		return 0;
	}

	/*public static char[][] toArray(String str) {
		int k = 0;
		char[][] matrix1 = new char[3][3];
		for (int c1=0; c1<matrix1.length; c1++) {
			for (int d1=0; d1<3; d1++) {
				if (k<str.length()) {
					matrix[c1][d1] = str.charAt(k);
					k++;
				}
			}
		}
		return matrix1;
	}
	*/
}
		
