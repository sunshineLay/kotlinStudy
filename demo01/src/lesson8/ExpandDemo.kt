package lesson8

import lesson9.ramdomTake as rk

//扩展函数-扩展属性-DSL
//扩展：Extension
//lesson 8+9
fun main() {
//    "liuanyi".easyPrintln().addExt //easyPrintln()不能进行链式调用
//    "liuanyi".easyPrintln2().addExt(3).easyPrintln()//easyPrintln2()进行链式调用
//    null.printlnWithDefault("default")
//    null printlnWithDefault2 "default2"
//    "defu".run(::println)//为什么标准库函数不需要import

//    val list = listOf("1","2","3","hahah")
//    val set = setOf("1","2","3","hahah")
//    println(list.rk())
//    println(set.rk())
}
//一、扩展函数
//1、不直接修改类定义的情况下增加类功能

//2、自定义类和标准库里面的类都适用

//3、无法继承的类也可以扩展。

//4、作用域是被访问修饰符控制的。默认是全局。

//1-1 定义扩展函数
//类.普通函数定义
fun String.addExt(amount:Int = 1) = this + "!".repeat(amount)
//String.repeat()
//此方法返回一个字符串，该字符串的值是给定字符串的重复 count 次的串联。如果字符串为空或 count 为零，则返回空字符串。
fun Any.easyPrintln() = println(this)

//1-2 泛型扩展函数：泛型的扩展函数在任何一个类型都是使用。标准库函数的作用域函数都是这样的
fun <T>T.easyPrintln2():T{
    println(this)
    return this
}

//二、 扩展属性
//类.属性
//2-1
//例子：给String提供扩展一个属性：计算韵母数量的函数

//2-2 可空类型的扩展
fun String?.printlnWithDefault(default:String) = println(this ?: default)

//2-3 infix 关键字
//适用于单个参数的扩展和类函数。简洁语法调用。
//调用时候点和参数括号可以忽略。
infix fun String?.printlnWithDefault2(default:String) = println(this ?: default)

//2-4 定义扩展文件
//扩展函数需要在多个文件中使用，可以将它定义在单独的文件中,然后import调用

//2-5 重命名扩展
//import lesson9.ramdomTake as rk

//2-6 Kotlin 标准库中的扩展
//特点：原来类名+s
//例子:Maps.kt、Ranges.kt、Sequences.kt


