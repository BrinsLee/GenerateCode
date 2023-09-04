package com.act.code

import com.act.code.Config.activityClassMap
import com.act.code.Config.fragmentClassMap
import com.act.code.Config.normalClassMap
import com.act.code.Config.serviceClassMap
import com.act.code.Config.viewGroupClassMap
import com.act.code.tools.*
import java.io.File

object Main {
    fun generateNomClass() {
        val packageSize = Config.packageSize // 创建包的个数

        repeat(packageSize) {
            val packageName = Config.packageName + "." + generateDeclareObjectKey()
            val listFile = mutableListOf<String>()
            // 每个包里面有多少个类
            repeat((5..10).random()) {
                listFile.add("${generateClassKey((5.. 16).random())}.java")
            }
            normalClassMap[packageName] = listFile
        }
        normalClassMap.forEach {
            println("-keep class "+ it.key + ".** { *; }")
            it.value.forEach { name ->
                FileUtils.generateFile(it.key, name, FileUtils::initFileContent)
            }
        }
    }

    /**
     * 创建ViewGroup
     */
    fun generateViewGroupClass() {
        val packageSize = Config.packageSize / 8 // 创建ViewGroup包的个数
        repeat(packageSize) {
            val packageName = Config.packageViGName + "." + generateDeclareObjectKey()
            val listFile = mutableListOf<String>()
            // 每个包里面有多少个类
            repeat((5..8).random()) {
                listFile.add("${generateClassKey((5 .. 16).random())}Layout.java")
            }
            viewGroupClassMap[packageName] = listFile
        }

        // 创建activity
        viewGroupClassMap.forEach {
            println("-keep class "+ it.key + ".** { *; }")
            it.value.forEach { name ->
                FileUtils.generateFile(it.key, name, FileUtils::initViewGroupContent)
            }
        }
    }


    /**
     * 创建 activity
     */
    fun generateActivityClass() {
        val packageSize = Config.packageSize / 8 // 创建activity包的个数
        repeat(packageSize) {
            val packageName = Config.packageActName + "." + generateDeclareObjectKey()
            val listFile = mutableListOf<String>()
            // 每个包里面有多少个类
            repeat((5..8).random()) {
                listFile.add("${generateClassKey((5 .. 16).random())}Activity.java")
            }
            activityClassMap[packageName] = listFile
        }

        // 创建activity
        activityClassMap.forEach {
            println("-keep class "+ it.key + ".** { *; }")
            it.value.forEach { name ->
                FileUtils.generateFile(it.key, name, FileUtils::initActivityContent)
            }
        }
    }

    /**
     * 创建Fragment
     */
    fun generateFragmentClass() {
        val packageSize = Config.packageSize / 8 // 创建fragment包的个数
        repeat(packageSize) {
            val packageName = Config.packageFraName + "." + generateDeclareObjectKey()
            val listFile = mutableListOf<String>()
            // 每个包里面有多少个类
            repeat((5..8).random()) {
                listFile.add("${generateClassKey((5 .. 16).random())}Fragment.java")
            }
            fragmentClassMap[packageName] = listFile
        }

        // 创建activity
        fragmentClassMap.forEach {
            println("-keep class "+ it.key + ".** { *; }")
            it.value.forEach { name ->
                FileUtils.generateFile(it.key, name, FileUtils::initFragmentContent)
            }
        }
    }

    /**
     * 生成Service
     */
    fun generateServiceClass() {
        val packageSize = Config.packageSize / 8 // 创建Service包的个数
        repeat(packageSize) {
            val packageName = Config.packageSerName + "." + generateDeclareObjectKey()
            val listFile = mutableListOf<String>()
            // 每个包里面有多少个类
            repeat((1..3).random()) {
                listFile.add("${generateClassKey((5 .. 16).random())}Service.java")
            }
            serviceClassMap[packageName] = listFile
        }

        // 创建activity
        serviceClassMap.forEach {
            println("-keep class "+ it.key + ".** { *; }")
            it.value.forEach { name ->
                FileUtils.generateFile(it.key, name, FileUtils::initServiceContent)
            }
        }
    }


    fun generateManifestClass() {
        val path = "./src/main"
        val fileName = "AndroidManifest.xml"
        val createSuccess = GenerateFileTools.generateFile(path, fileName)

        val buffer = StringBuffer()
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
        buffer.append("<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\"\n package=\"${Config.applicationId}\">\n")
        buffer.append("<application >\n")

        activityClassMap.forEach { map ->
            map.value.forEach {
                buffer.append("<activity android:screenOrientation=\"sensorLandscape\"  android:exported=\"true\" android:name=\"${map.key}.${it.split(".")[0]}\" />\n")
            }
        }
        serviceClassMap.forEach { map ->
            val export = (0..1).random() == 0
            map.value.forEach {
                buffer.append("<service android:exported=\"$export\" android:enabled=\"$export\" android:name=\"${map.key}.${it.split(".")[0]}\" />\n")
            }
        }
        buffer.append(" </application>\n")
        buffer.append("</manifest>\n")
        if (createSuccess) {
            val file = File("$path/$fileName")
            file.writeText(buffer.toString())
        }
    }

}


fun main() {

    val startTime = System.currentTimeMillis()

    println("开始创建普通类")
    println("...")
    Main.generateNomClass() // 普通类
    println("创建完成")

    println("开始创建ViewGroup类")
    println("...")
    Main.generateViewGroupClass() // ViewGroup类
    println("创建完成")

    println("开始创建activity 和 相关布局文件")
    println("...")
    Main.generateActivityClass() // Activity 的类
    println("创建完成")

    println("开始创建service")
    println("...")
    Main.generateServiceClass() // Service 的类
    println("创建完成")

    println("开始创建清单文件")
    Main.generateManifestClass()
    println("创建完成")

    println("开始创建fragment 和 相关布局文件")
    println("...")
    Main.generateFragmentClass() // Fragment 的类
    println("创建完成")


    println("===================all file size ======================")
    totalFiles()
    val activitySize = activityClassMap.size
    val fragmentSize = fragmentClassMap.size
    val serviceSize = serviceClassMap.size
    var normalClass = 0
    allFile.forEach {
        if (it.contains("Activity") || it.contains("Fragment") || it.contains("Service")) {
//            activitySize += 1
        } else {
            normalClass += 1
        }
    }

    println("总计:${allFile.size} activity $activitySize  fragment $fragmentSize  service $serviceSize  class : $normalClass \n 用时:${System.currentTimeMillis() - startTime}")



    if (GenerateFileTools.generateFile("./", "allFile.txt")) {
        val file = File("./allFile.txt")
        val buffer = StringBuffer()
        allFile.forEach {
            buffer.append(it).append("\n")
        }
        file.writeText(buffer.toString())
    }


}


