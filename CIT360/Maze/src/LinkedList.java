// Linked list implementation

public class LinkedList<T> {

	// LinkedLists wrap data in nodes
	private class Node<E> {
		public E	   data = null; // Data of type T/E
		public Node<E> next = null; // Points to next node in list

		Node(E obj) {
			data = obj;
		}
	}

	private Node<T> _head = null; // Points to first node
	private Node<T> _tail = null; // Points to last node
	private long    _size = 0l;   // Total nodes in list

	public T peekFirst() throws Exception {
		if (_size == 0l) {
			// Don't want to return null in case user purposely stores null in list
			throw new Exception("List is empty.");
		}
		return _head.data;
	}
	
	public T peekLast() throws Exception {
		if (_size == 0l) {
			// Don't want to return null in case user purposely stores null in list
			throw new Exception("List is empty.");
		}
		return _tail.data;
	}
	
	public long size() {
		return _size;
	}

	public void addFirst(T obj) {
		Node<T> node = new Node<T>(obj);

		if (_size == 0l) {
			// Head & tail will point to the same node
			_tail = node;
		}
		node.next = _head; // Doesn't matter if null
		_head = node;
		++_size;
	}

	public void addLast(T obj) {
		if (_size == 0l) {
			// List is empty
			addFirst(obj);
			return;
		}
		_tail.next = new Node<T>(obj); // Null --> new Node
		_tail = _tail.next; 		   // Move tail to new node
		_tail.next = null;			   // New node points to nothing
		++_size;
	}

	public T removeFirst() throws Exception {
		if (_size == 0l) {
			throw new Exception("List underflow");
		}
		T data = _head.data; // Temporary

		if (_head == _tail) {
			_head = _tail = null; // Only one node in list
		} else {
			_head = _head.next; // Move head forward
		}
		--_size;
		return data;
	}
 
	public T removeMiddle() throws Exception {
		if (_size <= 2l) {
			return removeLast(); // Achieves the same thing
		}
		// Get item at the center of the list
		Node<T> before = _head;  	 // Node directly before center item
		Node<T> center = _head.next; // Start from head.next since we know size > 2
		for (long i = 1l, mI = _size / 2l; i != mI; ++i) {
			if (i == mI - 1l) {
				before = center;
			}
			center = center.next;
		}
		// Removing the middle node creates a hole in the list, sew that hole
		// by having the node before the middle node point to the one after it
		before.next = center.next;

		--_size;
		return center.data;
	}

	public T removeLast() throws Exception {
		if (_size <= 1l) {
			return removeFirst(); // Achieves the same thing
		}
		Node<T> lastTail = _tail;

		// Move tail until it reaches the one before
		_tail = _head;
		while (_tail.next != lastTail) {
			_tail = _tail.next;
		}
		_tail.next = null; // Prevent memory leak :]

		--_size;
		return lastTail.data;
	}
	
	public T get(long index) throws Exception {
		if (index > _size - 1l) {
			throw new Exception("Index out of range");
		}
		Node<T> temp = _head;
		for (int i = 0; i != index; ++i) {
			temp = temp.next;
		}
		return temp.data;
	}

	public int indexOf(T obj) {
		Node<T> temp = _head;
		for (int i = 0; temp != null; ++i, temp = temp.next) {
			if (temp.data == obj)
				return i;
		}
		return -1;
	}

	public boolean contains(T obj) {
		return indexOf(obj) != -1;
	}

	public String toString() {
		StringBuilder str = new StringBuilder("head [\n");
		Node<T> temp = _head;
		for (int i = 0; temp != null; ++i, temp = temp.next) {
			str.append("  " + i + ": " + temp.data.toString() + "\n");
		}
		return str.append("] tail").toString();
	}
}
