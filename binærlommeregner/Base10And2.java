package baseConverter;


public class Base10And2 {
	public Base10And2() {
		// TODO Auto-generated constructor stub
	}
	public static int[] base10to2(int base10) {
		// TODO Auto-generated method 
		
		int[] arr = new int[(int)(Math.log(base10) / Math.log(2))+1];
		int i = arr.length-1;
		while(base10 > 0) {
			arr[i] = base10%2;
			
			base10 /= 2;
			
			i--;
		}
		
		return arr;
	}
	
	public static int base2To10(int[] base2) {
		
		       int ans = 0;
		       
		       for(int i = 0; i<base2.length; i++) {
		    	   ans = (ans << 1) | base2[i];
		       }
		return ans;
	}
}
