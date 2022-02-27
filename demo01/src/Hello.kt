//编译时常量声明一：top-Level
const val MAX = 100

fun main() {
    //声明变量
    val hello:String = "666"//存在类型推断
//    println(hello)
    //var 和 val的区别：var 是可修改的；val是只读的。某种角度来说，val = final
    var name = "Jack"
    name = "lay"
//    println(name+hello)
    //我们大多数情况下，默认优先使用val,等到需要改变的变量，我们再使用var.

    //声明变量但是不初始化
    val result:Int
    val couple:String

    //输出MIN
//    println(Data.MIN)
    //Java 有两种数据类型：基本数据类型和引用类型（基本数据类型放在栈，引用类型放在堆）
    //Kotlin 只有引用类型。为了性能，在JVM字节码中会自动转换成基本数据类型。

    //条件语句\条件表达式
    //01
    val isPass = true
//    if (isPass) println("通过")
    //02
    val isMan = true
    if (isMan){
//        println("男人")
    }else{
//        println("女人")
    }
    //03：表达式
    val a = 4
    val b = 7
    val max:Int = if(a>b) a else b

    //Range 表达式、区间、数列
    //..是运算符
    //1..20 [1,20] 等价于 1.rangeTo(20)
    //1 until 20 [1,20)
    // in or !in 区间、集合
    //IntRange、LongRange、CharRange 可以进行迭代，但是浮点型（Double和Float的range），只能判断in or !in

    // downTo、step、reversed、.last\.first\.step、.filter(过滤函数)
    // [#]自定义Range  - 待ing - 暂时没有需求，之后再继续补强

//    if(a in 1..20) println("正确")//表示[1,20],左闭右闭区间
//    if(a in 20 downTo 1) println("反向-正确")
    //类的区间
//    val versionRange = Version(1, 11)..Version(1, 30)
//    println(Version(0, 9) in versionRange)
//    println(Version(1, 20) in versionRange)

    //结合for表现数列
//    for (i in 20 downTo 1 step 2) println(i)
//    for (i in (1..20).reversed()) println(i)
//    val last = (1..12 step 2).last
//    val first = (1..12 step 2).first
//    val step = (1..12 step 2).step
//    println("last:$last")
//    println("first:$first")
//    println("step:$step")

    //过滤函数.filter() 过滤函数的返回值是经过过滤之后的对应集合
//    val filter = (1..20).filter { it % 3 == 0 }
//    //List.forEach{} 遍历输出当前集合
//    filter.forEach { println(it) }

    //可以链式调用
//    (1..30).filter { it % 4 == 0 }.forEach { println(it) }
//    1.rangeTo(10).forEach { println(it) }

    //when 表达式 相当于 Java的switch 表达式
    // 所有写到else if的条件语句，都应该考虑去使用when表达式
//    val grade = when (10) {
//        in 1..20 -> "第一阶段"
//        in 21..200 -> "第二阶段"
//        else -> "超级"
//    }
//    println(grade)

    //如何理解Any?回答：Any?是Kotlin所有类的根类，包括Any


}
class Data{
    //那么我们能不能认为val 就是常量呢？不能。
    //var 是指具备setter和getter的变量
    var sexy = 55
    set(value) {
        field = value
    }
    get() = field*2
    //val 是指只具备getter的变量
    val age = 1
    get() = field*2
    //注意：通常情况下不建议写属性的setter和getter方法。在属性设置为private时，我们更推荐通过Java那样的public getXX()的形式来实现。
    //注意：Java默认状态是default;Kotlin 的默认状态是public。

    //Kotlin 的访问修饰符：public（默认）、private(自己)、protected(自己和子类)、internal(当前module使用)

    //编译时常量声明二：伴生对象中，companion object可以简单理解为原来的Java中的Static 部分。
    companion object{
        const val MIN = 1
    }
    //之所以编译时常量只能存在于函数之外。是因为函数都是运行时才调用以及对变量赋值。
    //编译时常量只能是基本数据类型：9种。String、Int、Byte、Short、Long、Double、Float、Char、Boolean
    //Java 是8种，Java中String 不算是基本数据类型。
    //Byte的范围是0~255.byte字节是计算机存储的最小单位。1byte = 8bit.1bit 是一个二进制位。
}