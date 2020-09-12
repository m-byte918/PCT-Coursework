
public class MergeSort {
	private static int[] temp  = null; // Temporary array
	private static int[] array = null; // Points to original array

	static void sort(int[] arr) {
		array = arr;
		temp  = new int[arr.length];
		split(0, arr.length - 1);
	}

	private static void split(int low, int high) {
		if (low == high)
			return; // Only one element

		int mid = (low + high) / 2;

		split(low, mid); // Recursively split the left half
		split(mid + 1, high); // Recursively split the right half

		merge(low, mid, high); // Merge all halves
	}

	private static void merge(int low, int mid, int high) {
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