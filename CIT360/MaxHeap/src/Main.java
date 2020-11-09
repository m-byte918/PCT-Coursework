import java.util.concurrent.ThreadLocalRandom;

public class Main {
	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(128);
		
		heap.insert(5);
		
		for (int i = 0; i < 15; ++i) {
			heap.insert(ThreadLocalRandom.current().nextInt(1, 128));
		}
		
		System.out.println(heap.toString() + "\n\n");
		
		System.out.println(heap.removeMax() + "\n\n");
		
		System.out.println(heap.toString());
	}
}
