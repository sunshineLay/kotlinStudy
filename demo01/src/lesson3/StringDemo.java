package lesson3;

public class StringDemo {
    public static void main(String[] args) {
        String test = new String();
        test = "test";
        String test2 = "test";
        System.out.println(test == test2);
        System.out.println(test.equals(test2));
    }
}
