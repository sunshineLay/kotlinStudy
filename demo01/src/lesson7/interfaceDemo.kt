package lesson7

//接口
fun main() {
//    Talker2("老子明天不上班").usedTalk()
}
//接口可以定义属性和函数
//接口成员默认open
//接口方法实现必须使用Override关键字
interface Talk{
    //接口可以提供成员的默认实现
    val number :Int
        get() = (1..10).shuffled().first()
    var talkContent:String?
    fun usedTalk()
    //接口可以提供成员的默认实现
    fun getAdmin() = "admin"
}
class Talker2(override var talkContent: String?) :Talk{
    override fun usedTalk() {
        println(talkContent)
    }
}

//面试题：重写和重载的解释。
//回答：重写就是子类重写父类。重载就是同一个类同名方法参数不同

//因为业务能力和架构设计抽象出来的接口是进步的体现