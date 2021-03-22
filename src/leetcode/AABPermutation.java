package leetcode;

import java.util.HashSet;

/**
 * 조합 순열 알고리즘
 * asis is aab
 * tobe is aab, aba, baa
 *
 * cf. uniquePath class에서는 tobe의 개수를 알 수 있다.
 *
 */
public class AABPermutation {
    // 문자열로 만들 수 있는 모든 경우의 수 (중복x)
    public static HashSet<String> allSet;

    public static void main(String[] args) {
        solution("aab");
    }
    
    public static void solution(String s) {
        allSet = new HashSet<>();
        permutation("", s);
    }
    
    // 모든 경우의 수를 구하는 순열
    public static void permutation(String prefix, String s) {
        int n = s.length();
        if(n==0)
            allSet.add(prefix); // all에 삽입
        else {
            //substring(i) 는 i 이후의 값을 가져온다
            for(int i=0; i<n; i++) {
                permutation(prefix + s.charAt(i),
                                s.substring(0, i) + s.substring(i+1));
            }
        }
    }
}