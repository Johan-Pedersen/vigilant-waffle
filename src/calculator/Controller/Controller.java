package calculator.Controller;
import calculator.Logic.Base10And2Converter;
//import calculator.Logic.BinCalculator_old;
import calculator.Logic.BinCalculator;
import calculator.Storage.Storage;
import calculator.Logic.Utilities;

public class Controller {
	
	private BinCalculator calculator = new BinCalculator();
	private Base10And2Converter converter = new Base10And2Converter();
	private Storage storage = Storage.getInstance();
	
	public String Sum(String num1, String num2) {
		
		String[] formattetInput = Utilities.format(num1, num2);
		String calculation = calculator.SumTwosComplement(formattetInput[0], formattetInput[1]);
		storage.addCalculation(calculation);
		return Utilities.removeLeadingZeros(calculation);
	}
	
	/**
	public String subtract(String num1, String num2) {
		
		String calculation = calculator.SumTwosComplement(num1, num2);
		storage.addCalculation(calculation);
		return calculation;
		
	}
	*/
	public String multiply(String num1, String num2) {
		
		
		String[] formattetInput = Utilities.format(num1, num2);
		String calculation = calculator.multiplication(formattetInput[0], formattetInput[1]);
		
		storage.addCalculation(calculation);
		return Utilities.removeLeadingZeros(calculation);
	}
	
	
	public String divide(String divident, String divisor) {
		
		
		String[] formattetInput = Utilities.format(divident, divisor);
		String calculation = calculator.division(formattetInput[0], formattetInput[1]);
		
		storage.addCalculation(calculation);
		return Utilities.removeLeadingZeros(calculation);
	}
	
	
	public Storage getStorage() {
		return storage;
	}
	
	public long convertBase2To10(String num) {
		return converter.base2To10(num);
	
	}
	
	
	

}
