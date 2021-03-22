package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {
//        s = "barfoothefoobarman", words = ["foo","bar"]
//        s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//        s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
//        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
//        System.out.println(findSubstring("barfoofoobarthefoobarman",new String[]{"foo", "bar", "the"}));
        System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake"
                ,new String[]{"fooo", "barr", "wing", "ding", "wing"}));
//        System.out.println(new ArrayList<Integer>(Arrays.asList(6,9)));
    }

    static boolean test(int length, String s, ArrayList<String> words) {
        int left = 0, right = left + length;

        //s를 words.length로 나눈다
        String str = s.substring(left, right);

        while (!str.isEmpty() && !words.isEmpty()
                && left < right && right <= s.length()) {
            str = s.substring(left, right);
            if (words.contains(str)) words.remove(str);
            else
                return false;
            left = right;
            right = left + length;

        }
        return true;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int length = words[0].length();
        List<Integer> list = new ArrayList<>();

        int left = 0, right = length*words.length;

        while (left < right && right <= s.length()) {
            String str = s.substring(left, right);

            if(test(length, str, new ArrayList<>(Arrays.asList(words)))){
                list.add(left);
            }

            left ++;
            right = length*words.length + left;

        }

        return list;
    }
}
