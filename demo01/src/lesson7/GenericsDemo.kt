package lesson7

import lesson5.Demo
import lesson5.DemoA
import lesson5.DemoB

//泛型
//定义泛型类、泛型函数、泛型约束
fun main() {
//    val magic = Magic(DemoA())
//    magic.t.test()

    //[]操作符取值
//    val magic = Magic2(DemoA(),DemoB(),DemoA(),DemoB())
//    magic.subject[1].test()//得到Array元素[index]

}
//定义泛型类：泛型就是可以接收任何类型
//T 可以换成任何字符
class MagicBox<T>(item:T){
    var subject:T = item
    val subject2:T by lazy { load() }
    //泛型函数
    fun load():T{
        return subject
    }
    //多泛型参数
    //泛型类、泛型函数可以定义多个泛型参数
    fun <R> test(demo:(T)->R):R?{
        return demo(subject2)
    }
}
//泛型函数
fun <T> setXX(item: T){

}
//泛型类型约束
//1-指定类型
class Magic<T: Demo>(val t:T){}

//2-多个参数 vararg 可变参数
class Magic2<T: Demo>(vararg t:T){
    var subject :Array<out T> = t //数组类型
}

//out - 协变
//T只是作为函数返回结果，可以使用<out T>
//生产者接口
interface Move<out T>{
    fun product():T
}
//in - 逆变
//T只是作为函数传入参数，可以使用<in T>
//消费者接口
interface Move2<in T>{
    fun consume(item:T)
}
//invariant - 不变：<T>
//又是返回结果，又是传入参数
interface Move3<T>{
    fun consume(item:T)
    fun product():T
}
//为什么使用in&out?
//父类泛型对象可以赋值给子类泛型对象，用in
//子类泛型对象可以赋值给父类泛型对象，用out
//使用泛型类型本身就是为了程序代码的扩展

//泛型参数类型会被类型擦除，T在运行时是不可知的
//reified 关键字+inline 使用这个关键字之后，在该泛型函数被调用的前提下，可以在运行期得到T的具体类型

