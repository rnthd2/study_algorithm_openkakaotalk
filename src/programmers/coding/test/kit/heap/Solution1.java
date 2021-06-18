package programmers.coding.test.kit.heap;


import java.util.PriorityQueue;

//11:00분 부터
public class Solution1 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }

    static int solution(int[] scoville, int K) {

        //int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        //int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }

        int count = 0;
        while(priorityQueue.peek() < K) {

            //모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
            if(priorityQueue.size() == 1) return -1;

            int first = priorityQueue.poll();
            int second = priorityQueue.poll();

            //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
            int newFoodScoville = first + (second * 2);

            priorityQueue.add(newFoodScoville);

            count++;
        }
        return count;
    }
}
