package mylabs;

public class EqualsAndHashCodeTester {

    public static void main(String[] args) {
        String a = "Apple";
        System.out.println(a.hashCode());
        String b = "Apple";
        System.out.println(b.hashCode());
        System.out.println(a);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());


        System.out.println("------------");

        String c = new String("Apple");
        String d = new String("Apple");
        System.out.println(d.equals(c));
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());

    }
}
