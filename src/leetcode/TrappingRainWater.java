package leetcode;

import java.util.function.IntPredicate;

public class TrappingRainWater {
    public static void main(String[] args) {
//        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4,9,4,5,3,2}));
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(trap(new int[]{}));
        System.out.println(trap(new int[]{4, 2, 3}));
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{5,4,1,2}));
        System.out.println(trap(new int[]{0, 1, 2, 0, 3, 0, 1, 2, 0, 0, 4, 2, 1, 2, 5, 0, 1, 2, 0, 2}));
    }
    public static int trap(int[] arr) {
        int i=0;
        int j=arr.length-1;
        int res=0;
        int ml=0;
        int mr=0;
        while(i<j){
            if(arr[i]<arr[j]){
                ml=Math.max(ml,arr[i]);
                res+=ml-arr[i];
                i++;
            }else{
                mr=Math.max(mr,arr[j]);
                res+=mr-arr[j];
                j--;
            }
        }
        return res;
    }

//    public static int trap(int[] height) {
//        if(height.length < 1){
//            return 0;
//        }
//
//        int totalRainWater = 0;
//        int right = 1, left;
//
//        //두 기둥 찾기
//        //1. 시작지점에서 같거나 큰 값이 오른쪽 기둥이 된다
//        for (left = 0; left < height.length; left++, right = left + 1) {
//            while (right < height.length) {
//                if (height[left] <= height[right]) {
//                    totalRainWater += addRainWater(height, left, right);
//                    left = right;
//                    right = left + 1;
//                } else {
//                    right++;
//                }
//            }
//        }
//
//        //2.
//        for (right = height.length-1, left = right-1; right > 0; right--, left = right -1) {
//            while(left >= 0) {
//                if(height[left] == height[right]){
//                    right = left;
//                    left = right-1;
//                } else if(height[left] > height[right] && right - left >= 2){
//                    totalRainWater += addRainWaterReverse(height, left, right);
//                    right = left;
//                    left = right-1;
//                }
//                else {
//                    left--;
//                }
//            }
//
//        }
//
//        return totalRainWater;
//    }
//
//    //물 붓기
//    static int addRainWater(int[] heights, int left, int right) {
//        int rainWater = 0, index;
//        //1의 경우 물 붓기
//        index = left + 1;
//        while (index <= right) {
//            int spare = heights[left] - heights[index];
//            rainWater += spare > 0 ? spare : 0;
//            index++;
//        }
//
//        return rainWater;
//    }
//    static int addRainWaterReverse(int[] heights, int left, int right) {
//        int rainWater = 0, index;
//        //2의 경우 물 붓기
//        index = right-1;
//        while(index >= left){
//            int spare = heights[right]-heights[index];
//            rainWater+= spare > 0 ? spare : 0;
//            index--;
//        }
//
//        return rainWater;
//    }


    public static int trap3(int[] height) {
        int rainWater = 0;
        int peak = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] >= height[peak]) {
                rainWater += calculateRain(height, peak, i);
                peak = i;
            }
        }

        int nextPeak = height.length - 1;

        for (int i = height.length - 2; i >= peak; i--) {
            if (height[i] >= height[nextPeak]) {
                rainWater += calculateRain(height, i, nextPeak);
                nextPeak = i;
            }
        }

        return rainWater;
    }

    public static int calculateRain(int[] height, int left, int right) {
        int waterLevel = Math.min(height[left], height[right]);
        int rainwater = 0;

        for (int i = left + 1; i < right; i++) {
            rainwater += waterLevel - height[i];
        }

        return rainwater;

//        if((height[i-1] - height[i]) > 0){
//            map.put(i-1, height[i-1]-height[i]);
//        } else if((height[i-1] - height[i]) < 0 && !map.isEmpty()) {
//            int min = Math.min(lastElement.getValue(), height[i]);
//            int minHeight = (i-lastElement.getKey()-1);
//            result += min * minHeight;
//            map.remove(lastElement.getKey());
//        } else {
//            continue;
//        }
    }


    public static int trap2(int[] height) {

        int result = 0;
        int prev = 1;
        int[] array;

        int a = height[prev];
        int end = sequentialSearch_forward(height, prev + 1, (num) -> {
            if (a <= num) {
                return true;
            }
            return false;
        });


        return result;
    }

    public static int test(int[] array) {
        int a = array[0];
        int end = sequentialSearch_forward(array, 1, (num) -> {
            if (a <= num) {
                return true;
            }
            return false;
        });
        int b = array[array.length - 1];
        int start = sequentialSearch_reverse(array, array.length - 2, (num) -> {
            if (b == num) {
                return true;
            }
            return false;
        });
        return 0;
    }

    //정방향 순차탐색
    static int sequentialSearch_forward(int dataArr[], int start, IntPredicate predicate) {
        for (int i = start; i < dataArr.length; i++) if (predicate.test(dataArr[i])) return i;
        return -1;
    }

    //역방향 순차탐색
    static int sequentialSearch_reverse(int dataArr[], int length, IntPredicate predicate) {
        for (int i = length; i > 0; i--) if (predicate.test(dataArr[i])) return i;
        return -1;
    }


}
