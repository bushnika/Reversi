package bushnik.alexa;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Player {
	
	Scanner kb = new Scanner(System.in);
	private String name; // name of the player
	private int colour; // colour of the chips
	private Board board; // board
	/**
	 * Creates a player
	 * @param name - name of the player
	 * @param colour - colour of the chip
	 * @param board - the board used
	 */
	public Player(String name, int colour, Board board) {
		this.name = name;
		this.colour = colour;
		this.board = board;
	}
	/**
	 * Places the piece for the chosen player at the chosen location. Replaces the piece in between 
	 * the old piece and the new piece to the players colour.
	 * @param row row of the piece
	 * @param col column of the piece
	 */
	public void placeChip(int row, int col) {
		this.board.placeChip(this.colour, row, col);
		Move move = new Move(row, col);
		this.board.replaceChip(move, this.colour);
		
	}
	/**
	 * Sets the players name to a variable
	 * @throws IOException Null values
	 */
	public void setNames() throws IOException {

		System.out.println("What is your name: ");
		String line = kb.nextLine();
		this.name = line;
	}
	/**
	 * Gets the name of the player
	 * @return name of player
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Gets the colour number of the player
	 * @return colour of player
	 */
	public int getcolour() {
		return this.colour;
	}

	/**
	 * Finds the valid moves and allows them to be selected
	 */
	public void findCanSelect() {

		ArrayList<Move> moves = board.validMoves(this.colour);

		for (Move move : moves)
			board.setCanSelect(move);
	}
}
