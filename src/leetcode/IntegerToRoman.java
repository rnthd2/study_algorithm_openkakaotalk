package leetcode;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class IntegerToRoman {


	public static void main(String[] args) {
		IntegerToRoman integerToRoman = new IntegerToRoman();
		//				System.out.println(integerToRoman.intToRoman(58));
		System.out.println(integerToRoman.intToRoman(4));
		//		System.out.println(integerToRoman.intToRoman(20));
		System.out.println(integerToRoman.intToRoman(1994));
	}



	enum Symbol {
		I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
		private final int value;

		Symbol(int value) {
			this.value = value;
		}
	}

	//exception 4 or 9
	public String getException(int num, int exp) {
		//if num is 40, and then return XL
		Symbol[] list = Symbol.values();
		for (int i = 0; i < list.length; i++) {
			if (list[i].value > num) {
				return (exp == 4) ?
						list[i - 1].name() + list[i].name() :
						list[i - 2].name() + list[i].name();
			}
		}
		return null;
	}

	public String intToRoman(int num) {
		Symbol[] symbols = Symbol.values();
		ArrayList<String> list = new ArrayList<>();

		int i = symbols.length - 1;
		while (num > 0 && i > 0) {
			// 1. int의 자릿수 구하기
			//			int length = (int) (Math.log10(num) + 1) - 1;
			//			int length = String.valueOf(num).length();
			// 2. 필요한값 구하기
			// 2-1. 가장 큰 자릿수의 값 가져오기 ex. 4999 -> 4000
			int max = (int) Math.pow(10, (int) (Math.log10(num) + 1) - 1);
			// 2-2. 4 or 9 만 체크하면 된다
			int check4or9 = num / max;
			// 3. 나머지가 4 or 9면 두개 합친걸로 대체한다
			if (check4or9 == 4 || check4or9 == 9) {
				list.add(getException(max * check4or9, check4or9));
				num -= max * check4or9;
			} else if (num / symbols[i].value > 0) {
				list.add(symbols[i].name());
				num -= symbols[i].value;
			} else {
				--i;
			}
			if (i == 0) {
				while (num > 0) {
					list.add(symbols[0].name());
					--num;
				}
			}
		}

		//String list to String
		return list.stream().map(str -> String.valueOf(str)).collect(Collectors.joining());
	}

}
