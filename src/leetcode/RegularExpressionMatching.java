package leetcode;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 */
public class RegularExpressionMatching {

	private static final char ANY_SINGLE_MATCH = '.';
	private static final char PRE_ELE_MATCH = '*';

	public static void main(String[] args) {
		RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
		System.out.println(regularExpressionMatching.isMatch("ControlPanel", "Co.[a-z]o.*P[a-z]*"));
		System.out.println(regularExpressionMatching.isMatch("aab", "c*a*b"));
		System.out.println(regularExpressionMatching.isMatch("aa", "a*"));
		System.out.println(regularExpressionMatching.isMatch("ab", ".*"));
		System.out.println(regularExpressionMatching.isMatch("mississippi", "mis*is*p*."));
		System.out.println(regularExpressionMatching.isMatch("mississippi", "mis*is*ip*."));

	}

	public boolean isMatch(String s, String p) {
		return s.matches(p);
	}
}
