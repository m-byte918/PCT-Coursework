
public class ArrayStack<T> {
	private T[] _stack = null;
	private int _ptr   = -1;

	@SuppressWarnings("unchecked")
	ArrayStack(int capacity) {
		_stack = (T[])new Object[capacity];
	}

	public int size() {
		return _ptr + 1;
	}
	
	public int capacity() {
		return _stack.length;
	}

	public boolean isEmpty() {
		return _ptr == -1;
	}

	public T peek() {
		return isEmpty() ? null : _stack[_ptr];
	}

	public T push(T obj) {
		int newPtr = size();
		if (newPtr >= capacity()) {
			throw new StackOverflowError("Stack is full");
		}
		return _stack[_ptr = newPtr] = obj;
	}

	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		T temp = peek();
		_stack[_ptr--] = null;
		return temp;
	}
}
