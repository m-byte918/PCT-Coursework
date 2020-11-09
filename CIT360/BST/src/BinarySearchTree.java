
public class BinarySearchTree<K, V> {
	
	// Each node in the tree contains a key and a value, and a left and right branch
	@SuppressWarnings("hiding")
	private class _Node<K, V> {
		public K key;
		public V value;
		public _Node<K, V> left = null, right = null;

		_Node(K key, V value) {
			this.key   = key;
			this.value = value;
		}
	}

	// Always points to the root of the tree
	private _Node<K, V> _root = null;

	public boolean contains(K key) {
		return _searchTree(_root, key) != null;
	}

	public V get(K key) {
		_Node<K, V> temp = _searchTree(_root, key);
		return temp != null ? temp.value : null;
	}
	
	public void put(K key, V obj) {
		_root = _insert(_root, key, obj);
	}
	
	public void remove(K key) {
		_root = _delete(_root, key);
	}
	
	@Override
	public String toString() {
		return _inorderTraversal(_root);
	}
	
	@SuppressWarnings("unchecked")
	private _Node<K, V> _searchTree(_Node<K, V> current, K key) {
		// Base case
		if (current == null) {
			return null;
		}
		int compareResult = ((Comparable<K>)key).compareTo(current.key);
		if (compareResult == 0) {
			return current; // Found
		}
		if (compareResult < 0) {
			// Traverse left
			return _searchTree(current.left, key);
		}
		// Traverse right
		return _searchTree(current.right, key);
	}

	@SuppressWarnings("unchecked")
	private _Node<K, V> _insert(_Node<K, V> current, K key, V value) {
		if (current == null) {
			return new _Node<K, V>(key, value);
		}
		int compareResult = ((Comparable<K>)key).compareTo(current.key);
		if (compareResult < 0) {
			// Insert left
			current.left = _insert(current.left, key, value);
		} else if (compareResult > 0) {
			// Insert right
			current.right = _insert(current.right, key, value);
		}
		return current;
	}
	
	@SuppressWarnings("unchecked")
	private _Node<K, V> _delete(_Node<K, V> root, K key) {
        if (root == null) {
        	return root; // Empty tree
        }
        int compareResult = ((Comparable<K>)key).compareTo(root.key);
		if (compareResult < 0) {
			// Traverse left of tree
			root.left = _delete(root.left, key);
		} else if (compareResult > 0) {
			// Traverse right of tree
			root.right = _delete(root.right, key);
		} else {
            // Node with one or less child
            if (root.left  == null) return root.right;
            if (root.right == null) return root.left;

            // Get & delete the inorder successor
            root.key = _minimumKey(root.right);
            root.right = _delete(root.right, root.key);
        }
        return root;
    }

	private K _minimumKey(_Node<K, V> current) {
		while (current.left != null) {
			current = current.left;
		}
		return current.key;
	}
	
	private String _inorderTraversal(_Node<K, V> root) {
		StringBuilder sb = new StringBuilder();
		if (root != null) {
			sb.append(_inorderTraversal(root.left));
			sb.append(root.key.toString() + ": " + root.value.toString() + ", ");
			sb.append(_inorderTraversal(root.right));
		}
		return sb.toString();
	}
}
