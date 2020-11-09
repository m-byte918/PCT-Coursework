
public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		
		bst.put(0, "zero");
		bst.put(1, "one");
		bst.put(2, "two");
		bst.put(3, "three");
		bst.put(4, "four");
		bst.put(5, "five");
		bst.put(6, "six");
		bst.put(7, "seven");
		bst.put(8, "eight");
		bst.put(9, "nine");
		
		System.out.println(bst.contains(1));
		System.out.println(bst.contains(69));
		
		System.out.println(bst);
		
		bst.remove(0);
		
		System.out.println(bst);
		
		System.out.println(hash("lol"));
	}
	
	private static int hash(String str) {
		int hash = 0;
		
		for (int i = 0; i < str.length(); ++i) {
			hash = ((hash << 5) - hash) + str.charAt(i);
			hash &= hash;
		}
		return hash;
	}

}
