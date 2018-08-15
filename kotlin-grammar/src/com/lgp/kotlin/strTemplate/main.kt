package com.lgp.kotlin.strTemplate


/**
 * @AUTHOR lgp
 * @DATE 2018/8/14 16:29
 * @DESCRIPTION 字符串模板的语法
 *
 **/
fun main(args: Array<String>) {

    val i = 10
    val s = "i = $i" // 求值结果为 "i = 10"
    println(s)

    val ss = "ssssss"
    val sstr = "$ss.length is ${ss.length}" // 求值结果为 ssssss.length is 6
    println(sstr)

// 使用$ 字符（它不支持反斜杠转义）
    val price = """
    ${'$'}9.99
    """
    println(price)  // 求值结果为 $9.99

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

//    String 是不可变的。方括号 [] 语法可以很方便的获取字符串中的某个字符，也可以通过 for 循环来遍历
    val str = "string"

    for (c in str) {
        print(c)
        print(str[1])
    }
    println()

    val text = """
    |多行字符串
     多行字符串
    """
    println(text)   // 输出有一些前置空格

    val text1 = """
    |多行字符串
     多行字符串
    """.trim()
    println(text1)   // 输出有|

//    可以通过 trimMargin() 方法来删除多余的空白,注意使用这个方法前面必须有|
//    但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。
    val trimText = """
    |多行字符串
    多行字符串
    """.trimMargin()
    println(trimText)// 输出无|
}