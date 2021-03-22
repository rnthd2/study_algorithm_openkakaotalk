package leetcode;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
        System.out.println(canJump(new int[]{2,2,0,1,4}));
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump(new int[]{0,1}));
        System.out.println(canJump(new int[]{0}));
    }
    public static boolean canJump(int[] nums) {
        if(nums.length < 2) return true;
        return test2(nums, nums.length-2, nums.length-1);
    }
    static boolean test2(int[] nums, int left, int right) {
        if(left == 0){
            if(right-left <= nums[left])
                return true;
            else
                return false;
        }

        if(right-left <= nums[left]){
            return test(nums, left-1, left);
        } else {
            return test(nums, left-1, right);
        }
    }
    static boolean test(int[] nums, int left, int right) {
        if (left > 0 && nums[left] == 0){
            return test(nums, left - 1, right);
        } else if(right-left <= nums[left]){
            if(left==0)
                return true;
            else
                return test(nums, left-1, left);
        } else if (left>0){
            return test(nums, left-1, right);
        }
        return false;
    }
}
