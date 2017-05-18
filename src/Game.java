import java.io.IOException;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) throws IOException {
		/**
		 *	Object of the Operations class
		 */
		Operations ops = new Operations();
		
		/**
		 * Method that puts the word3.txt file into a trie
		 */
		ops.putFileInTrie();
		
		/**
		 * Reading an input 
		 */
		System.out.print("\nEnter your text: ");
		Scanner in = new Scanner (System.in);
		String input = in.nextLine();
		
		/**
		 * Method that does the permutations of the string
		 */
		ops.permutation(input);
		
		/**
		 * Method that calculates the Scrabble score of a word and prints it
		 */
		ops.calculateAnagram();
	}
}
