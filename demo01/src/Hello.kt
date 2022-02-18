//编译时常量声明一：top-Level
const val MAX = 100

fun main() {
    //声明变量
    val hello:String = "666"//存在类型推断
    println(hello)
    //var 和 val的区别：var 是可修改的；val是只读的。某种角度来说，val = final
    var name = "Jack"
    name = "lay"
    println(name+hello)
    //我们大多数情况下，默认优先使用val,等到需要改变的变量，我们再使用var.

    //声明变量但是不初始化
    val result:Int
    val couple:String

    //输出MIN
    println(Data.MIN)

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

    //编译时常量声明二：
    companion object{
        const val MIN = 1
    }
    //之所以编译时常量只能存在于函数之外。是因为函数都是运行时才调用以及对变量赋值。
}