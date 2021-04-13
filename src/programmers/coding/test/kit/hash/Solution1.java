package programmers.coding.test.kit.hash;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 *
 * participant	completion	return
 * ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
 * ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
 */
public class Solution1 {
    public static void main(String[] args) {
//        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
//        String[] completion = new String[]{"stanko", "ana", "mislav"};

        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};

        System.out.println(solution(participant, completion));
    }

    /**
     * 정확성 : 50
     * 효율성 : 50
     *
     * @param participant
     * @param completion
     * @return
     */
    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i=0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }

    /**
     * 정확성 : 50
     * 효율성 : 0
     *
     * @param participant
     * @param completion
     * @return
     */
    public static String solution1(String[] participant, String[] completion) {

        ArrayList<String> ps = new ArrayList<>();
        ps.addAll(Arrays.asList(participant));
        ArrayList<String> cs = new ArrayList<>();
        cs.addAll(Arrays.asList(completion));

        ps.removeIf(p ->{
            if(cs.contains(p)){
                cs.remove(p);
                return true;
            }
            return false;
        });

        return ps.get(0);
    }
}
