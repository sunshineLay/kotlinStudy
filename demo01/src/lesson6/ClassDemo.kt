package lesson6

//嵌套类、数据类
//Kotlin 的hashCode算法和Java的是一致的。
fun main() {
    val coordinate = Coordinate(3, 4)
    val coordinate2 = Coordinate(3, 4)
    val coord = Coord(3, 4)
    //== 等价于 equals()
//    println(Coordinate(1,5)== Coordinate(y=5,x=1))
//    Coordinate(1,5).equals(coordinate).also(::print)
    //1、hashCode值一般是通过属性值计算得到的。在属性值一样的情况下，hashCode就是相同的。
//    coordinate.hashCode().also(::println)//(31-1;62-2;93-3)31x+y 规律
//    coord.hashCode().also(::println)//(31-1;62-2;93-3)31x+y 规律
    //copy
//    coordinate.copy(y=10).hashCode().also(::println)
    //解构声明
//    val(x,y) = Coord(3, 4)
//    println("$x")
//    println("$y")
//    println(coordinate===coordinate2)//不同的对象
}

//嵌套类
//B 只对A有用，此时B写在A里面，就叫嵌套类
class A{
    class B{
        fun play() = "B - play"
    }
    private fun test(){
        B().play()
    }
}

//数据类
//提供了toString、equals、hashCode的个性化实现
//==默认情况下是对比引用地址，但是data class变成了值对比
//== 等价于 equals()
//isInBounds这种类体属性 不参与对于data class 实例对象的相等判断

//总结：数据类适合存储数据的简单对象，对于需要比较、复制、打印自身内容的类。数据类尤其适合他们。
//数据类的必要条件
//1-主构造函数带有至少一个参数；
//2-参数必须带有var、val
//3-数据类不能是抽象abstract、开放open、密封sealed或者内部inner的；
data class Coordinate(var x:Int,var y:Int){
    val isInBounds = x>0 && y>0//坐标是不是正值
}
data class Coord(var x:Int,var y:Int){

}
//copy:data class 的对象可以copy产生差不多的新对象
//copy的陷阱：次级构造函数的函数体不会在copy的时候执行

//面试题：为什么重写equals()要重写hashCode()? 重要的面试题，关系到hashMap这类和Hash相关的集合。
//1、hashCode值一般是通过属性值计算得到的。在属性值一样的情况下，hashCode就是相同的。

//2、hashCode值的大小决定存储于和Hash相关的集合的位置。

//3、往hash表结构里面添加元素，先比较对象的hash值，在比较equals方法。如果两个方法都是true,则认为是同一个对象。

//总结：因为在内存上和业务上的一致是不同的。
//new 两个对象，内存上就是两个对象。但是把两个属性内容一致的对象放到hashSet这样的集合的时候，我们认为这样的两个对象是同一个对象。
//hash表的判断顺序是先hashCode,再判断equals。为了得到hash表想要实现的结果，就必须重写hashCode和equals两个方法。将判断是不是同一个对象的依据从内存引用地址变成对象的属性。