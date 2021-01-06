package leetcode;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,3));
    }

    /**
     * 조합 순열 알고리즘
     *
     * asis is aab
     * tobe is aab, aba, baa
     * 이라면, 총 3개에 중복이 2개니까 3!/2!이다.
     *
     * asis is aabb
     * tobe is aabb, bbaa, abab, baba, abba, baab
     * 이라면, 총 4개에 중복이 2개, 2개니까 4!/2!2!이다.
     *
     * double to int
     *
     * 1. d를 Math.round로 반올림 시킨다
     * 2. 반올림 된 d를 string 값으로 변환시킨다.
     * 3. Integer.parseInt(String값) 에서 괄호안에 2번을 넣어준다.
     *
     * @param m
     * @param n
     * @return
     */
    static int uniquePaths(int m, int n) {
        int down_count = m-1;
        int right_count = n-1;


        double d = factorial(down_count + right_count)
                / (factorial(down_count) * factorial(right_count));

        return Integer.parseInt(String.valueOf(Math.round(d)));
    }

    /**
     * 팩토리얼
     *
     * @param n
     * @return
     */
    static double factorial(int n) {
        if(n == 0) {
            return 1;
        } else if(n <= 1) {
            return n;
        } else {
            return factorial(n-1)*n;
        }
    }


}
