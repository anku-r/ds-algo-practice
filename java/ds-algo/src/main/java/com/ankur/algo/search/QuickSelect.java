package com.ankur.algo.search;

/**
 * Implementation of Quick Select Algorithm
 * It is used to find Kth Minimum Element
 */
public class QuickSelect {

	public static void main(String[] args) {
		int[] arr = {
				11, 10, 7, 9, 2, 6, 8
		};	
		int result = quickSelect(arr, 0, arr.length, 3);
		System.out.println(result);
	}
	
	public static int quickSelect(int[] arr, int begin, int end, int k) {
		if (begin < end) {
			int pos = partition(arr, begin, end);
			if (pos == k - 1) {
				return arr[pos];
			} else if (pos > k - 1) {
				return quickSelect(arr, begin, pos, k);
			} else {
				return quickSelect(arr, pos + 1, end, k);
			}
		}
		return 0;
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
