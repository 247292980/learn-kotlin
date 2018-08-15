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

//三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小
    val a: Int = 10000
    println(a === a) // true，值相等，对象地址相等

    //经过了装箱，创建了两个不同的对象
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    //虽然经过了装箱，但是值是相等的，都是10000
    println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
    println(boxedA == anotherBoxedA) // true，值相等

//     小类不能转大类,大类不能转小类，要用方法转
//     每种数据类型都有下面的这些方法，可以转化为其它的类型：
//    toByte(): Byte
//    toShort(): Short
//    toInt(): Int
//    toLong(): Long
//    toFloat(): Float
//    toDouble(): Double
//    toChar(): Char

//    val b: Byte = 1 // OK, 字面值是静态检测的
//    val i: Int = b // 错误
    val b: Byte = 1 // OK,
    val b1: Int = b.toInt() // OK
    val c: Int = 1 // OK,
    val c1: Byte = c.toByte() // OK
//自动转换时，小能转大
    val l: Long = 0L + 3 // Long + Int => Long
//    val l1: Int = 3 + 1L // Long + Int => Long

//    shl(bits) – 左移位 (Java’s <<)
//    shr(bits) – 右移位 (Java’s >>)
//    ushr(bits) – 无符号右移位 (Java’s >>>)
//    and(bits) – 与
//    or(bits) – 或
//    xor(bits) – 异或
//    inv() – 反向
    val d: Int = 10
    println(d.shl(1))
    println(d.shr(1))
    println(d.ushr(1))
    println(d.and(1))
    println(d.or(1))
    println(d.xor(1))
    println(d.inv())
//和 Java 不一样，Kotlin 中的 Char 不能直接和数字操作,Char 必需是单引号 ' 包含起来的
//    ""里面是string
    decimalDigitValue('0')

//            || – 短路逻辑或
//            && – 短路逻辑与
//            ! - 逻辑非
    println(true || false)
    println(true && false)
    println(!false)

//    数组用类 Array 实现，并且还有一个 size 属性及 get 和 set 方法，由于使用 [] 重载了 get 和 set 方法
//    除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组
    //[1,2,3] 使用函数arrayOf()创建数组
    val a3 = intArrayOf(1, 2, 3)
    //[0,2,4] 使用工厂函数 创建数组
    val b3: IntArray = IntArray(3) { i -> (i * 2) }

    //读取数组内容
    println(a3[0])    // 输出结果：1
    println(b3)    // 输出结果：[Ljava.lang.Integer;@5e2de80c
    println(b3[1])    // 输出结果：2
    println(b3.size)    // 输出结果：3
    println(b3.set(1, 1))    // kotlin.Unit
    println(b3.get(1))    // 输出结果：1
    b3[1] = b3[1] * 2
    println(b3.get(1))    // 输出结果：2
}

fun parseInt(str: String): Int? {
    return null
}

fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9') {
        throw IllegalArgumentException("Out of range")
    }
    return c.toInt() - '0'.toInt() // 显式转换为数字
}