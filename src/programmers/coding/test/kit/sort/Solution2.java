package programmers.coding.test.kit.sort;

import java.util.Arrays;

public class Solution2 {

    /**
     * numbers	return
     * [6, 10, 2]	"6210"
     * [3, 30, 34, 5, 9]	"9534330"
     * @param args
     */

    public static void main(String[] args) {
        int[] numbers = {0,0,0,0};
        System.out.println(solution(numbers));
    }

    static String solution(int[] numbers) {
        String[] strings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        // 정렬 : 문자열 "62"와 "26"을 수치로 비교해서 정렬하는 방법
        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        String s = "";
        for (String string : strings) {
            s += string;
        }

        return s.charAt(0)=='0'? "0" : s;
    }

}
