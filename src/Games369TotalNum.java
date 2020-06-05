/**
 * 문제 설명
 * 여러 사람이 둘러 앉아 즐기는 369 게임은 다음 과 같은 규칙을 가지고 있다.
 * <p>
 * 규칙:
 * <p>
 * 양의 정수 A에서 시작하여 차례로 사람들 이 돌아가면서 숫자를 하나씩 증가하면서 불러 나 간다.
 * <p>
 * 단, 부르는 숫자가 3의 배수이거나 그 숫자 에 3,6,9중 하나라도 들어 있는 경우에 숫자는 부르지 않고 박수를 친다.
 * <p>
 * 예를 들어, 369 게임을 17부터 시작하는 경우를 생각해보자. 박수를 X로 표현하면,
 * <p>
 * 이 게임의 진 행은 17-X-X-20-X-22-X-X-25–X–X-28-X-X …과 같을 것이다.
 * <p>
 * 시작하는 양의 정수 A와 끝나는 양의 정수 B가 주어졌을 때, 박수를 치는 총 횟수를 구하는 프로 그램을 작성하시오.
 * <p>
 * 입력
 * 한 줄에 시 작하는 양의 정수 A와 끝나는 양의 정수 B가 순 서대로 주어진다.
 * <p>
 * 두 수의 범위는 1≤A≤B≤10의 100,000이다.
 * <p>
 * 출력
 * 박수치는 총 횟수를 20,150,523으로 나눈 나머지를 출력한 다.
 *
 * https://www.acmicpc.net/problem/10802
 */

import java.util.Scanner;

public class Games369TotalNum {
	static int num =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] in = str.split(" ");
		int start = Integer.valueOf(in[0]);
		int end = Integer.valueOf(in[1]);


		for (int i = start; i <= end; i++) {
			//i가 3의 배수인지 확인
			if (!digits(i) && i % 3 == 0) {
				num++;
			}
		}

		System.out.println(num);
	}

	//i의 각 자리수에 3,6,9가 포함되어있는지 확인
	static boolean digits(int i){
		String str = String.valueOf(i);
		boolean result = false;
		for (int j = 0; j < str.length(); j++) {
			int k = Integer.valueOf(str.charAt(j)+"");
			if (k == 3 || k == 6 || k == 9) {
				num++;
				result = true;
			}
		}
		return result;
	}
}
