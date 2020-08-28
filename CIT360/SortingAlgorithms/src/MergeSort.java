public class MergeSort {
	private int[] temp, array;

	MergeSort(int[] arr) {
		array = arr;
		int len = arr.length;
		temp = new int[len];
		split(0, len - 1);
	}

	private void split(int low, int high) {
		if (low == high)
			return; // Only one element

		int mid = (low + high) / 2;

		split(low, mid); // Recursively split the left half
		split(mid + 1, high); // Recursively split the right half

		merge(low, mid, high); // Merge all halves
	}

	private void merge(int low, int mid, int high) {
		int i     = low;
		int left  = low;     // Index starting from the back
		int right = mid + 1; // Index starting from the right of the midpoint

		while (left <= mid && right <= high) {
			// Put whichever element is smaller into temp array, then increment the side it was on
			temp[i++] = array[array[left] <= array[right] ? left++ : right++];
		}
		// Put the remaining elements (if any) into temp array
		while (left  <= mid)  temp[i++] = array[left++];
		while (right <= high) temp[i++] = array[right++];

		// Copy everything back into the original array
		for (; low <= high; ++low)
			array[low] = temp[low];
	}
}