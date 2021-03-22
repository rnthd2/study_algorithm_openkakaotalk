package leetcode;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{5,5},{1,2},{2,4},{2,3},{4,4},{5,5},{2,3},{5,6},{0,0},{5,6}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,4},{0,1}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,4},{0,0}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }
    static ArrayList<int[]> list;

    public static int[][] merge(int[][] intervals) {
        list = new ArrayList<>();

        //2차원 배열 2번째 원소까지 정렬
//        Arrays.sort(intervals, (interval1, interval2) -> {
//           if(interval1[0] == interval2[0]) return Integer.compare(interval1[1], interval2[1]);
//           else return Integer.compare(interval1[0],interval2[0]);
//        });

        Arrays.sort(intervals, Comparator.comparing(o1 -> o1[0]));

        test(intervals, intervals[0][0], intervals[0][1], 1);

        //list를 2차원 배열로 변환
        return list.stream().toArray(int[][]::new);
    }

    static void test(int[][] intervals, int left, int right, int index){
        if(index >= intervals.length){
            list.add(new int[]{left, right});
            return;
        }
        if(right >= intervals[index][0]){
            if(intervals[index][0] < left) left = intervals[index][0];
            if(intervals[index][1] > right) right = intervals[index][1];
            test(intervals, left, right, ++index);
        } else {
            list.add(new int[]{left, right});
            test(intervals, intervals[index][0], intervals[index][1], ++index);
        }
    }
}
