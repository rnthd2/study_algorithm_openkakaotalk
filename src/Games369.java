import java.util.Scanner;

/**
 * 문제: 369게임. 숫자가 주어졋을때 박수를 몇번 쳐야되는지 출력하시오
 * 입력: 36
 * 출력: 2
 */
public class Games369 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int num = 0;
		for (int i = 0; i < str.length() ; i++) {
			int val = Integer.valueOf(str.charAt(i)+"");
			if (val == 3 || val == 6 || val == 9) {
				num++;
			}
		}
		System.out.println(num);
	}
}


