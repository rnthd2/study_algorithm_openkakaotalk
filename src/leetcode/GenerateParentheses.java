package leetcode;

import java.util.ArrayList;
import java.util.List;

//모든 괄호 찾기
public class GenerateParentheses {
	public static void main(String[] args) {
		System.out.println(GenerateParentheses.generateParenthesis(2));
	}

	public static List<String> generateParenthesis(int n) {

		List<String> result = new ArrayList<>();
		if (n == 0)
			return result;

		char[] tempArr = new char[n * 2];

		generateParenthesisHelper(n, n, tempArr, 0, result);
		return result;
	}

	public static void generateParenthesisHelper(int left, int right, char[] tempArr, int index, List<String> result) {

		// Base Case
		if (left == 0 && right == 0) {
			result.add(new String(tempArr));
		} else {

			if (left > 0) {
				tempArr[index] = '(';
				generateParenthesisHelper(left - 1, right, tempArr, index + 1, result);
			}

			if (left < right) {
				tempArr[index] = ')';
				generateParenthesisHelper(left, right - 1, tempArr, index + 1, result);
			}
		}
	}
}
