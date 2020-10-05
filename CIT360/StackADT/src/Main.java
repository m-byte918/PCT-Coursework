
public class Main {
	
	public static void main(String[] args) {
		ArrayStack<Integer> stacc = new ArrayStack<Integer>(5);
		System.out.println(stacc.capacity());
		stacc.push(1);
		stacc.push(1);
		stacc.push(1);
		stacc.push(1);
		System.out.println(stacc.size());
	}
}
