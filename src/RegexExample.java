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
        //r.*? : 문자r + 어떠한 문자도 상관없이 1개 이상인 문자열
        matcherString(Pattern.compile("r.+?"), "One ring to bring them all and in the darkness bind them");
        //r.*? : 문자r + 어떠한 문자도 상관없이 0개 이상인 문자열
        matcherString(Pattern.compile("r.??"), "One ring to bring them all and in the darkness bind them");
        //<div>.*</div> : 탐욕적인(Greedy) 수량
        matcherString(Pattern.compile("<div>.*</div>"), "<div>test</div><div>test2</div>");
        //<div>.*?</div> : 게으른(Lazy) 수량자
        matcherString(Pattern.compile("<div>.*?</div>"), "<div>test</div><div>test2</div>");
        //\w : 단어(word:알파벳,숫자,언더라인'_')
        matcherString(Pattern.compile("\\w"), "A1 B2 c3 d_4 e:5 ffGG77--__--");
        //\w* : 단어(word:알파벳,숫자,언더라인'_')가 0개 이상인 문자열
        matcherString(Pattern.compile("\\w*"), "A1 B2 c3 d_4 e:5 ffGG77--__--");
        //[a-z]\w* : a부터 z까지 문자 + 단어(word:알파벳,숫자,언더라인'_')가 0개 이상인 문자열
        matcherString(Pattern.compile("[a-z]\\w*"), "A1 B2 c3 d_4 e:5 ffGG77--__--");
        //\w{5} : 단어(word:알파벳,숫자,언더라인'_')가 5개인 문자열
        matcherString(Pattern.compile("\\w{5}"), "A1 B2 c3 d_4 e:5 ffGG77--__--");
        //[A-z0-9_] : \w와 같은 정규표현식, 단어(word:알파벳,숫자,언더라인'_')
        matcherString(Pattern.compile("[A-z0-9_]"), "A1 B2 c3 d_4 e:5 ffGG77--__--");
        //\W : 단어(word:알파벳,숫자,언더라인'_')가 아닌 문자
        matcherString(Pattern.compile("\\W"), "A1 B2 c3 d_4 e:5 ffGG77--__--");
        //\s : 공백인 문자
        matcherString(Pattern.compile("\\s"), "Ere iron was found or tree was hewn,    When young was mountain under moon; Ere ring was made, or wrought was woe,    It walked the forests long ago.");
        //\S : 공백이 아닌 문자
        matcherString(Pattern.compile("\\S"), "Ere iron was found or tree was hewn,    When young was mountain under moon; Ere ring was made, or wrought was woe,    It walked the forests long ago.");
        //\d : digit의 약자, 0부터 9까지의 숫자인 문자
        matcherString(Pattern.compile("\\d"), "Page 123; published: 1234 id=12#24@112");
        //\D : 숫자가 아닌 문자
        matcherString(Pattern.compile("\\D"), "Page 123; published: 1234 id=12#24@112");
        //[0-9] : 0부터 9까지의 숫자인 문자
        matcherString(Pattern.compile("[0-9]"), "Page 123; published: 1234 id=12#24@112");
        //\b. : word boundary, 어떠한 문자도 상관없는 문자열들의 시작 문자
        matcherString(Pattern.compile("\\b."), "Ere iron was found or tree was hewn,    When young was mountain under moon;");
        //.\b : word boundary, 어떠한 문자도 상관없는 문자열들의 마지막 문자
        matcherString(Pattern.compile(".\\b"), "Ere iron was found or tree was hewn,    When young was mountain under moon;");
        //\B. : word boundary, 어떠한 문자도 상관없는 문자열들의 시작 문자가 아닌 문자
        matcherString(Pattern.compile("\\B."), "Ere iron was found or tree was hewn,    When young was mountain under moon;");
        //.\B : word boundary, 어떠한 문자도 상관없는 문자열들의 마지막 문자가 아닌 문자
        matcherString(Pattern.compile(".\\B"), "Ere iron was found or tree was hewn,    When young was mountain under moon;");
        //\A... : 첫 행의 시작으로부터 어떠한 문자도 상관없는 3개의 문자열
        matcherString(Pattern.compile("\\A..."), "Ere iron was found or tree was hewn,    When young was mountain under moon;");
        //...\Z : 마지막 행의 마지막으로부터 어떠한 문자도 상관없는 3개의 문자열
        matcherString(Pattern.compile("...\\Z"), "Ere iron was found or tree was hewn,    When young was mountain under moon;");
        //\w+(?=X) : 1개 이상인 word + 대문자 X 인 문자열에서 대문자 X를 제외한 문자열
        matcherString(Pattern.compile("\\w+(?=X)"), "AAAX---aaax---111");
        //\w+ : 1개 이상인 word 문자열
        matcherString(Pattern.compile("\\w+(?=X)"), "AAAX---aaax---111");
        //\w+(?=\w) : 1개 이상인 word + word를 포함한 문자열에서 마지막 word를 제외한 문자열
        matcherString(Pattern.compile("\\w+(?=X)"), "AAAX---aaax---111");
        //?=: : 긍정형 전방탐색, 앞에서부터 문자 : 가 올 때까지의 문자열에서 :를 제외한 문자열
        //?<=\$ : 긍정형 후방탐색, 문자 $부터 시작하는 문자열에서 문자 $를 제외한 문자
        //AAA(?!X) : 부정형 전방 탐색, 마지막 문자가 X 인 문자열을 제외한 문자열
        matcherString(Pattern.compile("AAA(?!X)"), "AAAX---AAAAx");
        //\b(?<!\$)\d+\b : 부정형 후방 탐색, 문자 $로 시작하는 문자열을 제외한 1개 이상의 숫자인 문자열

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
