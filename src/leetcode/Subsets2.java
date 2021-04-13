package leetcode;

import java.util.*;

/**
 * 멱집합 : 배열의 모든 부분집합을 구하라(중복 없이)
 */
public class Subsets2 {
    public static void main(String[] args) {
        int[] nums = {4,1,0};
        System.out.println(subsetsWithDup(nums));
    }

    static List<List<Integer>> result;
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        powerset(new Stack<>(), nums, 0);
        return result;
    }

    private static void powerset(Stack<Integer> stack, int[] nums, int current) {
        if (current >= nums.length) {
            if(!result.contains(stack)){
                result.add(new ArrayList<>(stack));
            }
        } else {
            // 있다
            stack.push(nums[current]);
            powerset(stack, nums, current+1);

            // 없다
            stack.pop();
            powerset(stack, nums, current+1);
        }
    }

}
