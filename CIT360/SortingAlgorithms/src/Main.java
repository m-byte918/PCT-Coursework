import java.lang.reflect.Method; // printExecutionTime()
import java.util.Random;         // printExecutionTime()

public class Main {
	static final int MAX_VALUE = 1024;
	static final int ITERATIONS = 256;
	static Random rng = new Random();

	public static void main(String[] args) throws Exception {
		testAlgorithms(16);
		testAlgorithms(128);
		testAlgorithms(1024);
		testAlgorithms(2048);
	}

	public static void testAlgorithms(int arrayLength) throws Exception {
		System.out.printf("Array size: \t\t%d" 
				+ "\nMax value: \t\t%d" 
				+ "\nNumber of iterations: \t%d"
				+ "\nAverage tun times (in nanoseconds):\n", arrayLength, MAX_VALUE, ITERATIONS);

		// Each algorithm will sort the same set of 500 random arrays
		int[][] unsortedArrays = new int[ITERATIONS][arrayLength];
		for (int i = 0, j; i < ITERATIONS; ++i) {
			for (j = 0; j < arrayLength; ++j)
				unsortedArrays[i][j] = rng.nextInt(MAX_VALUE) + 1;
		}
		// Measure all algorithms
		printExecutionTime(unsortedArrays, "selectionSort");
		printExecutionTime(unsortedArrays, "bubbleSort");
		printExecutionTime(unsortedArrays, "bubbleSortBool");
		printExecutionTime(unsortedArrays, "bubbleSortWhile");
		printExecutionTime(unsortedArrays, "insertionSort");
		printExecutionTime(unsortedArrays, "quickSort");
		printExecutionTime(unsortedArrays, "dualPivotQuickSort");
		printExecutionTime(unsortedArrays, "mergeSort");
		printExecutionTime(unsortedArrays, "radixSort");
		System.out.println("-------------------------------------");
	}

	public static void printExecutionTime(int[][] unsortedArrays, String sortName) throws Exception {
		// Java why...
		// https://stackoverflow.com/questions/160970/how-do-i-invoke-a-java-method-when-given-the-method-name-as-a-string
		Method method = Main.class.getMethod(sortName, int[].class);
		long startTime = 0l;
		long totalTime = 0l;
		int[] arr = new int[unsortedArrays[0].length];

		// Accumulate execution times of each sort.
		for (int i = 0; i < ITERATIONS; ++i) {
			// Assign array to a COPY of the next cached array
			System.arraycopy(unsortedArrays[i], 0, arr, 0, arr.length);

			// Only measure execution time of the sort
			startTime = System.nanoTime();
			method.invoke(null, arr);
			totalTime += System.nanoTime() - startTime;
		}
		System.out.printf("    %-19s--> %,d\n", sortName, totalTime / ITERATIONS);
	}

	public static void swap(int[] arr, int i, int j) {
		if (i == j)
			return; // Don't swap with self
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0, j = 0, min = 0; i < arr.length; ++i) {
			min = i;
			// Search the remainder of the array for anything smaller than the current
			// minimum
			for (j = i + 1; j < arr.length; ++j) {
				if (arr[j] < arr[min])
					min = j; // New minimum
			}
			if (min != i)
				swap(arr, i, min); // Swap current element with minimum
		}
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0, j = 0, next = 0, l = arr.length - 1; i < l; ++i) {
			// Move both pointers at the same time
			for (j = 0; j < l - i; ++j) {
				if (arr[j] > arr[next = j + 1])
					swap(arr, j, next); // Swap element with the one to the right
			}
		}
	}

	public static void bubbleSortBool(int[] arr) {
		boolean sorted = true; // Assume sorted until swap occurs

		for (int i = 0, j = 0, next = 0, l = arr.length - 1; i < l; ++i) {
			sorted = true;
			// Move both pointers at the same time
			for (j = 0; j < l - i; ++j) {
				if (arr[j] > arr[next = j + 1]) {
					swap(arr, j, next); // Swap element with the one to the right
					sorted = false; // Swapped, we know elements are not sorted
				}
			}
			if (sorted)
				return; // No swaps, we can exit early
		}
	}

	/*
	 * This is faster than bubbleSort and bubbleSortBool for some reason on my machine
	 */
	public static void bubbleSortWhile(int[] arr) {
		int len = arr.length - 1;
		int i = 0;
		int next = 0;
		while (i < len) {
			if (arr[i] > arr[next = i + 1]) {
				swap(arr, i, next); // Swap element with the one to the right
			}
			if (++i == len) {
				i = 0; // Loop back around
				--len; // Last element in final position, skip it in next iteration
			}
		}
	}

	public static void insertionSort(int[] arr) {
		for (int i = 1, j = 0, key = 0; i < arr.length; ++i) {
			j   = i - 1;  // Left element
			key = arr[i]; // Right (current) element
			// Keep sorting to the left as long as there are values larger than the current
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j -= 1;
			}
			arr[j + 1] = key; // "Swap"
		}
	}

	/*
	 * Separate methods to comply with Method::invoke() signature
	 */
	public static void quickSort(int[] arr) {
		qsort(arr, 0, arr.length - 1);
	}
	public static void dualPivotQuickSort(int[] arr) {
		dpqsort(arr, 0, arr.length - 1);
	}
	public static void mergeSort(int[] arr) {
		MergeSort.sort(arr);
	}
	public static void radixSort(int[] arr) {
		RadixSort.sort(arr);
	}

	/*
	 * The ACTUAL QuickSort
	 */
	private static void qsort(int[] arr, int low, int high) {
		if (low >= high) {
			return; // Only one element
		}
		int pivot = arr[high];
		int i = low - 1; // Index of leftmost element - 1
		for (int tempLow = low; tempLow < high; ++tempLow) {
			// Swap elements less than pivot with arr[i + 1]
			if (arr[tempLow] < pivot)
				swap(arr, ++i, tempLow);
		}
		// Swap arr[i + 1] with pivot. i now points to correct pivot position
		swap(arr, ++i, high);

		// Recursively sort elements to the left and right of the pivot
		qsort(arr, low, i - 1);  // Left
		qsort(arr, i + 1, high); // Right
	}

	/*
	 * The ACTUAL Dual-Pivot QuickSort
	 */
	private static void dpqsort(int[] arr, int low, int high) {
		if (low >= high) {
			return; // Only one element
		}
		int lPivot = arr[low];  // Left pivot
		int rPivot = arr[high]; // Right pivot

		if (lPivot > rPivot) {
			// Left pivot must be smaller
			swap(arr, low, high);
			lPivot = arr[low];
			rPivot = arr[high];
		} else while (lPivot == rPivot && low < high) {
			// Pivots must be different
			lPivot = arr[++low];
		}
		int lp = low  + 1; // Leftmost element + 1
		int rp = high - 1; // Rightmost element - 1

		for (int i = lp; i <= rp;) {
			if (arr[i] < lPivot)
				swap(arr, i++, lp++); // Swap elements less than left pivot
			else if (rPivot < arr[i])
				swap(arr, i, rp--);   // Swap elements greater than right pivot
			else
				++i;
		}
		swap(arr, low,  --lp); // lp now points to correct left pivot position
		swap(arr, high, ++rp); // rp now points to correct right pivot position

		// Recursively sort elements to left, middle, and right of the pivots
		dpqsort(arr, low,    lp - 1); // Left
		dpqsort(arr, lp + 1, rp - 1); // Middle
		dpqsort(arr, rp + 1, high);   // Right
	}
}