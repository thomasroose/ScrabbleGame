import java.util.HashMap;

/**
 * Node class used in the Trie
 */
public class Node{
		char c;
		HashMap<Character, Node> children = new HashMap<Character, Node>();
		boolean isInTrie;
		
		public Node(){}
		
		public Node(char c){
			this.c = c;
		}
	}