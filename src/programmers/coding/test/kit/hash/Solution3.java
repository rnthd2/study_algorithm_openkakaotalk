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
//        String [][] clothes = new String [][] {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        String [][] clothes = new String [][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {

        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < clothes.length; i++) {
            String s = clothes[i][1];
            //입지 않는 경우 추가를 위하여 1을 기본값으로 한다
            //의상 종류 개수 추가를 위하여 1을 더한다
            map.put(s, map.getOrDefault(s, 1) + 1);
        }

        //하루에 최소 한개 이상의 의상을 입는다
        int result = 1;

        for (Integer count : map.values()) {
            result *= count;
        }

        //모두 입지 않는 경우의 수를 뺀다
        return result-1;
    }

}
