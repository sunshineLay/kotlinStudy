package lesson5

//复习OOP的三大关键：封装、继承、多态
//继承
//base 类：Any和Any?
fun main() {
    //函数重载
//    DemoB().test()
    //类型检查 is
    val demoA = DemoA()
    val demo = Demo("demo")
//    println(demoA is Demo)
//    println(demoA is DemoA)
    //类型转换 as 子类转成父类
    play((demoA as Demo))
    //智能类型转换
    play(demoA)

}
//open
//class 默认是封闭的，如果需要被继承就要使用open 标记
fun play(d:Demo){
    d.test()
}

open class Demo(val name:String){
    open fun test(){
        println("Demo-test")
    }
}
class DemoA: Demo("DemoA")

//函数重载
//对于父类的函数进行重载必须标记open
class DemoB:Demo("DemoB"){
    override fun test() {
//        super.test()
        println("DemoB-test")
    }
}