import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableTest {

    static class Cars {
        private final List<Car> cars;

        Cars(List<Car> cars) {
            this.cars = cars;
        }

        public List<Car> getCars() {
            return cars;
        }
    }

    static class Car {
        private final String name;

        public Car(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


    /**
     * 불변 객체
     *
     * 재할당은 가능하지만, 한번 할당되면 변경할 수 없다.
     * setter 설정도 불가능하다.
     * 외부로부터 할당된 객체 내부를 보호한다.
     */
    static class ImmutableCars {
        private final List<Car> cars;

        /**
         * 방어적 복사
         *
         * 깊은 복사는 아니다. 내부 요소들은 공유하고 있다.
         *
         * @param cars
         */
        public ImmutableCars(List<Car> cars){
            this.cars = new ArrayList<>(cars);
        }

        /**
         * Collections.unmodifiableList 사용
         *
         * @return 불변 리스트
         */
        public List<Car> getCars() {
            return Collections.unmodifiableList(cars);
        }
    }

    static class ImmutablePerson {
        private final String name;
        private final int age;

        ImmutablePerson(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "ImmutablePerson{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class ImmutablePersons {
        private final List<ImmutablePerson> people;

        public ImmutablePersons(List<ImmutablePerson> people) {
            this.people = new ArrayList<>(people);  //새로운 주소값으로 할
        }

//        public ImmutablePersons(List<ImmutablePerson> people) {
//            this.people = people;
//        }

        public List<ImmutablePerson> getPeople() {
            return people;
        }
    }

    private static void tester3(){
        List<ImmutablePerson> people = new ArrayList<>();
        people.add(new ImmutablePerson("a", 1));
        people.add(new ImmutablePerson("b", 2));

        ImmutablePersons immutablePersons = new ImmutablePersons(people);
        people.add(new ImmutablePerson("c", 3));

        for (ImmutablePerson person : immutablePersons.getPeople()) {
            System.out.println(person.toString());
        }
    }

    public static void main(String[] args) {
//        tester1();
//        tester2();
        tester3();
    }

    /**
     * 불변 객체 성립 안됨
     */
    private static void tester1() {
        List<Car> names = new ArrayList<>();
        names.add(new Car("car1"));
        Cars cars = new Cars(names);
        for (Car car : cars.getCars()) {
            System.out.println(car.toString());
        }
        System.out.println(cars);

        names.add(new Car("car2"));
        for (Car car : cars.getCars()) {
            System.out.println(car.toString());
        }
        System.out.println(cars);
    }

    private static void tester2(){
        List<Car> names = new ArrayList<>();
        names.add(new Car("car1"));
        ImmutableCars cars = new ImmutableCars(names);
        for (Car car : cars.getCars()) {
            System.out.println(car.toString());
        }
        System.out.println(cars);

        names.add(new Car("car2")); //추가 안됨
        for (Car car : cars.getCars()) {
            System.out.println(car.toString());
        }
        System.out.println(cars);   //같은 주소값

        List<Car> anotherCars = new ArrayList<>(cars.getCars());
        anotherCars.add(new Car("car2"));
        System.out.println(anotherCars);    //서로 다른 주소값을 가지고 있음

        List<Car> cars1 = cars.getCars();   //같은 인스턴스 변수를 가리키고 있음
        cars1.add(new Car("car3")); //런타임 에러
    }
}
