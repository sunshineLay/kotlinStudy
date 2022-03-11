package lesson6

//运算符重载
//对于自定义的运算符应该表达的词义可以使用运算符重载关键字来重载运算符的含义
fun main() {
    //运算符重载
//    val numberTest = NumberTest(11, 22) + NumberTest(1, 2)
//    print(numberTest)

    //代数数据类型
//    chooseIdentity(Identity.MANAGER)

    //密封类
    chooseIdentity2(Identity2.Staff("S668899"))
}
//运算符重载
data class NumberTest(var x:Int,var y:Int){
    operator fun plus(numberTest: NumberTest)= NumberTest(x+numberTest.x,y+numberTest.y)//此处重定义了+的使用，其他运算符重载同理,常见运算符可在官网查询
}
//代数数据类型：表示一组子类型的闭集。1、枚举类；2、密封类
//使用闭集的情况下，when表达式不用写else,编译器会自动检查代码是否有遗漏
//枚举类
enum class Identity{
    BOSS,
    STAFF,
    MANAGER
}
fun chooseIdentity(identity: Identity) = when(identity){
    Identity.BOSS -> println("老板")
    Identity.STAFF -> println("员工")
    Identity.MANAGER -> println("经理")
}
//密封类
//密封类可以有很多子类，要继承密封类，子类必须写在密封类里面
//新增员工编号，且老板没有员工编号
sealed class Identity2{
    object Boss:Identity2()
    class Staff(val staffId:String):Identity2()//比枚举类更好的地方是可以单独设置每一个子类的专用属性
    class Manager(val staffId:String):Identity2()
}
fun chooseIdentity2(identity: Identity2) = when(identity){
    is Identity2.Boss -> println("老板")
    is Identity2.Staff -> println("员工,编号是：${identity.staffId}")
    is Identity2.Manager -> println("经理,编号是：${identity.staffId}")
}