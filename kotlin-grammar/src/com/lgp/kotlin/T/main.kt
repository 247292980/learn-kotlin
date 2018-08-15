package com.lgp.kotlin.T


/**
 * @AUTHOR lgp
 * @DATE 2018/8/15 17:29
 * @DESCRIPTION 泛型的语法
 *
 **/
fun main(args: Array<String>) {
    val box: Box<Int> = Box<Int>(1)
// 或者
    val box2 = Box(1) // 编译器会进行类型推断，1 类型 Int，所以编译器知道我们说的是 Box<Int>。

    var boxInt = Box<Int>(10)
    var boxString = Box<String>("str")

    println(boxInt.value)
    println(boxString.value)

    val age = 23
    val name = "str"
    val bool = true

    doPrintln(age)    // 整型
    doPrintln(name)   // 字符串
    doPrintln(bool)   // 布尔型

    sort(listOf(1, 2, 3)) // OK。Int 是 Comparable<Int> 的子类型
//    sort(listOf(HashMap<Int, String>())) // 错误：HashMap<Int, String> 不是 Comparable<HashMap<Int, String>> 的子类型


    var strCo: outout<String> = outout("a")
    var anyCo: outout<Any> = strCo
    println(anyCo.foo())   // 输出 a
    var strDCo1 = inin("a")
    var anyDCo1 = inin<Any>("b")
    strDCo1 = anyDCo1
}
//星号投射(star-projection): 有些时候, 你可能想表示你并不知道类型参数的任何信息, 但是仍然希望能够安全地使用它.
// 这里所谓"安全地使用"是指, 对泛型类型定义一个类型投射, 要求这个泛型类型的所有的实体实例, 都是这个投射的子类型。
// 定义一个支持协变的类

//fun <*,String> asd() = Unit //代表 Function<in Nothing, String> ;
//fun <Int, *>asdf() = Unit        // 代表 Function<Int, out Any?> ;
//fun <, > asdfg() = Unit       //代表 Function<in Nothing, out Any?> .


class outout<out A>(val a: A) {
    fun foo(): A {
        return a
    }
}

// 定义一个支持逆变的类
class inin<in A>(a: A) {
    fun foo(a: A) {
//报错        return a

    }
}

//泛型约束
fun <T : Comparable<T>> sort(list: List<T>) {
    // ……
}

fun <T> doPrintln(content: T) {
    when (content) {
        is Int -> println("整型数字为 $content")
        is String -> println("字符串转换为大写：${content.toUpperCase()}")
        else -> println("T 不是整型，也不是字符串")
    }
}

class Box<T>(t: T) {
    var value = t
}