import java.lang.reflect.Method; // printExecutionTime()
import java.util.Random; // printExecutionTime()

public class Main {
	static final int MAX_VALUE = 1000;
	static final int ITERATIONS = 500;
	static Random rng = new Random();

	public static void main(String[] args) throws Exception {
		testAlgorithms(100);
		testAlgorithms(1000);
	}

	public static void testAlgorithms(int arrayLength) throws Exception {
		System.out.printf("Array size: \t\t%d"
				+ "\nMax value: \t\t%d"
				+ "\nNumber of iterations: \t%d"
				+ "\nAverage tun times (in nanoseconds):\n", arrayLength, MAX_VALUE, ITERATIONS);

		// Measure all algorithms
		printExecutionTime("selectionSort", arrayLength);
		printExecutionTime("bubbleSort",    arrayLength);
		printExecutionTime("insertionSort", arrayLength);
		printExecutionTime("quickSort",     arrayLength);
		printExecutionTime("mergeSort",     arrayLength);
		System.out.println("-------------------------------------");
	}

	public static void printExecutionTime(String algorithmName, int arrayLength) throws Exception {
		// Java why... https://stackoverflow.com/questions/160970/how-do-i-invoke-a-java-method-when-given-the-method-name-as-a-string
		Method method = Main.class.getMethod(algorithmName, int[].class);
		long startTime = 0l;
		long totalTime = 0l;
		int[] arr = new int[arrayLength];

		// Accumulate execution times of each sort
		for (int i = 0, j = 0; i < ITERATIONS; ++i) {
			// Allocating a new array in a separate method per iteration is a waste
			for (j = 0; j < arrayLength; ++j) {
				arr[j] = rng.nextInt(MAX_VALUE) + 1; // Replace with new value
			}
			// Only measure execution time of the sort. Method::invoke() may skew results but what can ya do :shrug:
			startTime = System.nanoTime();
			method.invoke(null, arr);
			totalTime += System.nanoTime() - startTime;
		}
		System.out.printf("    %-15s--> %d\n", algorithmName, totalTime / ITERATIONS);
	}

	public static void swap(int[] arr, int i, int j) {
		if (i == j)
			return; // Don't swap with self
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0, j = 0, min = 0, l = arr.length; i < l; ++i) {
			min = i;
			// Search the remainder of the array for anything smaller than the current minimum
			for (j = i + 1; j < l; ++j) {
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

	public static void insertionSort(int[] arr) {
		for (int i = 1, j = 0, key = 0, l = arr.length; i < l; ++i) {
			j = i - 1; // Left element
			key = arr[i]; // Right (current) element
			// Keep sorting to the left as long as there are values larger than the current
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j -= 1;
			}
			arr[j + 1] = key; // "Swap"
		}
	}

	// Separate methods to comply with Method::invoke() signature
	public static void quickSort(int[] arr) {
		qsort(arr, 0, arr.length - 1);
	}
	public static void mergeSort(int[] arr) {
		new MergeSort(arr);
	}

	// The ACTUAL QuickSort
	private static void qsort(int[] arr, int low, int high) { 
		if (low >= high)
			return; // Only one element
        // Pivot is now at the correct place
        int pivotIndex = partition(arr, low, high);

        // Recursively sort elements to the left and right of the pivot
        qsort(arr, low, pivotIndex - 1); // Left
        qsort(arr, pivotIndex + 1, high); // Right
    }
	private static int partition(int arr[], int low, int high) { 
        int pivot = arr[high]; // Index of rightmost element
        int i = low - 1; // Index of leftmost element - 1
        for (; low < high; ++low) {
            if (arr[low] < pivot)
                swap(arr, ++i, low); // Swap arr[i + 1] with arr[low]
        }
        swap(arr, ++i, high); // Swap arr[i + 1] with pivot
        return i;
    }
}
