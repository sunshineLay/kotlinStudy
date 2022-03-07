//第三课：字符串、数字类型、标准库函数
const val TESTSTR = "liuanyi's friend.\\xigua's hahah"
const val NAME = "liuanyi,songzhiyuan,wangyuan"
const val REPSTR = "aeiou,03047"
const val REPSTR2 = "aeiou,03047"
fun main() {
    //一、String 模板
    //1、直接在字符串中使用已经声明的变量，语法：$变量名
//    val name = "lay"
//    println("$name,你怎么这么NB？")
    //2、直接在字符串中使用表达式，语法：${}
//    val isPass = false
//    println("$name,${if (isPass) "吃法" else "喝酒"}")

//    二、String substring,字符串截取，支持IntRange类型（整数范围类型参数）
//    until [0,8)
    NAME.substring(0 until 8).apply {
        println(this)
    }
//    indexof 查找某一个元素或字符串在原字符串中第一次出现的下标
    TESTSTR.indexOf("\\").apply {
        println(this)
    }
//    split 返回的是list集合数据。切割字符
//    val splitList = NAME.split(",")
    NAME.split(",").forEach(::println)
//    List集合支持解构语法特性. 它允许你在一个表达式里给N个变量赋值。N>=1
    val(lay:String,szy:String,wy:String) = NAME.split(",")
    println("大哥$wy,二师兄$lay,沙师弟$szy")
//    replace 字符串替换
//    第一个参数是正则表达式，Regex("[aeiou]")
//    第二个函数是如何替换搜索到的字符，
    val replace = REPSTR.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "1"
            "e" -> "2"
            "i" -> "3"
            "o" -> "4"
            "u" -> "5"
            else -> it.value
        }
    }
    println(REPSTR)
    println(replace)
//    字符串比较
//    == 和 ===
//    == 检查两个字符串中的字符是否匹配
//    === 检查两个变量是否指向内存堆上同一个对象
//    Kotlin 在JVM上运行的时候和Java是没有任何区别的。
//    所以，同样字符串内容的两个对象指向同一个字符串常量池内存。
    println(REPSTR == NAME)
    println(REPSTR === REPSTR2)
//    forEach 遍历字符




}