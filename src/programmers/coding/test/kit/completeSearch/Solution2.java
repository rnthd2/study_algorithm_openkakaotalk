package programmers.coding.test.kit.completeSearch;

import java.util.HashSet;

/**
 * 소수 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
public class Solution2 {
    /**
     * numbers	return
     * "17"	3
     * "011"	2
     * @param args
     */
    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution(numbers));
    }

    static int solution(String numbers) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        for (Integer s : set) {
            if (s == 2) count++;
            if (s % 2 != 0 && isPrime(s)) {
                count++;
            }
        }
        return count;
    }

    //모든 자리의 순열 만들기
    //"011" -> 0,1,10,11,110,101
    public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) {
            set.add(Integer.valueOf(prefix)); //스트링을 Interger로 변환
        }

        for (int i = 0; i < n; i++){
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }
    }

    //소수 찾기
    public static boolean isPrime(int num){
        if(num == 1 || num == 0)
            return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
