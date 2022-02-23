
//函数相关模块
fun main() {
    //函数头
//    println(doSomething(12,"lay"))
    //函数参数
    //1、默认值参。默认值参可传值，也可以不传值。
    //2、具名函数参数。具名函数可以具名某个或全部，其他的按照顺序来写。
//    save(name="张三丰",18)
    //3、Unit 函数，即返回类型是Unit的函数。Java 中使用void 关键字来表示这种情况。通常Unit类型不需要在函数头中写出来。
    //面试题：Kotlin中的Unit和Java中的void 的区别？
    //    回答：相同之处都是表达函数返回值为无。不同之处是：1-Unit是一个类，继承于Any.2-而且他的单例对象Unit 可以调用toString()函数。值为”kotlin.Unit“
//    println(Unit.toString())

    //Nothing类型 Nothing类型代表永远没有返回值，通常用于直接抛出异常的函数。Java中永远抛出null的返回值是Void.(V必须是大写)
    //Nothing? 表示没有返回值，或者返回值是null.
//    TODO("出错判断")

}
//函数头
//访问修饰符+fun关键字+函数名(参数名：参数类型,...):返回类型
private fun doSomething(age:Int,name:String):String{
    return "$name,你今年$age 岁了。"
}
//1、默认值参
//3、Unit 函数
fun save(name: String,age: Int = 14){
    println("$name,$age 岁")
}
