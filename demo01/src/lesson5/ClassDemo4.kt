package lesson5

//初始化陷阱
fun main() {
//    println(Test9("haha").playName)

}
//1.第一，注意顺序
class Test7{
    //顺序错误：必须先写类属性，再写init{}
//    init {
//        num.length
//    }
//    val num = "10"
}

//2.又是注意顺序
class Test8{
    //下面代码编译期不报错，但是实际上会报错
    val name:String
    private fun getName() = name[0].toUpperCase()//java.lang.NullPointerException
    init {
//        println(getName())//错误
        name = "lay"
        println(getName())//正确
    }
}
//3、还是顺序问题
class Test9(_name:String){
    val playName = initPlayName()//此时就是null,因为此时name还是null
    val name = _name
    private fun initPlayName() = name
}