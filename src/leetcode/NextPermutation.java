package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NextPermutation {
    static int[] nums = new int[]{1,2,3};

    public static void main(String[] args) {
        nextPermutation(nums);
//        nextPermutation(new int[]{1,2,3}); //1,3,2
//        nextPermutation(new int[]{3,2,1}); //1,2,3
//        nextPermutation(new int[]{1,1,5}); //1,2,3
    }

    public static void nextPermutation(int[] nums) {
        int x = test(nums);
        System.out.println("x : " + x);
        if (x < 0) {
            System.out.println(Arrays.toString(test3(nums, 0)));
        } else {
//            System.out.println(test2(nums, x));
            //test2는 비즈니스 로직상 반드시 있다
            int y = test2(nums, x);

            swap(nums, x, y);

            System.out.println(Arrays.toString(test3(nums, x+1)));
        }

    }

    static int test(int[] nums) {
        return IntStream.range(0, nums.length-1)
                .filter(i -> nums[i] < nums[i+1])
                .max()
                .orElse(-1);
    }

    static int test2(int[] nums, int num) {
        return IntStream.range(0, nums.length)
                .filter(i -> num < i)
                .filter(i -> nums[num] < nums[i])
                .max()
                .orElse(-1);
    }

    static int[] swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
        return array;
    }

    static int[] test3(int[] nums, int left) {
        int right = nums.length-1;
        while(left < right){
            swap(nums, left++, right--);
        }
        return nums;
    }
}
