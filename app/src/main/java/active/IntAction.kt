package active

// 生成相关的时间
fun main() {
    val dayTime = 24 * 60 * 60 * 1000L
    println(dayTime)
    println((7 * dayTime) + System.currentTimeMillis())
    println((50 * dayTime) + System.currentTimeMillis())

}



