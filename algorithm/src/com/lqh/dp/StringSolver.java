package com.lqh.dp;

/**
 * A solver which solve some string related problems mainly using the Dynamic
 * programming approach. Note: there might be method which doesn't use the
 * dynamic programming approach
 * 
 * @author qinhe
 * 
 */
public class StringSolver {

	/**
	 * Find the longest substring without repeating characters. Note: The problem
	 * comes from the leetcode:
	 * https://leetcode.com/problems/longest-substring-without
	 * -repeating-characters/
	 * 
	 * @param s
	 *            the input string
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

	/**
	 * Longest Palindromic Substring
	 * 
	 * Note: the problem is from
	 * https://leetcode.com/problems/longest-palindromic-substring/
	 * 
	 * @param s
	 *            the input string
	 * @return the longest palindromic substring
	 */
	public String longestPalindrome(String s) {
		char[] chars = s.toCharArray();
		int sLength = chars.length;
		if (sLength == 0 || sLength == 1) {
			return s;
		}

		// f[a][b] indicates whether the substring s[a...b] is palindromic
		boolean[][] f = new boolean[sLength][sLength];

		// initial the cached results
		for (int i = 0; i < sLength; i++) {
			for (int j = i; j < sLength; j++) {
				if (i == j) {
					// the char itself is palindromic
					f[i][j] = true;
				}
			}
		}

		int max = 1;
		int maxStart = 0;
		for (int i = 1; i < sLength; i++) {
			for (int j = i - 1; j >= 0; j--) {
				// should be right to left as the previous result is required
				if (chars[j] == chars[i]) {
					// if there are no characters between them or the string
					// between them is palindromic
					if (j + 1 == i || f[j + 1][i - 1]) {
						f[j][i] = true; // update the indicator
						int length = i - j + 1;
						if (max < length) {
							maxStart = j;
							max = length;
						}
					}
				}
			}
		}
		return s.substring(maxStart, maxStart + max);
	}
}
