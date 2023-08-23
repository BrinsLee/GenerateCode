package fileReader

import java.io.*


object FileReaderExample {
    /**
     * @param source 目标文件
     * @param dest 拷贝到的文件地址
     */
    fun copyFileToPath(source: File, dest: File) {
        source.inputStream().use { it ->
            val os = FileOutputStream(dest)
            val buffer = ByteArray(1024)
            var length: Int
            while (it.read(buffer).also { length = it } > 0) {
                os.write(buffer, 0, length)
            }
        }
    }
}

fun main() {
    val objectPath = "C:\\Users\\code\\test_file" // 要复制的路径
    val objectFile = "C:\\Users\\40953\\Downloads\\ddd\\card\\ic_card_side.png"  // 目标文件
    val file = File(objectFile)
    FileReaderExample.copyFileToPath(file, File(objectPath + "\\" + file.name))
}
