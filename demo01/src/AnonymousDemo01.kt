import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

//学习流程简化 -- >
// 第一步，视频 + 编辑器 学习法。
// 第二步，用（纸笔）费曼学习法进行复习。用XMind进行总结。
// 第三步，学完一个系列之后，结合总结笔记开始输出专栏博客。
// 专栏博客：（MarkDown来写）前言：做这件事的目的和当前现状。纲领：XMind的导出图片。正文：原理解析一篇；如何使用一篇；后记:之后做什么。参考：经验集中介绍。【1000字到1500字】


//匿名函数(二)
fun main() {
    //【函数内联】 inline：消除 lambda 带来的运行时开销

    //存在一个问题：lambda 在JVM会以对象实例存在，并且会对性能产生影响。Kotlin的优化机制就是内联
//    一般而言，lambda 表达式会被正常的编译成匿名类，这表示每调用一次 lambda 表达式，一个额外的类就会被创建。并且，如果 lambda 捕捉了某个变量，那么每次调用的时候都会创建一个新的对象。这导致效率较低。
//    但使用 inline 修饰符标记一个函数，可避免这种开销。

//    当一个函数被声明为 inline 时，它的函数体是内联的——换句话说，函数体会被直接替换到函数被调用的地方，而不是被正常调用。这个可通过看Kotlin ByteCode反编译的Java代码可以发现。

//    函数内联的限制：1、递归函数不能内联。2、内联函数调用另一个高阶函数。另一个高阶函数没有inline是不能作为内联函数中的函数类型参数的。3、避免内联过大函数。4、没有函数类型参数的函数没有内联的意义。

    //【函数引用】::函数引用
//    灵活使用函数不单单可以使用匿名函数，还能对具名函数使用函数引用
//    能使用Lambda表达式传递函数类型的地方都能使用具名函数的函数引用
//    推荐：只使用一次的地方用Lambda表达式来写

//    showStringTime2("贵阳",::getTimeStr)

    //函数类型作为返回类型【下面有例子】
//    val test2 = test()
//    println(test2("lay"))

    //闭包：就是【匿名函数】可以修改并引用自己作用域之外的变量，匿名函数可以引用定义自己的函数里面的变量
//    {
//        //1
//        {
//            //2
//            {
//                //3
//                {
//                    //4
//                }
//            }
//        }
//    }
    //4可以使用1、2、3的变量，3可以使用1、2的变量，这就是闭包。

    //闭包是架构设计的基石
    //架构设计需要分模块，分类，作用域清晰。
    //对于脚本语言而言，脚本语言没有package。就需要闭包来把作用域限定清楚。

    //闭包详述 -闭包本质是指函数和它所处外部的环境融为一体。他可以任意使用所处环境的资源。
    //Java 的闭包是局限的不完整的闭包————以匿名内部类无法使用所在函数区域的局部变量为例。（只有被final标记才能使用。）这是因为Java的方法对应JVM的栈帧结构，在栈帧结构中一个方法结束，所在的栈帧就出栈了。不在内存中了。所以Java中无法实现这种情况的闭包。
    //通常这种情况下，在Java中会把这个局部变量写成全局变量。或者写成一个类对象的属性。
    //由于引用对象会存储于堆中，不会因为栈帧的因素清理出内存。所以此时可以别扭的“实现”闭包的结果。
    //Kotlin 在JVM中的字节码反编译成Java代码之后可以看出，正是如此。
    //Kotlin 本身是完全支持闭包的。
    //js也支持闭包。在js中，一个闭包的环境是被当做一个对象进行储存的，所以js的语法支持绝对闭包。

    //关于内联函数的复习 - ing

    //lambda和匿名内部类
//    Java中的接口定义行为类型+匿名内部类实现接口行为 等效于 Kotlin中的匿名函数参数。

    //null 安全
//    Kotlin把运行期可以出现的空指针异常，提前在编译期强迫我们进行修改。这是对于Java的巨大进步。 -- 对比Java文件AnonymousDemo01
//    var str2 = readLine()//readLine() 控制台输入
//    println("你输入的是$str2")

    //可空性 类型？
    val str:String? = null

    //Kotlin 不允许在可空类型上调用对象方法，除非你主动接手安全管理
//    三种方案
//    一、安全调用操作符
//    例子：str?.length
//    此时，如果对象为null会跳过相关的函数调用。
//    适用于链式操作调用。最常用。
//    二、使用带let的安全调用操作符
//    let是作用域函数
//    适用场景：1、适用于对于一个复杂的对象进行链式操作时候减少空调用；2、对于调用对象it进行默认值处理。
//    三、适用于可能报空的操作，使用非空断言操作符！！.
//    val length = str!!.length
//    println(length)
//    四、使用if判断是否为空 -- 基本用不上
//    if(str !=null){
//        println("str不空")
//    }else{
//        println("str空")
//    }
//    五、空合并操作符?: 名叫elvis操作符。可以给我们一个缺省值
//    情况一：A ?: B
//    A为null,就使用B，B可以是一个代码块
//    val 牛逼 = str ?: "牛逼"
//    println(牛逼)
//    情况二：A是object?.let{}，结合let使用可以代替if-else


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
        "$it,第${count+MAX}次加油"
    }
}