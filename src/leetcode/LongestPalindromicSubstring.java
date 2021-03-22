package leetcode;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
		String result1 = longestPalindromicSubstring.longestPalindrome("babad");
		System.out.println(result1);
		String result2 = longestPalindromicSubstring.longestPalindrome("a");
		System.out.println(result2);
		String result3 = longestPalindromicSubstring.longestPalindrome("");
		System.out.println(result3);
		String result4 = longestPalindromicSubstring.longestPalindrome("abb");
		System.out.println(result4);
				String result5 = longestPalindromicSubstring.longestPalindrome("ab");
				System.out.println(result5);
				String result6 = longestPalindromicSubstring.longestPalindrome("CCC");
				System.out.println(result6);
				String result7 = longestPalindromicSubstring.longestPalindrome("babadada");
				System.out.println(result7);

	}

	public String longestPalindrome(String s) {
		int length=0;
		int begin=0;
		for (int start = 0; start < s.length(); start++) {
			for (int end = s.length()-1; end >=start; end--) {
				boolean isPalindrome = true;
				int left = start, right = end;
				//회문 확인
				while (left < right) {
					if (s.charAt(left) != s.charAt(right)) {
						isPalindrome = false;
						break;
					} else {
						++left;
						--right;
					}
				}
				if (isPalindrome && length <= end-start) {
					length = end-start+1;
					begin = start;
				}
				//max값 즉시 리턴
				if(length == s.length()){
					return s.substring(start, s.length());
				}
			}
		}
		return s.substring(begin, begin+length);
	}

}
