package calculator.Controller;
import calculator.Logic.BinCalculator;
import calculator.Storage.Storage;
import calculator.Logic.Base10And2Converter;


public class Controller {
	
	private BinCalculator calculator = new BinCalculator();
	private Base10And2Converter converter = new Base10And2Converter();
	private Storage storage = Storage.getInstance();
	
	public String add(long num1, long num2) {
		String calculation = calculator.addBinaryNumber(num1, num2);
		storage.addCalculation(calculation);
		return calculation;
	}
	
	public String subtract(long num1, long num2) {
		
		String calculation = calculator.subtractBinaryNumber(num1, num2);
		storage.addCalculation(calculation);
		return calculation;
		
	}
	
	public String multiply(long num1, long num2) {
		String calculation = calculator.multiplication(num1, num2);
		
		storage.addCalculation(calculation);
		return calculation;
	}
	
	public long convertBase2To10(String base2) {
		
		char[] tempArr = base2.toCharArray();
		
		long[] intArr = new long[tempArr.length];
		
		for(int i = 0; i<tempArr.length; i++) {
			
			intArr[i] = Character.getNumericValue(tempArr[i]);
		}
		
		
		return converter.base2To10(intArr);
	}
	
	public Storage getStorage() {
		return storage;
	}
	
	
	

}
