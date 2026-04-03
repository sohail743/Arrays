package com.java.dsa;

import java.util.HashMap;

public class ArraysBasics {

	// Problem 1 🟢 Q1. Find Maximum Element
	public int findMax(int arr[]) {

		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array is empty");
		}

		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;

	}

	// find second largest element
	public int secondMaxElement(int arr[]) {

		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array is empty");
		}

		int max1 = arr[0];
		int max2 = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max1) {
				max2 = max1;
				max1 = arr[i];
			}

			else if (arr[i] < max1 && arr[i] > max2) {
				max2 = arr[i];
			}
		}
		return max2;
	}

	// is array sorted or not
	public boolean isSorted(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array is empty");
		}
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;

	}

	// reverse an array
	public int[] reverseArray(int[] arr) {

		if (arr == null) {
			throw new IllegalArgumentException("Array is empty");
		}
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		return arr;

	}

	// 🟡 Q5: Move All Zeros to End
	public int[] moveZeroesToEnd(int arr[]) {
		if (arr == null) {
			throw new IllegalArgumentException("Array is empty");
		}

		int left = 0;
		for (int right = 0; right < arr.length; right++) {
			if (arr[right] != 0) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				left++;
			}
		}

		return arr;

	}

	// 🟡 Q6: Find Missing Number
	public int findMissingNumber(int arr[]) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		int size = arr.length + 1;
		int missingNumber = ((size * (size + 1)) / 2) - sum;
		return missingNumber;

	}

	// 🟡 Q7: Find Duplicate Element
	public int findDuplicate(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
			if (map.get(i) == 2) {
				return i;
			}

		}
		return -1;
	}

}
