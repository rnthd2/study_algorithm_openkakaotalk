package codility.training;

import java.util.HashMap;

/**
 * Prefix Sums
 * <p>
 * GenomicRangeQuery
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 *
 * 주어진 문자열에서
 * 배열 P와 Q의 N 번째 값 sub list 를 나타낸다.
 * P[N] = 0 , Q[N] = 3, 주어진 문자열.subList(0,3);
 * sublist에서 nucleotides(ACGT)과 비교하여 가장 작은 수의 배열을 구하시오.
 * sublist 가 "GCT" 라면 가장 작은 수는 "C"에 해당되는 2이다.
 */
public class Solution8 {
    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = {2,5,0};
        int[] Q = {4,5,6};
        System.out.println(solution(S, P, Q));
    }
    static final HashMap<Character, Integer> nucleotides = new HashMap(){
        {
            put('A', 1);
            put('C', 2);
            put('G', 3);
            put('T', 4);
        }
    };
    static int[] solution(String S, int[] P, int[] Q) {

        int M = P.length;
        int[] result = new int[M];

        for (int i = 0; i < M; i++) {
            int min = nucleotides.size();
            for (int j = P[i]; j <= Q[i]; j++) {
                int positions = nucleotides.get(S.charAt(j));
                min = (min <= positions) ? min : positions;
            }
            result[i] = min;
        }
        return result;
    }

}
