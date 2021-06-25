package codility.training;


import java.util.Stack;

/**
 * Stacks and Queues
 * Fish
 *
 * https://app.codility.com/demo/results/trainingAHX67Q-4QS/
 *
 * 배열 A는 N번째 물고기의 사이즈이다.
 * 배열 B는 N번째 물고기의 이동 방향이다.
 * 이동방향은 0이 하류로, 1은 상류이다.
 * 방향이 반대인 물고기가 마주치면 사이즈가 큰 물고기가 살아남는다.
 * 물고기 사이즈 중복은 없다.
 * 살아남은 물고기의 수를 구한다.
 */
public class Solution12 {
    /*
    A[0] = 4    B[0] = 0
  A[1] = 3    B[1] = 1
  A[2] = 2    B[2] = 0
  A[3] = 1    B[3] = 0
  A[4] = 5    B[4] = 0
     */
    public static void main(String[] args) {
        int[] A = {4,3,2,1,5};
        int[] B = {0,1,0,0,0};
        System.out.println(solution(A, B));
    }
    static int solution(int[] A, int[] B) {
        Stack<Integer> stream = new Stack<>();
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if(stream.isEmpty() && B[i] == 0){
                count++;
            } else {
                if(B[i] == 0){
                    //fight!
                    while(!stream.isEmpty() && stream.peek() < A[i]){
                        stream.pop();
                    }
                    if(stream.isEmpty()){
                        count++;
                    }
                } else
                    stream.push(A[i]);
            }
        }
        return stream.size() + count;
    }
}
