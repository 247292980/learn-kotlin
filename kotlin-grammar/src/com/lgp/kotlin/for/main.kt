package com.lgp.kotlin.`for`


/**
 * @AUTHOR lgp
 * @DATE 2018/8/14 16:56
 * @DESCRIPTION for的语法
 *
 **/
fun main(args: Array<String>) {
    //  递曾循环
    for (i in 1..4) {
        print(" " + i)// 输出“1234”
    }
    println()
    for (i in 4..1) {
        print(i)// 什么都不输出
    }
    println()
//    if里面的必须先定义
    val i: Int = 1
    if (i in 1..10) { // 等同于 1 <= i && i <= 10
        println(i)
    }

// 使用 step 指定步长
    for (i in 1..4 step 2) {
        print(i)
    } // 输出“13”
    println()
// 使用 until 函数排除结束元素
    for (i in 1 until 10) {   // i in [1, 10) 排除了 10
        print(i)
    }
    println()

//  递减循环
    for (i in 4 downTo  1 ) {
        print(i)
    }
    println()

    for (i in 4 downTo 1 step 2) {
        print(i)
    } // 输出“42”
    println()

    for (i in 1 downTo 4) {
        print(i)// 什么都不输出
    }
    println()
}