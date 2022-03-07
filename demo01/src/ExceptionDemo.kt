import java.lang.IllegalStateException
import java.lang.NullPointerException

//异常 Exception
//Kotlin 的异常处理完全基于Java的库
//expression 表达式

//Java 中异常分为受检异常（除了运行时异常的所有异常）和不受检的异常（运行异常）
//Kotlin没有受检异常
fun main() {
    //3.异常处理
//例子：
    var number:Int? = null
    var i = 10
    val any = try {
//        checkOperation(number)
//先决函数
//        val checkNotNull = checkNotNull(i)
//        println(checkNotNull)

//    require(true)

//    requireNotNull(number)

//    error(i)

//    assert(false)
        i!!.plus(2)
        println("try:" + i)
        --i
    } catch (e: IllegalStateException) {
        println(e)
    } catch (e: NullPointerException) {
        println("catch:" + i)
        --i
    } finally {
        println("finally" + i)
        --i
    }
    println("整个表达式的结果："+any)
//    补充：--i（先计算）和i--（先赋值）

// try - catch - finally
//    try {
//        // 一些代码
//    }
//    catch (e: SomeException) {
//        // 处理程序
//    }
//    finally {
//        // 可选的 finally 块
//    }

//    注意：可以有零到多个 catch 块。finally 块可以省略。 但是 catch 与 finally 块至少应该存在一个。
//    注意：try 是一个表达式，即它可以有一个返回值。
//    try-表达式的返回值是 try 块中的最后一个表达式或者是（所有）catch 块中的最后一个表达式。
//    finally 块中的内容不会影响表达式的结果。

//    try - catch - finally执行顺序
//    Java
//    情况一：try块中没有抛出异常，try、catch和finally块中都有return语句
//    结论：try-catch-finally都有return语句时，没有异常时，try的返回值会进入finally部分继续使用，最终返回值是finally中的return返回的。
//    情况二：try块中没有抛出异常，仅try和catch中有return语句
//    结论：try-catch都有return语句时，没有异常时，返回值是try中的return返回的，finally还是会执行，但是不会影响返回结果。
//    情况三：try块中抛出异常，try、catch和finally中都有return语句
//    结论：try块中抛出异常，try、catch和finally中都有return语句，try的return不执行，进入到catch代码块，
//    catch的return返回值进入finally继续使用.
//    最终返回值是finally中的return。
//    情况四:try块中抛出异常，try和catch中都有return语句
//    结论:返回的catch中return值。但是会继续执行finally.
//    情况五:try、catch中都出现异常，在finally中有返回
//    结论:返回finally中return值。
//    情况六:只在try代码块之外进行return。
//    结果：返回try-catch-finally执行之后的结果
//    结论一：
//    return语句并不是函数的最终出口，如果有finally语句，
//    这在return之后还会执行finally（return的值会暂存在栈里面，等待finally执行后再返回）
//    【简单总结：finally一定会执行，try和catch的return是对着finally进行输入的。
//    最终返回值是什么取决于最后一个return在哪。】

//    结论二：【推荐做法：finally不放return语句】
//    finally里面不建议放return语句，根据需要，return语句可以放在try和catch里面和函数的最后。可行的做法有四：
//    （1）return语句只在函数最后出现一次。
//    （2）return语句仅在try和catch里面都出现。
//    （3）return语句仅在try和函数的最后都出现。
//    （4）return语句仅在catch和函数的最后都出现。
//    注意，除此之外的其他做法都是不可行的，编译器会报错。

//    Kotlin 中try表达式中不使用return表达返回值，最后一行表达式就是返回值
//    和Java第一点区别：抛出异常的时候，最终返回catch的结果，不执行finally的最后一行。
//    和Java第二点区别：不抛出异常的时候，最终返回try的结果，不执行finally的最后一行。


}
fun checkOperation(num:Int?){
//    1.抛出异常:throw
//    Kotlin throw关键字用于抛出显式异常。它用于抛出自定义异常。要抛出异常对象，将使用throw-expression。
    num ?: throw UnskilledException()
//    throw 表达式的类型是特殊类型 Nothing。 该类型没有值，而是用于标记永远不能达到的代码位置。
//    在你自己的代码中，你可以使用 Nothing 来标记一个永远不会返回的函数
}
//2.自定义异常
class UnskilledException():IllegalStateException("不能允许的操作")

//4.先决条件函数。你可以通过他们定义先决条件，满足先决条件才能继续执行。
//进行判断，如果是，抛出异常
//checkNotNull(number) 判断是否为空 IllegalStateException
//require(false) 判断是否为false
//requireNotNull(number) 判断是否为空
//error(i) 判断是否为空
//assert(false) 判断是否为false,并打上断言编译器标记
