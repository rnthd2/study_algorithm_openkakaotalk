package codility.training;

import java.util.TreeSet;

/**
 * Counting Elements
 *
 * MissingInteger
 * https://app.codility.com/programmers/lessons/4-counting_elements/
 *
 * 비어있지않은 배열 A에서 빠진 양의 정수를 찾아 반환한다.
 * 빠지지 않았다면 다음 정수를 반환하고
 * 양의 정수가 없으면 1을 반환한다.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 */
public class Solution6 {
    public static void main(String[] args) {
        int[] A = {-1000000};
        System.out.println(solution(A));
    }
    static int solution(int[] A) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int a : A) {
            if(a > 0)
                treeSet.add(a);
        }

        int i = 1;

        while(!treeSet.isEmpty() && i == treeSet.pollFirst()){
            i++;
        }
        return i;
    }
}
