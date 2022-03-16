package lesson9

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun main() {
    "let".let {  }
}
//三、DSL
//问题一，Kotlin如何做到支持接受者对象的隐式调用
//【泛型类型的匿名函数】T.()->Unit 泛型的扩展lambda
//匿名函数类型this指向T
//[待接收者的函数自变量]
fun <T> T.apply2(block:T.()->Unit):T{
    block()
    return this
}
//问题二，Kotlin如何做到支持接受者对象的闭包形式返回？ 这是lambda的规范定义的
//public inline fun <T, R> T.let(block: (T) -> R): R {
//    contract {
//        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
//    }
//    return block(this)
//}

//<T,R> 括号里面可以无限定义泛型类型
class ExtDemo<T,R,S>(val t:T,val r:R,val s:S){
}
//(T) -> R 这是函数类型的写法，T在（）内就是it(lambda的语法).

//R 是返回值

//Kotlin 契约（Contract）
//contract {
//    callsInPlace(block, InvocationKind.EXACTLY_ONCE)
//}
//简单理解：契约是在告诉编译器,这个函数在运行时的行为。这是一个向编译器通知函数行为的方法。
//InvocationKind.EXACTLY_ONCE表示block lambda表达式只能被调用一次，此外这个外层函数还必须是个inline内联函数。

//Kotlin 委托（entrust）
//委托就是设计模式的委托模式，又名代理模式。
