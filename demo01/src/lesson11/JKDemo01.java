package lesson11;

import kotlin.jvm.functions.Function1;

import java.io.IOException;
import java.util.List;

public class JKDemo01 {
    public static void main(String[] args) {
//        JK.sayByeBye();
//        List<String> spells = new Spellbook().getSpells();
//        for (String str:spells){
//            System.out.println(str);
//        }

        //Java调用Kt中抛出异常
//        try {
//            JK.accpetData();
//        } catch (IOException e) {
//            //由于@Throws(IOException::class)东西，
//            // 让Java清楚的知道了Kotlin抛出的异常。
//            // 因为Kotlin进行编译之后的字节码翻译到Java语言之后会强制类型转换为Throwable 类型
//            // throw (Throwable)(new IOException());
//            //所以，只有通过注解@Throws(IOException::class)才能将具体异常传递给Java
//            e.printStackTrace();
//        }

        //Java 调用函数类型函数
//        Function1<String, String> transformStr = JK.getTransformStr();
//        String result = transformStr.invoke("TRUE");
//        System.out.println(result);
    }
}
