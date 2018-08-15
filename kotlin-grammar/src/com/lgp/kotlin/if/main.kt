package com.lgp.kotlin.`if`


/**
 * @AUTHOR lgp
 * @DATE 2018/8/15 10:15
 * @DESCRIPTION 条件控制语法
 *
 **/
fun main(args: Array<String>) {
    val a = 100
    val b = 101

//    传统用法
    var max = a
    if (a < b) {
        max = b
    }

// 使用 else
    var max1: Int
    if (a > b) {
        max1 = a
    } else {
        max1 = b
    }

// 作为表达式
    val max2 = if (a > b) {
        a
    } else {
        b
    }

    val max3 = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }

//    when 将它的参数和所有的分支条件顺序比较，直到某个分支满足条件。
//    when 既可以被当做表达式使用也可以被当做语句使用。如果它被当做表达式，
//      符合条件的分支的值就是整个表达式的值，如果当做语句使用， 则忽略个别分支的值。
//    when 类似其他语言的 switch 操作符
    val x = 1
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> { // 注意这个块
            println("x 不是 1 ，也不是 2")
        }
    }
//    在 when 中，else 同 switch 的 default。如果其他分支都不满足条件将会求值 else 分支。
    when (x) {
        0 -> println("x == 0")
        else -> println("otherwise")
    }
    val validNumbers: IntArray = IntArray(3) { i -> i * 1 }
    when (x) {
        in validNumbers -> println("x is valid")
        in 1..10 -> println("x is in the range")
        !in 10..20 -> println("x is outside the range")
        else -> println("none of the above")
    }

    //    另一种可能性是检测一个值是（is）或者不是（!is）一个特定类型的值
    println(hasPrefix("prefix-asd"))
//when 也可以用来取代 if-else if链。 如果不提供参数，所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支
    var lgp: Man = Man()
    when {
        lgp.isEven() -> print("lgp is even")
        lgp.isOdd() -> print("lgp is odd")
        else -> print("lgp is funny")
    }

//    when 中使用 in 运算符来判断集合内是否包含某实例
    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}

fun hasPrefix(x: Any) = when (x) {
    is String -> x.startsWith("prefix")
    !is String -> println(x)
    else -> false
}
