package com.lgp.kotlin.type


/**
 * @AUTHOR lgp
 * @DATE 2018/8/14 16:48
 * @DESCRIPTION
 *
 **/
fun main(args: Array<String>) {
    println(getStringLength(123))
    println(getStringLength("123"))
}
//使用 is 运算符检测一个表达式是否某类型的一个实例
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // 做过类型判断以后，obj会被系统自动转换为String类型
        return obj.length
    }

//     if (obj !is String){
//         return -1
//     }

    // 这里的obj仍然是Any类型的引用
    return null
}
