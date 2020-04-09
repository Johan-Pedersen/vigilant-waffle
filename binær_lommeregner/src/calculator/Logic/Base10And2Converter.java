package calculator.Logic;


public class Base10And2Converter {
	public Base10And2Converter() {
		// TODO Auto-generated constructor stub
	}
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
	
	public long base2To10(long[] intArr) {
		
		       long ans = 0;
		       
		       for(int i = 0; i<intArr.length; i++) {
		    	   ans = (ans << 1) | intArr[i];
		       }
		return ans;
	}
	
}
