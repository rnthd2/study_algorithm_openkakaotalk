package programmers.coding.test.kit.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1 {
    /**
     * array	commands	return
     * [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(array, commands);
    }


    static int[] solution(int[] array, int[][] commands) {
        PriorityQueue<Integer> queue;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            int[] subArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            queue = new PriorityQueue(subArray.length);
            for (int a : subArray) {
                queue.add(a);
            }
            int index = commands[i][2];
            while(--index > 0){
                queue.poll();
            }
            list.add(queue.peek());

        }

        return list.stream().mapToInt(i->i).toArray();
    }

    static int[] subArrayByIAndJ(int[] array, int[] commands){
        //int array sublist java
        //array, begin, end
        return Arrays.copyOfRange(array, commands[0]-1, commands[1]);
    }

    // Generic method to get subarray of a non-primitive array
    // between specified indices
    public static<T> T[] subArray(T[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end + 1);
    }
}
