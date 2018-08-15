package com.lgp.kotlin.`for`


/**
 * @AUTHOR lgp
 * @DATE 2018/8/14 16:56
 * @DESCRIPTION for的语法
 *
 **/
fun main(args: Array<String>) {

//    for 循环可以对任何提供迭代器（iterator）的对象进行遍历
    var collection = intArrayOf(3, 2, 1)
//    获取值
    for (item in collection) {
        println(item)
    }
//    获取key
    for (item in collection.indices) {
        println(item)
    }
//    获取值和key
    for ((index, value) in collection.withIndex()) {
        println("the element at $index is $value")
    }

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
    for (i in 4 downTo 1) {
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

//  while ，如果不满足条件，则不能进入循环。
//  do…while  即使不满足条件，也至少执行一次。
    println("----while 使用-----")
    var x = 1
    while (x > 0) {
        println(x--)
    }
    println("----do...while 使用-----")
    var y = 1
    do {
        println(y--)
    } while (y > 0)
//    Kotlin 有三种结构化跳转表达式：
//    return。默认从最直接包围它的函数或者匿名函数返回。
//    break。终止最直接包围它的循环。
//    continue。继续下一次最直接包围它的循环。
    println("----return 使用-----")
    for (i in 1..10) {
//        if (i==3) return  // i 为 3 时 结束main
        if (i == 3) continue  // i 为 3 时跳过当前循环，继续下一次循环
        println(i)
        if (i > 5) break   // i 为 6 时 跳出循环
    }
//    在 Kotlin 中任何表达式都可以用标签（label）来标记。
// 标签的格式为标识符后跟 @ 符号， 要为一个表达式加标签，我们只要在其前加标签即可
    loop@ for (i in 1..10) {
        println(i)
        for (j in 1..10) {
            if (i > 5)
                break@loop
        }
    }

    foo(intArrayOf(123, 231, 312))
    foo1(intArrayOf(123, 231, 312))
}

//    标签处返回
fun foo(ints: IntArray) {
    ints.forEach lit@{ it ->
        if (it == 0)
            return@lit
        println(it)
    }
}

//使用隐式标签更方便
fun foo1(ints: IntArray) {
    ints.forEach {
        if (it == 0) return@forEach
        print(it)
    }
}

//什么都不使用的正版
fun foo3(ints: IntArray) {
    ints.forEach(fun(value: Int) {
        if (value == 0) return
        print(value)
    })
}