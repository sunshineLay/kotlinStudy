package lesson7

import lesson5.Demo
import lesson5.DemoA
import lesson5.DemoB
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

//名词解释：
//向上兼容、向下兼容、向前兼容、向后兼容
//主流使用的是向前兼容（向上）和向后兼容（向下）
//向后兼容中“后”指“落后”，站在新版本的立场讨论过去版本的兼容性问题。
//向前兼容中“前”指“前进”，表示未来的事情，站在旧版本的立场讨论未来版本的兼容性问题。

//泛型
//定义泛型类、泛型函数、泛型约束
fun main() {
//    val magic = Magic(DemoA())
//    magic.t.test()

    //[]操作符取值
//    val magic = Magic2(DemoA(),DemoB(),DemoA(),DemoB())
//    magic.subject[1].test()//得到Array元素[index]

    testB()

}
//定义泛型类：泛型就是可以接收任何类型
//T 可以换成任何字符
class MagicBox<T>(item:T){
    var subject:T = item
    val subject2:T by lazy { load() }
    //泛型函数
    fun load():T{
        return subject
    }
    //多泛型参数
    //泛型类、泛型函数可以定义多个泛型参数
    fun <R> test(demo:(T)->R):R?{
        return demo(subject2)
    }
}
//泛型函数
fun <T> setXX(item: T){

}
//泛型类型约束
//1-指定类型
class Magic<T: Demo>(val t:T){}

//2-多个约束条件
open class A{}
interface B{}//A 和 B必须有一个是接口，因为Kotlin和Java一样，都是单继承
class MagicBox2<T> where T: A,T: B{

}

//2-多个参数 vararg 可变参数
class Magic2<T: Demo>(vararg t:T){
    var subject :Array<out T> = t //数组类型
}

//out - 协变
//T只是作为函数返回结果，可以使用<out T>
//生产者接口
interface Production<out T>{
    fun product():T
//    fun consume(item:T)//此时编辑器会报错，因为out不支持作为消费者使用T
}
//in - 逆变
//T只是作为函数传入参数，可以使用<in T>
//消费者接口
interface Consumer<in T>{
    fun consume(item:T)
}
//invariant - 不变：<T>
//又是返回结果，又是传入参数
interface ProductionConsumer<T>{
    fun consume(item:T)
    fun product():T
}
//为什么使用in&out?
//父类泛型对象可以赋值给子类泛型对象，用in。 <? super type>
//子类泛型对象可以赋值给父类泛型对象，用out。<? extends type>
//使用泛型类型本身就是为了程序代码的扩展
//总结：生产者的情况下，子类类型一定包含所有的父类类型的内容。所以子类可以赋值给父类。
//总结：消费者的情况下，父类类型作为入参可以调用的方法在子类类型中一定存在。所以父类可以赋值给子类。

//泛型参数类型会被类型擦除，T在运行时是不可知的
//reified 关键字+inline 使用这个关键字之后，在该泛型函数被调用的前提下，可以在运行期得到T的具体类型
//适用场景：对象 is T,在这种需要明确T是什么类型的时候需要使用reified 关键字

//对比Java
//<?> 代表泛型可以是任何类型
//<? extends type> 代表接收type及其子类 也可以相当于<T:type>
//<? super type> 代表接收type及其父类

//看《掘金文章：深入理解Kotlin中的泛型（协变、逆变）》
//https://juejin.cn/post/6847902219140857870#heading-10

//0、技术不会无缘无故的产生，每一种技术都会对应一种需求
//1、没有泛型之前（Java1.5之前），集合中装的都是Object，这会导致两个问题：
//一、AList.add(new B());//可以添加成功，这是明显错误的。因为AList只应该添加A对象。
// （不能在添加的时候限制输入类型）
//二、（A）AList.get(0);//必须要强制类型转换，且由于前面的错误添加，这一步会在运行时报错。
//(必须要强制类型转换)

//2、泛型出现
//List<A> AList = new ArrayList<A>();
//AList.add(new B());//编译不通过，解决了问题一。
//AList.get(0);//不需要强制类型转换，解决了问题二。

//3、泛型的优点
//3-1、限制入参（类型参数化），类型安全。
//3-2、简化代码。
//3-3、自动进行类型转化，获取数据不用进行类型强转。

//4、泛型的实现：类型擦除
//Java实现类型擦除的目的是为了和Java1.5之前进行向后兼容。
//Kotlin和Java完全兼容，所以Kotlin自然也要实现类型擦除。

//5.泛型获取
//运行时泛型类型的获取。
//思路一：直接在泛型类中传入类型class参数
open class GenericsA<T>(val tData:T,val clazz:Class<T>){
    fun getType():Class<T>{
        return clazz;
    }
}
//上述思路的问题在于，1、太麻烦；2、不能获取一个泛型类型。例如ArrayList<String>.class

//思路二：可以使用匿名内部类得到。
fun test(){
    val arrayList = ArrayList<String>()
    val strList = object : ArrayList<String>(){}
    println(arrayList.javaClass.genericSuperclass)
    println(strList.javaClass.genericSuperclass)
    //结果：
//    java.util.AbstractList<E>
//    java.util.ArrayList<java.lang.String>
}

//5-1 为什么匿名内部类就能获取到泛型参数的类型？不是进行了类型擦除吗？
//答：是被擦除了。Kotlin和Java在编译为字节码的时候都是被擦除了的。但是某些泛型信息（例如：匿名内部类）会被class文件 以Signature（签名的形式）保留在Class文件的Constant pool中。
//所以我们在运行时可以得到。
//由此我们可以写出一个得到所有类型信息的泛型类
open class GenericsB<T>{
    var type:Type = Any::class.java
    init {
        val superClass = this.javaClass.genericSuperclass
        type = (superClass as ParameterizedType).actualTypeArguments[0]
    }
}
fun testB(){
    val ob = object : GenericsB<Map<String, String>>() {}
    println(ob.type)
}
//可以得到泛型类型的class结果
//java.util.Map<java.lang.String, ? extends java.lang.String>

