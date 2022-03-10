package lesson6

//对象、接口、抽象类
fun main() {
    //1-Object 声明
//    ApplicationConfig.test()
//    ApplicationConfig.test()
    //结果如下：
//    init - 只会初始化一次
//    test
//    test

    //2、Object 表达式
//    val ob = object : People(){
//        override fun test() {
//            println("object-test")
//        }
//    }
//    ob.test()

    //3、伴生对象
    Type.getPeople().test()


}
//使用Object 直接就可以写出单例(定义一个只能产生一个实例的类)
//Object 有三种
//1-Object 声明
object ApplicationConfig{
    init {
        println("init")
    }
    fun test(){
        println("test")
    }
}
//2-Object 表达式 = 相当于Java里面的匿名内部类
open class People{
    open fun test(){
        println("People-test")
    }
}

//3-伴生对象 = 使用场景类似Java的Static
class Type{
    //一个类只有一个伴生对象
    //伴生对象只会初始化一次,只有调用伴生对象里面的资源，才会实例化伴生对象
    //资源加载
    companion object{
//        某个对象的初始化和这个类实例绑定在一起
       fun getPeople() = People()
    }
}