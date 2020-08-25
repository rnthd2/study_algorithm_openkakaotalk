package leetcode;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		LongestCommonPrefix prefix = new LongestCommonPrefix();
		System.out.println(prefix.longestCommonPrefix(new String[] { "a", "aa"}));
		System.out.println(prefix.longestCommonPrefix(new String[] { "aa","a" }));
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
			while(!strs[i].startsWith(result)){
				result = result.substring(0, result.length()-1);
			}
		}

		return result;
	}

}
