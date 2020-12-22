package leetcode;

import java.util.Arrays;

public class InsertInterval {
    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(insert(new int[][]{}, new int[]{5,7})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,3},{6,9}}, new int[]{6,10})));

    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length < 2) return new int[][]{newInterval};

        int index = 0, left, right;
        int count = 0;
        left = newInterval[0];
        right = newInterval[1];

        while(intervals.length > 1 && index < intervals.length) {
            //merge 대상
            if(intervals[index][0] <= right && intervals[index][1] >= left) {
                left = Math.min(left, intervals[index][0]);
                right = Math.max(right, intervals[index][1]);
                intervals[index] = new int[]{-1,-1};
                ++count;
            }
            ++index;
        }

        index=0;
        int [][] result = new int[intervals.length-count+1][];
        for (int i = 0; i < intervals.length; i++) {
            if(intervals.length<2 || intervals[i][0] == -1){
                result[index] = new int[]{left,right};
                i+=count-1;
            } else {
                result[index] = intervals[i];
            }
            ++index;
        }

        //list를 2차원 배열로 변환
        return result;
    }

}
