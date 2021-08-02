import java.util.HashMap;

public class EqualsOverrideTest {
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            Person person = (Person) obj;
            if(this.name == person.name){
                return true;
            }
            if(this.age == person.age){
                return true;
            }
            return false;
        }

        @Override
        public int hashCode(){
            final int prime = 31;
            int hashCode = 1;

            hashCode = prime * hashCode + ((name == null) ? 0 : name.hashCode());
            hashCode = prime * hashCode + age;

            return hashCode;
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person("a", 1);
        Person person2 = new Person("a", 1);
        System.out.println(person1.equals(person2));

        HashMap<Person, Integer> map = new HashMap<>();
        map.put(person1, 0);
        map.put(person2, 1);
        System.out.println(map.size());
    }
}
