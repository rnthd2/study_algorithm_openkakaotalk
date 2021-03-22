package leetcode;

public class CountandSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        //n은 회전 횟수
        if(n == 1) return "11";
        if(n == 2) return "21";

        StringBuilder result = new StringBuilder("21");
        for (int i = 1, cnt = 1; i < n; i++, cnt=1) {
            StringBuilder current = result;
            result = new StringBuilder();
            char c = current.charAt(0);

            //뒤에랑 같으면 개수만 늘리고 , 다르면 숫자쓰고 다음꺼
            for (int j = 1; j <= current.length(); j++) {
                if(current.charAt(j) != c){
                    result.append(cnt).append(c);
                    cnt = 1;
                    c = current.charAt(j);
                } else
                    cnt++;
            }
        }
        return result.toString();
    }


}
