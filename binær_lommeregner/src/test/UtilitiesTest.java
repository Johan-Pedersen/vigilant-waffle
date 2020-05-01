package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

import calculator.Logic.Utilities;




class UtilitiesTest {

	@Test
	void testStringify() {
		
		ArrayList<Integer> testArr = new ArrayList<>();
		
		testArr.add(1);
		testArr.add(2);
		testArr.add(3);
		testArr.add(4);
		testArr.add(5);
		
		assertEquals("12345", Utilities.stringyfi(testArr));
	}
	
	@Test
	void testFormat() {
		
		//Normal input
		String[] nums = Utilities.format("11001001", "00101100");
		String[] expected = new String[] {"11001001", "00101100"};
		Assert.assertArrayEquals( expected, nums );
		
		//Input med mellemrum
		nums = Utilities.format("110010 01", " 0  010 110 0");
		Assert.assertArrayEquals( expected, nums );
		
		//input hvor tallene ikke er samme længde
		expected = new String[] {"10000001", "00101100"};
		nums = Utilities.format("1001", " 00101100");
		Assert.assertArrayEquals( expected, nums );
		
		//input med mellemrum og ikke samme længde
		nums = Utilities.format("10 01", " 0  010 110 0");
		Assert.assertArrayEquals( expected, nums );
	
	}
	
	
	@Test
	void testRemoveLeadingZeros() {
		String actual = Utilities.removeLeadingZeros("10010010");
		assertEquals("110010", actual);
		
		actual = Utilities.removeLeadingZeros("11001010");
		assertEquals("11001010", actual);
	
		actual = Utilities.removeLeadingZeros("101001010");
		assertEquals("11001010", actual);
	
		actual = Utilities.removeLeadingZeros("111001010");
		assertEquals("111001010", actual);
	
		actual = Utilities.removeLeadingZeros("100000001001010");
		assertEquals("11001010", actual);
	
		actual = Utilities.removeLeadingZeros("10101001010");
		assertEquals("1101001010", actual);
	
	}

}
