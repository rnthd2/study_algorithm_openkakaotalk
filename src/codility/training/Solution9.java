package codility.training;

import java.util.Arrays;

/**
 * Sorting
 *
 * NumberOfDiscIntersections
 * https://app.codility.com/programmers/lessons/6-sorting/
 *
 * https://darkstart.tistory.com/195
 *
 * J번째 원과 K번째의 원이 겹치는 개수 가져오기
 * J번째 원은 배열 A 에서 인덱스 (J,0)에 위치해 있고
 * A[J] = 안에 값은 J번째 원의 반지름이다
 */
public class Solution9 {


    public static void main(String[] args) {
        int[] A = {1, 5, 2, 1, 4, 0};
        System.out.println(solution(A));
    }

    /*
        The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [0..2,147,483,647].
     */
    static int solution(int[] A)
    {
        int N = A.length;
        long[] lower = new long[N];
        long[] upper = new long[N];

        for (int i = 0; i < N; i++) {
            lower[i] = i - (long) A[i];
            upper[i] = i + (long) A[i];
        }

        Arrays.sort(lower);
        Arrays.sort(upper);

        int intersection = 0;
        int j = 0;

        for (int i = 0; i < N; i++) {
            while (j < N && upper[i] >= lower[j]) {
                intersection += j;
                intersection -= i;
                j++;
            }
        }

        if (intersection > 10000000) return -1;
        return intersection;
    }
    static int solution1(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                //from i-A[i] to i+A[i]
                //from j-A[j] to j+A[j]
                if(j-i <= A[i] + A[j]){
                    count++;
                }
            }
        }
        if (count > 10000000) return -1;
        return count;
    }

}
