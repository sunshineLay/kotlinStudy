package lesson5

//Kotlin的类
fun main() {
    val play = Play()
    play.playGame?.let {
        it.toLowerCase().capitalize()
    }.run(::print)
}

class Play{
    //field
    //kotlin 的每一个类的属性都会自动产生field、getter、setter。
    //val 只有get()
    //get()和set()可以自己重写。但是在开发情况下通常不修改本身的get()和set()
    //普通属性值必须赋值
    var name = "abc"
        get() = field.capitalize()//首字母大写
        private set(value){
            field = value.trim()
        }
    //计算属性在get()方法中赋值,此时kotlin不会产生field
    val randomNum
        get() = (1..6).shuffled().first()
    //防范竞态条件：就是可空属性必须进行空判断?.,链式调用需要返回this时使用also,返回lambda形式结果。 this时使用let,不需要链式调用使用apply.
    var playGame:String? = "LOL"



}