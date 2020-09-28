package leetcode;

public class ImplementstrStr {
    public static void main(String[] args) {
//        String str = "hello";
        String str = "helelo";
//        int x = str.indexOf(" ");   //-1
//        int x = str.indexOf("");    //0
//        int x = str.indexOf("eo");//-1
//        int x = str.indexOf("hello");//0
//        int x = str.indexOf("o");//4
//        int x = str.indexOf("lo");//3
//        int x = str.indexOf("el");//1
//        int x = str.indexOf("elo");//3
//        System.out.println(x);
//        boolean y = str.substring(0,5) == "elo";
//        System.out.println(str.substring(3,6));
//        boolean y = str.substring(3,6).equals("elo");
//        System.out.println(y);

//        System.out.println(str.length());
//        System.out.println(str.substring(0,0+"el".length()));
        System.out.println("aaaaa".indexOf("bba"));
        System.out.println(strStr("hello", "ll"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() < 1) return 0;
        int left = 0, right;
        while(left <= haystack.length()){
            right = left + needle.length();
            if(right > haystack.length())
                return -1;
            else if(haystack.substring(left,right).equals(needle))
                return left;
            else
                left++;
        }
        return -1;
    }


}
