package data.structure.linear.two;

import data.structure.linear.BasicQueueFunction;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class QueueLevelTwo {

	private static final int LIMIT_NUM_MIN = 1;
	private static final double LIMIT_NUM_MAX = 2 * Math.pow(10, 9);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			int num = Integer.valueOf(sc.nextLine());
			if (num >= LIMIT_NUM_MIN && num <= LIMIT_NUM_MAX) {
				System.out.println(getPalindrome(num));
			} else {
				break;
			}
		}
	}

	// 회문 구하기
	static int getPalindrome(int num) {
		for (int i = LIMIT_NUM_MIN; i < LIMIT_NUM_MAX; i++) {
			ArrayList<Integer> palindromes = new ArrayList();
			if (i < 10) {
				palindromes.add(i);
			} else {
				String str = String.valueOf(i);
				BasicQueueFunction func = new BasicQueueFunction(str.length());
				for (int j = 0; j < str.length(); j++) {
					func.push(str.charAt(j));
				}
				if (func.front() == func.back()) {
					palindromes.add(i);
				}
			}
			if (palindromes.size() == num) {
				return palindromes.get(--num);
			}

		}
		return 0;
	}
}
