//简单的集合使用
//set、List、Map
fun main() {
    //list 的只读集合声明
    val nameList = listOf("lay","zjz","szy","wy")
    val ageList = listOf(11,22,33,44)
    //list的Range 表达式
    val age = 22
    if (age in ageList) println("age 存在于集合ageList中")

}