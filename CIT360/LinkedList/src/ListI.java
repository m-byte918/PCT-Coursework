/**
 * Basic interface for a Linked List implementation.
 */
public interface ListI<T> {
	/**
	 * Add a String object to the front of the list.
	 * Use example- linkedList.addFirst("this should be first");
	 * 
	 * @param str the String object to store in the list
	 */
	void addFirst(T obj);
	
	/**
	 * Add a String object to the end of the list.
	 * Use example- linkedList.addLast("this should be last");
	 * 
	 * @param str the String object to store in the list
	 */
	void addLast(T obj);
	
	/**
	 * Remove the first node from the List and return it's data.
	 * Use example- String data = linkedList.removeFirst();
	 * 
	 * @return data
	 */
	T removeFirst() throws LinkedListException;
	
	/**
	 * Remove the last node from the List and return it's data.
	 * Use example- String data = linkedList.removeLast();
	 * 
	 * @return data
	 */
	T removeLast() throws LinkedListException;
	
	/**
	 * Look in the linked list for a particular string. If found
	 * return true, else return false.
	 * Use example- if(linkedList.contains("phil")
	 * 
	 * @param o The string to search for
	 * @return
	 */
	boolean contains(T obj);
	
	/**
	 * Returns list as a string
	 */
	String toString();
	
	/**
	 * Returns the current size of the list
	 * 
	 * @return 
	 */
	long size();
}
