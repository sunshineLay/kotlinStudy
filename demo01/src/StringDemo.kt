fun main() {
    //String 模板
    //1、直接在字符串中使用已经声明的变量，语法：$变量名
    val name = "lay"
//    println("$name,你怎么这么NB？")

    //2、直接在字符串中使用表达式，语法：${}
    val isPass = false
    println("$name,${if (isPass) "吃法" else "喝酒"}")
}