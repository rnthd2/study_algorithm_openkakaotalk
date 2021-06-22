package programmers.coding.test.kit.dfsAndbfs;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 단어변환
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * <p>
 * begin	target	words	return
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환
 * <p>
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
 *
 *
 * print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]), 4)
 * print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log"]), 0)
 * print(solution("hit", "hot", ["hot", "dot", "dog", "lot", "log"]), 1)
 * print(solution("1234567000", "1234567899", [
 *       "1234567800", "1234567890", "1234567899"]), 3)
 * print(solution("hit", "cog", ["cog", "log", "lot", "dog", "hot"]), 4)
 */
public class Solution3 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin, target, words));
    }

    static int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0;
        LinkedList<int[]> queue = new LinkedList();
        int index = 0, depth = 1;

        while(!changable(begin, words[index])){
            index++;
        }

        queue.offer(new int[]{index, depth});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            String parentWords = words[poll[0]];

            if(target.equals(parentWords)){
                return poll[1];
            }
            for (int i = 0; i < words.length; i++) {
                if(changable(words[i], parentWords))
                    queue.offer(new int[]{i, poll[1]+1});
            }
        }

        return 0;
    }


    static boolean changable(String s1, String s2) {
        int result = 1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                result--;
            }
        }
        return result > -1;
    }
}
