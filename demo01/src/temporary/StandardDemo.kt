package temporary

import java.io.File

//标准库函数
//除了with,其他都是扩展函数
//作用域函数(共同特点:1、都能简化判空；2、都能使用函数引用；)：apply、let、run、with、also
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
    // let的返回结果更加灵活。apply只能是this对象。
    // let适用于计算加工，灵活返回结果。所以，let适用于当需要中间变量存在的时候的计算加工。
//    val t1 = test.let {
//        println(it*it)
//        it+1
//    }
//    println("t1:$t1")
//    val t2 = test.apply {
//        println(this*this)
//        this*this
////        this+=1 //报错
//        this+1
//    }
//    println("t2:$t2")

    //三、run
    // 1、this指代当前对象或者省略
    // 2、闭包形式返回
    // 这里提出一个问题：this和it的区别。
    // 区别一：this很多时候隐式调用，而且主要用于调用this对象本身的方法。
    // it不能隐式调用，而且it主要作为计算对象或者入参来使用。
//    val readable = File("C://Users/lay/Desktop/kt-apply.txt").run {
//        setReadable(true)
//    }.run(::println)


    //四、with
    // 1.with是run的变体，和run的最大区别是调用的不同
    // 2.this指代当前对象或者省略
    // 3.闭包形式
    // 例子：RecyclerView的UI设置数据就使用with
//    with("C://Users/lay/Desktop/kt-apply.txt") {
//        println(this)
//    }

    //五、also
    //1、it指代当前对象，返回this.
    //适用于多个扩展函数的链式调用。也就是说适用于对于同一个对象进行多次中间过程处理的情况。比如先加工再填充。
//    val fileLineList:List<String>
//    File("C://Users/lay/Desktop/kt-apply.txt").also {
//        println("文件名是：${it.name}")
//        //printWriter() 覆盖式添加
//        it.printWriter().use { out->
//            out.println("three")
//            out.println("four")
//            out.println("five")
//            out.println("six")
//        }
//    }.also {
//        //在后面添加
//        it.appendText("one\n")
//        it.appendText("two\n")
//    }.also {
//        fileLineList = it.readLines()
//    }
//    fileLineList.forEach(::println)

//    六、takeIf
//    1、it指代对象。{}内的结果为true,返回this对象。为false,返回null。
//    File("C://Users/lay/Desktop/kt-apply.txt").takeIf {
//        it.canRead()
//    }?.readText().run(::println)


//    七、takeUnless
    //1、it指代对象。{}内的结果为false,返回this对象。为true,返回null。
//    val value = File("C://Users/lay/Desktop/kt-apply.txt").takeUnless {
//        it.isHidden //在Microsoft Windows系统中，如果文件在文件系统中被标记为隐藏文件，则认为该文件是隐藏的.判断是不是隐藏文件
//    }?.readText().run(::println)


}