@file:JvmName("JK")
package lesson11

import java.io.IOException
import kotlin.jvm.Throws

fun main() {
//    val book = Book("三国演义")
//    println(book.javaClass)

}
//Kotlin和Java的互操作
//一、互操作和可空性
//1、可空性：Java所有类型可空，所以Kotlin使用所有Java方法都必须空安全操作？.
//2.所有Java和Kotlin的对象的类型映射都是javaClass。
//另：String! 是平台类型（可能可空，又可能不可空）

//二、属性、异常互操作
//(k-J)1、Java中的属性的get、set方法在kotlin中可以直接调用属性值来获取和赋值。

//(J-k)2、@JvmName可以改变对外给Java调用的名字(必须在第一行)
//@file:JvmName("JK") 对于整个文件使用
// @JvmName("getSpells1") 对于fun使用

//(J-k)3、@JvmField 可以让Java直接使用Kotlin的属性而不是使用getter方法

//(J-k)4、@JvmOverloads 协助产生Kotlin函数的重载版本。让Java方便调用
//某种程度上来说，Kotlin的fun在有默认参数的前提条件下，在调用的时候完全可以重载形式调用，
// 但是Java不行，所以需要这个注解。

//(J-k)5、@JvmStatic 允许调用伴生对象中的函数
        //@JvmField 允许调用伴生对象中的属性

//(J-k)6、@Throws() 目的：解决Java和Kotlin有关异常检查的差异。
// 写给Java调用的Kotlin API
//使用这个注解可以让Java调用者知道抛出的具体异常是什么

//三、函数类型
//(J-k) Java调用Kotlin的函数类型，使用FunctionN(0-22)N是值参数目
//每一个FunctionN都包含一个invoke（调用）函数，专用于调用函数类型函数

class Book(val name:String){

}
fun sayByeBye() = println("Bye-Bye")

class Spellbook{
    @JvmField
    val spells = listOf("Magic Ms.L","Lay on Hans")

//    @JvmName("getSpells1")
    fun getSpells():List<String>{
        return spells
    }
}

@Throws(IOException::class)
fun accpetData():Nothing{
   throw IOException()
}

val transformStr = { str:String ->
    str?.toLowerCase().capitalize()
}

