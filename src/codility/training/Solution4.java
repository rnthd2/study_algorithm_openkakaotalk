package codility.training;

/**
 * Time Complexity
 *
 * FrogJmp
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 *
 * 개구리가 앞으로 뛰어야 되는 횟수를 반환한다.
 * X : 개구리가 이미 뛴 거리
 * Y : 개구리가 앞으로 뛸 거리
 * D : 개구리가 한 번 뛰는데 가는 거리
 * X = 10, Y = 85, D = 30
 */
public class Solution4 {
    public static void main(String[] args) {
        int X = 10;
        int Y = 75;
        int D = 30;
        System.out.println(solution(X, Y, D));
    }
    static int solution(int X, int Y, int D) {
        int count = (Y - X) / D;
        return (Y - X) % D == 0? count : count+1;
    }
}
