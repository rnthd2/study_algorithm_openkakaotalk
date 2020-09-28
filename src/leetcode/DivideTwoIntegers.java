package leetcode;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(10/3);
        System.out.println(7/-3);
        System.out.println(-2147483648/-1);
        System.out.println(-1/-1);
        System.out.println(divide(10, 3));
    }
    public static int divide(int dividend, int divisor) {
        if(Integer.MIN_VALUE == dividend && divisor == -1)
            return Integer.MAX_VALUE;
        return dividend/divisor;
    }
}
