package leetcode;

// prefix 가져오기

// 문자열 비교시에는
// 첫 번째 문자열을 기준으로 문자를 하나씩 줄여가는 방법을 사용하는게
// StringIndexOutOfBoundsException을 일으키지 않는데 유용하다

public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix prefix = new LongestCommonPrefix();
		System.out.println(prefix.longestCommonPrefix(new String[] { "a", "aa" }));
		System.out.println(prefix.longestCommonPrefix(new String[] { "aa", "a" }));
		System.out.println(prefix.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		System.out.println(prefix.longestCommonPrefix(new String[] {}));
		System.out.println(prefix.longestCommonPrefix(new String[] { "a" }));
	}

	public String longestCommonPrefix(String[] strs) {
		String result;
		if (strs.length > 0)
			result = strs[0];
		else
			return "";

		for (int i = 1; i < strs.length; i++) {
			while (!strs[i].startsWith(result)) {
				result = result.substring(0, result.length() - 1);
			}
		}

		return result;
	}

}
