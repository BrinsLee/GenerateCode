package com.act.code.tools

import java.io.File
import java.util.Locale

private val lowerChars = "qazxswedcvfrtgbnhyujmkiolp".toCharArray()
private val numChars = "1234567890".toCharArray()
private val upperChars = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray()
private val chars4 = "_".toCharArray()

val listType = mutableListOf<String>().apply {
    add("String")
    add("Boolean")
    add("char")
    add("Long")
    add("Double")
    add("int")
    add("Float")
    add("Byte")
    add("String[]")
    add("Boolean[]")
    add("char[]")
    add("Long[]")
    add("Double[]")
    add("int[]")
    add("Float[]")
    add("Byte[]")
}


// 创建对象名称
fun generateClassKey(keyLength: Int = 12): String {
    val buffer = StringBuffer()
    repeat(keyLength) {
        if (it == 0) {
            buffer.append(upperChars.random())
        } else {
            buffer.append((lowerChars + numChars + upperChars + chars4).random())
        }
    }
    return buffer.toString()
}

// 创建对象名称
fun generateObjectKey(keyLength: Int = 12): String {
    val buffer = StringBuffer()
    repeat(keyLength) {
        if (it == 0) {
            buffer.append((lowerChars + upperChars).random())
        } else {
            buffer.append((lowerChars + numChars + upperChars + chars4).random())
        }
    }
    return buffer.toString()
}

// 创建对象名称
fun generateKey(keyLength: Int = 12): String {
    val buffer = StringBuffer()
    repeat(keyLength) {
        if (it == 0) {
            buffer.append((lowerChars).random())
        } else {
            buffer.append((lowerChars + numChars).random())
        }
    }
    return buffer.toString()
}


// 创建方法名称
fun generateFunName(keyLength: Int = (8..18).random()): String {
    val buffer = StringBuffer()
    repeat(keyLength) {
        buffer.append((lowerChars + upperChars).random())
    }
    return buffer.toString()
}


// 创建对象名称
fun generateLayoutId(keyLength: Int = 12): String {
    val buffer = StringBuffer()
    repeat(keyLength) {
        buffer.append((lowerChars + chars4).random())
    }
    return buffer.toString()
}


// 声明对象名称
fun generateDeclareObjectKey(keyLength: Int = (8..16).random()): String {
    val buffer = StringBuffer()
    repeat(keyLength) {
        buffer.append((lowerChars).random())
    }
    return buffer.toString()
}

//随机颜色
fun generateColorValue(): String {
    var R: String = Integer.toHexString((0..255).random()).uppercase(Locale.ROOT)
    var G: String = Integer.toHexString((0..255).random()).uppercase(Locale.ROOT)
    var B: String = Integer.toHexString((0..255).random()).uppercase(Locale.ROOT)
    R = if (R.length == 1) "0$R" else R
    G = if (G.length == 1) "0$G" else G
    B = if (B.length == 1) "0$B" else B
    val result = "#$R$G$B"
    println(result)
    return result
}

//随机可见性
fun generateVisible(): String {
    val random = (0 .. 2).random()
    return when(random) {
        0 -> "gone"
        1 -> "invisible"
        else -> "visible"
    }
}

//随机gravity
fun generateGravity(): String {
    val random = (0 .. 6).random()
    return when(random) {
        0 -> "left"
        1 -> "top"
        2 -> "right"
        3 -> "bottom"
        4 -> "center_horizontal"
        5 -> "center_vertical"
        else -> "center"
    }
}

//随机ellipsize
fun generateEllipsize(): String {
    val random = (0 .. 5).random()
    return when(random) {
        0 -> "end"
        1 -> "middle"
        2 -> "marquee"
        3 -> "start"
        else -> "none"
    }
}

//随机scaleType
fun generateScaleType(): String {
    val random = (0 .. 7).random()
    return when(random) {
        0 -> "center"
        1 -> "centerCrop"
        2 -> "centerInside"
        3 -> "fitCenter"
        4 -> "fitEnd"
        5 -> "fitStart"
        6 -> "fitXY"
        else -> "matrix"
    }
}

fun genKey(keyLength: Int = (8..16).random()): String {
    val buffer = StringBuffer()
    repeat(keyLength) {
        buffer.append((upperChars).random())
    }
    return buffer.toString()
}


fun generateArgs(sp: Int): String {
    var buffer = StringBuffer()
    repeat(sp - 1) {
        buffer.append(numChars.random()).append("-")
    }
    buffer.append(numChars.random())
    return buffer.toString()
}

fun generateLocalVar(sp: Int): String {
    var buffer = StringBuffer()
    repeat(sp) {
        buffer.append(lowerChars.random())
    }
    return buffer.toString()
}

fun totalFiles(): Int {
    val files = File("./com")
    redFile(files)
    return allFile.size
}

val allFile = mutableListOf<String>()
fun redFile(file: File) {
    if (file.isFile) {
        allFile.add(file.absolutePath)
    } else {
        file.listFiles()?.forEach {
            redFile(it)
        }
    }
}

fun redRandomChar(): Char {
    return (lowerChars + numChars + upperChars + chars4).random()
}




