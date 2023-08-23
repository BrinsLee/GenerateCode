package active

import com.act.code.tools.*

// 生成 String
fun main() {

    repeat(20) {
        println(genKey((6..9).random()))
    }

/*    println("String.valueOf(${((0..80000).random())}).equals(\"${(0..80000).random()}\");")
    println("String.valueOf(new Double(${((0..80000).random())})).equals(new Float(${(0..80000).random()}));")*/
}
