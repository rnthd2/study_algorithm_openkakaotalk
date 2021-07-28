import java.util.*;

public class FunctionalInterface {
    public static void main(String[] args) {

        Object object = new Object(){
            int max(int a, int b){
                return Math.max(a,b);
            }
        };

//        int max = object.max(1,2); // error! 함수형 인터페이스 필요

        MaxFunctionalInterface f = new MaxFunctionalInterface() {
            @Override
            public int max(int a, int b) {  //public 이어야함
                return Math.max(a, b);
            }
        };

        MaxFunctionalInterface f1 = (a, b) -> Math.max(a, b);

        MinFunctionalInterface f2 = (a, b) -> Math.min(a, b);

//        MultipleFunctionalInterface f3 = ... 람다식은 익명객체이기 때문에 함수형 인터페이스가 아닌 이상 어떤 메서드인지 알 수 없음

        /**
         * example
         */
        List<String> list = Arrays.asList("a", " b", "c");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
        Collections.sort(list, Comparator.reverseOrder());


        /**
         * example2 함수형 인터페이스 타입의 매개변수
         */
        VoidFunctionalInterface m = () -> System.out.println("max functional interface call start!");
        test(m);

        test(() -> System.out.println("max functional interface call start!"));

        //호출 가능
        MaxFunctionalInterface.exceptionStaticMethod();
        f1.exceptionDefaultMethod();
    }

    static void test(VoidFunctionalInterface m){
        m.method();
    }

    /**
     * 함수형 인터페이스 타입의 반환타입
     * @return
     */
    VoidFunctionalInterface test2() {
        VoidFunctionalInterface v = () -> {};
        return v;
    }

    VoidFunctionalInterface test3() {
        return () -> {};
    }

    interface VoidFunctionalInterface{
        public abstract void method();
    }

    // 함수형 인터페이스 : 단 하나의 추상 메서드만 선언된 인터페이스
    @java.lang.FunctionalInterface
    interface MaxFunctionalInterface{
        public abstract int max(int a, int b);
        public static void exceptionStaticMethod(){
            System.out.println("except static method!");
        }
        public default void exceptionDefaultMethod(){
            System.out.println("except default method!");
        }
    }
    @java.lang.FunctionalInterface
    interface MinFunctionalInterface{
        public abstract int min(int a, int b);
    }

    interface MultipleFunctionalInterface{
        public abstract int max(int a, int b);
        public abstract int min(int a, int b);
    }
}


