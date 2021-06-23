package codility.training;

import java.util.Arrays;

/**
 * Counting Elements
 *
 * MaxCounters
 * https://app.codility.com/programmers/lessons/4-counting_elements/
 *
 * 비어있지않은 A 배열에 값은 채워져야 할 인덱스이다.
 * 값이 N이상이면 채워진 배열에서 가장 큰 수로 배열을 모두 채운다.
 *
 * N = 5 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 *
 * (0, 0, 1, 0, 0)
 * (0, 0, 1, 1, 0)
 * (0, 0, 1, 2, 0)
 * (2, 2, 2, 2, 2)
 * (3, 2, 2, 2, 2)
 * (3, 2, 2, 3, 2)
 * (3, 2, 2, 4, 2)
 *
 * 완성도 : 77%
 */
public class Solution5 {

    public static void main(String[] args) {
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 6, 4};
        System.out.println(solution(N, A));
    }

    static int[] solution(int N, int[] A) {
        int[] B = new int[N];
        int max = 0;
        for (int a : A) {
            if (a <= N) {
                max = Math.max(max, ++B[a-1]);
            } else
                Arrays.fill(B, max);
        }
        return B;
    }
}
