
/**
 * 꼬리재귀 test
 *
 * stack frame : local 변수, argu, 반환 주소
 *
 */
public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(recursion(10));
        System.out.println(recursionTail(10, 1));

    }

    /**
     * 스택에 메모리가 쌓이는 재귀 함수 형식
     * 오버플로우가 발생 할 수 있다.
     * @param n
     * @return
     */
    private static int recursion(int n){
        if(n==1) return 1;
        return n + recursion(n-1);

    }

    /**
     * 꼬리 재귀 함수
     *
     * 반환 되는 값에서 추가 연산을 필요로 하지 않음
     * 반환 되는 값 자체를 반환한다.
     * @param n
     * @param m
     * @return
     */
    private static int recursionTail(int n, int m){
        if(n==1) return m;
        return recursionTail(n-1, m+n);
    }

}
