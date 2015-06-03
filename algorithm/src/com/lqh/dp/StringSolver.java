package com.lqh.dp;

/**
 * A solver which solve some string related problems mainly using the Dynamic
 * programming approach.
 * Note: there might be method which doesn't use the dynamic programming approach
 * 
 * @author qinhe
 *
 */
public class StringSolver {
	
	/**
	 * Find the longest substring without repeating characters
	 * Note: The problem comes from the leetcode: https://leetcode.com/problems/longest-substring-without-repeating-characters/
	 *  
	 * @param s the input string
	 * @return the length of the longest substring without repeating characters
	 */
	public int lengthOfLongestSubstring(String s) {
		char[] chars = s.toCharArray();
		int length = chars.length;
		if (length == 0 || length == 1)
			return length;
		int max = 0;
		int i = 0;
		int j = 1;
		int currentILength = 1;// the longest string which start from index i
		while (i < length && j < length) {
			while (j < length && !exist(chars, i, j - 1, chars[j])) {
				j++;
				currentILength++;
			}

			if (currentILength > max) {
				max = currentILength;
			}
			i++;
			currentILength--;
		}
		return max;
	}

	public boolean exist(char[] chars, int left, int right, char target) {
		for (int i = left; i <= right; i++) {
			if (chars[i] == target)
				return true;
		}
		return false;
	}
}
