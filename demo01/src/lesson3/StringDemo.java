package lesson3;

public class StringDemo {
    public static void main(String[] args) {
        String test = new String();
        test = "test";
        String test2 = "test";
        //Java中==是对比引用地址
        //equals()默认是和==等效，但在String中，是比较两个字符串的内容。
        System.out.println(test == test2);
        System.out.println(test.equals(test2));
    }
}
