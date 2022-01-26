package calculator.Logic;

import calculator.Controller.Controller;
import calculator.Logic.Utilities;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinCalculator_old calc = new BinCalculator_old();
		Base10And2Converter converter = new Base10And2Converter();
		BinCalculator us = new BinCalculator();
		Controller controller = new Controller();
		
		
		System.out.println(us.twosComplement("1111"));
		
		/**
		System.out.println(calc.addBinaryNumber(10,1101));
		
		int[] arr = {1,1,1,0};
		System.out.println("gammel converter " +converter.base2To10(arr));
	
		System.out.println("sub " + calc.subtractBinaryNumber(101 ,  1101));
		
//		System.out.println(calc.multiplication(111, 1101));
		
		System.out.println("1's complement " +calc.onesCompliment(11010));
		Integer hej = 00011000;
		
		System.out.println(Long.toBinaryString(24));
		System.out.println(calc.onesCompliment(12));
		
		
		System.out.println("new base2to10 " +converter.base2To10New("1110"));
		
		//Her skal sign bitten ikke være med
//		String resultatBin =  us.SumTwosComplement("11101001", "01011100");
		
		//Den flipper negative tal
//		String resultatBin =  us.SumTwosComplement("10001100", "01000101");
		
		//Her skal sign bitten ikke være med 
		String resultatBin =  us.SumTwosComplement("01000101", "00001100");
		
//		
		//Giver 14 men det skulle være -7
		System.out.println("us SumTwosComplement minus: " + resultatBin);
		System.out.println("minus two's complement: " + us.twosComplement(resultatBin));
		
		//Burde heller ikke give negativt
		System.out.println("Test2: " + us.SumTwosComplement("10010110", "01101110"));
		System.out.println("00010110 som dec " +  converter.base2To10New("00010110"));
		System.out.println("Test2 som decimal " + converter.base2To10New(us.SumTwosComplement("10010110", "01101110")));
		
		
		//Giver 19 men skulle være 17 //Fixed: tallene skal være samme længde, 
//		System.out.println("us SumTwosComplement plus: " +
//				us.SumTwosComplement("00001100", "01000101"));
		
		
		
//		System.out.println("pus resultat som decimal " + converter.base2To10New(us.SumTwosComplement("00001100", "01000101")));
		//Hvornår skal jeg tage two's compelement af resultatet
		System.out.println("minus Resultat som decimal " +converter.base2To10New(resultatBin));
		
//		System.out.println("Usingstring add: " +us.addBinaryNumber("1110", "0101"));
		
		*/
		
		
		System.out.println("Utilities test: " + Utilities.format("10 01", "00101100")[0] +" "+ Utilities.format("1001", "001 01 100")[1]);
	}

}
 	