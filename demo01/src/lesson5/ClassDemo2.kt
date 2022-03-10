package lesson5

import kotlin.io.println as println

//Kotlin 类

//初始化
//主构造函数
fun main() {
//    val test = Test("lay", 26)
//    println(test)
//    println("test的name:${test.name}")
    Test2(3)?.run{
        println("$name 的年龄是$age")
    }
}

//(_name:String,_age:Int) 这就是主构造函数
//对比Java，构造函数类名同名，Kotlin省略主构造函数名
//临时变量用下划线命名。
class Test(_name:String,_age:Int){
    var name = _name
    var age = _age
}
//主构造函数定义属性
class Test2(var name:String,var age:Int){
    //次构造函数
    //多个次构造函数配置参数
    //次构造函数委托主构造函数（：this）、也能委托其他次构造函数
    //基本使用
    constructor(name:String):this(name,age=66){
        this.name = name.toUpperCase()
    }
    //在次级构造函数中进行配置
    constructor(age:Int):this(name="lay",age){
        this.age = when (age) {
            3 -> 40
            else -> 11
        }
    }

}
//默认参数,此时传值就会覆盖默认值，不传就是默认值
//构造函数可见性 : 主构造函数默认是 public 可见性 , 如果将该构造函数设置成 private , 那么 constructor 关键字必须要有
class Test3 private constructor(var name:String = "lay",_age:Int = 66){

}
