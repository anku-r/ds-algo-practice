package com.ankur.algo.sort;

/*
 * Implementation of Quick Sort
 */
public class QuickSort {

    public static void main(String[] args) {
	int[] arr = { 11, 10, 7, 9, 2, 6, 8 };
	quickSort(arr, 0, arr.length, 5);
	for (int n : arr) {
	    System.out.println(n);
	}
    }

    public static void quickSort(int[] arr, int begin, int end, int key) {
	if (begin < end) {
	    int pos = partition(arr, begin, end);
	    if (pos != key - 1) {
		quickSort(arr, begin, pos, key);
		quickSort(arr, pos + 1, end, key);
	    }
	}
    }

    public static int partition(int[] arr, int begin, int end) {
	int pos = begin;
	int temp;
	for (int i = begin; i < end - 1; i++) {
	    if (arr[end - 1] > arr[i]) {
		if (i != pos) {
		    temp = arr[i];
		    arr[i] = arr[pos];
		    arr[pos] = temp;
		}
		pos++;
	    }
	}
	temp = arr[end - 1];
	arr[end - 1] = arr[pos];
	arr[pos] = temp;
	return pos;
    }
}
