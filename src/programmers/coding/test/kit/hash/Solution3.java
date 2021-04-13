package programmers.coding.test.kit.hash;

import java.util.HashMap;

/**
 * 위장
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 *
 * [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]
 */
public class Solution3 {
    public static void main(String[] args) {
        String [][] clothes = new String [][] {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {

        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < clothes.length; i++) {
            String s = clothes[i][1];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int result = 0;








        
        /*for (int r = map.size(); r > 0; r--) {
            double d = factorial(map.size())/(r*(map.size()-r));
            int count = Integer.parseInt(String.valueOf(d));
            while(count>0){
                Iterator<Integer> iterator = map.values().iterator();
                while(iterator.hasNext()){
                    iterator.next();
                }
                count--;
            }

        }*/


        return 0;
    }
    /**
     * 팩토리얼
     *
     * @param n
     * @return
     */
    static double factorial(int n) {
        if(n == 0) {
            return 1;
        } else if(n <= 1) {
            return n;
        } else {
            return factorial(n-1)*n;
        }
    }
}
