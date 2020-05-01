package calculator.Logic;

import java.util.ArrayList;
import calculator.Logic.Base10And2Converter;
import calculator.Logic.Utilities;

public class BinCalculator {
	
	
	
	
	/**
	 * Lægger 2 binære tal sammen. 
	 * Hvis et af tallene er negative, skal dette tal converetes via 2's complement.
	 * inden man kalder denne metode på det. 
	 * @param firstNum
	 * @param secondNum
	 * @return
	 */
	
	private String addBinaryNumber(String firstNum, String secondNum) {
 		String first = firstNum, second = secondNum;
		
		int carry = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		
		while(first.length() >1 && second.length()>1) {
		
			//Omdanner sidste bit til int, så man kan lave matematik operationer på dem
			int numericVal1 =  Character.getNumericValue(first.charAt(first.length()-1));
			int numericVal2 =  Character.getNumericValue(second.charAt(second.length()-1));
			
			//lægger de 2 bits sammen plus menten fra forgående udregning og tager mod 2 af dette
			//da man på den måde finder resultatet for udregningen
			
			int temp = (numericVal1 + numericVal2 + carry) %2;
	
			//udregning af eventuel mente 
			carry = (numericVal1 + numericVal2 + carry) /2;
			
			result.add(0,temp);
			
			//fjerner den sidste bit fra hver tal
			first = first.substring(0, first.length()-1);
			second = second.substring(0, second.length()-1);
			}
		
		//Hvis der er et sidste tal i menete, lægges dette til
		if(carry != 0) {
			result.add(0, carry);
			
			carry = 0;
		}
		
		// tilføjer den sidste carry Lav addition for signbit
		//i first og second, så når tallene er lige lange går 
//		det rigtigt og når man bare skal lægge 1 til et tal som 
//		i twos complement
		
		//Omdanner sidste bit til int, så man kan lave matematik operationer på dem
		int numericVal1 =  Character.getNumericValue(first.charAt(first.length()-1));
		int numericVal2 =  Character.getNumericValue(second.charAt(second.length()-1));
		
		int temp = (numericVal1 + numericVal2 + carry) %2;
		
		//udregning af eventuel mente 
		carry = (numericVal1 + numericVal2 + carry) /2;
		
		result.add(0,temp);
		
		//fjerner den sidste bit fra hver tal
		first = first.substring(0, first.length()-1);
		second = second.substring(0, second.length()-1);
	
	//Hvis der er et sidste tal i menete, lægges dette til
	if(carry != 0) {
		result.add(0, carry);
//		first = addBinaryNumber(first, ""+carry);
			
	}
		
		//Hvis der stadig er tal tilbage i første nummer, tilføjes de resterende
		while(first.length() >0) {
			int numericVal =  Character.getNumericValue(first.charAt(first.length()-1));
			result.add(0,numericVal);
			 first = first.substring(0, first.length()-1);
				 
		}
		
		//Hvis der er tal tilbage i andet nummer, tilføjes de resterende
		while(second.length() >0) {
			int numericVal =  Character.getNumericValue(second.charAt(second.length()-1));
			result.add(0,numericVal);
			 second = second.substring(0, second.length()-1);
				 
		}
		
		
		//Pæn udskrift af arraylisten
		return Utilities.stringyfi(result);
	}
	
