package stack.level.three;

import java.util.Arrays;

//todo {5,4,3,2,1} 의 내림차순일때 버그임...
public class StackLevelThree {

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			try {
				for (int j = 0; j < i; j++) {
					if (!(prices[i] < prices[j])) {
						++answer[j];
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] prices = { 5,4,3,2,1 };
		System.out.println("answer is " + Arrays.toString(solution(prices)));
	}
}
