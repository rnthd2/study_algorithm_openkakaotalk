package programmers.coding.test.kit.heap;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    /**
     * jobs	return
     * [[0, 3], [1, 9], [2, 6]]	9
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    }

    static int solution(int[][] jobs) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            // 빠른 실행 시간부터 추출해야 하므로 배열 요소 비교 Comparator 정의.
            public int compare(int[] val1, int[] val2) {
                return val1[1]-val2[1];
            }
        });

        //요청 속도가 빠른 순으로 배열을 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        int result = 0;
        int index = 0;
        int len = jobs.length;
        int currentTime = 0;

        while(index < len || !priorityQueue.isEmpty()){
            while(index < len && jobs[index][0] <= currentTime){
                priorityQueue.offer(jobs[index++]);
            }

            if(priorityQueue.isEmpty()){
                currentTime = jobs[index][0];
            } else {
                int[] job = priorityQueue.poll();
                result += currentTime - job[0] + job[1];
                currentTime += job[1];
            }

        }
        return result/len;
    }

}
