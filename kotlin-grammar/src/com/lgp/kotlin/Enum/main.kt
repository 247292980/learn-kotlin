package com.lgp.kotlin.Enum


/**
 * @AUTHOR lgp
 * @DATE 2018/8/15 17:50
 * @DESCRIPTION 枚举的语法
 *
 **/
fun main(args: Array<String>) {


    var color: Color = Color.BLUE

    println(Color.values()) // 以数组的形式，返回枚举值
    println(Color.valueOf("RED"))// 转换指定 name 为枚举值，
    println(color.name)
    println(color.ordinal)

    printAllValues<Color>() // 输出 RED, GREEN, BLUE
}

//可以使用 enumValues<T>() 和 enumValueOf<T>() 函数以泛型的方式访问枚举类中的常量
inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}

enum class Color {
    RED, BLACK, BLUE, GREEN, WHITE
}

enum class Color1(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

enum class Shape(value: Int) {
    ovel(100),
    rectangle(200)
}

//枚举还支持以声明自己的匿名类及相应的方法
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },
    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}