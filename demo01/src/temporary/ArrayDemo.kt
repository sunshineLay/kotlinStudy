package temporary

//数组
fun main() {
    //一、两种创建方式
    //确定元素的：arrayOf(1,2,3)
//    arrayOf(1,2,3).forEach(::println)
    //不确定元素，确定元素的规律的
//    Array(5){i ->i*2-1 }.forEach(::println)
    //创建指定大小，元素为空的数组
//    val nullArr = arrayOfNulls<Int>(6)
//    nullArr.forEach(::println)
    //常量初始化
//    Array(5){0}.forEach(::println)
    //原生类型初始化,原生类型都能这样写
//    IntArray(5).forEach(::println)
    IntArray(5){77}.forEach(::println)

    //二、数组是型变的，即Array<String> 不能赋值给 Array<Any>,编译器会报错
    //三、数组的[]表示了get(),set()
//    nullArr[0] = 3
//    nullArr.forEach(::println)

    //数组类型，基本数据类型有专有的数组类型。


}