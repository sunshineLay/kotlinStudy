package lesson6

//枚举类：定义常量集合的特殊类
fun main() {
//    println(Direction.SOUTH.ordinal)
    Direction.WEST.testName()
}
//方向
//枚举类常量EAST是Direction类的一个实例
enum class Direction{
    EAST,
    WEST,
    NORTH,
    SOUTH;
    //枚举类里面有构造函数
    fun testName(){
        println("${this.name}的序号是${this.ordinal}")
    }
}
//枚举类可以在常量中添加数据类型(基本数据类型和引用数据类型都可以)
enum class Colour(rgb: Int, name: String) {
    BLUE(0x2196F3,"蓝色"),
    BLACK(0x000000, "黑色"),
    RED(0xF44336, "红色"),
    GREEN(0x4CAF50, "绿色");
}
