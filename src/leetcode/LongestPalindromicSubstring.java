package leetcode;

import java.util.HashMap;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
		String result1 = longestPalindromicSubstring.longestPalindrome("babad");
		String result2 = longestPalindromicSubstring.longestPalindrome("a");
		String result3 = longestPalindromicSubstring.longestPalindrome("");
		String result4 = longestPalindromicSubstring.longestPalindrome("ccc");
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}

	public String longestPalindrome(String s) {
		if(s.length()<1) return "";
		HashMap<Character, Integer> map = new HashMap();
		int start=0, end=0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)){
				if(i-map.get(c) > end-start){
					start = map.get(c);
					end = i;
				}
			} else {
				map.put(c, i);
			}
		}

		return s.substring(start, end+1);
	}
}
