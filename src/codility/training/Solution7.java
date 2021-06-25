package codility.training;

/**
 * Prefix Sums
 *
 * CountDiv
 * https://app.codility.com/programmers/lessons/5-prefix_sums/
 *
 * 숫자 A 부터 숫자 B까지 정수 중에 K로 나눌 수 있는 수의 개수를 반환한다.
 */
public class Solution7 {
    public static void main(String[] args) {
        System.out.println(solution(6,11,2));
        System.out.println(solution(1,1,11));
        System.out.println(solution(11,345,17));
        System.out.println(solution(10,10,5));
        System.out.println(solution(0,Integer.MAX_VALUE,1));

    }

    static int solution(int A, int B, int K) {
        if(B < K && A == B) return 0;
        else if(B == K) return 1;
        else {
            int left = A / K;
            if(left == 0) left = 1;
            int right = B / K;
            return right - left + 1;
        }
//        int count = 0;
//        for (int i = A; i <= B; i++) {
//            if(i%K == 0)
//                count++;
//        }
//        return count;
    }
}
