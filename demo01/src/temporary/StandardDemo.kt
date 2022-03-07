package temporary

import java.io.File

//标准库函数
//除了with,其他都是扩展函数
//作用域函数(共同特点，都能简化判空)：apply、let、run
const val test = 6
fun main() {
    //一、apply函数 配置型、初始化函数。传入this对象（this指代当前对象）。返回this对象。（自己）
//    例子：File对象 Windows的路径分隔符是\,Kotlin里面是/
//    C://Users/lay/Desktop/kt-apply.txt
    //apply里面隐式调用，省略了this,这个this就是file1
//    val file2 = File("C://Users/lay/Desktop/kt-apply.txt").apply {
//        setReadable(true)
//        setWritable(true)
//        setExecutable(false)
//    }
//    file2.printWriter().use { out->
//        out.println("one")
//        out.println("two")
//    }
//    println("完成")

    //二、let函数 传入it对象（it指代当前对象）。返回lambda表达式的最后一行（闭包形式返回）。
    // 对比let和apply,我们可以看出。this不能用来进行运算，只能作为对象去调用这个this的方法。但是it可以。
    // 而且let的返回结果更加灵活。apply只能是this。
    // let适用于计算加工，灵活返回结果。所以，let适用于当需要中间变量存在的时候的计算加工。
    val t1 = test.let {
        println(it*it)
        it*it
    }
    println("t1:$t1")
    val t2 = test.apply {
        println(this*this)
        this*this
//        this+=1 //报错
    }
    println("t2:$t2")

    //三、run


}