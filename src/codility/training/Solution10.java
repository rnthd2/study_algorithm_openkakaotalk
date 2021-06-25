package codility.training;

import java.util.Stack;

public class Solution10 {
    public static void main(String[] args) {

    }

    /*
    N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")
     */

    public int solution(String S) {
        return isValid(S)? 1:0;
    }

    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            switch (c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')': if(stack.size() < 1 || !stack.peek().equals('('))
                    return false; stack.pop(); break;
                case ']': if(stack.size() < 1 || !stack.peek().equals('['))
                    return false; stack.pop(); break;
                case '}': if(stack.size() < 1 || !stack.peek().equals('{'))
                    return false; stack.pop(); break;
            }
        }
        return stack.isEmpty();
    }
}
