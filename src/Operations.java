import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class that does all the operations
 */
public class Operations {
	Trie file = new Trie();
	Scrabble scrabble = new Scrabble();
	
	private List<String> input = new ArrayList<String>();
	private Map<String, Integer> scrabbleWord = new HashMap<String,Integer>();
	
	/**
	 * Put the words3.txt file in a Trie
	 * @throws IOException
	 */
	public void putFileInTrie() throws IOException{
		System.out.println("Reading file");
		FileInputStream fstream = new FileInputStream("words3.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String string;
		
		while((string = br.readLine()) != null){
			file.insert(string);
		}
		System.out.println("File is in trie");
		br.close();
	}
	
	/**Call the permutation method
	 * @param str	string that needs to be permuted
	 */
	public void permutation(String str) { 
	    permutation("", str); 
	}
	
	/**
	 * Method that does the permutations
	 * @param prefix	prefix of the string
	 * @param str		the string without prefix
	 */
	public void permutation(String prefix, String str){
		int n = str.length();
			
		for(int i = 0; i < n; i++){
			Node node = file.searchNode(prefix + str.charAt(i));
			if(node != null){
				if(file.search(node)){
					input.add(prefix + str.charAt(i));
				}
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1,n));
			}
		}	
	}
	
	/**
	 * Determine the Scrabble score of all words and put it in an map
	 * Print the map
	 */
	public void calculateAnagram(){
		String word;
		int score;
		
		for(int i = 0; i < input.size(); i++){
			word = input.get(i);
			score = scrabble.scrabbleScore(word);
			scrabbleWord.put(word, score);
		}
		Map<String,Integer> map = sortByValues( (HashMap) scrabbleWord);
		Set set = map.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			Map.Entry sortedMap = (Map.Entry)iterator.next();
			System.out.println(sortedMap.getKey() + ": " + sortedMap.getValue());
		}
	}
	
	/**
	 * Sort the HashMap by the Scrabble score
	 * @param map	map that needs to be sorted by value
	 * @return the sorted map
	 */
	private static HashMap sortByValues(HashMap map){
		List list = new LinkedList(map.entrySet());
		
		/**
		 * Comparator for sorting the map by value
		 */
		Collections.sort(list,new Comparator(){
			public int compare (Object o1, Object o2){
				return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
			}
		});
		
		HashMap sortedHashMap = new LinkedHashMap();
		for(Iterator it = list.iterator(); it.hasNext();){
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}	
}
