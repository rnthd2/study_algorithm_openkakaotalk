package leetcode;

public class SortColors {
    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }

    public static void sortColors(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = i;
            for (int j = i-1; j > -1; j--,temp--) {
                if(nums[j] > nums[temp]){
                    swap(nums,temp,j);
                }
            }
        }

    }
    public static int[] swap(int[] array, int i, int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
        return array;
    }
}
