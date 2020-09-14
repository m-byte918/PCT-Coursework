
public class RadixSort {
	static final int BASE = 10;

	private static int[] array   = null; // Points to original array
	private static int[] temp    = null; // Temporary array
	private static int[] buckets = null; // Cached buckets from 0 to BASE-1

	static void sort(int[] arr) {
		array   = arr;
		temp    = new int[array.length];
		buckets = new int[BASE];

		// Get highest number in array 
		int place = 0;
		int max = array[0];
		for (int n = 0; place < array.length; ++place) {
			if (max < (n = array[place]))
				max = n;
		}
	    // Use counting sort for each place, starting at 1
	    for (place = 1; max / place > 0; place *= BASE)
	    	countingSort(place);
	}

	private static void countingSort(int place) {
		int i = 0;

	    // Empty all buckets
	    for (; i < BASE; ++i) buckets[i] = 0;

	    // Store frequency of each digit in buckets
	    for (i = 0; i < array.length; ++i) {
	    	temp[i] = 0; // Reset temp array while we're here :]
	        ++buckets[(array[i] / place) % BASE];
	    }
	    // Accumulate buckets with the one before it
	    for (i = 1; i < BASE; ++i) {
	    	buckets[i] += buckets[i - 1];
	    }
	    // Access bucket value using number's digit as the subscript, then use that
	    // value-1 as the location the number will be placed in the temp array
	    for (i = array.length - 1; i >= 0; --i) {
			temp[--buckets[(array[i] / place) % BASE]] = array[i];
	    }
	    // Copy temp array into original for the next iteration
	    System.arraycopy(temp, 0, array, 0, array.length);
	}
}
