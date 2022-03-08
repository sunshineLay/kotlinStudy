package lesson4

fun main() {
    //声明
    val strSet:Set<String>
    //创建和元素获取
    val set = setOf("name", "age", "name")
    //按照下标获取
    set.elementAt(2).let(::println)
    //可变集合
}