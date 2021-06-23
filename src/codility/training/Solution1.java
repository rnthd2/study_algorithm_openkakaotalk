package codility.training;

/**
 * Iterations
 *
 * BinaryGap
 * https://app.codility.com/programmers/lessons/1-iterations/
 *
 * 정수를 바이너리로 변환하여 1 사이의 가장 큰 거리를 반환한다.
 * 없으면 0을 반환한다.
 *
 * 1024의 정수는 10000010001로 변환되어 1000001 의 갭은 5, 10001의 갭은 3으로 5를 반환한다.
 * 11000 이나 0001은 0을 반환한다.
 *
 */
public class Solution1 {

    public static void main(String[] args) {
        solution(1041);
    }

    static int solution(int N) {
        //정수를 바이너리로 변환
        //1024 -> 10000010001로 변환
        String toBinaryString = Integer.toBinaryString(N);
        int result = 0;
        for (int i = 0, left = 0; i < toBinaryString.length(); i++) {
            if (toBinaryString.charAt(i) == '1') {
                result = Math.max(i - left -1, result);
                left = i;
            }
        }
        return result;
    }
}
