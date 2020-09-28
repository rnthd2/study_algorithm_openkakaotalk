package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {
//        s = "barfoothefoobarman", words = ["foo","bar"]
//        s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//        s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
//        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman",new String[]{"foo", "bar", "the"}));
//        System.out.println(new ArrayList<Integer>(Arrays.asList(6,9)));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int length = words[0].length();
        List<Integer> list = new ArrayList<>();
        List<String> temp = new ArrayList<>(Arrays.asList(words));

        int left = 0
                , i = -1  //all starting indices of substring
                , right = left + length;

        while (left < right && right <= s.length()){
            String str = s.substring(left, right);

            if (temp.contains(str)) {
                if (temp.size() == words.length) i = left;
                temp.remove(str);
                if (temp.isEmpty()){
                    list.add(i);
                    i = -1;
                }
            } else {
                temp = new ArrayList<>(Arrays.asList(words));
                right = i + length;
            }
            left = right;
            right = left + length;

        }

        return list;
    }
}
