
public class MaxHeap {
	private int[] _heap;
	private int _size;
	
	MaxHeap(int cap) {
		_heap = new int[cap];
		_size = 0;
	}
	
	public int size() {
		return _size;
	}
	
	public int max() {
		return _size == 0 ? -1 : _heap[0];
	}
	
	public void insert(int i) {
		_heap[_size] = i;
		_upHeap(_size++);
	}
	
	public int removeMax() {
		if (_size == 0) {
			return -1;
		}
		int temp = _heap[0];
		
		_heap[0] = _heap[--_size];
		
		_downHeap(0);
		return temp;
	}
	
	public String toString() {
		int rowMax = 1;
		int row = 1;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < _heap.length; ++i, ++row) {
			sb.append(_heap[i] + ",  ");
			
			if (row == rowMax) {
				sb.append("\n\n");
				rowMax = rowMax + rowMax;
				row = 0;
			}
		}
		return sb.toString();
	}
	
	private int _parent(int i) {
		return (i - 1) / 2;
	}
	
	private int _left(int i) {
		return i * 2 + 1;
	}
	
	private int _right(int i) {
		return i * 2 + 2;
	}
	
	private boolean _hasLeft(int i) {
		return _left(i) < _size;
	}
	
	private boolean _hasRight(int i) {
		return _right(i) < _size;
	}
	
	private void _swap(int i, int j) {
		int temp = _heap[i];
		_heap[i] = _heap[j];
		_heap[j] = temp;
	}
	
	private void _upHeap(int i) {
		int p = 0;
		while (i > 0) {
			p = _parent(i);
			
			if (_heap[i] < _heap[p]) {
				// Heap property has been restored
				break;
			}
			_swap(i, p);
			i = p;
		}
	}
	
	private void _downHeap(int i) {
		while (_hasLeft(i)) {
			int leftIndex = _left(i);
			int largeChildIndex = leftIndex;
			
			if (_hasRight(i)) {
				int rightIndex = _right(i);
				
				if (_heap[leftIndex] < _heap[rightIndex]) {
					largeChildIndex = rightIndex;
				}
			}
			
			if (_heap[largeChildIndex] < _heap[i]) {
				break;
			}
			
			_swap(i, largeChildIndex);
			i = largeChildIndex;
		}
	}
}
