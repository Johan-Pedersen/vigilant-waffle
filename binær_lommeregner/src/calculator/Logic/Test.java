package calculator.Logic;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinCalculator calc = new BinCalculator();
		
		Base10And2Converter converter = new Base10And2Converter();
		//System.out.println(calc.addBinaryNumber(1,111));
		
		long[] arr = {1,1,1,0};
		System.out.println(converter.base2To10(arr));
	
		//System.out.println(calc.subtractBinaryNumber(101 ,  1101));
		
		System.out.println(calc.multiplication(111, 1101));
		
		
	}

}
 	