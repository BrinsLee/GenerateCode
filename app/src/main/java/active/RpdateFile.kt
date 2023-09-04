package active

import com.act.code.FileUtils
import java.io.File

fun main() {
//    updateManifest()
    updateJavaFile()
}
fun updateManifest(){
    val file = File("af/AndroidManifest.xml")
    val pkg="com.belada.l205u2s9adga"
    FileUtils.updateManifest(file,pkg)
}
fun updateJavaFile(){
    var file = File("af/AwsdfApplication.java")
    var uFile = FileUtils.printLines(file)
}