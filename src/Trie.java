import java.util.HashMap;
import java.util.Map;

/**
 * Trie class for storing the word3.txt file
 *
 */
public class Trie {
	private Node root;

	public Trie(){
		root = new Node();
	}
	
	/**
	 * Insert a word in the trie
	 * @param word	string you insert into the tree
	 */
	public void insert(String word){
		HashMap<Character, Node> children = root.children;
		
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			
			Node node;
			if(children.containsKey(c)){
				node = children.get(c);
			}else{
				node = new Node(c);
				children.put(c, node);
			}
			children = node.children;
			
			if(i == word.length()-1){
				node.isInTrie = true;
			}
		}
	}
		
	/**
	 * Checks if the node is in the trie
	 * @param node		node that is searched
	 * @return 	boolean that is true of false
	 */
	public boolean search(Node node){
		boolean found = false;
		
		if(node != null && node.isInTrie){
			found = true;
		}else{
			found = false;
		}
		return found;
	}
	
	/**
	 * Search the word in the trie
	 * @param string	word that is searched
	 * @return	node that is found
	 */
	public Node searchNode(String string){
		Map<Character, Node> children = root.children;
		Node node = null;
		for(int i = 0; i < string.length(); i++){
			char c = string.charAt(i);
			if(children.containsKey(c)){
				node = children.get(c);
				children = node.children;
			}else{
				return null;
			}
		}
		return node;
	}
}
