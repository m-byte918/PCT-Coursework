public class Main {

	public static void main(String[] args) throws LinkedListException {
		LinkedList<String> list = new LinkedList<String>();
		
		list.addLast("Phil");
		list.addLast("How");
		list.addLast("Was");
		list.addLast("Your");
		list.addLast("Day");
		list.addLast("Today");
		list.addFirst("Hi");
		
		System.out.println(list.size());
		System.out.println(list.peekFirst());
		System.out.println(list.peekLast());
		System.out.println(list.toString());
		
		list.removeFirst();
		list.removeLast();
		list.removeMiddle();
		
		System.out.println(list.contains("Phil"));
		System.out.println(list.indexOf("Phil"));
		System.out.println(list.toString());
	}
}
