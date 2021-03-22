package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {


    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,1,2}));
    }

    static List<List<Integer>> permute(int[] nums) {
        // 순열 알고리즘으로 모든 배열의 순을 구한다
        return perm(nums, 0, nums.length, new ArrayList<>());
    }

    static List<List<Integer>> perm(int[] arr, int depth, int length, List<List<Integer>> list) {

        if (depth == length) {
            //int array to list
            List<Integer> integers = Arrays.stream(arr).boxed().collect(Collectors.toList());
            if(!list.contains(integers)) list.add(integers);
            return list;
        }
        for (int i = depth; i < length; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, length, list);
            swap(arr, i, depth);
        }
        return list;
    }

    // 순열에 필요한 swap
    static void swap(int[] oper , int a , int b) {
        int tmp=oper[a];
        oper[a]=oper[b];
        oper[b]=tmp;
    }
}
