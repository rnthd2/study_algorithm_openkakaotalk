package leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
		int[] nums1= {1,2};
		int[] nums2= {3,4};
		double result = medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
		System.out.println(result);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums3=new int[nums1.length + nums2.length];
		System.arraycopy(nums1, 0, nums3, 0, nums1.length);
		System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
		Arrays.sort(nums3);
		int n = nums3.length/2;
		if(nums3.length %2 == 0){
			return (nums3[n-1] + nums3[n])/2d;
		} else {
			return nums3[n];
		}
	}
}
