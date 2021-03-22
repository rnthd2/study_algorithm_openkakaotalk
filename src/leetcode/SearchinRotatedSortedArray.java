package leetcode;

public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
//        //1.pivot이 뒤집힘
        System.out.println(search(new int[]{4,5,6,7,0,1,2},6));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2},2));
//
//        //2.pivot 앞이 뒤집힘
//        System.out.println(search(new int[]{7,8,1,2,3,4,5,6},0));
//        System.out.println(search(new int[]{7,8,1,2,3,4,5,6},7));
//
//        //3.pivot 뒤가 뒤집힘
//        System.out.println(search(new int[]{4,5,6,7,8,1,2},5));
//        System.out.println(search(new int[]{4,5,6,7,8,1,2},1));

        //issue
//        System.out.println(search(new int[]{1,3},0));
    }

    static int search(int[] nums, int target) {

        int first = 0;
        int last = nums.length-1;

        return 나눈_영역(nums, target, first, last);
    }

    //left다...
    // nums = 몽땅
    static int 나눈_영역(int[] nums, int target, int first, int last){

        int pivot = (first + last)/2;
        if (target == nums[pivot]) return pivot;
        if (target == nums[first]) return first;
        if (target == nums[last]) return last;

        //first와 pivot이 같다는 건 마지막 재귀함수이거나, 배열이 2개인 경우
        if (first == pivot) return -1;

        //안뒤집힘
        if(nums[first] < nums[last]){
            //left
            if(target < nums[pivot]){
                return 나눈_영역(nums, target, first, pivot-1);
            }
            //right
            else {
                return 나눈_영역(nums, target, pivot+1, last);
            }
        }
        //뒤집힘
        else {
            //left가 뒤집힘, right가 오름차순
            if(nums[first] > nums[pivot]) {
                if(target >= nums[pivot+1] && target <= nums[last]){
                    return 나눈_영역(nums, target, pivot+1, last);
                } else {
                    return 나눈_영역(nums, target, first, pivot-1);
                }
            }
            //right가 뒤집힘, left가 오름차순
            else {
                if(target >= nums[first] && target <= nums[pivot-1]){
                    return 나눈_영역(nums, target, first, pivot-1);
                } else {
                    return 나눈_영역(nums, target, pivot+1, last);
                }
            }
        }
    }
}
