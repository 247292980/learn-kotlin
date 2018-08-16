package com.lgp.kotlin.`class`

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent


/**
 * @AUTHOR lgp
 * @DATE 2018/8/15 14:30
 * @DESCRIPTION 类型的语法
 *
 **/
fun main(args: Array<String>) {
//    abstract    // 抽象类
//    final       // 类不可继承，默认属性
//    enum        // 枚举类
//    open        // 类可继承，类默认是final的
//    annotation  // 注解类
//
//    private    // 仅在同一个文件中可见
//    protected  // 同一个文件中或子类可见
//    public     // 所有调用的地方都可见
//    internal   // 同一个模块中可见

    val site = foo2() // Kotlin 中没有 new 关键字
    println(site.name)//要使用一个属性，只要用名称引用它即可
    var person: Person = Person()

    person.lastName = "wang"

    println("lastName:${person.lastName}")

    person.no = 9
    println("no:${person.no}")

    person.no = 20
    println("no:${person.no}")

    val demo = Outer.Nested().foo() // 调用格式：外部类.嵌套类.嵌套类方法/属性
    println(demo)    // == 2

    val demo1 = Outer1().Inner().foo()
    println(demo1) //   1
    val demo2 = Outer1().Inner().innerTest()
    println(demo2)   // 内部类可以引用外部类的成员，例如：成员属性

    var test = Test()

    /**
     * 采用对象表达式来创建接口对象，即匿名内部类的实例。
     */
    test.setInterFace(object : TestInterFace {
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }
    })
    val s = Student4()
    s.study()

    var user = User("123456")
    user.Print()

    printFoo(D())

    var t = null
    println(t.toString())

    println("no:${MyClass.no}")
    MyClass.foo()

    val c = C8()
    val d = D8()
    c.caller(d)

//    对象表达式
    val site3 = object {
        var name: String = "菜鸟教程"
        var url: String = "www.runoob.com"
    }
    println(site3.name)
    println(site3.url)

//    对象可以继承于某个基类，或者实现其他接口:
    val ab: A3 = object : A3(1), B7 {
        override fun hi() {
        }

        override val y = 15
    }
//    引用该对象，我们直接使用其名称
    DataProviderManager.registerDataProvider(Student("1", 2, "3", 4))

    val instance = MyClass6.create()   // 访问到对象的内部元素
}
//类内部的对象声明可以用 companion 关键字标记，这样它就与外部类关联在一起，我们就可以直接通过外部类访问到对象的内部元素。
//伴生对象
//一个类里面只能声明一个内部关联对象，即关键字 companion 只能使用一次。
class MyClass6 {
    companion object Factory {
        fun create(): MyClass6 = MyClass6()
    }
}

//    Kotlin 使用 object 关键字来声明一个对象。
object DataProviderManager {
    fun registerDataProvider(provider: Student) {
        // ……
    }

    val allDataProviders: Collection<Student>
        get() {
            var coll: Collection<Student>? = null
            return coll!!
        }
}

//在对象表达中可以方便的访问到作用域中的其他变量:
fun countClicks(window: JComponent) {
    var clickCount = 0
    var enterCount = 0

    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            clickCount++
        }

        override fun mouseEntered(e: MouseEvent) {
            enterCount++
        }
    })
}

open class A3(x: Int) {
    public open val y: Int = x
}

interface B7 {
    fun hi()
}


//在一个类内部你可以为另一个类声明扩展。
//在这个扩展中，有个多个隐含的接受者，其中扩展方法定义所在类的实例称为分发接受者，而扩展方法的目标类型的实例称为扩展接受者。
class D8 {
    fun bar() {
        println("D bar")
    }
}

class C8 {
    fun baz() {
        println("C baz")
    }

    fun D8.foo() {
        bar()   // 调用 D.bar
        baz()   // 调用 C.baz
    }

    fun caller(d: D8) {
        d.foo()   // 调用扩展函数
    }
}

//如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数和属性。
//伴生对象通过"类名."形式调用伴生对象，伴生对象声明的扩展函数，通过用类名限定符来调用：
class MyClass {
    companion object {}  // 将被称为 "Companion"
}

fun MyClass.Companion.foo() {
    println("伴随对象的扩展函数")
}

val MyClass.Companion.no: Int
    get() = 10

//扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。
// 初始化属性因为属性没有后端字段（backing field），所以扩展属性不能有初始化器，只能由显式提供的 getter/setter 定义。
val D.bar get() = 10

//在扩展函数内， 可以通过 this 来判断接收者是否为 NULL,这样，即使接收者为 NULL,也可以调用扩展函数
fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}

//扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，具体被调用的的是哪一个函数，由调用函数的的对象表达式来决定的，而不是动态的类型决定的:
open class C2()

class D : C2()

fun C2.foo() = "c"   // 扩展函数 foo

fun D.foo() = "d"   // 扩展函数 foo

fun printFoo(c: C2) {
    println(c.foo())  // 类型是 C 类
}


open class Foo4 {
    open val count: Int = 0
}

class User(var name: String)

/**扩展函数**/
fun User.Print() {
    println("用户名 $name")
}

//你可以用一个var属性重写一个val属性，但是反过来不行
class Bar41(override val count: Int) : Foo4()

class Bar42 : Foo4() {
    override var count: Int = 0
}

open class Foo {
    open val x: Int = 2
}

class Bar1 : Foo() {
    override val x: Int = 1
}

//有多个相同的方法（继承或者实现自其他类，如A、B类），则必须要重写该方法，使用super范型去选择性地调用父类的实现。
open class A {
    open fun f() {
        print("A")
    }

    fun a() {
        print("a")
    }
}

interface B {
    fun f() {
        print("B")
    } //接口的成员变量默认是 open 的

    fun b() {
        print("b")
    }
}

class C : A(), B {
    override fun f() {
        super<A>.f()//调用 A.f()
        super<B>.f()//调用 B.f()
    }
}

/**用户基类**/
open class Person4 {
    open fun study() {       // 允许子类重写
        println("我毕业了")
    }
}

/**子类继承 Person 类**/
class Student4 : Person4() {

    override fun study() {    // 重写方法
        println("我在读大学")
    }
}

//如果子类有主构造函数， 则基类必须在主构造函数中立即初始化。
open class Person3(var name: String, var age: Int) {// 基类

}

class Student(name: String, age: Int, var no: String, var score: Int) : Person3(name, age)

//如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，或者在代理另一个构造函数
class Student3 : Person3 {

    constructor(age: Int) : this("asd", age)

    constructor(name: String, age: Int) : super(name, age)
}

//使用对象表达式来创建匿名内部类：
class Test {
    var v = "成员属性"

    fun setInterFace(test: TestInterFace) {
        test.test()
    }
}

//如果一个类可被继承，可以使用 open 关键字进行修饰。
open class haha(p: Int)           // 定义基类

/**
 * 定义接口
 */
interface TestInterFace {
    fun test()
}

/**嵌套内部类**/
class Outer1 {
    private val bar: Int = 1
    var v = "成员属性"

    inner class Inner {
        fun foo() = bar  // 访问外部类成员
        fun innerTest() {
            var o = this@Outer1 //获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }
}

//嵌套类
class Outer {                  // 外部类
    private val bar: Int = 1

    class Nested {             // 嵌套类
        fun foo() = 2
    }
}

//抽象类 后
abstract class Derived {
    abstract fun f()
}

//如果一个非抽象类没有声明构造函数(主构造函数或次构造函数)，它会产生一个没有参数的构造函数。
// 构造函数是 public 。如果你不想你的类有公共的构造函数，你就得声明一个空的主构造函数：
class DontCreateMe private constructor()

// 主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
class Man constructor(firstName: String) {
    init {
        println("FirstName is $firstName")
    }

    //    类也可以有二级构造函数，需要加前缀 constructor:
//    如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数
    constructor(people: People) : this(people.name)
}

//kotlin提供了一种可以延迟初始化的方案
//lazy{} 只能用在val类型, lateinit 只能用在var类型
class People(val firstName: String, val lastName: String) {
    val name: String by lazy { "sherlbon" }
    lateinit var adapter: Man
//    lateinit不能用在可空的属性上 报错
//    lateinit var adapter1: Int
//    lateinit可以在任何位置初始化并且可以初始化多次。而lazy在第一次被调用时就被初始化，想要被改变只能重新定义
//    lateinit 有支持（反向）域（Backing Fields）
}


class Person {
    //    getter 和 setter 都是可选
//     如果属性类型可以从初始化语句或者类的成员函数中推断出来，那就可以省去类型，val不允许设置setter函数，因为它是只读的。
    var lastName: String = "zhang"
//    field 关键词只能用于属性的访问器
        get() = field.toUpperCase()   // 将变量赋值后转换为大写
        set(value) {
            field = "zhang$value"
        }

    var no: Int = 100
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    var heiht: Float = 145.4f
        private set
}

class Empty
class foo {
    fun foo() {
        print("Foo")
    } // 成员函数
}

class foo2 {
    var name: String = "name"
    var url: String = "url"
    var city: String = "city"
}

//Koltin 中的类可以有一个 主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后:
class Person2 constructor(firstName: String)

//constructor关键字可以省略。
class Person1(firstName: String)