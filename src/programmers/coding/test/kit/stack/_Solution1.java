package programmers.coding.test.kit.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 다리를 지나는 트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 *
 * bridge_length	weight	truck_weights	return
 * 2	10	[7,4,5,6]	8
 * 100	100	[10]	101
 * 100	100	[10,10,10,10,10,10,10,10,10,10]	110
 */
public class _Solution1 {
    public static void main(String[] args) {

    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridge = new LinkedList<>();

        int index = 0;
        int time = 0;

        while(index < truck_weights.length){
            if(sumOfBridge(bridge) + truck_weights[index+1] <= weight){
                bridge.add(index);
            }
            time++;
        }

        return time;
    }
    private static int sumOfBridge(Queue<Integer> bridge){
        return bridge
                .stream()
                .mapToInt(weight -> weight)
                .sum();
    }
}
