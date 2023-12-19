package JavaActivities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String args[]) {
		int[] intArr = { 12, 1, 4, 10, 23, 5, 7, 3 };
		System.out.println("Array Before sorting: ");
		System.out.println(Arrays.toString(intArr));
		sortArrayInAscOrder(intArr);
		System.out.println("Array after sorting in ascending Order: ");
		System.out.println(Arrays.toString(intArr));
	}

	public static void sortArrayInAscOrder(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			// store the key just before the last shifted element or after the element just smaller than or equal to the key
			arr[j + 1] = key;
		}
	}

}
