package active

import java.io.File

fun main() {
    getListFilePath()
}

fun getListFilePath(): MutableMap<String, String> {
    val path = "C:\\Users\\40953\\IdeaProjects"
    readLocalFile(File(path))
    return filePathMap
}


val filePathMap = mutableMapOf<String, String>()


fun readLocalFile(file: File) {
    if (file.isFile) {
        filePathMap[file.parent] = file.absolutePath
    } else file.listFiles()?.forEach {
        readLocalFile(it)
    }
}





