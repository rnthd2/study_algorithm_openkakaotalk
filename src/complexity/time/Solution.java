package complexity.time;

class Solution {
    public int search(int[] nums, int target) {
        
        int pivot = nums.length / 2;
        int first = 0;
        int last = nums.length-1;
        
        if (target == nums[pivot]) return pivot;
        if (target == nums[first]) return first;
        if (target == nums[last]) return last;
        
        if (nums[first] < nums[pivot]) {
            if (nums[first] < target && target < nums[pivot]) {
                for(int x = first ; x < pivot ; x ++) {
                    if (nums[x] == target) return x;
                }               
            }
            for(int x = pivot ; x < last ; x ++) {
                if (nums[x] == target) return x;
            }               
        }
        
        if (nums[pivot] < nums[last]) {
            if (nums[pivot] < target && target < nums[last]) {
                for(int x = pivot ; x < last ; x ++) {
                    if (nums[x] == target) return x;
                }               
            }
        }
        return -1;
    }
}
