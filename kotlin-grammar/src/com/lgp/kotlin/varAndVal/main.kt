package com.lgp.kotlin.varAndVal


/**
 * @AUTHOR lgp
 * @DATE 2018/8/14 16:20
 * @DESCRIPTION
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
fun main(args: Array<String>) {
    println(a)

}

