package lesson10

//函数式编程
//定义：
//设计理念一：不可变数据的副本在链上的函数之间传递
//设计理念二：函数的结果仅取决于参数，而没有副作用
//举例：lambda表达式、链式调用
fun main() {
    //zip：合并函数来合并两个集合，返回一个包含键值对的新集合。
//    val valueList = listOf(1, 2, 3)
//    val keyList = listOf("l", "a", "y")
//    val zip = keyList.zip(valueList)
//    zip.forEach{(key:String,value:Int) ->
//        println("$key 的值是$value")
//    }

    //fold 累计结果函数(累加、累乘、累减、阶乘)，可以设置初始值
    //亦即n!=1×2×3×...×(n-1)×n。阶乘亦可以递归方式定义：0!=1，n!=(n-1)!×n。
    val foldValue = listOf(1, 2, 3, 4).fold(1) { acc, number ->
        println("acc value:$acc")
        acc + number
    }
    println(foldValue)

}
//0、Kotlin中的函数式编程范式主要依赖于高阶函数的特性。在集合问题上尤其明显。
//1、编程范式：Kt支持多种编程范式。
//扩展：常见的4种编程范式比较 - https://juejin.cn/post/6844904078858797063

//关于集合数据类型进行函数式编程操作的函数可以分为三类：
//一、变换(transform)
//map:遍历接受者集合。原来的集合不会改变，返回新的集合表示新的结果。
//map:返回的集合中的元素个数和输入集合必须一样，不过新的集合里的元素可以是类型不同的

//flatmap：操作一个集合的集合。将多个集合中的元素合并返回一个包含所有元素的单一集合。

//二、过滤
//接收一个predicate函数，用这个函数判断集合中的元素是否为true.
//true ->add 新集合
//false ->remove 新集合
//predicate函数:filter{条件} ->{}中可以和flatMap{}的结果套娃使用。
//另：kotlin 集合 : any/none/all
//any: 是否至少有一个
//none: 是否都不是
//all：是否都是


//三、合并：将不同的集合合并成一个新的集合
//zip：合并函数来合并两个集合，返回一个包含键值对的新集合。
//fold:累加函数。如果初始值是StringBuilder,可以用来拼接字符串

//函数式编程在很多时候的思路比面对对象的思想更加简便。
//函数式编程就是入参导致出参。
//函数式编程的关键是突出重点，代码语义明确。


