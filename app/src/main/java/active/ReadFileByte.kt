package active

import java.io.File


// 读取文件
class ReadFileByte {

    fun readLocalFile(file: File) {
        println(file.absolutePath)
        val buffer = StringBuffer()

        val newFile = File("C:\\Users\\40953\\Downloads\\jsb-default-4-3\\frameworks\\runtime-src\\proj.android-studio\\res\\mipmap-xhdpi\\aaa.png")
        newFile.createNewFile()

        val listLines = file.readLines()
        listLines.forEachIndexed { index, s ->
            if (index == listLines.lastIndex) {
                buffer.append(s)
            } else {
                buffer.append(s).append("\n")
            }
        }
    }
}

fun main() {
//    readLocalFile(File("C:\\Users\\40953\\Downloads\\jsb-default-4-3\\frameworks\\runtime-src\\proj.android-studio\\res\\mipmap-xhdpi\\ssssss.png"))
    val file222 = File("C:\\Users\\40953\\Downloads\\jsb-default-4-3\\frameworks\\runtime-src\\proj.android-studio\\res\\mipmap-xhdpi\\ddd.png")
    ReadFileByte().readLocalFile(file222)
}

