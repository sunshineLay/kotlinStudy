package lesson4

//Map
//存储Pair
fun main() {
    //创建
    //只读
    val map = mapOf("l" to 1, "a" to 2)
    //可变
    val mutableMap = mutableMapOf("l" to 1, "a" to 2)
    mutableMap += "y" to 3
    //遍历元素
//    mutableMap.forEach(::println)

//    mutableMap.forEach{(key:String,value:Int)->
//        println("$key 的值是$value")
//    }

//    mutableMap.forEach{
//        println("${it.key}的值是${it.value}")
//    }
    //读取元素
    //[key] 不存在返回null
//    map["y"].run(::print)
    //getValue 不存在抛出异常 java.util.NoSuchElementException: Key a2 is missing in the map.
//    map.getValue("a2").run(::print)
    //getOrElse 不存在返回匿名函数最后一行
//    map.getOrElse("a2"){"a2"}.run(::print)
    //getOrDefault 不存在返回默认值(默认值必须是同类型的值)
//    map.getOrDefault("a2",7).run(::print)

    //可变读取，getOrPut(key){value}
//    mutableMap.getOrPut("m"){4}.run(::println)
//    mutableMap.forEach(::println)
}