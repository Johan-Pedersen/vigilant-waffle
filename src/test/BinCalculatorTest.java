package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import calculator.Controller.Controller;

class BinCalculatorTest {
	private Controller controller = new Controller();
	
	@Test
	void testSum() {
		
		/**
		 * HUSK:
		 * Der bruges sign bits
		 */
		
		//subtraktion
		String result = controller.Sum("1010101", "0001110");
		assertEquals("1111", result);
		
		//2 negative tal
		
		//når der lægges 1 til efter onescompelemtn sker der en fejl
		result = controller.Sum("10010101", "10001110");
		assertEquals("1100011", result);
		
		
		//addition
		result = controller.Sum("0010101", "0001110");
		assertEquals("0100011", result);
		
		
		//tjekker for om signbit bliver overskrevet
		//faktisk : 0100011
		result = controller.Sum("0110101", "0101110");
		assertEquals("01100011", result);
		
		//Alle bit er 0
		result = controller.Sum("00000000", "00000000");
		assertEquals("0", result);
		
		//Alle bit er 1
		
		//faktisk: har et 1 tal for lidt
		result = controller.Sum("101111111", "101111111");
		assertEquals("111111110", result);
		
		
		//Stort tal
		
		result = controller.Sum("00101110100001011110001", "00100001110111110010101110");
		assertEquals("0100111101011111110011111", result);
		
		//lille tal
		result = controller.Sum("01", "01");
		assertEquals("010", result);
		
		//forskellige størrelse tal 1
		result = controller.Sum("0101", "011001111");
		assertEquals("011010100", result);
		
		//forskellige størrelse tal 2
		result = controller.Sum("011001111", "0101");
		assertEquals("011010100", result);

		//faktisk resultat: 011000
		//God
		result = controller.Sum("0011", "11011");
		assertEquals("11000", result);

		//faktisk resultat: 011000
		//god
		result = controller.Sum("11011", "0011");
		assertEquals("11000", result);

		//fejler
		result = controller.Sum("1011", "01011");
		assertEquals("01000", result);
		
		//fejler
		result = controller.Sum("01011", "1011");
		assertEquals("01000", result);

		//fejler
		result = controller.Sum("010101", "10111");
		assertEquals("01110", result);
		
		result = controller.Sum("010100", "101101");
		assertEquals("0111", result);
		
	}
	
	
	@Test
	void testMultiplikation() {
		
		String result = controller.multiply("00011", "000011");
		assertEquals("01001", result);
		
		result = controller.multiply("10011", "00011");
		assertEquals("11001", result);
		
		result = controller.multiply("10011", "10011");
		assertEquals("01001", result);
		
	}
	
	@Test
	void testDivision() {
		
		String result = controller.divide("00011", "00011");
		assertEquals("01", result);
	    
		//-147 / 7 = -21
	    result = controller.divide("110010011", "0111");
		assertEquals("110101", result);
		
	    result = controller.divide("011", "011");
		assertEquals("01", result);
	}

}
