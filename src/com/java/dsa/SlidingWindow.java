package com.java.dsa;

import java.util.HashMap;

public class SlidingWindow {

	// 🟢 Q1: Maximum Sum Subarray of Size K
	public int maxSumSubarray(int[] arr, int k) {

		if (arr == null || arr.length < k) {
			throw new IllegalArgumentException("Invalid input");
		}

		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		int maxSum = sum;

		for (int i = k; i < arr.length; i++) {
			sum += arr[i];
			sum -= arr[i - k];
			maxSum = Math.max(maxSum, sum);
		}

		return maxSum;

	}

	// 🟡 Q2: Longest Subarray with Sum ≤ K
	public int longestSubarray(int[] arr, int k) {

		if (arr == null) {
			throw new IllegalArgumentException("Invalid input");
		}
		int left = 0;
		int sum = 0;
		int maxLength = 0;
		for (int right = 0; right < arr.length; right++) {
			sum += arr[right];

			while (sum > k) {
				sum -= arr[left];
				left++;
			}
			if (sum <= k) {
				maxLength = Math.max(maxLength, right - left + 1);
			}
		}
		return maxLength;

	}

	// 🔥 Q3: Longest Substring Without Repeating Characters
	public int longestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int left = 0;
		int maxLength = 0;
		for (int right = 0; right < s.length(); right++) {
			Character ch = s.charAt(right);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			while (map.get(ch) > 1) {
				char leftChar = s.charAt(left);
				map.put(leftChar, map.get(leftChar) - 1);
				left++;
			}

			maxLength = Math.max(maxLength, right - left + 1);

		}
		return maxLength;

	}
}
