import java.util.*;
import java.util.stream.Collectors;

public class Utils {

    /********************   converter   ********************/

    /**
     * 문자열을 int 배열로 변환
     *
     * @return
     */
    public static int[] convertStringToIntArray(String str){
        return Arrays.asList(str.split("")).stream().mapToInt(Integer::parseInt).toArray();
    }

    /**
     * 문자 배열을 int 배열로 변환
     *
     * @param array
     * @return
     */
    public static int[] convertStringArrayToIntArray(String[] array){
        return Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
    }

    /**
     * Integer 배열을 ArrayList로 변환
     *
     * @param array
     * @return
     */
    public static List<Integer> convertIntegerArrayToList(Integer[] array){
        return Arrays.asList(array);
    }

    /**
     * ArrayList 를 Integer 배열로 변환
     *
     * @param list
     * @return
     */
    public static Integer[] convertListToIntegerArray(List<Integer> list){
        return null;
    }

    /**
     * int 배열을 ArrayList로 변환
     *
     * @param array
     * @return
     */
    public static ArrayList<Integer> convertIntArrayToList(int[] array){
        return new ArrayList<>(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }

    /**
     * todo ArrayList 를 int 배열로 변환
     *
     * @param list
     * @return
     */
    public static int[] convertListToIntArray(List<Integer> list){
        return null;
    }


    /********************   순열과 조합   ********************/
    /**
     * 모든 자리의 순열 만들기
     * programmers/completeSearch/Solution2[소수 찾기]
     * "011"의 문자열로 만들 수 있는 자리수에 상관 없이 모든 숫자 찾기(0,1,10,11,110,101)
     *
     * @param prefix prefix ""
     * @param str    찾고자 하는 문자열 "011"
     * @param set    찾은 숫자 저장 new HashSet();
     */
    public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if (!prefix.equals("")) {
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
        }
    }


    /**
     * 괄호 여부
     * codility/training/Solution10
     *
     * @param s
     * @return
     */
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

    /********************   정렬   ********************/
    /**
     * 배열 정렬하기
     * programmers/hash/Solution2[전화번호 목록]
     * new String[]{"4","2","3"} 이나 new Integer[]{4,2,3}을 정렬하는 방법
     * Integer가 아닌 int 배열은 int[] 로 매개변수를 받아 사용해야한다.
     *
     * @param objects 정렬 하고자 하는 변수
     * @return 정렬 한 변수
     */
    public static Object[] arraySorting(Object[] objects) {
        Arrays.sort(objects);
        return objects;
    }

    /**
     * Comparable와 Comparator의 차이와 사용법
     *
     * Comparable은 compareTo를 오버라이드하여 들어온 매개변수 한 개와 비교하지만
     * Comparator의 compare은 오버라이드하여 들어온 매개변수끼리 비교한다
     * https://st-lab.tistory.com/243
     *
     * 현재 객체 < 파라미터로 넘어온 객체: 음수 리턴
     * 현재 객체 == 파라미터로 넘어온 객체: 0 리턴
     * 현재 객체 > 파라미터로 넘어온 객체: 양수 리턴
     * - Arrays.sort(array)
     * - Collections.sort(list)
     * https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html
     */
    static class Sorting implements Comparable<Sorting>{
        int order, reverse;

        public Sorting(int order, int reverse) {
            this.order = order;
            this.reverse = reverse;
        }

        @Override
        public int compareTo(Sorting s) {
            //오름차순
//            return Integer.compare(order, s.order);
//            return order - s.order;
            //내림차순
//            return Integer.compare(s.order, order);

            if(Integer.compare(order, s.order) == 0) {
                return Integer.compare(s.order, order);
            } else {
                return Integer.compare(order, s.order);
            }
        }
    }

    /********************   선언   ********************/
    public void doDeclareFillIntArray(int size){
        int[] array = new int[size];
        Arrays.fill(array, 1);
    }

    /********************   문자열   ********************/
    /**
     * 접두어 확인
     * programmers/hash/Solution2[전화번호 목록]
     * "119"의 접두어가 "1195524421"에 있는지 확인하는 방법
     *
     * @param s1 확인 하고자 하는 문자열 "1195524421"
     * @param s2 접두어 "119"
     * @return 접두어인 경우 true 반환
     */
    public static boolean isStartsWith(String s1, String s2) {
        return s1.startsWith(s2);
    }

    /********************   맵(map)   ********************/
    /**
     * map의 기본값 혹은 값 가져오기
     * programmers/hash/Solution3[위장]
     * map에 값이 없으면 defaultValue(0)를 가져오고 map에 값이 있으면 get(s)+1이 실행됨
     * map의 key(obj) 값이 몇 번 사용되었는지 찾고 싶을 때 사용
     *
     * @param map
     * @param obj
     */
    public static void putDefaultValueOrGetValueInMap(HashMap<Object, Integer> map, Object obj) {
        map.put(obj, map.getOrDefault(obj, 0) + 1);
    }

    /********************   기타   ********************/
    /**
     * 소수 찾기
     * programmers/completeSearch/Solution2[소수 찾기]
     * 1과 0을 제외한 에라토스테네스의 체 알고리즘을 적용한 방법
     * cf. https://hak0205.tistory.com/10
     *
     * @param num 찾고자 하는 숫자
     * @return 소수 여부
     */
    public static boolean isPrime(int num) {
        if (num == 1 || num == 0)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    /**
     * 팩토리얼
     *
     * @param n
     * @return
     */
    static double factorial(int n) {
        if(n == 0) {
            return 1;
        } else if(n <= 1) {
            return n;
        } else {
            return factorial(n-1)*n;
        }
    }

    public static void main(String[] args) {
        System.out.println(arraySorting(new String[]{"4", "2", "3"}));
        System.out.println(arraySorting(new Integer[]{4, 2, 3}));
        System.out.println(isStartsWith("119", "1195524421"));

        String[] ex = {"A", "B", "C", "A"};
        HashMap<Object, Integer> map = new HashMap<>();
        for(Object str : ex) putDefaultValueOrGetValueInMap(map,str);
        System.out.println(":: MAIN :: " + map);

        List<Sorting> list = new ArrayList<>();
        Sorting sorting1 = new Sorting(1, 2);
        Sorting sorting2 = new Sorting(2, 1);
        list.add(sorting1);
        list.add(sorting2);
        Collections.sort(list);
        //배열인 경우, Arrays.sort(list);
        list.forEach(s -> System.out.println(s.order + "," + s.reverse));

        String[] strings = {"1", "2", "3"};
        convertStringArrayToIntArray(strings);

    }
}
