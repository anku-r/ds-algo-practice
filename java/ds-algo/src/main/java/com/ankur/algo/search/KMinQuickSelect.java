package com.ankur.algo.search;

public class KMinQuickSelect {

	public static void main(String[] args) {
		int[] arr = {
				7, 3, 6, 9, 1, 5
		};
		
		int pos = partition(arr, 0, arr.length, 5);
		System.out.println(pos);
	}
	
	public int quickSelect(int[] arr, int p, int q, int key) {
		int pos = p;
		if (p < q) {
			pos = partition(arr, p, q, key);
			if (pos > key)
			quickSelect(arr, p, pos - 1, key);
			quickSelect(arr, pos + 1, q, key);
		}
		return arr[pos];
	}
	
	public static int partition(int[] arr, int p, int q, int key) {
		int pos = p;
		int pivot = arr[pos];
		for (int i = p + 1; i < q; i++) {
			if (pivot > arr[i]) {
				pos++;
			}
		}
		return pos;
	}
}
