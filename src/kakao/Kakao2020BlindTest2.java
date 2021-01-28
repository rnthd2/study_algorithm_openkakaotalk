package kakao;

import java.util.Stack;

public class Kakao2020BlindTest2 {
    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
        System.out.println(solution("()()())"));

    }

    public static String solution(String p) {
        String u="", v;
        String answer = "";
        String prefix = "";

        //1. 올바른 문자열인지 확인 > 그대로 리턴
        //2. u는 "균형잡힌 괄호 문자열"과 v 빈 문자열이 될 수도 있고
        //3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        //  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        if(isValid(p))return p;

        int division = 2;
        int index = 0;
        while(division <= p.length()){
            u = p.substring(index, division);
            if(isValid(u)){
                prefix+=u;
                index=division;
            } else if(isBalance(u)){
                break;
            }
            division+=2;
        }
        v=p.substring(division);

        //4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        //  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        //  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        //  4-3. ')'를 다시 붙입니다.
        //  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        //  4-5. 생성된 문자열을 반환합니다.
        answer = "(" + answer;
        answer += v;
        answer += ")";
        u=u.substring(1, u.length()-1);
        u = changeU(u);
        answer+=reverseString(u);
        return prefix + answer; // ()(())()
    }

    private static String changeU(String u) {
        for (int i = 0; i < u.length(); i++) {
            switch (u.charAt(i)){
                case '(':
                    u = u.substring(0,i)+'('+ u.substring(i+1);
                    break;
                case ')':
                    u = u.substring(0,i)+')'+ u.substring(i+1);
                    break;
            }
        }
        return u;
    }


    /**
     * 문자열 뒤집기
     *
     * @param s
     * @return
     */
    public static String reverseString(String s){
        return (new StringBuffer(s)).reverse().toString();
    }

    /**
     *  올바른 괄호의 문자열인지 확인
     */
    static boolean isValid(String s) {
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            switch (c){
                case '(':
                    stack.push(c);
                    break;
                case ')': if(stack.size() < 1 || !stack.peek().equals('('))
                    return false; stack.pop(); break;
            }
        }
        return stack.isEmpty();
    }

    /**
     *  균형잡힌 괄호의 문자열인지 확인
     */
    static boolean isBalance(String s) {
        int count=0;
        for (char c : s.toCharArray()) {
            switch (c){
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    break;
            }
        }
        return count==0?true:false;
    }
}
