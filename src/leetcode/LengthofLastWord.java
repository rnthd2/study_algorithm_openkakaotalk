package leetcode;

public class LengthofLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord(" "));
    }
    public static int lengthOfLastWord(String s) {
        int length = 0;
        char[] chars = s.trim().toCharArray();

        for (int i = chars.length - 1; i >= 0 && chars.length > 0; i--) {
            if(chars[i] == ' '){
                break;
            } else {
                length++;
            }
        }
        return length;
    }
}
