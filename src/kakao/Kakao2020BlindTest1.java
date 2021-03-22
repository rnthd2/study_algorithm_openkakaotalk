package kakao;

public class Kakao2020BlindTest1 {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
    }

    static String compress = "";

    static int solution(String s) {
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length(); i++) {
            getCompress(s, i, 0, 1);
            result = Math.min(compress.length(),result);
            compress="";
        }
        return result;
    }

    static void getCompress(String s, int num, int index, int count) {
        String s1 = s.substring(index, index+num);
        if(index+(num*2) >= s.length()) {
            compress += (count>1?count:"") + s1;
            compress += s.substring(index+num);
            return;
        } else {
            String s2 = s.substring(index + num, index + (num * 2));
            if(s1.equals(s2)){
                getCompress(s, num, index+num, ++count);
            } else {
                compress += (count>1?count:"") + s1;
                getCompress(s, num, index+num, 1);
            }
        }
    }

}












//
//    public static int solution2(String s) {
//        int answer = Integer.MAX_VALUE;
//        int sum = 0;
//
//        for (int i = 1; i < s.length(); i++) {
//            int index = 0;    //1개로 자를때, 2개로 자를때 ....
//            int count = 1;
//            while(index+i < s.length()){
//                int split = index+i;
//                String s1 = s.substring(index, split);
//                String s2 = s.substring(split, split+i);
//                if(s1.equals(s2)){
//                    count++;
//                } else {
//                    int x = String.valueOf(count).length();
//                    if(count>1){
//                        sum+=x+1;
//                    } else {
//                        sum +=1;
//                    }
////                    sum += ((count>1)?1:(x+1));
//                    count=1;
//                }
//                index++;
//            }
//            answer = Math.min(answer, sum);
//
//        }
//
//
//        return answer;
//    }}
