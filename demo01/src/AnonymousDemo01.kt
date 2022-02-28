import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

//学习流程简化 -- > 视频 + 编辑器 学习法，学完之后，再用XMind或者笔记进行总结。其实总结用XMind最好。

//匿名函数(二)
fun main() {
    //【函数内联】 inline：消除 lambda 带来的运行时开销

    //存在一个问题：lambda 在JVM会以对象实例存在，并且会对性能产生影响。Kotlin的优化机制就是内联
//    一般而言，lambda 表达式会被正常的编译成匿名类，这表示每调用一次 lambda 表达式，一个额外的类就会被创建。并且，如果 lambda 捕捉了某个变量，那么每次调用的时候都会创建一个新的对象。这导致效率较低。
//    但使用 inline 修饰符标记一个函数，可避免这种开销。

//    当一个函数被声明为 inline 时，它的函数体是内联的——换句话说，函数体会被直接替换导函数被调用的地方，而不是被正常调用。这个可通过看Kotlin ByteCode反编译的Java代码可以发现。

//    函数内联的限制：1、递归函数不能内联。2、内联函数调用另一个高阶函数。另一个高阶函数没有inline是不能使用内联函数中的函数类型参数的。

    //【函数引用】::函数引用
//    灵活使用函数不单单可以使用匿名函数，还能对具名函数使用函数引用
//    能使用Lambda表达式传递函数类型的地方都能使用具名函数的函数引用
//    推荐：只使用一次的地方用Lambda表达式来写

//    showStringTime2("贵阳",::getTimeStr)

    //函数类型作为返回类型【下面有例子】
    val test2 = test()
    println(test2("lay"))

    //闭包：就是【匿名函数】可以修改并引用自己作用域之外的变量，匿名函数可以引用定义自己的函数里面的变量
    //闭包是架构设计的基石
    //架构设计需要分模块，分类，作用域清晰。
    //对于脚本语言而言，脚本语言没有package。就需要闭包来把作用域限定清楚。

    //lambda和匿名内部类（46分钟）


}

//函数内联
//使用方式：使用 inline 修饰带有函数类型参数的函数
inline fun showStringTime2(region:String,timeStr:(Long)->String){
    println("在${region}地区，现在的时间是${timeStr(Instant.now().toEpochMilli())}")
}
fun getTimeStr(currentMillis:Long):String{
    val dfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val localTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(currentMillis), ZoneId.systemDefault())//使用系统默认的时区
    return dfPattern.format(localTime)
}
//函数类型作为返回类型
//这个例子体现出了闭包的特点。在返回值的匿名函数中使用了count这个作用域之外的变量
fun test():(String)->String{
    val count = 100
    return {
        it ->
        "$it,第${count}次加油"
    }
}