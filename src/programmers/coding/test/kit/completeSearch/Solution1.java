package programmers.coding.test.kit.completeSearch;

import java.util.*;

public class Solution1 {
    static final int[] GET_MARK_1 = {1, 2, 3, 4, 5};
    static final int[] GET_MARK_2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static final int[] GET_MARK_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    static final List<int[]> GET_MARK_LIST = new ArrayList<>(Arrays.asList(GET_MARK_1, GET_MARK_2, GET_MARK_3));

    public static void main(String[] args) {
        solution(new int[]{1,2,3,1,2});
    }


    static int[] solution(int[] answers) {

        int max = 0;
        int count;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < GET_MARK_LIST.size(); i++) {
            count = 0;
            for (int j = 0; j < answers.length; j++) {
                int markIdx = j % (GET_MARK_LIST.get(i).length);
                if (GET_MARK_LIST.get(i)[markIdx] == answers[j]) {
                    count++;
                }
            }

            if(count < max || count == 0) {
                continue;
            } else {
                if(count > max)
                    result.clear();
                max = count;
                result.add(i+1);
            }
        }

        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
