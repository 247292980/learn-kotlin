package com.lgp.kotlin.varAndVal


/**
 * @AUTHOR lgp
 * @DATE 2018/8/14 16:20
 * @DESCRIPTION 常量变量定义的语法
 *
 **/
// 不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
val a: Int = 1
/*//a +=1          // 修改赋值会报错*/
val b = 1       // 系统自动推断变量类型为Int
//val c: Int      // 如果不在声明时初始化则报错
//可变变量定义：var 关键字
var x: Int = 5
var y = 5        // 系统自动推断变量类型为Int

//类型后面加?表示可为空
var age: String? = null
//age为空返回-1
val age3 = age?.toInt() ?: -1
//不做处理返回 null
val age2 = age?.toInt()
//抛出空指针异常
//val age1 = age!!.toInt()

fun main(args: Array<String>) {
    println(age)
    println(age3)
    println(age2)
//    println(age1)

    val x = parseInt("1") ?: -1
    val y = parseInt("2") ?: -1
    // 直接使用 `x * y` 会导致错误, 因为它们可能为 null.
    if (x != null && y != null) {
        // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
        println(x * y)
    }
}

fun parseInt(str: String): Int? {
    return null
}