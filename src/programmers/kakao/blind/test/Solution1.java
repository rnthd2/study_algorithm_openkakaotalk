package programmers.kakao.blind.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 신규 아이디 추천
 * https://programmers.co.kr/learn/courses/30/lessons/72410
 *
 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
 * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
 *      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(solution("new_id"));
    }
    public static String solution(String new_id) {
        String answer = "";

//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id.toLowerCase();
//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id.replace("/\\-/g","");
        return answer;
    }
    private static void matcherString(Pattern compile, String val) {
        Matcher matcher = compile.matcher(val);
        if (matcher.find()){
            System.out.println(matcher.group());
        } else {
            System.out.println("is not exist");
        }
    }
}
