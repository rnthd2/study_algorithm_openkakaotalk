package codility.training;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Array
 *
 * CyclicRotation
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 *
 * A 배열을 K번만큼 회전한 배열을 리턴한다.
 * A = [3, 8, 9, 7, 6], K = 3
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] A = new int[]{};
        int K = 3;
        System.out.println(solution(A, K));
    }

    static int[] solution(int[] A, int K) {
        if(A.length == 0) return new int[]{};
        K %= A.length;

        LinkedList<Integer> list = new LinkedList<>(Arrays.stream(A).boxed().collect(Collectors.toList()));

        while (K-- > 0) {
            Integer e = list.getLast();
            list.removeLast();
            list.addFirst(e);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}
