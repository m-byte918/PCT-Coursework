
public class ArrayQueue<T> {

	private T[] queue;
	private int front;
	private int size;

	@SuppressWarnings("unchecked")
	ArrayQueue(int capacity) {
		queue = (T[])new Object[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return queue[front];
	}
	
	public T enqueue(T obj) {
		if (size == queue.length) {
			return null;
		}
		int available = (front + size) % queue.length;
		++size;

		return queue[available] = obj;
	}

	public T dequeue() {
		if (isEmpty()) {
			return null;
		}
		T temp = queue[front];
		
		queue[front] = null;
		front = ++front % queue.length;

		--size;
		return temp;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("front [\n");
		for (int i = 0; i < queue.length; ++i) {
			sb.append("  " + queue[i] + "\n");
		}
		return sb.append("] back").toString();
	}
}
