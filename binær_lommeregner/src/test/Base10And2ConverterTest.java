package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.Logic.Base10And2Converter;

class Base10And2ConverterTest {
	
	Base10And2Converter converter = new Base10And2Converter();
	
	
	@Test
	void Base10To2Test() {
		
		String result = converter.base10To2("1");
		
		assertEquals("1", result);
		result = converter.base10To2("0");
		assertEquals("0", result);
		
		result = converter.base10To2("00");
		assertEquals("0", result);
		
		result = converter.base10To2("42");
		assertEquals("101010", result);
		
		result = converter.base10To2("1337");
		assertEquals("10100111001", result);
		
		result = converter.base10To2("1110101");
		assertEquals("100001111000001010101", result);
		
	}
	
	@Test
	void Base2To10Test() {
		long result = converter.base2To10("010");
		assertEquals(2, result);
		
		result = converter.base2To10("00");
		assertEquals(0, result);
		
		result = converter.base2To10("0110101110");
		assertEquals(430, result);
		
		result = converter.base2To10("11");
		assertEquals(-1, result);

		result = converter.base2To10("1111");
		assertEquals(-7, result);
		
		result = converter.base2To10("00000000");
		assertEquals(0, result);
		
		result = converter.base2To10("00110111");
		assertEquals(55, result);
		
		result = converter.base2To10("011111011110");
		assertEquals(2014, result);
		
		result = converter.base2To10("00000001111");
		assertEquals(15, result);
			
		result = converter.base2To10("000001011101010100111");
		assertEquals(47783, result);
		
		
		result = converter.base2To10("01001");
		assertEquals(9, result);
		
	
	}
	
	
}
