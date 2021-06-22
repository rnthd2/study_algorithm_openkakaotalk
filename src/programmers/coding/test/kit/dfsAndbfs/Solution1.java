package programmers.coding.test.kit.dfsAndbfs;

public class Solution1 {

    /**
     * 타겟 넘버
     * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
     *
     * 제한사항
     * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
     * 각 숫자는 1 이상 50 이하인 자연수입니다.
     * 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
     * 입출력 예
     *
     * numbers	target	return
     * [1, 1, 1, 1, 1]	3	5
     * @param args
     */
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, numbers[0]);
        dfs(numbers, target, 0, -numbers[0]);
        return count;
    }

    static int count = 0;
    static void dfs(int[] numbers, int target, int index, int current){
        if(index == numbers.length-1) {
            if (current == target)
                count++;
            return;
        }

        dfs(numbers, target, ++index, current + numbers[index]);
        dfs(numbers, target, index, current - numbers[index]);
    }
}
