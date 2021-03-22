package leetcode;

public class LongestValidParentheses {
    public static void main(String[] args) {
//        System.out.println(longestValidParentheses("(()"));
//        System.out.println(longestValidParentheses(")()())"));
//        System.out.println(longestValidParentheses(""));
//        System.out.println(longestValidParentheses(")("));
//        System.out.println(longestValidParentheses("()()"));
//        System.out.println(longestValidParentheses("(()"));
//        System.out.println(longestValidParentheses("(()())"));
//        System.out.println(longestValidParentheses("()(()"));
        System.out.println(longestValidParentheses("(()"));
    }

    //가장 긴 유효한 괄호

    public static int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        char[] cs = s.toCharArray();
        int longest = 0;
        for (int i = 0; i < n; ++i) {
            if (cs[i] == ')' && i > 0) {
                if (cs[i - 1] == '(') {
                    dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
                } else {
                    int j = i - 1 - dp[i - 1];
                    if (j >= 0 && cs[j] == '(') {
                        dp[i] = dp[i - 1] + 2 + (j - 1 >= 0 ? dp[j - 1] : 0);
                    }
                }
                longest = Math.max(longest, dp[i]);
            }
        }
        return longest;


    }

//    public static int longestValidParentheses(String s) {
//
//        int result = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 2; j <= s.length(); j += 2) {
//                if (result < j-i){
//                    if(isValid(s.substring(i, j))){
//                        result = j-i;
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    //괄호 짝맞추기는 stack 으로...
//    public static boolean isValid(String s) {
//        Stack stack = new Stack();
//        for (char c : s.toCharArray()) {
//            switch (c){
//                case '(':
//                    stack.push(c);
//                    break;
//                case ')': if(stack.size() < 1 || !stack.peek().equals('('))
//                    return false; stack.pop(); break;
//            }
//        }
//        return stack.isEmpty();
//    }

}
