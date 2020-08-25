package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static void main(String[] args) {
		RomanToInteger romanToInteger = new RomanToInteger();
		System.out.println(romanToInteger.romanToInt("MCMXCIV"));
		System.out.println(romanToInteger.romanToInt("IX"));
	}

	private static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
		put('I', 1);
		put('V', 5);
		put('X', 10);
		put('L', 50);
		put('C', 100);
		put('D', 500);
		put('M', 1000);
	}};

	public int romanToInt(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			int x = map.get(s.charAt(i));
			int y = i+1 < s.length()? map.get(s.charAt(i+1)) : -1;

			if(x >= y ){
				result += x;
			}
			// 4 or 9
			else {
				result += y-x;
				i++;
			}
		}
		return result;
	}
}
