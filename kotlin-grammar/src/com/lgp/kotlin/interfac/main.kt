package com.lgp.kotlin.interfac


/**
 * @AUTHOR lgp
 * @DATE 2018/8/15 15:58
 * @DESCRIPTION 接口的语法
 *
 **/
fun main(args: Array<String>) {

}

//一个类或者对象可以实现一个或多个接口,不带括号是接口，带括号是类
class Child : MyInterface {
    override fun bar() {
        // 方法体
    }
}

//interface 关键字定义接口，允许方法有默认实现
interface MyInterface {
    fun bar()    // 未实现
    fun foo() {  //已实现
        // 可选的方法体
        println("foo")
    }
}

//接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性：
interface MyInterface1 {
    var name: String //name 属性, 抽象的
}

class MyImpl1 : MyInterface1 {
    override var name: String = "runoob" //重载属性
}
