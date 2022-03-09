package lesson4



//set:没有顺序的不重复集合。
fun main() {
    //声明
    val strSet:Set<String>
    //创建和元素获取
    val set = setOf("name", "age", "name1")//在创建set集合的时候元素重复不会报错，在使用set的时候会报错第二次出现重复元素的位置元素不存在。
    //按照下标获取
//    set.elementAt(2).let(::println)
//    set.forEach(::println)
    //可变集合
    mutableSetOf("1","2","3")
    //通过集合转换去重
    val list = listOf(1,2,3,2,1,4)
    list.forEach(::print)
    println()
//    list.toSet().toList().forEach(::print)
    //通过快捷函数去重
    list.distinct().forEach(::print)

}