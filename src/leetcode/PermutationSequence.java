package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(3,1));
        System.out.println(getPermutation(3,3));
        System.out.println(getPermutation(3,6));
        System.out.println(getPermutation(4,1));
        System.out.println(getPermutation(4,2));
        System.out.println(getPermutation(4,8));
        System.out.println(getPermutation(4,9));
        System.out.println(getPermutation(4,10));
        System.out.println(getPermutation(5,3));
        System.out.println(getPermutation(5,4));
        System.out.println(getPermutation(5,5));
        System.out.println(getPermutation(5,6));
        System.out.println(getPermutation(5,7));
        System.out.println(getPermutation(5,8));
        System.out.println(getPermutation(5,9));
        System.out.println(getPermutation(5,10));
        System.out.println(getPermutation(5,11));
    }

    /**
     * 사전식 순열/순서 정렬 알고리즘
     *
     * @param n 배열 수와 값을 정의한다
     * @param k 찾고자 하는 순열의 순서
     * @return
     */
    public static String getPermutation(int n, int k) {
        int[] array = IntStream.range(1, n+1).toArray();
        while(--k > 0) {
            //1,2,3,4 -> 1,2,4,3
            swap(array, array.length - 2, array.length - 1);

            //1,2,4,3 -> 1,3,2,4
            if(--k > 0 )
                getNextPerm(array);
        }
        return Arrays.toString(array).replaceAll("[^0-9]","");
    }

    /**
     * 1.감소하는(내림차순정렬 순서를 따르고 있는) 꼬리부분을 찾는다
     * 2.중심축을 찾는다(2번에서 찾은 꼬리부분 앞의 수)
     * 3.피봇보다 큰 수이면서 꼬리부분에서 가장 작은 수를 찾는다
     * 4.3번에서 찾은 수와 2번에서 찾은 중심축의 위치를 바꾼다
     * 5.꼬리부분을 반대로 뒤집는다
     * 6.끝
     * cf.https://developyo.tistory.com/97
     * @param array
     */
    static void getNextPerm(int[] array){
        //감소하는(내림차순정렬 순서를 따르고 있는) 꼬리부분을 찾는다
        //현재 right 는 꼬리의 시작점
        int right = array.length - 1;
        while (right > 0 && array[right - 1] >= array[right]) {
            right--;
        }

        //중심축을 찾는다(2번에서 찾은 꼬리부분 앞의 수)
        int left = right-1;

        //피봇보다 큰 수이면서 꼬리부분에서 가장 작은 수를 찾는다
        for (int i = right+1; i < array.length; i++) {
            if(array[left] < array[i] && array[right] > array[i])
                right = i;
        }

        //3번에서 찾은 수와 2번에서 찾은 중심축의 위치를 바꾼다
        swap(array,left,right);

        //꼬리부분을 반대로 뒤집는다
        left = left+1;
        right = array.length-1;
        while(left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    // 순열에 필요한 swap
    static void swap(int[] oper , int a , int b) {
        int tmp=oper[a];
        oper[a]=oper[b];
        oper[b]=tmp;
    }
}
