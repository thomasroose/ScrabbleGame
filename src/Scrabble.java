import java.util.HashMap;

/**
 * Scrabble class for the game
 *
 */
public class Scrabble {
	static HashMap<Character,Integer> alphabet = new HashMap<>();
	
	/**
	 * All the letters with their Scrabble score
	 */
	static{
		alphabet.put('a', 1);
		alphabet.put('b', 3);
		alphabet.put('c', 3);
		alphabet.put('d', 2);
		alphabet.put('e', 1);
		alphabet.put('f', 4);
		alphabet.put('g', 2);
		alphabet.put('h', 4);
		alphabet.put('i', 1);
		alphabet.put('j', 8);
		alphabet.put('k', 5);
		alphabet.put('l', 1);
		alphabet.put('m', 3);
		alphabet.put('n', 1);
		alphabet.put('o', 1);
		alphabet.put('p', 3);
		alphabet.put('q', 10);
		alphabet.put('r', 1);
		alphabet.put('s', 1);
		alphabet.put('t', 1);
		alphabet.put('u', 1);
		alphabet.put('v', 4);
		alphabet.put('w', 4);
		alphabet.put('x', 8);
		alphabet.put('y', 4);
		alphabet.put('z', 10);
	}
	
	/**
	 * Calculate the Scrabble score of a word
	 * @param word		string that the Scrabble score is calculated of
	 * @return the Scrabble score
	 */
	public int scrabbleScore(String word){
		int sum = 0;
        for(int i = 0; i <word.length();i++) {
            sum += alphabet.get(word.charAt(i));
        }
        return sum;
	}
}
