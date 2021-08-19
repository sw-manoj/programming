package com.samples.sort;

public class QuickSort {

	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);

			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];

		int lastSmallestEleIndex = low - 1;
		// accumulating smaller number than pivot to left , leave higher num in that pos
		// initially when accessed but when next smaller element is accessed we swap
		// lastSmallIndex+1 with latest small index found(j),
		// and storing lastSmallIndex
		// so that at end we can swap pivot with next index to lastsmallIndex.
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] <= pivot) {
				lastSmallestEleIndex++;
				swap(arr, lastSmallestEleIndex, j);
			}
		}

		swap(arr, lastSmallestEleIndex + 1, high);
		return lastSmallestEleIndex + 1;
	}

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = {0, 2,10, 7, 8, 9, 1, 5 };
		int n = arr.length;

		QuickSort ob = new QuickSort();
		ob.quickSort(arr, 0, n - 1);

		System.out.println("sorted array");
		printArr(arr);
	}
}
