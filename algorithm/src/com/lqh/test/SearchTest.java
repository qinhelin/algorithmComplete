package com.lqh.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lqh.search.BinarySearch;

public class SearchTest extends AbstractTest {
	
	@BeforeClass
	public static void initTest() {
		initLogger(SearchTest.class);
	}

	@Test
	public void testBinarySearch() {
		int[] a1 = { 1, 2, 3, 4, 5, 6, 7 };
		int v = 3;
		if (BinarySearch.search(a1, v) != 2) {
			fail("Unexpected Index."); //$NON-NLS-1$
		}
		info("Success.");
	}

	@Test
	public void testBinarySearchError() {
		int[] a1 = { 1, 2, 3, 4, 5, 6, 7, 123, 321 };
		int v = 3;
		if (BinarySearch.searchError(a1, v) != 2) {
			fail("Unexpected Index."); //$NON-NLS-1$
		}
		info("Success.");
	}
}
