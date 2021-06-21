package programmers.coding.test.kit.greedy;

import java.util.Arrays;

/**
 * 체육복
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 *
 * n	lost	reserve	return
 * 5	[2, 4]	[1, 3, 5]	5
 * 5	[2, 4]	[3]	4
 * 3	[3]	[1]	2
 * 10   [5, 7, 9], [1, 2, 3, 4, 6, 8] 10
 * 10   [3,4] [4,5] 9
 * 10   [5,4,3,2,1] [3,1,2,5,4] 10
 * 4    [3, 1], [2, 4] 4
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        int n = 4;
        int[] lost = new int[]{3,1};
        int[] reverse = new int[]{2,4};
        System.out.println(solution(n, lost, reverse));
    }

    static int solution(int n, int[] lost, int[] reserve) {

        //1,1,1,1,1로 int 배열 한번에 채우기
        int[] hasCount = new int[n];
        Arrays.fill(hasCount,1);
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int r : reserve) {
            hasCount[r-1]+=1;
        }

        for (int l : lost) {
            hasCount[l-1]-=1;
        }

        int index = 0;
        while(index < hasCount.length-1){
            if((hasCount[index] == 2 && hasCount[index+1] == 0)
                    || (hasCount[index] == 0 && hasCount[index+1] == 2)){
                hasCount[index] = 1;
                hasCount[index+1] = 1;
            }
            index++;
        }

        return (int) Arrays.stream(hasCount).boxed().filter(c -> c != 0).count();
    }
}
