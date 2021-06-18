package programmers.coding.test.kit.stack;

import java.util.LinkedList;

public class Solution2 {

    static int solution(int[] priorities, int location) {
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> sortedQueue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(i);
        }

        while(sortedQueue.size() != priorities.length) {
            int jFileIndex = queue.poll();
            boolean b = isLargeJFileInQueue(priorities, queue, jFileIndex);
            if (b) {
                queue.addLast(jFileIndex);
            } else {
                sortedQueue.add(jFileIndex);
            }
        }

        return sortedQueue.indexOf(location)+1;
    }

    private static boolean isLargeJFileInQueue(int[] priorities, LinkedList<Integer> queue, int jFileIndex) {
        return queue.stream().filter(q -> priorities[q] > priorities[jFileIndex]).count()>0;
    }



    /**
     * priorities	location	return
     * [2, 1, 3, 2]	2	1
     * [1, 1, 9, 1, 1, 1]	0	5
     * @param args
     */
    public static void main(String[] args) {
        int[] priorities = {1,9,1,2};
        int location = 3;
//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;
        System.out.println(solution(priorities, location));
    }
}
