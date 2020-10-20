package leetcode;

import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(searchInsert(new int[]{1}, 0));
    }

    static int searchInsert(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);

        //없는 경우, -1
        if(result < 0){
            //타겟 < nums[0]인 경우
            if (nums[0] > target) return 0;

            //nums[0] < 타겟 < nums[nums.length]인 경우
            int index = 1;
            while(index < nums.length){
                if(nums[index] > target) return index;
                else index++;
            }

            //타겟 > nums[nums.length]인 경우
            return nums.length;
        } else {
            return result;
        }

    }

//        int index = nums.length/2-1;
//        int value = nums[index];
//        if(value == target){
//            return index;
//        } else if(value > target){
//            return search(nums, target, 0, index-1);
//        } else {
//            return search(nums, target, index+1, nums.length);
//        }

//    static int search(int[] nums, int target, int left, int right){
//        if(left < right) {
//            int index = (left + right) / 2 - 1;
//            int value = nums[index];
//            if (value == target) {
//                return index;
//            } else if (value < target) {
//                return search(nums, target, left, index - 1);
//            } else {
//                return search(nums, target, index + 1, right);
//            }
//        }
//        else    //no exist
//            return 0;
//    }
}
