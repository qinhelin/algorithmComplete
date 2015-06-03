package com.lqh.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lqh.dp.StringSolver;

public class StringSolverTest extends AbstractTest{

	StringSolver solver = new StringSolver();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLengthOfLongestSubstring() {
		String str = "afdabfdafead";
		int length = solver.lengthOfLongestSubstring(str);
		if( length != 4){
			fail("The runnting result is "+ length);
		}
		info("Test length of longest substring succeed.");
	}
	
	@Test
	public void testLongestPalindrome() {
		String[] testCases = {"","a","aaa","abcbdesea"};
		String[] results = {"","a","aaa","bcb"};
		for(int i=0;i<testCases.length;i++){
			String str = testCases[i];
			String subStr = solver.longestPalindrome(str);
			if(!subStr.equals(results[i])){
				fail("The runnting result is "+ subStr +" [expected result: "+results[i]+"]");
			}
		}
		info("Test length of longest palindrome succeed.");
	}
}
