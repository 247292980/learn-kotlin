package com.lgp.kotlin.dataClass


/**
 * @AUTHOR lgp
 * @DATE 2018/8/15 16:58
 * @DESCRIPTION 数据类 封装类语法
 *
 **/

fun main(args: Array<String>) {
    val jack = User(name = "Jack", age = 1)
//    使用 copy 类复制 User 数据类，并修改 age 属性:
    val olderJack = jack.copy(age = 2)
    println(jack)
    println(olderJack)

//    组件函数允许数据类在解构声明中使用
    val jane = User("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age") // prints "Jane, 35 years of age"
}

//密封类用来表示受限的类继承结构：当一个值为有限几种的类型, 而不能有任何其他类型时。
//使用 sealed 修饰类 ，密封类可以有子类，但是所有的子类都必须要内嵌在密封类中。
sealed class Expr{
    data class Const(val number: Double) : Expr()
    data class Sum(val e1: Expr, val e2: Expr) : Expr()
    object NotANumber : Expr()
}
//密封类就是一种专门用来配合 when 语句使用的类
fun eval(expr: Expr): Double = when (expr) {
    is Expr.Const -> expr.number
    is Expr.Sum -> eval(expr.e1) + eval(expr.e2)
    Expr.NotANumber -> Double.NaN
}
//Kotlin 可以创建一个只包含数据的类，关键字为 data：
data class User(val name: String, val age: Int) {

}