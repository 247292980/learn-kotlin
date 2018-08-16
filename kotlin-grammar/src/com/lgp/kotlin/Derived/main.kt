package com.lgp.kotlin.Derived

import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


/**
 * @AUTHOR lgp
 * @DATE 2018/8/16 10:54
 * @DESCRIPTION 委托 观察的语法
 *
 **/
fun main(args: Array<String>) {
    val b = BaseImpl(10)
    println() // 输出 10

    val e = Example()
    println(e.p)     // 访问该属性，调用 getValue() 函数

    e.p = "str"   // 调用 setValue() 函数
    println(e.p)

    val user = User()
    user.name = "第一次赋值"
    user.name = "第二次赋值"


//    在一个映射（map）里存储属性的值。
    // 构造函数接受一个映射参数
    val site = Site(mapOf(
            "name" to "baidu",
            "url" to "www.baidu.com"
    ))
    //如果使用 var 属性，需要把 Map 换成 MutableMap：
    var site1 = Site(mapOf(
            "name" to "baidu2",
            "url" to "www.baidu.com2"
    ))

    // 读取映射值
    println(site.name)
    println(site1.url)

    var foo: Foo = Foo()
    foo.notNullBar = "bar"
    println(foo.notNullBar)

    val myTestClass = MyTestClass()
    println(myTestClass.myField1)
}

//部分委托
class MyReadOnlyPropertyImpl : ReadOnlyProperty<MyTestClass, String> {
    override fun getValue(thisRef: MyTestClass, property: KProperty<*>): String {
        val s = "aaa"
        return s;
    }
}

class MyProvider {
    operator fun provideDelegate(thisRef: MyTestClass, prop: KProperty<*>): ReadOnlyProperty<MyTestClass, String> {
        println("do something") // 这行代码是在getValue方法之外调用的
        val myReadOnlyPropertyImpl = MyReadOnlyPropertyImpl() // 这里才是调用getValue方法的地方
        return myReadOnlyPropertyImpl
    }
}

class MyTestClass {
    val myProvider = MyProvider()
    val myField1: String by myProvider
}

//Not Null
class Foo {
    var notNullBar: String by Delegates.notNull<String>()
}

class Site1(val map: MutableMap<String, Any?>) {
    val name: String by map
    val url: String  by map
}

class Site(val map: Map<String, Any?>) {
    val name: String by map
    val url: String  by map
}

//可观察属性 Observable
//observable 可以用于实现观察者模式。
//Delegates.observable() 函数接受两个参数: 第一个是初始化值, 第二个是属性值变化事件的响应器(handler)。
//在属性赋值后会执行事件的响应器(handler)，它有三个参数：被赋值的属性、旧值和新值：
class User {
    var name: String by Delegates.observable("初始值") { prop, old, new ->
        println("旧值：$old -> 新值：$new")
    }
}

//属性委托 属性委托指的是一个类的某个属性值不是在类中直接进行定义，而是将其托付给一个代理类
// 定义包含属性委托的类
class Example {
    var p: String by Delegate()
}

// 委托的类
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 这里委托了 ${property.name} 属性"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}

//类委托 类的委托即一个类中定义的方法实际是调用另一个类的对象的方法来实现的

// 创建接口
interface Base {
    fun print()
}

// 实现此接口的被委托的类
class BaseImpl(val x: Int) : Base {
    override fun print() {
        print(x)
    }
}

// 通过关键字 by 建立委托类
class Derived(b: Base) : Base by b