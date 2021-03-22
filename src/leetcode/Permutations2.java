package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations2 {
    static List<List<Integer>> list;
    public List<List<Integer>> permuteUnique(int[] nums) {
        list = new ArrayList<>();
        // 순열 알고리즘으로 모든 배열의 순을 구한다
        perm(nums, 0, nums.length);
        return list.stream().distinct().collect(Collectors.toList());
    }
    static void perm(int[] arr, int depth, int length) {

        if (depth == length) {
            List<Integer> test = new ArrayList<>();
            Arrays.stream(arr).forEach(num -> test.add(num));
            list.add(test);
            return;
        }
        for (int i = depth; i < length; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, length);
            swap(arr, i, depth);
        }
    }

    // 순열에 필요한 swap
    static void swap(int[] oper , int a , int b) {
        int tmp=oper[a];
        oper[a]=oper[b];
        oper[b]=tmp;
    }
}
