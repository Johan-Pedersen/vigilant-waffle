package calculator.Logic;

import java.util.ArrayList;

public class Utilities {
	
	
	
	/**
	 * Omdanner en ArrayListe til en pæn string
	 * @param nums
	 * @return
	 */
	
	public static String stringyfi(ArrayList<Integer> nums) {
		
			String str = nums.toString();
			
			return str.substring(1, str.length()-1).replace(", ", "");
		}

	
	/**
	 * Sikre at inputtet har det rigtige format.
	 * 
	 * første input hentes fra index 0 og andet input henetes fra index 1
	 * 
	 * Skal kaldes som det første i alle metoder.
	 * 
	 * 
	 * @param num
	 * @return tuple
	 */
	public static String[] format(String BinInput1, String BinInput2) {
			
			String[] tuple = new String[2];
			
			ArrayList<Integer> result1= new ArrayList<Integer>();
			ArrayList<Integer> result2 = new ArrayList<Integer>();
			
			String num1 ="";
			String num2 ="";
			
			//Alle mellemrum bliver fjernet
			num1 = BinInput1.replaceAll(" ", "");
			num2 = BinInput2.replaceAll(" ", "");
			
			
			
			//Finder den absolutte difference mellem de 2 tal
			int absDif = Math.abs(num1.length()- num2.length());
			
			//Hvis tallene ikke er lige lange tilføjes 0'er foran signbit
			//på det mindste tal indtil de er samme længde
			
			if(absDif != 0) {
				
				//Man kører de 2 tal i gennem indtil tallene kun har deres sign-bit
				//Dette er for at få convertet dem om til ArrayList<Integer>, 
				//Så man kan sætte værdier ind på en et specefiket index.
				while(num1.length()> 1) {
					int n = Character.getNumericValue(num1.charAt(num1.length()-1));
					result1.add(0, n);
					num1 = num1.substring(0, num1.length()-1);
				}
				
				while( num2.length()> 1) {
					
					int n2 = Character.getNumericValue(num2.charAt(num2.length()-1));
					result2.add(0, n2);	
					num2 = num2.substring(0, num2.length()-1);
				}
				
				
				//Man tilføjer 0'er til det mindste tal
				while (result1.size()> result2.size()) {
					result2.add(0, 0);
				}
				
				while (result2.size()> result1.size()) {
					result1.add(0, 0);
				}
				
				//Tilføjer signbit på index 0 
				result1.add(0, Character.getNumericValue(num1.charAt(0)));
				result2.add(0, Character.getNumericValue(num2.charAt(0)));
				
				
				//omdanner ArrayListen til string og tilføjer og assigner det til num1 og num2
				num1 = stringyfi(result1);
				num2 = stringyfi(result2);
			}
			
			
			//Tilføjer værdierne til tuplen 
			tuple[0] = num1;
			tuple[1] = num2;

			return tuple;
		}
	
	
	/**
	 * Fjerner alle 0'erne, mellem signbit og den først
	 * MSB med værdien 1.
	 * 
	 * Skal kun kaldes når tallet skal skrives ud.
	 * @param num
	 * @return
	 */
	public static String removeLeadingZeros(String num) {
		int index = 1;
		for(; index<num.length(); index++) {
			
			//Når man møder det første tal af betydning,
			//skal man stoppe
			if(num.charAt(index) == '1') {
				break;
			}
		}
		
		//Tilføjer signbit til resten af tallet efter
		//man har lokaliseret det første 1 tal
		return num.charAt(0) + num.substring(index);
	}


}
