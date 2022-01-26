package calculator.Logic;
import java.util.ArrayList;


public class Base10And2Converter {
	public Base10And2Converter() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	Gammel
	public long[] base10to2(long base10) {
		// TODO Auto-generated method 
		
		long[] arr = new long[(int) ((Math.log(base10) / Math.log(2))+1)];
		int i = arr.length-1;
		while(base10 > 0) {
			arr[i] = base10%2;
			
			base10 /= 2;
			
			i--;
		}
		
		return arr;
	}
	*/
	
	
	
	/**
	 * Konverterer et base 10 tal til base 2
	 * @param num
	 * @return
	 */
public String base10To2(String num) {
	
	ArrayList<Long> result = new ArrayList<Long>();
	long base10 = 0;
		
	if(num.charAt(0) == '-') {
	    base10 = Long.parseLong(num.substring(1));
	}else {
	    base10 = Long.parseLong(num);
	}
	
	if(base10 == 0) return "00";
	
	while(base10> 0) {
		 result.add(0,base10%2);
		 
		 base10 /=2;
		 
	}
	String str = result.toString();
	
	if(num.charAt(0)=='-') {
	    return "1"+str.substring(1, str.length()-1).replace(", ", "");
	}else
	    return "0"+str.substring(1, str.length()-1).replace(", ", "");
	}




/*
 * Gammel
 * 
 * Ingen grund til at converterer til string, da dette potentielt er overflødigt 
 * hvis der skal laves operationer på det (Men jeg tvivler på det)(Bare for god kode stil)	
 * @param intArr
 * @return
 
	public long base2To10(int[] intArr) {
		
		       long ans = 0;
		       
		       
		       //Man skal ikke konverterer sign bitten
		       for(int i = 1; i<intArr.length; i++) {
		    	   
		    	   //Man skal se på tallene repæsenteret som binære tal
		    	   //Når man siger "or" mellem 2 tal, kigger man individuelt på hver bit.
		    	   ans = (ans << 1) | intArr[i];
		       }
		       
		       //Hvis sign bit'en er "1" betyder det at resultatet skal være negativt
		       	if(intArr[0] == 1) {
		       		
		       		ans *= -1;
		       	}
		       
		return ans;
	}
	*/

	/**
	 * Konverterer base 2 tal til base 10  
	 * @param num
	 * @return
	 */
	public long base2To10(String num) {
		long ans = 0;

		for(int i = 1; i<num.length(); i++) {
	    	   
	    	   //Man skal se på tallene repæsenteret som binære tal
	    	   //Når man siger "or" mellem 2 tal, kigger man individuelt på hver bit.
	    	   ans = (ans << 1) |  Character.getNumericValue(num.charAt(i));
	       }
		
		if(num.charAt(0) =='1') {
			ans*=-1;
		}
	       
	return ans;
	}
	
}
