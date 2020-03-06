package calculator;

public class BinCalculator{
	
	//Alle metoder tager binære tal som metode.
	
	/**
	 * Addition methode
	 * @param firstNum
	 * @param secondNum
	 * @return
	 */
	public static String addBinaryNumber(int firstNum, int secondNum) {
		StringBuilder sb = new StringBuilder();
		
		int carry = 0;
		while (firstNum != 0 || secondNum != 0) {
			int temp = (firstNum%10 + secondNum %10 + carry)%2;
			
		
			carry = (firstNum%10 + secondNum %10 + carry)/2;
			
			firstNum /= 10;
			secondNum /= 10;
			sb.append(temp);
		}
		
		sb.append(carry);
		return sb.reverse().toString();		
	}
	
	/**
	 * subtraction methode
	 * @param firstNum
	 * @param secondNum
	 * @return
	 */
	public static String subtractBinaryNumber(int firstNum, int secondNum) {
		StringBuilder sb = new StringBuilder();
		
		while(firstNum != 0 || secondNum != 0) {
			
			
			//Er det nødvendigt at have Math.abs() 
			int temp = Math.abs((firstNum % 10 - secondNum%10) %2);
		
				
			if(secondNum%10 == 0 && firstNum%10 == 1) {
				secondNum = BinCalculator.onesCompliment(secondNum);
			}
			
			firstNum /=10;
			secondNum /= 10;
			
			sb.append(temp);
		}
		
		return sb.reverse().toString();
	}
	
	/**
	 * One's compliment flipper 1'ere til 0'ere og omvendt.
	 * Bliver brugt til subtraction
	 * @param num
	 * @return
	 */
	private static int onesCompliment(int num) {
		StringBuilder sb = new StringBuilder();
		
		boolean done = false;
		while(!done) {
			
			if(num % 10 == 1) {
				sb.append(0);
				
				done = true;
				
			}else {
				sb.append(1);
			}
			
			num /= 10;
		}
		
		while(num != 0) {
			if(num % 10 == 1) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			
			num /= 10;
		}
		
		
		return Integer.valueOf(sb.reverse().toString());
	}
	
	/**
	 * multiplication, fistNum skal være det største tal
	 * @param firstNum
	 * @param secondNum
	 * @return
	 */
	
	public static String multiplication(int firstNum, int secondNum) {
		StringBuilder sb = new StringBuilder();
		int total = 0;		
		int temp2 = secondNum;
		StringBuilder zeros = new StringBuilder();
		int count = 0;
		
		zeros.append(0);
		int addition = 0;
		
		while(temp2 != 0) {
			int temp1 = firstNum;

			
			while (temp1 != 0) {
				
				sb.append(temp2%10 & temp1%10);
				
				temp1 /= 10;
			}
			
			//Når første tal er 0 bliver total ikke talt op. Og der bliver derfor ikke tilføjet 0'er
			sb.reverse();
			if(count > 0) {
				
				sb.append(zeros);
				
				zeros.append(0);
			}
			addition =  Integer.valueOf(sb.toString()); 
			
			total = Integer.valueOf(addBinaryNumber(total,addition));
			sb = new StringBuilder();
			temp2 /=10;
			count++;
		}
		return Integer.toString(total);
	}
	
	public static String division() {
		StringBuilder sb  = new StringBuilder();
		
		
		
		return sb.toString();
		
	}
	
}

