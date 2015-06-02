package com.lqh.sorting;

public class Sorting {
	
	/**
	 * Bubble sort implementation
	 * @param nums the input array
	 * @return the sorted array
	 */
	public static int[] bubbleSort(int[] nums) {
		int length = nums.length;
		for (int i = length - 1; i > 0; i--) {
			boolean stop = true;
			for (int j = 0; j < i; j++) {
				if (nums[j] > nums[j + 1]) {
					swap(nums, j, j + 1);
					stop = false;
				}
			}
			if (stop)
				break;
		}
		return nums;
	}
	
	/**
	 * Insert sort implementation
	 * @param nums the input array
	 * @return the sorted array
	 */
	public static int[] insertSort(int[] nums) {
		int length = nums.length;
		for (int i = 1; i < length; i++) {
			int key = nums[i];
			int j = i - 1;
			while (j >= 0 && nums[j] > key) {
				nums[j + 1] = nums[j];
				j--;
			}
			nums[++j] = key;
		}
		return nums;
	}

	/**
	 * Quick sort implementation
	 * @param nums the input array
	 * @return the sorted array
	 */
	public static int[] quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}
	
	/**
	 * the recursion method that can be used for the quick sort
	 * @param nums the input array
	 * @param left the starting index 
	 * @param right the end index
	 * @return the array where the element between index <code>left</code> to <code>right</code> is sorted
	 */
	public static int[] quickSort(int[] nums, int left, int right) {
		if (left >= right)
			return nums; // the end condition
		int pivot = partition(nums, left, right);
		quickSort(nums, left, pivot - 1);
		quickSort(nums, pivot + 1, right);
		return nums;
	}
	
	/**
	 * partition the sub range of array
	 * 
	 * @param nums the input array
	 * @param left the starting index
	 * @param right the end index
	 * @return the pivot index. nums[left..pivotIndex-1] is smaller than pivot. And nums[pivotIndex+1, right] is larger than pivot
	 */
	public static int partition(int[] nums, int left, int right) {// closed area
		// select the most right element as pivot
		int pivot = nums[right];
		int i = left - 1; // the indicator which shows the most right element
							// which is lower than pivot
		for (int j = left; j < right; j++) {
			if (nums[j] < pivot) {
				i++; // the position where the pivot located
				swap(nums, j, i);
			}
		}
		swap(nums, ++i, right);
		return i; // the position of pivot
	}
	
	/**
	 * Swap two elements in the array
	 * @param nums the array where the elements store
	 * @param i the index of the first element in array
	 * @param j the index of the second element in array
	 */
	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
