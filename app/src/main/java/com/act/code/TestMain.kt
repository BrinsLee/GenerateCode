package com.act.code.com.act.code

import com.act.code.FileUtils
import com.act.code.generate.GenerateLayoutFun
import com.act.code.generate.GenerateVoidFun
import com.act.code.tools.GenerateFileTools
import java.io.File
import kotlin.text.StringBuilder

fun main() {
//     testInLayout()
//    testInNormalClass()
    testInnerFiled()
}

private fun testInLayout() {
    val file = File("app/src/main/res/layout/testlayout.xml")
    val newWholeText = StringBuilder()
    file.forEachLine {
        if (it.length > 1) {
            val newLine = StringBuilder(it)
            if (it.endsWith("\">") || it.endsWith("/>")) {
//                println("符合条件的有$it 随机生成颜色值 ${String.format("%X",
//                    (16.0.pow(5).toInt()..16.0.pow(6).toInt()).random())}")
                val textviewString = GenerateLayoutFun.generateFrameLayoutContent(
                    GenerateLayoutFun::generateImageViewScaleType,
                    GenerateLayoutFun::generateTextViewEms,
                    GenerateLayoutFun::generateButtonViewPadding
                )
                newLine.appendLine("\n\t$textviewString")
            }
            newWholeText.appendLine(newLine)
        }
    }
    file.writeText(newWholeText.toString())
//    val file = File("af/AndroidManifest.xml")
//    val pkg="ffgrvcz.frghtecz.llthdgbd"
//    FileUtils.updateManifest(file,pkg)
}

private fun testInActivity() {

}

private fun testInnerFiled() {
    val file = File("app/src/main/java/active/TestInnerFiledClass.java")
    if (!file.exists()) {
        GenerateFileTools.generateFile("app/src/main/java/active/", "TestInnerFiledClass.java")
    }
    val sb = StringBuilder()
    val mutableList = mutableListOf<String>()
    FileUtils.declareInnerField45(mutableList)
    file.forEachLine {
        if (it.isNotEmpty()) {
            val newLine = StringBuilder(it)
            if (!it.contains("package") && !it.contains("}")) {
                if (it.contains("testInner()")) {
                    newLine.appendLine("\n")
                    mutableList.forEach {
                        newLine.appendLine(it)
                    }
                }
            }
            sb.appendLine(newLine)
        }
    }
    file.writeText(sb.toString())

}

private fun testInNormalClass() {
    val file = File("app/src/main/java/active/TestClass.java")
    if (!file.exists()) {
        GenerateFileTools.generateFile("app/src/main/java/active/", "TestClass.java")
    }
    val sb = StringBuilder()
    val fileFunList : HashMap<String, MutableList<String>> = GenerateVoidFun.generateVoidFun7()
    file.forEachLine {
        if (it.isNotEmpty()) {
            val newLine = StringBuilder(it)
            if (it.contains("package")) {
                FileUtils.listPackage.forEach {
                    newLine.append("\n$it\n")
                }
            }
            if (!it.contains("package") && !it.contains("}")) {
                newLine.appendLine("\n")
                println(fileFunList.keys)
                fileFunList.forEach {
                    it.value.forEach {
                        newLine.appendLine(it)
                    }
                }
            }
            // System.out.println(newLine)
            sb.appendLine(newLine)
        }
    }
    file.writeText(sb.toString())

}
