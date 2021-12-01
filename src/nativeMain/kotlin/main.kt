import interop.*
import kotlinx.cinterop.*

fun main() {
    println("Hello")
    listTesting()
    waitForInput()
}

fun listTesting() {
    val cList = cValue<ListBuilder> {
        length = 4
    }

    val newList = mutableListOf<Int>()

    cList.useContents {
        for (i in 0..length) {
            newList += values!![i]
        }
    }

    println("List made from C array: $newList")

}

fun callValue() {

    var aFromStruct : Int = 0
    var bFromStruct : Double = 0.0

    val cStruct = cValue<MyStruct> {
        a = 42
        b = 3.14
    }

    cStruct.useContents {
        aFromStruct = a
        bFromStruct = b
    }

    println("Kotlin: a from struct was $aFromStruct")
    println("Kotlin: b from struct was $bFromStruct")

    println("Kotlin: a from x was ${x.a}")
    println("Kotlin: b from x was ${x.b}")

    incrementA(x)

    println("Kotlin: a from x was ${x.a}")
    println("Kotlin: b from x was ${x.b}")

    passStructToC(cStruct)

    println(cStruct.size)
}

fun makeMyStruct(myStruct: MyStruct) {
    myStruct.a = 2
    myStruct.b = 0.32
}

fun mapTest() {
    val mapEntry1 = cValue<MapEntry> {
        key = 1
        value = 2
    }
}

fun incrementA(struct: MyStruct) {
    struct.a += 1
}

fun <T> listBuilder(struct: ListBuilder) : List<T> {
    val newList = mutableListOf<T>()
    println("Kotlin: Array Length is ${struct.length}")
    for (i in 0 until struct.length) {
        newList += (struct.values!![i] as T)
        println("Kotlin: Array Value at $i is ${struct.values!![i]}")
    }
    return newList
}

fun printList(list : List<Int>) {
    println("Kotlin: List is $list")
}