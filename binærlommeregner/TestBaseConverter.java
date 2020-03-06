package baseConverter;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Base10And2 test1 = new Base10And2();
		System.out.println(Arrays.toString(test1.base10to2(24)));
		int[] h = {1,1,1,0,1,0};
		
		System.out.println(test1.base2To10(h));
	}

}