//框架中对此的使用：Gson解析的时候就需要使用内部类。Retrofit也是从Class类的常量池中拿到的变量。

//思路三：kotlin的reified关键字获取泛型类型
//inline fun <reified T> getType(): T {
//    return T::class.java
//}
//原理：Kotlin的内联函数是在编译的时候，编译器把内联函数的字节码直接插入到调用的地方，所以参数类型也会被插入到字节码中。

//6、类型约束
//T:B
//where T:A,T:B

//7、协变和逆变（Java中没有的）
//定义：如果类型A是类型B的子类型，那么Generic<A>也是Generic<B>的子类，这就是协变。使用out关键字
//协变只读不可写的特性。

//val flowerProduct: Product<Flower> = WhiteFLowerProduct()
////编译不出错，但是运行时会出现类型不兼容错误。
//flowerProduct.add(ReaFlower())

//定义：如果类型A是类型B的子类型，反过来Generic<B>是Generic<A>的子类型，我们称这种关系为逆变。
//在Kotlin中，我们用'in'关键字来声明逆变泛型。
//只能写入不能读取


//泛型面试七连问：https://zhuanlan.zhihu.com/p/385906824
//1.我们为什么需要泛型?
//第一，可以编写适应不同类型的模板代码，减少重复
//第二，使用时不需要进行类型转换，方便且减少出错机会

//2.什么是泛型擦除?
//从源代码文件变成字节码文件的编译过程中，泛型类会将泛型类型丢弃。List<String>和List<Int> 没有任何区别。

//3.为什么需要泛型擦除?
//因为Java需要向后兼容Java1.5之前的代码

//4.泛型擦除后retrofit是怎么获取类型的?
//retrofit是通过getGenericReturnType来获取类型信息的
//jdk的Class 、Method 、Field 类提供了一系列获取 泛型类型的相关方法。
//以Method为例,getGenericReturnType获取带泛型信息的返回类型 、
// getGenericParameterTypes获取带泛型信息的参数类型。

//5、泛型的信息不是被擦除了吗？
//是被擦除了， 但是某些（声明侧的泛型，接下来解释） 泛型信息会被class文件 以Signature的形式 保留在Class文件的Constant pool中。
//
//通过javap命令 可以看到在Constant pool中#5 Signature记录了泛型的类型。

//6、Gson解析为什么要传入内部类？
//6-1 Gson是怎么获取泛型类型的，也是通过Signature吗?
//回答：上面我们说了，声明侧泛型会被记录在Class文件的Constant pool中,使用侧泛型则不会
//
//声明侧泛型主要指以下内容
//
//1.泛型类，或泛型接口的声明 2.带有泛型参数的方法 3.带有泛型参数的成员变量
//
//使用侧泛型
//
//也就是方法的局部变量,方法调用时传入的变量。
//
//Gson解析时传入的参数属于使用侧泛型，因此不能通过Signature解析

//6-2 为什么Gson解析要传入匿名内部类？这看起来有些奇怪?
//根据以上的总结，方法的局部变量的泛型是不会被保存的
//
//Gson是如何获取到List<String>的泛型信息String的呢？
//
//Class类提供了一个方法public Type getGenericSuperclass() ，可以获取到带泛型信息的父类Type。
//
//也就是说java的class文件会保存继承的父类或者接口的泛型信息。
//
//所以Gson使用了一个巧妙的方法来获取泛型类型：
//
//1.创建一个泛型抽象类TypeToken <T> ，这个抽象类不存在抽象方法，因为匿名内部类必须继承自抽象类或者接口。所以才定义为抽象类。
//
//2.创建一个 继承自TypeToken的匿名内部类， 并实例化泛型参数TypeToken<String>
//
//3.通过class类的public Type getGenericSuperclass()方法，获取带泛型信息的父类Type，也就是TypeToken<String>
//
//总结：Gson利用子类会保存父类class的泛型参数信息的特点。 通过匿名内部类实现了泛型参数的传递。

//6-3 那些泛型信息会被保留，哪些是真正的擦除了？
//声明侧和使用侧

//7、什么是PECS原则?
//PECS的意思是Producer Extend Consumer Super，简单理解为如果是生产者则使用Extend，如果是消费者则使用Super

//1.如果你只是从集合中取数据，那么它是个生产者，你应该用extend
//
//2.如果你只是往集合中加数据，那么它是个消费者，你应该用super
//
//3.如果你往集合中既存又取，那么你不应该用extend或者super

//使用PECS主要是为了实现集合的多态

//有一个比较好记的口诀：
//
//1.只读不可写时,使用List<? extends Fruit>:Producer
//
//2.只写不可读时,使用List<? super Apple>:Consumer
//
//总得来说，List<Fruit>和List<Apple>之间没有任何继承关系。API的参数想要同时兼容2者，则只能使用PECS原则。这样做提升了API的灵活性，实现了泛型集合的多态
//当然，为了提升了灵活性，自然牺牲了部分功能。鱼和熊掌不能兼得。

//本文梳理了Java泛型机制这个知识点，回答了如下几个问题
//
//1.我们为什么需要泛型?
//
//2.什么是泛型擦除?
//
//3.为什么需要泛型擦除？
//
//4.泛型擦除后retrofit怎么获得类型的?
//
//5.Gson解析为什么要传入内部类
//
//6.什么是PECS原则?
//
//7.为什么需要PECS原则?

