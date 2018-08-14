package com.lgp.kotlin.`fun`


/**
 * @AUTHOR lgp
 * @DATE 2018/8/14 16:05
 * @DESCRIPTION  函数定义的语法
 **/
fun main(args: Array<String>) {
    println(sum(1, 2))
    println(sum1(2, 2))
    println(sum2(2, 3))
    sum3(3, 3)
    /*此处输出不报错，orz...*/
    println(sum3(3, 4))
    sum4(4, 4)
    println(sum5(4, 5, 6))

//    匿名函数 lambda
    val lambdaSum: (Int, Int) -> Int = { x, y -> x + y }
    println(lambdaSum(5,5))
}

//普通函数定义
//函数定义使用关键字 fun，参数格式为
//参数 : 类型
fun sum(a: Int, b: Int): Int {   // Int 参数，返回值 Int
    return a + b
}

//表达式函数定义
//表达式作为函数体，返回类型自动推断
fun sum1(a: Int, b: Int) = a + b

// public 方法则必须明确写出返回类型
public fun sum2(a: Int, b: Int): Int = a + b

//无返回值的函数(类似Java中的void)：
fun sum3(a: Int, b: Int): Unit {
    println(a + b)
}

// 如果是返回 Unit类型，则可以省略
public fun sum4(a: Int, b: Int) {
    println(a + b)
}

// 函数的变长参数可以用 vararg 关键字进行标识
fun sum5(vararg v: Int): Int {
    var sum: Int = 0
    for (vt in v) {
        sum += vt
    }
    return sum
}