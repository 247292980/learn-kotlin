package pojo


/**
 * @AUTHOR lgp
 * @DATE 2018/8/14 15:51
 * @DESCRIPTION
 *
 **/
class Hello(val name: String) {
    fun greet() {
        println("Hello, $name")
    }
}

fun main(args: Array<String>) {
    Hello("World!").greet()          // 创建一个对象不用 new 关键字
}