	/**
	 * Summere 2 binære tal. Input kan både være positivt og negativt. 
	 * Første char i fistNum og SecondNum er signbit
	 * 
	 * Længden af inputtet skal være ligmed eller længerer end
	 * længden af outputtet.
	 * @param firstNum
	 * @param secondNum
	 * @return
	 */
	public String SumTwosComplement(String firstNum, String secondNum) {
		Base10And2Converter converter = new Base10And2Converter();
		String first = firstNum, second = secondNum, addedResult;
		boolean isNegativ = false, needShortening = false;
		
		
		//Tjekker om input er negativt, hvis ja, så tages 2's complement af dette tal
		if(first.charAt(0) == '1') {

			first = twosComplement(first);
			
			//Tjekker om resultatet bliver negativt
			if(Math.abs(converter.base2To10(firstNum))> Math.abs(converter.base2To10(secondNum))) {
				isNegativ = true;
			}else if (secondNum.charAt(0) == '0' && Math.abs(converter.base2To10(firstNum))< Math.abs(converter.base2To10(secondNum)) ){
				
				//Hvis second tal er negativt og er absolut set mindre
				needShortening = true;
			}
		}
		
		if(second.charAt(0) == '1') {
			
			second = twosComplement(second);
			
			if(Math.abs(converter.base2To10(firstNum))<= Math.abs(converter.base2To10(secondNum))) {
				isNegativ = true;
			}else if (firstNum.charAt(0) == '0' && Math.abs(converter.base2To10(firstNum))> Math.abs(converter.base2To10(secondNum)) ){
				
				//Hvis second tal er negativt og er absolut set mindre
				needShortening = true;
			}
			
		}
		
		
		//Lægger de 2 tal sammen.
		addedResult = addBinaryNumber(first, second);
		
		
		
		//Hvis resultatet er negativt tages 2's complement af resultatet,
		//for at konvertere det fra 2's complement form og til normal binær form
		
		if(needShortening) {
			addedResult = addedResult.replaceFirst("01", "0");
		}
		if(isNegativ) {
			return twosComplement(addedResult);
		}
		return addedResult;
			
		}
	
	
	/**
	 * Flipper alle bit i tallet.
	 * 0 => 1
	 * 1 => 0
	 * @param num
	 * @return
	 */
	private String onesComplement(String num) {
		ArrayList<Integer> result = new ArrayList<>();
		
		String temp = num;
		int bit = 0;
		while (temp.length() > 0) {
			bit = Character.getNumericValue(temp.charAt(temp.length()-1));
			if (bit == 1) {
				result.add(0, 0);
			}else {
				result.add(0, 1);
			}
			
			temp = temp.substring(0, temp.length()-1);
			
		}
		
		return Utilities.stringyfi(result);
	}
	
	
	/**
	 * Tager 2's complement af tallet ved at tage 1's complement og lægge 1 til
	 * 	
	 * @param num
	 * @return
	 */
	public String twosComplement(String num) {
		return addBinaryNumber(onesComplement(num), Utilities.format(num, "01")[1]);
	}
	
	
	/**
	 * multiplicere 2 binære tal sammen
	 * @param firstNum
	 * @param secondNum
	 * @return
	 */
	public String multiplication(String firstNum, String secondNum) {
		
		ArrayList<Integer> subResults = new ArrayList<Integer>();
		String result ="0";
		String first = firstNum, second = secondNum;
		//Tæller hvor mange 0'er der skal bag på subResults
		int count = 0;
		int temp1 = 0;
		int temp2 = 0;
		
		
		//Sammenligner hvert tal i second med hvert tal i first.
		
		while(second.length()> 1) {	
			temp2 = Character.getNumericValue(second.charAt(second.length()-1));
			first = firstNum;
			
			while(first.length()>1) {
				temp1 = Character.getNumericValue(first.charAt(first.length()-1));
				subResults.add(0, temp1&temp2);
				first = first.substring(0, first.length()-1);	
			}
			
			//Tilføjer 0'er til subresultaet
			for(int i = 0; i<count; i++){	
				subResults.add(0);
			}
			
			//Lægger resultatet sammen med subresultatet.
			result = addBinaryNumber(result, Utilities.stringyfi(subResults));
			count++;
			second = second.substring(0, second.length()-1);
			subResults = new ArrayList<Integer>();
			}
		
		//tilføjer sign bit
		temp2 = Character.getNumericValue(second.charAt(second.length()-1));
		temp1 = Character.getNumericValue(first.charAt(first.length()-1));
		
		// ^ == XOR
		return (temp1^temp2) +""+ result;
			
		}
}
