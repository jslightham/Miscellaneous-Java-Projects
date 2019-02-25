public class SortingAlgorithms {

	public static int m_counter = Main.counter;
	public static boolean done = false;
	private static int[] myArray;
	private static int[] tempArray;

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j])
					minIndex = j;
				try {
					Thread.currentThread().sleep(Main.slowDown);
				} catch (Exception e) {
					System.out.println(e);
				}
			}

			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		done = true;
	}

	public static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j;
			for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
				arr[j + 1] = arr[j];
				try {
					Thread.currentThread().sleep(Main.slowDown);
				} catch (Exception e) {
					System.out.println(e);
				}
			}

			arr[j + 1] = temp;
		}
		done = true;
	}

	public static void BogoSort(int[] i) {

		while (!isSorted(i)) {
			shuffle(i);
			try {
				Thread.currentThread().sleep(Main.slowDown);
			} catch (Exception e) {
				System.out.println(e);
			}
			m_counter++;
			/*
			 * if(counter%1000000==0) { System.out.println(counter); }
			 */

		}
		done = true;
		System.out.println("Solution found! (shuffled " + m_counter + " times)");
		Main.print(i);
	}

	public static void shuffle(int[] i) {
		for (int x = 0; x < i.length; ++x) {
			int index1 = (int) (Math.random() * i.length);
			int index2 = (int) (Math.random() * i.length);
			int a = i[index1];
			i[index1] = i[index2];
			i[index2] = a;
		}
	}

	private static boolean isSorted(int[] i) {
		for (int x = 0; x < i.length - 1; ++x) {
			if (i[x] > i[x + 1]) {
				return false;
			}
		}

		return true;
	}

	public static void bubble(int array[]) {
		int n = array.length;
		int k;
		for (int j = n; j >= 0; j--) {
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (array[i] > array[k]) {
					swap(i, k, array);
				}
				try {
					Thread.currentThread();
					Thread.sleep(Main.slowDown);
				} catch (Exception e) {
					System.out.println(e);
				}

			}
			// Main.print(array);

		}
		done = true;
		System.out.println("Solution found! (shuffled " + m_counter + " times)");
	}

	private static void swap(int i, int j, int[] array) {

		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		m_counter++;
	}

	public static void mergeSort(int arr[]) {

		myArray = arr;
		int length = arr.length;
		tempArray = new int[length];
		setUpMerge(0, length - 1);
	}

	private static void setUpMerge(int lower, int higher) {

		if (lower < higher) {
			int middle = lower + (higher - lower) / 2;
			setUpMerge(lower, middle);
			setUpMerge(middle + 1, higher);
			doTheMerge(lower, middle, higher);

		}

	}

	private static void doTheMerge(int lower, int middle, int higher) {

		for (int i = lower; i <= higher; i++) {

			tempArray[i] = myArray[i];

		}
		int i = lower;
		int j = middle + 1;
		int k = lower;
		while (i <= middle && j <= higher) {
			if (tempArray[i] <= tempArray[j]) {
				myArray[k] = tempArray[i];
				i++;
			} else {
				myArray[k] = tempArray[j];
				j++;
			}
			k++;
			
			try {
				Thread.currentThread();
				Thread.sleep(Main.slowDown);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		while (i <= middle) {
			myArray[k] = tempArray[i];
			k++;
			i++;
		}
	}
}