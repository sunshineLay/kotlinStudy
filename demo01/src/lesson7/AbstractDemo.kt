package lesson7

//抽象类
fun main() {

}
//抽象类
abstract class Flower(val color:Int){
    var name:String = "花"
    abstract fun test()
    fun doSomething(){
        println("doSomething!$name")
    }
}
//抽象类和接口的几点区别
//1、接口没有构造函数
//2、接口成员属性可以不进行初始化，抽象类必须进行初始化
//3、语义不同，接口表示抽象的行为，抽象类表示对于一类事物的抽象
//4、接口可以多实现。抽象类只能单继承。