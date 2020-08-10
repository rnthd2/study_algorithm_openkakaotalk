package leetcode;

public class ReverseInteger {
	public static void main(String[] args) {
		ReverseInteger reverseInteger = new ReverseInteger();
//		System.out.println(reverseInteger.reverse(123));
		System.out.println(reverseInteger.reverse(-123));
		System.out.println(reverseInteger.reverse(1534236469));

	}

	public int reverse(int x) {
		int result=0;
		boolean negative = false;
		if(x < 0){
			negative=true;
			x*=-1;
		}
		while (x>0) {
			if(Integer.MAX_VALUE/10<result) return 0;
			result = result * 10;
			result = result + (x%10);
			x/=10;
		}
		return negative==true? result*-1 : result;
	}
}
