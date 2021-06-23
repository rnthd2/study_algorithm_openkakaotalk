package codility.training;

import java.util.Arrays;

/**
 * Array
 *
 * OddOccurrencesInArray
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 *
 * 홀수길이의 배열에서 짝이 없는 요소를 반환한다.
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * return 7;
 */
public class Solution3 {


    public static void main(String[] args) {
        int[] A = {9,3,9,3,9,10,9};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {

        Arrays.sort(A);

        for (int i = 0; i < A.length-1; i+=2) {
            if(A[i] != A[i+1]){
                return A[i];
            }
        }
        return A[A.length-1];
    }
}
