package lesson11

//序列
fun main() {
    //头1000的素数
    //区间方法，前提是知道（10000以内有1229个素数）
//    var i = 1
//    (1..10000).filter { it.isPrime() }.take(1000).forEach {
//        println("第$i 个素数是：$it")
//        i++
//    }

    //序列方法，完全可以不知道要进行多少次才能取得。
//    val takeSequence = generateSequence(3) { value ->
//        value + 1
//    }.filter { it.isPrime() }.take(1000)
//    println(takeSequence.toList().size)
//    takeSequence.forEach {
//        println("第$i 个素数是：$it")
//        i++
//    }

}
//序列
//List、Set、Map集合类型，统称为及早集合，包含的元素都会被加入并运行访问
//惰性集合(lazy collection)
//类似于惰性初始化 by lazy{load()} 性能优异
//用于包含大量元素的集合，集合元素是按需产生的。

//Kotlin 的内置惰性集合叫序列，序列不会索引排序内容，不会记录元素数目。
//序列的值可能无限多。
//序列需要一个产生新的值就调用一下的函数——迭代器函数（Iterable）
//种子值+{条件}，按需产生符合需求数量的“集合”

//序列可以toList()

//作业：用Kotlin产生前1000个素数。（10000以内有1229个素数）

//另：
// takeWhile { it % 2 == 0 } 满足条件，拿出这个it元素
//要从头开始获取指定数量的元素，请使用 take() 函数。
//要从尾开始获取指定数量的元素，请使用 takeLast()。

//素数扩展函数
fun Int.isPrime():Boolean{
    (2 until this).forEach {
        //只要有一个数满足取余为0，就代表不是素数
        if(this%it==0){
            return false//这个return是当前方法的return
        }
    }
    return true
}