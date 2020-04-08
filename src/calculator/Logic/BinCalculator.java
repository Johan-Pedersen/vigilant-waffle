package calculator.Logic;

public class BinCalculator{
	
	/**
	 * Addition methode
	 * @param firstNum
	 * @param secondNum
	 * @return
	 */
	public String addBinaryNumber(long firstNum, long secondNum) {
		StringBuilder sb = new StringBuilder();
		
		long first = firstNum, second = secondNum;
		
		long carry = 0;
		while (first != 0 || second != 0) {
			long temp = (first%10 + second %10 + carry)%2;
		
			carry = (first%10 + second %10 + carry)/2;
			
			first /= 10;
			second /= 10;
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
	public String subtractBinaryNumber(long firstNum, long secondNum) {
		
		long first = firstNum, second = secondNum;
		StringBuilder sb = new StringBuilder();
		if (first > second) {
			long temp = first;
			first = second;
			second = temp;
			
		}
		while(first != 0 || second != 0) {
			long temp = Math.abs((first % 10 - second%10) %2);
		
			if(second%10 == 0 && first%10 == 1) {
				second = onesCompliment(second);
			}
			
			first /=10;
			second /= 10;
			
			sb.append(temp);
		}
		
		if(firstNum > secondNum) {
			sb.append("-");
		}
		
		return sb.reverse().toString();
	}
	
	/**
	 * One's compliment flipper 1'ere til 0'ere og omvendt.
	 * Bliver brugt til subtraction
	 * @param num
	 * @return
	 */
	private Long onesCompliment(long num) {
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
		
		
		return Long.valueOf(sb.reverse().toString());
	}
	
	/**
	 * multiplication, fistNum skal være det største tal
	 * @param firstNum
	 * @param secondNum
	 * @return
	 */
	
	public String multiplication(long firstNum, long secondNum) {
 		StringBuilder sb = new StringBuilder();
 		long first = firstNum, second = secondNum;
 		
 		//Måden det bliver regnet ud på skal det første tal være størst, 
 		//og da rækkefølgen er ligegyldig når man ganger, kan man bare bytte om på dem
 		if(firstNum < secondNum) {
 			first = secondNum;
 			second = first;
 		}
 		
 		long total = 0;		
		StringBuilder zeros = new StringBuilder();
		long count = 0;
		
		zeros.append(0);
		long addition = 0;
		
		while(second != 0) {
			long temp = first;

			
			while (temp != 0) {
				
				sb.append(second%10 & temp%10);
				
				temp /= 10;
			}
			
			//Når second%10 == 0, behøver man ikke tjekke da det altid bliver 0
			//Når første tal er 0 bliver total ikke talt op. Og der bliver derfor ikke tilføjet 0'er
			sb.reverse();
			if(count > 0) {
				
				sb.append(zeros);
				
				zeros.append(0);
			}
			addition =  Integer.parseUnsignedInt(sb.toString()); 
			
			total = Integer.parseUnsignedInt(addBinaryNumber(total,addition));
			sb = new StringBuilder();
			second /=10;
			count++;
		}
		return Long.toString(total);
	}
	
	
	public String division(long firstNum, long secondNum) {
		
		//https://byjus.com/maths/binary-division/
		//https://www.calculator.net/binary-calculator.html?number1=10101010&c2op=-&number2=11001100&calctype=op&x=51&y=18
		
		return null;
	}
	
}

