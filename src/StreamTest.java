import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 다양한 데이터 소스를 다루기 위해 표준화된 Collection 을 만들었지만 List,Set,Map 은 사용방법이 모두 다르다.
 * 그래서 자바에서는 스트림을 만들었고 이또한 다양한 데이터 소스를 다루기 위함이다.
 * 컬렉션(List,Set,Map)과 배열을 스트림으로 데이터를 다룰수있다.
 *
 * Stream 정의 : 데이터의 연속적인 흐름
 * 데이터 소스를 stream을 통해 연속적인 데이터를 얻을 수 있다.
 *
 * Stream 특징 :
 * 1. read only
 * 2. 최종 연산 하고나면 다시 생성해야된다.
 * 3. 최종 연산까지 중간연산이 수행되지 않는다(지연된 연산).
 * 4. 내부 반복으로 처리한다.
 * 5. 병렬스트림이 가능하다(멀티쓰레드).
 * 6. 기본형 스트림을 제공한다.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intListToStream = list.stream();
        IntStream intStream = IntStream.range(1,5); //데이터가 기본형일 때, 오토 박싱 & 언박싱의 비효율이 제거됨

        Set<Integer> set = Set.of(1,2,3,4,5);
        Stream<Integer> intSetToStream = set.stream();

        Map<Integer, String> map = Map.of(1,"1", 2, "2");
        Stream<Integer> intKeyMapToStram = map.keySet().stream();

        Stream<Integer> arrayToStream = Stream.of(new Integer[]{1,2,3,4,5});

        /**
         * 중간 연산
         * n번 가능
         * filter
         * distinct 등
         */

        /**
         * 최종 연산
         * 0 또는 1번 가능
         */
    }
}
