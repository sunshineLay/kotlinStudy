package temporary

import kotlin.math.roundToInt

//数字类型
//编译时常量只能是基本数据类型：9种。String、Int、Byte、Short、Long、Double、Float、Char、Boolean
//Java 是8种，Java中String 不算是基本数据类型。
//Byte的范围是0~255.byte字节是计算机存储的最小单位。1byte = 8bit.1bit 是一个二进制位。

//官方文档中，数组Array也是一个基本类型。算上这种就是10种，不算这种就是9种。
const val strToInt = "66"
const val double = 66.8195457
fun main(){
    //一、安全类型转换 toIntOrNull()这样的函数，转换失败输出为Null
//    (strToInt.toIntOrNull() ?: 22).let(::println)//灵活使用函数引用::函数名
    //二、Double 类型格式化(根据目标格式转换为String，再转化回来)
    val strDouble = "%.2f".format(double)//会四舍五入
//    (strDouble.toDoubleOrNull() ?: 66).let(::println)
    //三、Double 转Int
    //精度损失
    println(double.toInt())
    //四舍五入
    println(double.roundToInt())
//

}