package lesson5

//初始化块 = 构造代码块
//Java：静态代码块在类加载的时候进行；构造代码块在构造类实例的时候执行
//Java: 构造代码块 -> 构造方法
//Kotlin : 在构造类实例的时候执行
//Kotlin : 主构造函数 -> 类的属性定义 -> init{} ->次构造函数
//init{} 相当于主构造函数的函数体。
fun main() {
//    Test4(27)
//    Test5("没有用").apply { setName() }.apply { getName() }
//    Test6().config //使用的时候才会初始化

}
//初始化块
class Test4(var age:Int = 66){
    init{
        require(age > 28){"年龄太小"}//抛出异常java.lang.IllegalArgumentException: 年龄太小
    }
}
//延迟初始化
//lateinit是进行一个约定，在之后进行初始化。
//这里可以知道主构造函数参数不能再类方法里面使用：_name:String不能再setName里面使用
class Test5(_name:String){
   lateinit var name:String
   fun setName(){
       name = "lay"
   }
   fun getName(){
       if (::name.isInitialized) println(name)//判断lateinit是否完成初始化，使用isInitialized
   }
}
//惰性初始化
class Test6{
    val config by lazy { loadConfig() }

    private fun loadConfig():String {
        println("loadConfig")
        return "config"
    }
}
//面试题：lateinit var 和val xx by lazy 的对比
//lateinit(延迟初始化属性)(只能用在var变量上)
//by lazy(惰性初始化)(只能用在val变量上)
