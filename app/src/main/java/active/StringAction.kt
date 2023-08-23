package active

fun main() {

    val time = System.currentTimeMillis()
    val dayTime = 60 * 60 * 24 * 1000 * 100
    println("$time    $dayTime    ${time + dayTime}")

    generateKeys(lisKeyWord.size).forEach {
        println(it)
    }

}
