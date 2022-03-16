package lesson9

//扩展函数需要在多个文件中使用，可以将它定义在单独的文件中,然后import调用

fun <T> Iterable<T>.ramdomTake():T = this.shuffled().last()