package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class IntegerToRoman {

	public static void main(String[] args) {
		IntegerToRoman integerToRoman = new IntegerToRoman();
		//				System.out.println(integerToRoman.intToRoman(58));
		System.out.println(integerToRoman.intToRoman(9));
		//		System.out.println(integerToRoman.intToRoman(20));
		System.out.println(integerToRoman.intToRoman(1994));
	}

	private static final ArrayList<String> symbols = new ArrayList(Arrays.asList("I", "V", "X", "L", "C", "D", "M", "", ""));

	public String getRoman(int num, int idx) {

		String idxStr = symbols.get(idx);
		String idxStr1 = symbols.get(idx+1);
		String idxStr2 = symbols.get(idx+2);

		switch (num) {
			case 4:
				return idxStr + idxStr1;
			case 5:
				return idxStr1;
			case 9:
				return idxStr + idxStr2;
			default: {
				String result = "";
				if (num < 9 && num > 5) {
					result += idxStr1;
					num-=5;
				}
				while (num-- > 0)
					result += idxStr;
				return result;
			}
		}
	}
	public String intToRoman(int num) {

		String result = "";
		// 가장 큰 자릿수의 값 가져오기 ex. 4999 -> 10^3 -> 3
		int idx = (int) (Math.log10(num) + 1) - 1;

		while(num > 0){
			result += getRoman(num/(int)Math.pow(10,idx), idx*2);
			//가장 큰 자릿수 값을 뺀 나머지 가져오기 ex. 4999 -> 999
			num %= (int) Math.pow(10, idx--);
		}

		return result;
	}
}
