package programmers.coding.test.kit.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1:40
//2:36
public class Solution1 {

    /**
     * progresses	speeds	return
     * [93, 30, 55]	[1, 30, 5]	[2, 1]
     * [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
     * @param args
     */
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer = solution(progresses, speeds);
        System.out.println(answer);
    }

    static int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
//
//    static int[] solution(int[] progresses, int[] speeds) {
//
//        int[] successDate = new int[progresses.length];
//
//        for (int i = 0; i < progresses.length; i++) {
//            //올림
//            successDate[i] = (int) Math.ceil((100 - progresses[i]) / (double)speeds[i]);
//        }
//
//        List<Integer> list = solution2(successDate);
//        return list.stream().mapToInt(i->i).toArray();
//    }

    private static List<Integer> solution2(int[] successDate) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int current = successDate[0];
        for (int index = 0; index < successDate.length; index++) {
            if(current >= successDate[index]){
                count++;
            } else {
                list.add(count);
                current = successDate[index];
                count = 1;
            }
        }
        list.add(count);
        return list;
    }
}
