package com.lqh.search;

/**
 * Here show some incorrect examples.
 *
 */
public class BinarySearch {
	//left close, right close
	public static int search(int[] array, int v){
		//do the binary search
		int min = 0;
		int max = array.length - 1;
		while (min <= max){
			int mid = min + (max-min)/2; // avoid overflow
			int value = array[mid];
			if( value < v){
				min = mid + 1;
			} else if(value > v){
				max = mid -1;
			} else {
				return mid;
			}
		}
		return -1; // don't find the v
	}
	
	//left closed, right open
	public static int search2(int[] array, int v){
		//do the binary search
		int min = 0;
		int max = array.length; //open which meaning it is 
		while (min <= max){
			int mid = min + (max-min)/2;
			int value = array[mid];
			if( value < v){
				min = mid + 1;
			} else if(value > v){
				max = mid; // right open, thus don't minus one
			} else {
				return mid;
			}
		}
		return -1; // don't find the v
	}
	
	public static int searchError(int[] array, int v){
		//do the binary search
		//both are closed
		int min = 0;
		int max = array.length-1;
		while (min <= max){
			int mid = min + (max-min)/2;
			int value = array[mid];
			if( value < v){
				min = mid; //open
			} else if(value > v){
				max = mid; // open
			} else {
				return mid;
			}
		}
		return -1; // don't find the v
	}
	
	public static void main(String args[]){
		
	}
}
