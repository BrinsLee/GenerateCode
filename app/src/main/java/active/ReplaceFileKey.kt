package active

import java.nio.file.Files
import kotlin.io.path.Path


// 替换相关文件和相关的关键字
fun main() {
    listReplaceFile.forEach{
        println("================================>>>")


        deleteEmptyLine(it)

//        generateKeyReplaceStringFile(it)
    }
}

// 需要替换的关键字
val lisKeyWord = arrayListOf(
        "getAppsFlyerUID", "getVersionCode", "getTextFromClipboard", "getNetworkOperatorMCC", "enterLocalGame",
        "startConnectGooglePlay", "setKeepScreenOn", "copyTextToClipboard", "shareToPhoneText", "shareTextToPackage",
        "getOnlyID", "getDeviceID", "signInByGoogle", "setOrientation"
)

// 匹配关键词生成的随机关键字
private val replaceKeyList = generateKeys(lisKeyWord.size)

// 需要替换的文件
val listReplaceFile by lazy {
    val mutableList = mutableListOf<String>().apply {
        add("C:\\Users\\code\\india_rummy_ludo\\assets\\Game\\platform\\Platform.ts")
        add("C:\\Users\\code\\india_rummy_ludo\\build\\jsb-default\\frameworks\\runtime-src\\proj.android-studio\\app\\src\\com\\tumeolmc\\hegzssxt\\sfdstkj\\WyewAvpi.kt")
    }
    mutableList
}

// 生成String
fun generateKeys(size: Int): List<String> {
    val mutableList = mutableListOf<String>()
    val charArray = "qwertyuiopasdfghjklzxcvbnm".toCharArray()
    repeat(size) {
        val charLength = (8..14).random()  // 8到16 位随机
        val buffer = StringBuffer()
        repeat(charLength) {
            val indexChar = (0..charArray.lastIndex).random()
            buffer.append(charArray[indexChar])
        }
        val generateStr = "$buffer"
        if (!mutableList.contains(generateStr)) {
            mutableList.add(generateStr)
        }
    }
    return mutableList
}

// 替换文件中的关键字
fun generateKeyReplaceStringFile(pathString: String) {
    val mutableMap = mutableMapOf<Int, String>()
    try {
        val path = Path(pathString)
        val reader = Files.newBufferedReader(path)
        var lineIndex = 0
        reader.forEachLine { line ->
            lineIndex++
            var lineValue = line
            lisKeyWord.forEachIndexed { index, s ->
                if (line.contains(s)) {
                    lineValue = line.replace(s, replaceKeyList[index])
                }
            }
            mutableMap[lineIndex] = lineValue
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    mutableMap.forEach {
        println("${it.value}")
    }
}

// 删除空行
fun deleteEmptyLine(filePath: String) {
    val mutableList = mutableListOf<String>()
    try {
        val path = Path(filePath)
        val reader = Files.newBufferedReader(path)
        reader.readLines().forEach {
            if (!it.trim().isNullOrEmpty()){
                mutableList.add(it)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    mutableList.forEach {
        println("$it")
    }
}
