import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

//匿名函数（一）

//匿名函数：定义时没有名字的函数。可以参考Java的匿名内部类
//匿名函数的好处: 第一点，在于可以轻松指定规则。
//匿名函数通常传递给其他函数（当做参数），或者从其他函数返回（函数类型的返回值）

//函数和方法都是对一个功能的封装。方法 = 面对对象的函数。方法只能通过类或者对象调用。函数可以直接调用。
fun main() {
    //匿名函数
    //({}) 等于 {} lambda表达式
    val count = "niubuniubi,kanxinqing".count { its ->
        its == 'n'
    }
//    println(count)
    //函数类型和隐式返回（最后一行就是返回结果）
    //例子：(Int,String)->Unit
    //函数类型变量 = 相当于代替了函数类型的具名函数
    val rule:(Char)->Boolean = {
        it -> it == 'n'
    }
    val count1 = "lay".count(rule)
//    println(count1)
    //问：是不是只有匿名函数和匿名函数变量能写函数类型的函数。Kotlin中具名函数能不能是函数类型？
    //函数参数：参数类型在函数类型定义中，参数名称在函数体中
//    val test01:(Int,Int,String)->String = {age,size,name->
//        "$name,今年$age 岁，身高$size"
//    }
//    println(test01(25,160,"lay"))
    //函数参数是一个的时候，参数名称可以使用it关键字
    val test:(String)->String = { it->
        "$it,hahah"
    }
//    println(test("zss"))
    //函数类型也适用类型推断
    //01
//    val isPass = {
//        true
//    }
    //02
//    val test01 = {age:Int,size:Int,name:String->
//        "$name,今年$age 岁，身高$size"
//    }
//    println(test01(25,162,"lad"))

    //lambda 表达式
//    {x: Int, y: Int -> x + y}

    //定义函数参数是函数：高阶函数
    //例如："lay".count(rule)

    //lambda 简略写法
    //01 -  函数的参数就是一个匿名参数
    //01-1
//    "niubuniubi,kanxinqing".count { its ->
//        its == 'n'
//    }
    //01-2
    showTimestamp {
        Instant.now().toEpochMilli()
        System.currentTimeMillis()
    }
    //02 - 函数的参数放在最后就能有简略写法
    showStringTime("中国"){ currentMillis ->
        val dfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val localTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(currentMillis), ZoneId.systemDefault())//使用系统默认的时区
        dfPattern.format(localTime)
    }


}
//小知识：时间戳这串数字是世界唯一的，但是对应的具体时间不唯一。
//函数简略写法情况一
fun showTimestamp(timestamp:()->Long){
    println("当前的时间戳是${timestamp()}")
}
//函数简略写法情况二
fun showStringTime(region:String,timeStr:(Long)->String){
    println("在${region}地区，现在的时间是${timeStr(Instant.now().toEpochMilli())}")
}


