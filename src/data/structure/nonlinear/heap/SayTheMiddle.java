package data.structure.nonlinear.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SayTheMiddle {
	public static void main(String[] args) {
		int N = 7; //1<=N<=100000
		//		int[] numbers = {1,5,2,10,-99,7,5};
		ArrayList<Integer> numbers = new ArrayList();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext() && numbers.size() < N) {
			numbers.add(Integer.valueOf(sc.next()));
			System.out.println(solution(N, numbers));
		}
	}

	static int solution(int N, ArrayList<Integer> numbers) {
		int middle;
		Collections.sort(numbers, (num1, num2) -> num1 > num2 ? 1 : -1);

		if(numbers.size()%2==0){
			//짝수면 size%2==0
			if (numbers.size() > 1) {
				middle = numbers.get(numbers.size()/2);
			} else {
				middle = numbers.get(0);
			}
		} else {
			//홀수면 size%2!=0
			if (numbers.size() > 1) {
				middle = numbers.get(numbers.size()/2);
			} else {
				middle = numbers.get(0);
			}
		}



//		getMiddle(numbers, size -> size%2==0);
		return middle;

	}
//	static int getMiddle(ArrayList<Integer> numbers, Predicate<Integer> filter){
//		if(filter.test())
//	}
}
