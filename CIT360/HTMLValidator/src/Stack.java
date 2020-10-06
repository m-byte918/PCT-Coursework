
public interface Stack<T> {
	int size();

	boolean isEmpty();

	T push(T obj);
	
	T pop();
	
	T peek();
}
