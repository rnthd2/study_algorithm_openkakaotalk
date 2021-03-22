package leetcode;

import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
		System.out.println(isValid("({{{{}}}))"));
		System.out.println(isValid("[({(())}[()])]"));
		System.out.println(isValid("]"));
	}

	//괄호 짝맞추기는 stack 으로...
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
