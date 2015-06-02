package com.lqh.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lqh.sorting.Sorting;

public class SortingTest extends AbstractTest{
	int[] a1,a2,a3;
	
	@BeforeClass
	public static void initTest() {
		initLogger(SortingTest.class);
	}
	
	@Before
	public void setUp() throws Exception {
		a1 = new int[]{1,3,2,41,2,4,1,23,5,7,6,8};
		a2 = new int[]{1,2,3,4,5,6,7,8};
		a3 = new int[]{1,3,4,2,6,5,9,8,7};
	}

	@Test
	public void testBubbleSort() {
		int[] result = Sorting.bubbleSort(a1);
		if(!isSorted(result)){
			fail("The sorted result:" + toArrayStr(result));
		}
		info("Bubble Sort success: "+ toArrayStr(result));
	}
	
	@Test
	public void testInsertSort(){
		int[] result = Sorting.insertSort(a1);
		if(!isSorted(result)){
			fail("The sorted result:" + toArrayStr(result));
		}
		info("Insert Sort success: "+ toArrayStr(result));
	}
	
	@Test
	public void testQuickSort(){
		int[] result = Sorting.quickSort(a1);
		if(!isSorted(result)){
			fail("The sorted result:" + toArrayStr(result));
		}
		info("Quick Sort success: "+ toArrayStr(result));
	}
	
	
	/**
	 * Check whether the array is sorted. It is used to validate the sorting result.
	 * @param nums the input array
	 * @return true if the array is sorted
	 */
	public static boolean isSorted(int[] nums){
		for(int i=0; i< nums.length-1; i++){
			if(nums[i] > nums[i+1]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Serialize the int array
	 * @param nums the input array
	 * @return the string which can be printed out
	 */
	public static String toArrayStr(int[] nums){
		StringBuilder builder = new StringBuilder("[");
		for(int i=0; i< nums.length; i++){
			builder.append(nums[i]+", ");
		}
		builder.delete(builder.length()-2, builder.length());
		builder.append("]");
		return builder.toString();
	}
}
