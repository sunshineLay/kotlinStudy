package lesson4

//集合：List、set、map
//List:顺序排序，元素可以重复的集合；
//Set:无序，元素不可重复的集合；
//Map:k-v,k不可重复的集合；

//集合本身分为可变和只读
//一个 只读 接口，提供访问集合元素的操作。
//一个 可变 接口，通过写操作扩展相应的只读接口：添加、删除和更新其元素。

//var和val的限定是对于变量指向的对象，集合本身的两种限定是对集合元素的限制
fun main() {
    //声明
    val strList:List<String>
    //List创建
    //只读
    val listOf = listOf(1, 2, 3)
//    listOf.add //报错
    //可变
    //mutable
    val list = mutableListOf(1,2,3)
    list.add(4)
    //只读和可变可以相互转换
    val toMutableList = listOf.toMutableList()
    toMutableList.add(5)
    val toList = list.toList()
    //List元素获取
    //得到对应下标结果，lambda里面是异常情况的默认值
    listOf.getOrElse(2){"unFind"}
    //得到对应下标结果，找不到返回null
    listOf.getOrNull(2)
    //mutator 函数 - 变因 - 这是修改可变集合的函数的总称。
    //添加、删除指定元素
    list+=8
    list-=1
//    println(list)
    //这里是运算符重载
    //根据某个条件移除
    list.removeIf { it==2 }
    println(list)
    //集合遍历
    //1、for in
//    for (i in list){
//        println(i)
//    }

    //2、forEach
//    list.forEach(::println)

    //3、forEachIndexed - 带下标的遍历
//    list.forEachIndexed { index, value ->
//        println("第$index 位置的值是$value")
//    }

    //解构
    //使用_过滤掉不想要的元素
//    val(a,_,c) = list
//    println("a的值是$a,c的值是$c")



}