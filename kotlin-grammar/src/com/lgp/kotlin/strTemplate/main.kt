package com.lgp.kotlin.strTemplate


/**
 * @AUTHOR lgp
 * @DATE 2018/8/14 16:29
 * @DESCRIPTION 字符串模板的语法
 *
 **/
fun main(args: Array<String>) {
//    $ 表示一个变量名或者变量值
    var a = 1
    println(a)
//    $varName 表示变量值
    val s1 = "a is $a"
    println(s1)

    a += 2
//    ${varName.fun()} 表示变量的方法返回值:
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)

}