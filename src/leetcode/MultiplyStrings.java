package leetcode;

public class MultiplyStrings {
    public static void main(String[] args) {
//        System.out.println(multiply("3" ,"6"));
//        System.out.println(multiply("123", "456"));
//        System.out.println(multiply("9" ,"99"));
//        System.out.println(multiply("99" ,"9"));
        System.out.println(multiply("9133", "0"));
    }

    //두 수의 곱
    public static String multiply(String num1, String num2) {
        return mutiply_every_digit(num1, num2, num1.length() - 1, num2.length() - 1, 0, new String("0"));
    }

    static String mutiply_every_digit(String num1, String num2, int c1, int c2, int squared, String result) {
        if (c1 < 0 || c2 < 0 || num1.equals("0") || num2.equals("0")) {
            return result;
        } else {
            String value = String.valueOf((num1.toCharArray()[c1] - '0') * (num2.toCharArray()[c2] - '0'));
            for (int i = 0; i < squared; i++) {
                value+='0';
            }
            result = addStrings(result, value);

            if (c1 < 1) {
                return mutiply_every_digit(num1, num2, num1.length() - 1, --c2, num2.length() - c2 - 1, result);
            } else {
                return mutiply_every_digit(num1, num2, --c1, c2, ++squared, result);
            }
        }
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int f = num1.length();
        int g = num2.length();
        int carry = 0;
        while(--f>=0 | --g>=0 ){
            int first = f>=0 ? num1.charAt(f) - '0' : 0;
            int second = g>=0 ? num2.charAt(g) - '0' : 0;
            sb.append((carry + first + second) % 10);
            carry = (carry + first + second) /10;
        }
        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
