package leetcode;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 11)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 11,11,11,11,11}, 4)));
        System.out.println(Arrays.toString(searchRange(new int[]{3,4,4,11,11,11}, 4)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
    }


    public static int[] searchRange(int[] nums, int target) {
        int start, index = 0;

        //find first index
        while(index < nums.length && nums[index] != target){
            index++;
        }

        //no exist target in array
        if (index >= nums.length)
            return new int[]{-1,-1};

        start = index;

        //find last index
        while(index < nums.length && nums[index] == target){
            index++;
        }

        return new int[]{start, index-1};
    }


    static int[] searchRange2(int[] nums, int target) {
        //int array to integer array
        Integer integers[] = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        int first = Arrays.asList(integers).indexOf(target);
        int last = Arrays.asList(integers).lastIndexOf(target);

        return new int[]{first, last};
    }
}
