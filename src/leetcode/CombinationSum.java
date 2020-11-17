package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    //todo... 내가 풀어봐야됨...
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combinationSumHelper(result, null, candidates, target, 0);
        return result;
    }

    private static void combinationSumHelper(List<List<Integer>> finalList, List<Integer> currentList, int[] candidates, int target, int num) {
        if (currentList == null) currentList = new ArrayList<Integer>();
        if (target == 0) {
            finalList.add(currentList);
            return;
        }
        for (int i = num; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                ArrayList<Integer> originalList = new ArrayList<Integer>(currentList);
                currentList.add(candidates[i]);
                combinationSumHelper(finalList, currentList, candidates, target - candidates[i], i);
                currentList = originalList;
            }
        }
        return;
    }
}
