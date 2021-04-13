package programmers.coding.test.kit.hash;

import java.util.Arrays;

/**
 * 전화번호 목록
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 *
 * Arrays.sort(String[] phone_book);의 경우,
 * "12","1234","456" 순으로 정렬된다.
 */
public class Solution2 {
    public static void main(String[] args) {
        String[] s = new String[]{"1234", "789","456"};
        System.out.println(solution(s));
    }
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}
