package codility.training;

import java.util.Stack;

/**
 * Stacks and Queues
 *
 * StoneWall
 * https://app.codility.com/c/run/training5YFRRQ-5PU/
 *
 * 배열 H[N]의 값을 N개의 직사각형 블록의 높이다.
 * *문제의 그림을 보는게 빠름...
 *
 * 블록의 높이가 높아지면 개수를 더하고 낮아지면 stack의 값을 제거...
 */
public class Solution11 {

    /*
    For example, given array H containing N = 9 integers:

  H[0] = 8    H[1] = 8    H[2] = 5
  H[3] = 7    H[4] = 9    H[5] = 8
  H[6] = 7    H[7] = 4    H[8] = 8
     */
    public static void main(String[] args) {
//        int[] H = {3,2,1};
        int[] H = {8,8,5,7,9,8,7,4,8};
        System.out.println(solution(H));

    }
    static int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int h : H) {
            while(!stack.isEmpty() && stack.peek() > h){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek() < h){
                stack.push(h);
                count++;
            }

        }
        return count;
    }

    static int solution2(int[] H) {
        Integer minimumHeight = null;
        int count = 0;
        for (int i = 0; i < H.length; i++) {
            while (minimumHeight != null && minimumHeight > H[i]) {
                minimumHeight = null;
            }
            if (minimumHeight == null || minimumHeight < H[i]) {
                minimumHeight = H[i];
                count++;
            }
        }
        return count;
    }
    static int solution1(int[] H) {
        int count = 1;
        int minHeight = H[0];
        for (int i = 1; i < H.length; i++) {
            if (minHeight <= H[i])
                count++;
            else
                minHeight = H[i];
        }
        return count;

    }

}
