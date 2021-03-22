import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {

//        pattern("^[0-9]*$", "123456789");
//        matcher(Pattern.compile("^[a-zA-Z]*$"), "abcdef");
//        pattern("Hello", "Hello, world!");
//        matcher(Pattern.compile("Hello"), "Hello, world!");
//        matcher(Pattern.compile("Hello,   world!"), "Hello, world!");


        /**
         * 아래 예제는 first match 기준으로 출력됩니다.
         * 역슬래시를 문자열 패턴으로 인식하기 위하여 더블역슬래시로 작성하였습니다.
         */
        //^ : who로 시작되는 -> 처음 who
        matcherString(Pattern.compile("^who"), "who is who");
        //$ : who로 끝나는 -> 마지막 who
        matcherString(Pattern.compile("who$"), "who is who");
        //^$ : is not exist
        matcherString(Pattern.compile("^$"), "$12$ \\-\\ $25$");
        //\$ : 문자열 $을 찾아라 (escape)
        matcherString(Pattern.compile("\\$"), "$12$ \\-\\ $25$");
        //^\$ : 문자열 $로 시작되는 문자를 찾아라 (escape)
        matcherString(Pattern.compile("^\\$"), "$12$ \\-\\ $25$");
        //\$$ : 문자열 $로 끝나는 문자를 찾아라 (escape)
        matcherString(Pattern.compile("\\$$"), "$12$ \\-\\ $25$");
        //\\ : \의 역할을 해제한 문자열\을 찾아라 (escape)
        matcherString(Pattern.compile("\\\\"), "$12$ \\-\\ $25$");
        //. : 어떠한 문자/공백/특수문자건 상관없이 찾아라
        matcherString(Pattern.compile("."), "Regular expressions are powerful!!!");
        //...... : 어떠한 문자/공백/특수문자건 상관없이 찾아라
        matcherString(Pattern.compile("......"), "Regular expressions are powerful!!!");
        //. : 어떠한 문자/공백/특수문자건 상관없이 찾아라
        matcherString(Pattern.compile("."), "O.K.");
        //\. : 어떠한 문자/공백/특수문자건 상관없이 찾아라
        matcherString(Pattern.compile("\\."), "O.K.");
        //\..\. : 어떠한 문자/공백/특수문자건 상관없이 찾아라
        matcherString(Pattern.compile("\\..\\."), "O.K.");
        //[] : 대괄호 안에 있는 문자 중 한개를 찾아라
        matcherString(Pattern.compile("[oyu]"), "How do you do?");
        //[]. : 대괄호 안에 있는 문자 중 한개 + 어떠한 문자든 상관없는 문자, 총 2개의 문자열을 찾아라
        matcherString(Pattern.compile("[dH]."), "How do you do?");
        //[][] : 대괄호 안에 있는 문자 중 한개 + 대괄호 안에 있는 문자 중 한개, 총 2개의 문자열을 찾아라
        matcherString(Pattern.compile("[owy][yow]"), "How do you do?");
        //[] : 대괄호 안에 있는 문자열을 찾아라
        matcherString(Pattern.compile("[C-K]"), "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz 0123456789");
        //[] : 대괄호 안에 있는 문자열을 찾아라
        matcherString(Pattern.compile("[C-Ka-d2-6]"), "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz 0123456789");
        //[^] : 대괄호 안에 있는 문자열을 제외한 문자열을 찾아라
        matcherString(Pattern.compile("[^A-Y]"), "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz 0123456789");
        //[^] : 대괄호 안에 있는 문자열을 제외한 문자열을 찾아라
        matcherString(Pattern.compile("[^ABCDabc]"), "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz 0123456789");
        //(|) : 문자열 또는 문자열을 찾아라
        matcherString(Pattern.compile("(on|ues|rida)"), "Monday Tuesday Friday");
        //(|)day : 문자열 또는 문자열 + day를 찾아라
        matcherString(Pattern.compile("(Mo|ues|Fri)day"), "Monday Tuesday Friday");
        //..(|) : 어떠한 문자든 상관없는 2개의 문자열 + 문자열 또는 문자열 + ay를 찾아라
        matcherString(Pattern.compile("..(o|sd|id)ay"), "Monday Tuesday Friday");
        //* : *앞 어떠한 문자가 0개 이상인 문자열을 찾아라
        matcherString(Pattern.compile("a*b"), "aabc abc bc");
        //+ : +앞 어떠한 문자가 1개 이상인 문자열을 찾아라
        matcherString(Pattern.compile("a+b"), "bc bbbc aaaaaabc");
        //? : ?앞 어떠한 문자가 0~1개인 문자열을 찾아라
        matcherString(Pattern.compile("a?b"), "caabc aaabbbc aaaaaabc");
        //.* : 모든 텍스트를 찾아라
        matcherString(Pattern.compile(".*"), "-@- *** -- \"*\" -- *** -@-");
        //-A*- : 문자- + 문자A가 있든없든 상관없음 + 문자- 를 찾아라
        matcherString(Pattern.compile("-A*-"), "-@- *** -- \"*\" -- *** -@-");
        //[-@]* : 문자- 또는 문자@를 모두 찾아라
        matcherString(Pattern.compile("[-@]*"), "-@- *** -- \"*\" -- *** -@-");
        //\*+ : 문자*가 1개 이상인 문자열을 찾아라
        matcherString(Pattern.compile("\\*+"), "-@@@- * ** - - \"*\" -- * ** -@@@-");
        //-@+- : 문자- + 문자@가 1개 이상인 문자열 + 문자- 를 찾아라
        matcherString(Pattern.compile("-@+-"), "-@@@- * ** - - \"*\" -- * ** -@@@-");
        //[^ ]+ : 공백을 제외한 문자가 1개 이상인 문자열을 찾아라
        matcherString(Pattern.compile("[^ ]+"), "     * ** - - \"*\" -- * ** -@@@-");
        //-X?XX?X : 문자- + X가 0~1개인 문자 + 문자X + X가 0~1개인 문자 + 문자X
        matcherString(Pattern.compile("-X?XX?X"), "--XX-@-XX-@@-XX-@@@-XX-@@@@-XX-@@-@@-");
        //-@?@?@?- : 문자- + @가 0~1개인 문자 + @가 0~1개인 문자 + @가 0~1개인 문자 + 문자-
        matcherString(Pattern.compile("-@?@?@?-"), "--XX-@-XX-@@-XX-@@@-XX-@@@@-XX-@@-@@-");
        //[^@]@?@ : 문자@를 제외한 문자 + @가 0~1개인 문자 + 문자@
        matcherString(Pattern.compile("-@?@?@?-"), "--XX-@-XX-@@-XX-@@@-XX-@@@@-XX-@@-@@-");
        //.{5} : 어떤 문자도 상관없이 5개의 문자열을 찾아라
        matcherString(Pattern.compile(".{5}"), "One ring to bring them all and in the darkness bind them");
        //[els]{1,3} : 문자e 또는 문자l 또는 문자s에 상관없이 1개 이상 3개 이하인 문자열
        matcherString(Pattern.compile("[els]{1,3}"), "Oness ring to bring them all and in the darkness bind them");
        //[a-z]{3,} : 문자a에서 문자z 중 상관없이 3개 이상인 문자열
        matcherString(Pattern.compile("[a-z]{3,}"), "One ring to bring them all and in the darkness bind them");
        //AB*A : 문자A + 문자B가 0개 이상 + 문자A
        matcherString(Pattern.compile("AB*A"), "AA ABA ABBA ABBBA");
        //AB{0,}A : 문자A + 문자B가 0개 이상 + 문자A
        matcherString(Pattern.compile("AB{0,}A"), "AA ABA ABBA ABBBA");
        //AB+A : 문자A + 문자B가 1개 이상 + 문자A
        matcherString(Pattern.compile("AB+A"), "AA ABA ABBA ABBBA");
        //AB{1,}A : 문자A + 문자B가 1개 이상 + 문자A
        matcherString(Pattern.compile("AB{1,}A"), "AA ABA ABBA ABBBA");
        //AB?A : 문자A + 문자B가 0~1개 + 문자A
        matcherString(Pattern.compile("AB?A"), "AA ABA ABBA ABBBA");
        //AB{0,1}A : 문자A + 문자B가 1개 이상 + 문자A
        matcherString(Pattern.compile("AB{0,1}A"), "AA ABA ABBA ABBBA");
        //r.* : 문자r + 어떠한 문자도 상관없이 0개 이상인 문자열
        matcherString(Pattern.compile("r.*"), "One ring to bring them all and in the darkness bind them");
        //r.*? : 문자r + 어떠한 문자도 상관없이 0개 이상인 문자열
        matcherString(Pattern.compile("r.*?"), "One ring to bring them all and in the darkness bind them");
        //<div>.*</div> : 탐욕적인(Greedy) 수량
        matcherString(Pattern.compile("<div>.*</div>"), "<div>test</div><div>test2</div>");
        //<div>.*?</div> : 게으른(Lazy) 수량자
        matcherString(Pattern.compile("<div>.*?</div>"), "<div>test</div><div>test2</div>");


        /**
         * 정규식 테스트 가능
         * https://regexr.com/
         */



    }

    private static void pattern(String pattern, String val) {
        boolean regex = Pattern.matches(pattern, val);
        System.out.println(regex);
    }

    private static void matcher(Pattern compile, String val) {
        Matcher matcher = compile.matcher(val);
        System.out.println(matcher.find());
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
