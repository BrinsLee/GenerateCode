package com.act.code

import com.act.code.Config.layoutList
import com.act.code.generate.GenerateActivityFun
import com.act.code.generate.GenerateFragmentFun
import com.act.code.generate.GenerateLayoutFun
import com.act.code.generate.GenerateServiceFun
import com.act.code.generate.GenerateViewGroupFun
import com.act.code.model.PackageNameData
import com.act.code.tools.GenerateFileTools
import com.act.code.tools.genKey
import com.act.code.tools.generateClassKey
import com.act.code.tools.generateDeclareObjectKey
import com.act.code.tools.generateFunName
import com.act.code.tools.generateKey
import com.act.code.tools.generateLayoutId
import com.act.code.tools.redRandomChar
import java.io.File

object FileUtils {


    /**
     *     val filePath = "com.cn.javass"
     *         val fileName = "/Builder${generateFunName()}.java"
     */
    public val listPackage = LinkedHashSet<String>()

    //已生成的Activity
    var generatedActivities: MutableList<PackageNameData> = ArrayList<PackageNameData>()

    //已生成的Fragment
    var generatedFragments: MutableList<PackageNameData> = ArrayList<PackageNameData>()

    //已生成的Service
    var generatedServices: MutableList<PackageNameData> = ArrayList<PackageNameData>()

    //已生成ViewGroup
    var generatedViewGroup: MutableList<PackageNameData> = arrayListOf(
        PackageNameData("android.view", "ViewGroup"),
        PackageNameData("android.widget", "LinearLayout"),
        PackageNameData("android.widget", "RelativeLayout"),
        PackageNameData("android.widget", "FrameLayout"),
        PackageNameData("android.widget", "GridLayout")
    )

    fun generateFile(packageValue: String, fileName: String, action: (String, File) -> File) {
        val filePath = "./" + packageValue.replace(".", "/")
        GenerateFileTools.generateFile(filePath, fileName)
        val file = File("$filePath/$fileName")
        action(packageValue, file)
    }


    fun initFileContent(packagePath: String, file: File): File {
        val fileFunList = mutableListOf<Map<String, MutableList<String>>>()
        listPackage.clear()
        repeat((Config.packageSize..2 * Config.packageSize).random()) {
            fileFunList.add(GenerateFileTools.generateFunAction())
        }
        val listFun = mutableListOf<String>()
        fileFunList.forEach { map ->
            map.forEach { entry ->
                listFun.add(entry.key)
            }
        }
        val buffer = StringBuffer()
        buffer.append("package $packagePath;\n")
        buffer.append("\n")
        listPackage.forEach {
            buffer.append("$it\n")
        }

        buffer.append("\n")
        buffer.append("\n")
        buffer.append("public class ${file.name.split(".")[0]}{\n")

        buffer.append("\n")

        val argList = ArrayList<String>()
        repeat((listFun.size) / 4) {
            declareStaticValueString().forEach { (t, u) ->
                argList.add(t)
                buffer.append(u).append("")
            }
        }

        repeat(listFun.size) {
            declareValueString().forEach { (t, u) ->
                argList.add(t)
                buffer.append(u).append("\n")
            }
        }
        buffer.append("\n")

        // 所有方法的调用
        buffer.append("public  ${file.name.split(".")[0]}(){")
        buffer.append("\n")
        listFun.forEach {
            buffer.append("System.out.println(${argList[(0 until argList.size).random()]}); ")
                .append("\n")
            buffer.append("$it").append("\n")
            buffer.append("System.out.println(${argList.get((0 until argList.size).random())}); ")
                .append("\n")
        }
        buffer.append("}")

        // 所有方法的内容
        buffer.append("\n")
        fileFunList.forEach { map ->
            map.forEach { entry ->
                val value = entry.value
                value.forEach {
                    buffer.append(it).append("\n")
                }
            }
            buffer.append("\n")
        }
        buffer.append("\n")
        buffer.append("}")
        buffer.append("\n")

        file.writeText(buffer.toString())
        return printLines(file)

    }

    fun updateManifest(file: File, pkg: String): File {
        val sb = StringBuilder()
        file.readLines().forEach {
            if (it.length > 1) {
                sb.appendLine(addManifest(it, pkg))
            }
        }
        file.writeText(sb.toString())
        return file
    }

    private fun addManifest(str: String, pkg: String): String {
        if (str.contains("<activity") || str.contains("<provider") || str.contains("<receiver") || str.contains(
                "</application>"
            )
        ) {
            val newStr = StringBuilder()
            repeat((1..4).random()) {
                newStr.appendLine(
                    "<meta-data android:name=\"" + generateClassKey((16..26).random()) + "\" android:value=\"" + generateClassKey(
                        (12..36).random()
                    ) + "\"/>"
                )

                newStr.appendLine("<activity android:name=\"" + pkg + "." + generateDeclareObjectKey() + "\" android:exported=\"true\" android:launchMode=\"singleTask\"/>")

            }
            newStr.append(str)
            return newStr.toString()
        } else if (str.contains("<supports-screens") || str.contains("<uses-feature") || str.contains(
                "<uses-permission"
            ) || str.contains("<queries>") || str.contains("</receiver>") || str.contains("</provider>") || str.contains(
                "</manifest>"
            ) || str.contains("<application")
        ) {
            val newStr = StringBuilder()
            repeat((1..4).random()) {
                newStr.appendLine(
                    "<meta-data android:name=\"" + generateClassKey((16..26).random()) + "\" android:value=\"" + generateClassKey(
                        (12..36).random()
                    ) + "\"/>"
                )
            }
            newStr.append(str)
            return newStr.toString()
        }
        return str
    }

    fun initViewGroupContent(packagePath: String, file: File): File {
        val listClassObject = getListClassObject()
        val fileFunList = mutableListOf<Map<String, MutableList<String>>>()
        listPackage.clear()

        val importClassList = mutableListOf<String>()  // 引入的class 类对象
        repeat(listClassObject.size / 8) {
            val classObject = listClassObject.random()
            if (!importClassList.contains(classObject)) {
                importClassList.add(classObject)
            }
        }
        importClassList.forEach {
            val classArray = it.split("->")
            listPackage.add("import ${classArray[0]}.${classArray[1].split(".")[0]};")
        }

        // 生成所非方法
        repeat((Config.packageSize..2 * Config.packageSize).random()) {
            fileFunList.add(GenerateFileTools.generateFunAction())
        }

        // 所有方法的使用集合
        val listFun = mutableListOf<String>()
        fileFunList.forEach { map ->
            map.forEach { entry ->
                listFun.add(entry.key)
            }
        }

        val className = file.name.split(".")[0]

        // 生成ViewGroup 的原生方法
        val listOriginActFun = mutableListOf<String>().apply {
            addAll(GenerateViewGroupFun.generateConstruct(className))
            addAll(GenerateViewGroupFun.generateSecondConstruct(className))
            addAll(GenerateViewGroupFun.generateThirdConstruct(className))
            addAll(GenerateViewGroupFun.generateOnMeasure())
            addAll(GenerateViewGroupFun.generateOnLayout())
            addAll(GenerateViewGroupFun.generateOnDraw())
            addAll(GenerateViewGroupFun.generateOnAttachedToWindow())
            addAll(GenerateViewGroupFun.generateOnDetachedFromWindow())

        }

        val buffer = StringBuffer()
        buffer.append("package $packagePath;\n")
        buffer.append("\n")
        listPackage.forEach {
            buffer.append("$it\n")
        }

        buffer.append("\n")
        buffer.append("\n")

        val index = (0 until generatedViewGroup.size).random()
        val viewGroup = generatedViewGroup[index]
        buffer.append("import ${viewGroup!!.packageName}.${viewGroup!!.name};\n")
        buffer.append("public class ${className} extends ${viewGroup!!.name} {\n")

        generatedViewGroup.add(PackageNameData(packagePath, file.name.split(".")[0]))

        buffer.append("\n")

        val argList = ArrayList<String>()
        // 添加头部的静态对象方法
        repeat((listFun.size) / 4) {
            declareStaticValueString().forEach { (t, u) ->
                argList.add(t)
                buffer.append(u).append("")
            }
        }

        // 添加非静态对象的方法
        repeat(listFun.size) {
            declareValueString().forEach { (t, u) ->
                argList.add(t)
                buffer.append(u).append("\n")
            }
        }
        buffer.append("\n")

        listOriginActFun.forEach {
            buffer.append(it + "\n")
        }

        // 所有方法的内容
        buffer.append("\n")
        fileFunList.forEach { map ->
            map.forEach { entry ->
                val value = entry.value
                value.forEach {
                    buffer.append(it).append("\n")
                }
            }
            buffer.append("\n")
        }

        buffer.append("\n")
        buffer.append("}")
        buffer.append("\n")

        file.writeText(buffer.toString())
        return printLines(file, true)

    }

    fun printLines(file: File, excludeSuper: Boolean = false): File {
        leftNum = 0
        val sb = StringBuilder()
        file.readLines().forEach {
            sb.appendLine(itExt(it, excludeSuper))
        }
        file.writeText(sb.toString())
        return file
    }

    private var leftNum = 0

    private fun itExt(itStr: String, excludeSuper: Boolean = false): String {
        if (itStr.contains("{")) {
            leftNum += getContainsCount(itStr, "{")
        }
        if (itStr.contains("}")) {
            leftNum -= getContainsCount(itStr, "}")
        }

        if (itStr.contains("{") || itStr.contains("}") || itStr.contains("case") || itStr.contains("default") || itStr.contains(
                "@JavascriptInterface"
            ) || itStr.contains("Override")
              || itStr.contains("NotNull")
              || itStr.contains("//")
              || itStr.isEmpty()
        ) {
            return itStr
        }
        val keepSuper = (excludeSuper && itStr.contains("super"))

        if (leftNum > 1) {
            val ext = StringBuilder()
            if (keepSuper) {
                ext.appendLine(itStr)
            }
            repeat((5..15).random()) {
                declareInnerField().forEach {
                    ext.appendLine(it)
                }
            }
            if (!keepSuper) {
                ext.appendLine(itStr)
            }
            return ext.toString()
        }
        return itStr
    }

    private fun getContainsCount(it: String?, str: String): Int {
        it?.run {
            val itLength = this.length
            val newLength = this.replace(str, "").length
            return itLength - newLength
        }
        return 0
    }

    // 获取所有的class 列表
    private fun getListClassObject(): List<String> {
        val list = mutableListOf<String>()
        Config.normalClassMap.forEach { map ->
            map.value.forEach {
                list.add(map.key + "->" + it)
            }
        }
        return list
    }

    private fun getListViewGroupClass(): List<String> {
        val list = mutableListOf<String>()
        Config.viewGroupClassMap.forEach { map ->
            map.value.forEach {
                list.add(map.key + "->" + it)
            }
        }
        return list
    }

    fun initFragmentContent(packagePath: String, file: File): File {
        val listClassObject = getListClassObject()
        val listViewGroup = getListViewGroupClass()
        val fileFunList = mutableListOf<Map<String, MutableList<String>>>()
        listPackage.clear()

        val importClassList = mutableListOf<String>()  // 引入的class 类对象
        repeat(listClassObject.size / 8) {
            val classObject = listClassObject.random()
            if (!importClassList.contains(classObject)) {
                importClassList.add(classObject)
            }
        }
        importClassList.forEach {
            val classArray = it.split("->")
            listPackage.add("import ${classArray[0]}.${classArray[1].split(".")[0]};")
        }

        // 生成所非方法
        repeat((Config.packageSize..2 * Config.packageSize).random()) {
            fileFunList.add(GenerateFileTools.generateFunAction())
        }

        // 所有方法的使用集合
        val listFun = mutableListOf<String>()
        fileFunList.forEach { map ->
            map.forEach { entry ->
                listFun.add(entry.key)
            }
        }

        // 生成fragment 的原生方法
        val listOriginActFun = mutableListOf<String>().apply {
            addAll(GenerateFragmentFun.generateActOnCreate())
            addAll(GenerateFragmentFun.generateActOnCreateView())
            addAll(GenerateFragmentFun.generateActOnAttach())
            addAll(GenerateFragmentFun.generateActOnActivityCreated())
            addAll(GenerateFragmentFun.generateActOnViewCreated())
            addAll(GenerateFragmentFun.generateActOnStart())
            addAll(GenerateFragmentFun.generateActOnResume())
            addAll(GenerateFragmentFun.generateActOnPause())
            addAll(GenerateFragmentFun.generateActOnStop())
            addAll(GenerateFragmentFun.generateActOnDestroy())
            addAll(GenerateFragmentFun.generateActOnDestroyView())

        }

        val buffer = StringBuffer()
        buffer.append("package $packagePath;\n")
        buffer.append("\n")
        listPackage.forEach {
            buffer.append("$it\n")
        }

        buffer.append("\n")
        buffer.append("\n")
        if (generatedFragments.isEmpty()) {
            buffer.append("public class ${file.name.split(".")[0]} extends Fragment {\n")
        } else {
            val index = (0 until generatedFragments.size).random()
            val fragment = generatedFragments[index]
            buffer.append("import ${fragment!!.packageName}.${fragment!!.name};\n")
            buffer.append("public class ${file.name.split(".")[0]} extends ${fragment!!.name} {\n")
        }
        generatedFragments.add(PackageNameData(packagePath, file.name.split(".")[0]))

        buffer.append("\n")

        val argList = ArrayList<String>()
        // 添加头部的静态对象方法
        repeat((listFun.size) / 4) {
            declareStaticValueString().forEach { (t, u) ->
                argList.add(t)
                buffer.append(u).append("")
            }
        }

        // 添加非静态对象的方法
        repeat(listFun.size) {
            declareValueString().forEach { (t, u) ->
                argList.add(t)
                buffer.append(u).append("\n")
            }
        }
        buffer.append("\n")

        // 所有方法的调用
        buffer.append("public  ${file.name.split(".")[0]}(){")
        buffer.append("\n")
        listFun.forEach {
            buffer.append("System.out.println(${argList[(0 until argList.size).random()]}); ")
                .append("\n")
            buffer.append("$it").append("\n")
            buffer.append("System.out.println(${argList[(0 until argList.size).random()]}); ")
                .append("\n")
        }
        buffer.append("}")

        // 所有方法的内容
        buffer.append("\n")
        fileFunList.forEach { map ->
            map.forEach { entry ->
                val value = entry.value
                value.forEach {
                    buffer.append(it).append("\n")
                }
            }
            buffer.append("\n")
        }

        listOriginActFun.forEach {
            buffer.append(it + "\n")
        }


        buffer.append("\n")
        buffer.append("}")
        buffer.append("\n")

        file.writeText(buffer.toString())
        return printLines(file)

    }


    fun initActivityContent(packagePath: String, file: File): File {
        val listClassObject = getListClassObject()
        val listViewGroup = getListViewGroupClass()
        val fileFunList = mutableListOf<Map<String, MutableList<String>>>()
        listPackage.clear()

        val importClassList = mutableListOf<String>()  // 引入的class 类对象
        repeat(listClassObject.size / 8) {
            val classObject = listClassObject.random()
            if (!importClassList.contains(classObject)) {
                importClassList.add(classObject)
            }
        }
        repeat(listViewGroup.size / 2) {
            val classObject = listViewGroup.random()
            if (!importClassList.contains(classObject)) {
                importClassList.add(classObject)
            }
        }
        importClassList.forEach {
            val classArray = it.split("->")
            listPackage.add("import ${classArray[0]}.${classArray[1].split(".")[0]};")
        }

        // 生成所非方法
        repeat((Config.packageSize..2 * Config.packageSize).random()) {
            fileFunList.add(GenerateFileTools.generateFunAction())
        }

        // 所有方法的使用集合
        val listFun = mutableListOf<String>()
        fileFunList.forEach { map ->
            map.forEach { entry ->
                listFun.add(entry.key)
            }
        }

        // 生成activity 的原生方法
        val listOriginActFun = mutableListOf<String>().apply {
            addAll(GenerateActivityFun.generateActOnCreate(importClassList))
            addAll(GenerateActivityFun.generateActOnBackPress())
            addAll(GenerateActivityFun.generateActOnConfigurationChanged())
            addAll(GenerateActivityFun.generateActOnNewIntent(importClassList))
            addAll(GenerateActivityFun.generateActOonRestoreInstanceState())
            addAll(GenerateActivityFun.generateActOnStart())
            addAll(GenerateActivityFun.generateActOnRestart())
            addAll(GenerateActivityFun.generateActOnResume())
            addAll(GenerateActivityFun.generateActOnPause())
            addAll(GenerateActivityFun.generateActOnStop())
            addAll(GenerateActivityFun.generateActOnDestroy())

        }

        val buffer = StringBuffer()
        buffer.append("package $packagePath;\n")
        buffer.append("\n")
        listPackage.forEach {
            buffer.append("$it\n")
        }

        buffer.append("\n")
        buffer.append("\n")
        if (generatedActivities.isEmpty()) {
            buffer.append("public class ${file.name.split(".")[0]} extends Activity {\n")
        } else {
            val index = (0 until generatedActivities.size).random()
            val activity = generatedActivities[index]
            buffer.append("import ${activity!!.packageName}.${activity!!.name};\n")
            buffer.append("public class ${file.name.split(".")[0]} extends ${activity!!.name} {\n")
        }
        generatedActivities.add(PackageNameData(packagePath, file.name.split(".")[0]))

        buffer.append("\n")

        val argList = ArrayList<String>()
        // 添加头部的静态对象方法
        repeat((listFun.size) / 4) {
            declareStaticValueString().forEach { (t, u) ->
                argList.add(t)
                buffer.append(u).append("")
            }
        }

        // 添加非静态对象的方法
        repeat(listFun.size) {
            declareValueString().forEach { (t, u) ->
                argList.add(t)
                buffer.append(u).append("\n")
            }
        }
        buffer.append("\n")

        // 所有方法的调用
        buffer.append("public  ${file.name.split(".")[0]}(){")
        buffer.append("\n")
        listFun.forEach {
            buffer.append("System.out.println(${argList[(0 until argList.size).random()]}); ")
                .append("\n")
            buffer.append("$it").append("\n")
            buffer.append("System.out.println(${argList[(0 until argList.size).random()]}); ")
                .append("\n")
        }
        buffer.append("}")

        // 所有方法的内容
        buffer.append("\n")
        fileFunList.forEach { map ->
            map.forEach { entry ->
                val value = entry.value
                value.forEach {
                    buffer.append(it).append("\n")
                }
            }
            buffer.append("\n")
        }

        listOriginActFun.forEach {
            buffer.append(it + "\n")
        }


        buffer.append("\n")
        buffer.append("}")
        buffer.append("\n")

        file.writeText(buffer.toString())
        return printLines(file)

    }


    fun initServiceContent(packagePath: String, file: File): File {
        val listClassObject = getListClassObject()
        val fileFunList = mutableListOf<Map<String, MutableList<String>>>()
        listPackage.clear()

        val importClassList = mutableListOf<String>()  // 引入的class 类对象
        repeat(listClassObject.size / 8) {
            val classObject = listClassObject.random()
            if (!importClassList.contains(classObject)) {
                importClassList.add(classObject)
            }
        }
        importClassList.forEach {
            val classArray = it.split("->")
            listPackage.add("import ${classArray[0]}.${classArray[1].split(".")[0]};")
        }

        // 生成所非方法
        repeat((Config.packageSize..2 * Config.packageSize).random()) {
            fileFunList.add(GenerateFileTools.generateFunAction())
        }

        // 所有方法的使用集合
        val listFun = mutableListOf<String>()
        fileFunList.forEach { map ->
            map.forEach { entry ->
                listFun.add(entry.key)
            }
        }

        val className = file.name.split(".")[0]

        // 生成service 的原生方法
        val listOriginActFun = mutableListOf<String>().apply {
            addAll(GenerateServiceFun.generateOnBindFun())
            addAll(GenerateServiceFun.generateOnCreate())
            addAll(GenerateServiceFun.generateOnStartCommand())
            addAll(GenerateServiceFun.generateOnDestroy())
            addAll(GenerateServiceFun.generateOnReBind())
            addAll(GenerateServiceFun.generateOnUnBind())

        }

        val buffer = StringBuffer()
        buffer.append("package $packagePath;\n")
        buffer.append("\n")
        listPackage.forEach {
            buffer.append("$it\n")
        }

        buffer.append("\n")
        buffer.append("\n")
        if (generatedServices.isEmpty()) {
            buffer.append("import android.app.Service;\n")
            buffer.append("public class ${className} extends Service {\n")
        } else {
            val index = (0 until generatedServices.size).random()
            val service = generatedServices[index]
            buffer.append("import ${service!!.packageName}.${service!!.name};\n")
            buffer.append("public class ${file.name.split(".")[0]} extends ${service!!.name} {\n")
        }
        generatedServices.add(PackageNameData(packagePath, className))


        buffer.append("\n")

        val argList = ArrayList<String>()
        // 添加头部的静态对象方法
        repeat((listFun.size) / 4) {
            declareStaticValueString().forEach { (t, u) ->
                argList.add(t)
                buffer.append(u).append("")
            }
        }

        // 添加非静态对象的方法
        repeat(listFun.size) {
            declareValueString().forEach { (t, u) ->
                argList.add(t)
                buffer.append(u).append("\n")
            }
        }
        buffer.append("\n")

        // 所有方法的调用
        buffer.append("public  ${className}(){")
        buffer.append("\n")
        listFun.forEach {
            buffer.append("System.out.println(${argList[(0 until argList.size).random()]}); ")
                .append("\n")
            buffer.append("$it").append("\n")
            buffer.append("System.out.println(${argList[(0 until argList.size).random()]}); ")
                .append("\n")
        }
        buffer.append("}")

        // 所有方法的内容
        buffer.append("\n")
        fileFunList.forEach { map ->
            map.forEach { entry ->
                val value = entry.value
                value.forEach {
                    buffer.append(it).append("\n")
                }
            }
            buffer.append("\n")
        }

        listOriginActFun.forEach {
            buffer.append(it + "\n")
        }


        buffer.append("\n")
        buffer.append("}")
        buffer.append("\n")

        file.writeText(buffer.toString())
        return printLines(file)

    }


    private fun declareInnerField(): MutableList<String> {
        val mutableList = mutableListOf<String>()
        return when ((0..48).random()) {
            0 -> mutableList.apply {
                add("System.getenv();")
            }

            1 -> mutableList.apply {
                add("System.getenv(\"" + genKey() + "\");")
            }

            2 -> mutableList.apply {
                add("System.getProperties().get(\"" + genKey() + "\");")
            }

            3 -> mutableList.apply {
                // Float.valueOf(99947.0F).floatValue();
                add("Float.valueOf(${(0..50000).random()}.0F).floatValue();")
            }

            4 -> mutableList.apply {
                // (new Double(3379.0D)).floatValue();
                add("new Double(${(0..80000).random()}.0D).floatValue();")
            }

            5 -> mutableList.apply {
                // (new Double(4764.0D)).doubleValue();
                add("new Double(${(0..80000).random()}.0D).doubleValue();")
            }

            6 -> mutableList.apply {
                //  "flOrtDbeqPRyU".getBytes();
                add("\"${genKey()}\".getBytes();")
            }

            7 -> mutableList.apply {
                //  (new Integer(8183)).equals(Integer.valueOf(7469));
                add("(new Integer(${(0..80000).random()})).equals(Integer.valueOf(${(0..80000).random()}));")
            }

            8 -> mutableList.apply {
                //  System.out.println("lmfPphXSQMIYPWV");
                add("System.out.println(\"${genKey()}\");")
            }

            9 -> mutableList.apply {
                //   int i = ("hpbbJcabwAVFHJvpTTRR".getBytes()).length;
                add("int ${genKey()} = (\"${genKey()}\".getBytes()).length;")
            }
            //新增
            10 -> mutableList.apply {
                // String.valueOf(88557).equals("26521");
                add("String.valueOf(${((0..80000).random())}).equals(\"${(0..80000).random()}\");")
            }

            11 -> mutableList.apply {
                //String.valueOf(new Double(512.0d)).equals(String.valueOf(new Float(512.0d)));
                add("String.valueOf(new Double(${((0..80000).random())})).equals(new Float(${(0..80000).random()}));")

            }

            12 -> mutableList.apply {
                /*if (51874.0f) > java.lang.Float.valueOf(25561.0f)) {
                    "vQeddJapsxJO".toByteArray()
                }*/
                val k = genKey()
                add("if (${((0..80000).random())}.0f > java.lang.Float.valueOf(${((0..80000).random())}.0f)) {")
                add("\"${genKey()}\".getBytes();")
                add("Float $k = (${((0..80000).random())}.0f - java.lang.Float.valueOf(${((0..80000).random())}.0f));")
                add("}")
            }

            13 -> mutableList.apply {
                /*if (51874.0f) > java.lang.Float.valueOf(25561.0f)) {
                    "vQeddJapsxJO".toByteArray()
                }*/
                val k = genKey()
                add("if (new Double(${((0..80000).random())}.0) < java.lang.Double.valueOf(${((0..80000).random())}.0f)) {")
                add("\"${genKey()}\".getBytes();")
                add("System.out.print(\"$k\");")
                add("}")
            }

            14 -> mutableList.apply {
                /**
                 * SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                 * format.format(new Date())
                 */
                val k = genKey(10)
                add("java.text.SimpleDateFormat ${k} = new java.text.SimpleDateFormat(\"yyyy/MM/dd HH:mm\");")
                add("$k.format(new java.util.Date());")
            }

            15 -> mutableList.apply {
                /**
                 * while (x > 0) {
                int digit = x % 10;
                x /= 10;
                }
                 */
                val k = genKey(10)
                val digit = genKey(10)
                add("int $k = ${(0 until 50).random()};")
                add("while ($k > 0) {")
                add("int $digit = $k % ${(10..20).random()};")
                add("$k /= 10;")
                add("}")
            }

            16 -> mutableList.apply {
                /**
                 * String s = "alkdjaskldj"
                 * int row = 0, col = 0;
                 * boolean goingDown = false;
                 *
                 */
                val str = genKey(15)
                val row = genKey(10)
                val col = genKey(10)
                add("String $str = \"${genKey(10)}\";")
                add("int $row = ${(0..5000).random()}, $col = ${(0..5000).random()};")
                add("boolean $col$row = false;")
            }

            17 -> mutableList.apply {
                /**
                 * String KJJ = "AKLSDJK";
                android.graphics.Paint paint = new Paint();
                 */
                val k = genKey(10)
                val paint = genKey(10)
                add("String $k = \"${genKey(15)}\";")
                add("android.graphics.Paint $paint = new android.graphics.Paint();")
                add("$paint.setColor(android.graphics.Color.argb(255, ${(0 until 256).random()},  ${(0 until 256).random()},  ${(0 until 256).random()}));")
            }

            18 -> mutableList.apply {
                val k = genKey(10)
                val paint = genKey(10)
                add("String $k = \"${genKey(15)}\";")
                add("android.graphics.Paint $paint = new android.graphics.Paint();")
                add("$paint.setAlpha(${(0 until 256).random()});")
            }

            19 -> {
                mutableList.apply {
                    val file = genKey(10)
                    val e = genKey(5)
                    add("java.io.File $file = new java.io.File(\"${genKey()}\");")
                    add("try {")
                    add("if ($file.exists() && $file.isFile()) {")
                    add("$file.delete();")
                    add("}")
                    add("} catch (java.lang.Exception $e) {")
                    add("$e.printStackTrace();")
                    add("}")
                }
            }

            20 -> {
                mutableList.apply {
                    add("if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {")
                    add("String.valueOf(${((0..80000).random())}).equals(\"${(0..80000).random()}\");")
                    add("}")
                }
            }

            21 -> {
                mutableList.apply {
                    val k = genKey()
                    add("if(android.os.Build.VERSION.SDK_INT == android.os.Build.VERSION_CODES.KITKAT_WATCH) {")
                    add("String.valueOf(${((0..80000).random())}).equals(\"${(0..80000).random()}\");")
                    add("String $k = String.valueOf(${((0..80000).random())}).substring(0);")
                    add("}")
                }
            }

            22 -> {
                mutableList.apply {
                    val file = genKey(9)
                    add("java.io.File $file = android.os.Environment.getDataDirectory();")
                    add("new android.os.StatFs($file.getPath());")
                }
            }

            23 -> {
                mutableList.apply {
                    val tag = genKey()
                    add("android.util.Log.d(\"$tag\", \"${genKey(16)}\");")
                }
            }

            24 -> {
                mutableList.apply {
                    val k = genKey()
                    val str = genKey()
                    add("java.io.BufferedReader $k = null;")
                    add("StringBuilder $str = new StringBuilder(\"$k\");")
                    add("$str.toString();")
                }
            }

            25 -> {
                mutableList.apply {
                    val file = genKey()
                    val input = genKey(10)
                    val fos = genKey(9)
                    val buffer = genKey()
                    val e = genKey(3)
                    val e2 = genKey(3)
                    val e3 = genKey(3)
                    add("java.io.File $file = new java.io.File(\"${genKey()}\");")
                    add("java.io.InputStream $input = null;")
                    add("java.io.FileOutputStream $fos = null;")
                    add("try {")
                    add("byte[] $buffer = new byte[1024];")
                    add("$fos = new java.io.FileOutputStream($file);")
                    add("$fos.write($buffer);")
                    add("} catch (java.lang.Exception $e) {")
                    add("$e.printStackTrace();}")
                    add("finally {")
                    add("if($input != null) {")
                    add("try {\n$input.close();\n} catch (java.lang.Exception $e2) {\n$e2.printStackTrace();\n}")
                    add("}")
                    add("if($fos != null) {")
                    add("try {\n$fos.close();\n} catch (java.lang.Exception $e3) {\n$e3.printStackTrace();\n}")
                    add("}")
                    add("}")
                }
            }

            26 -> {
                mutableList.apply {
                    val k = genKey()
                    add("android.util.DisplayMetrics $k = new android.util.DisplayMetrics();")
                    add("StringBuilder ${genKey()} = new StringBuilder(\"${genKey()}\");")
                }
            }

            27 -> {
                declareInnerField27(mutableList)
            }

            28 -> {
                declareInnerField28(mutableList)
            }

            29 -> {
                declareInnerField29(mutableList)
            }

            30 -> {
                declareInnerField30(mutableList)
            }

            31 -> {
                mutableList.apply {
                    val tag = genKey()
                    add("final String $tag[] = {\"/${genKey()}/${genKey()}/\", \"/${genKey()}/${genKey()}/\",\n" + "\"/${genKey()}/${genKey()}/\", \"/${genKey()}/\", \"/${genKey()}/${genKey()}/\"};")
                }
            }

            32 -> {
                /**
                 * "OhKdswlltcSVT".getBytes();
                System.getenv("nAjqWUohrGxkBzQYw");
                System.out.println("LGQVxfXByOfjH");

                 */
                mutableList.apply {
                    add("\"${genKey(10)}\".getBytes();")
                    add("System.getenv(\"${genKey()}\");")
                    add("System.out.println(\"${genKey()}\");")
                }
            }

            33 -> {
                mutableList.apply {
                    add("\"${generateFunName()}\".getBytes();\n" + "System.getProperties().get(\"${generateFunName()}\");")
                }
            }

            34 -> {
                mutableList.apply {
                    val k = genKey()
                    val str = genKey()
                    add("int $k = \"$str\".getBytes().length;")
                    add("new Integer(${(0..90000).random()}).equals(${(0..90000).random()});\n")
                }
            }

            35 -> {
                mutableList.apply {
                    val tag = genKey()
                    val path = genKey()
                    add("java.util.List<String> $tag = java.util.Arrays.asList(System.getenv(\"$path\"));".addTryCatch())
                }
            }

            36 -> {
                mutableList.apply {
                    val str = genKey()
                    add("android.net.Uri $str = android.net.Uri.parse(\"market://${genKey()}?id=\" + \"${genKey()}\");\nSystem.out.println($str.toString());".addTryCatch())
                }
            }

            37 -> {
                mutableList.apply {
                    val startTs = genKey()
                    add("long $startTs = android.os.SystemClock.elapsedRealtime();")
                    add("System.out.println(String.valueOf($startTs));")
                }
            }

            38 -> {
                mutableList.apply {
                    val startTs = genKey()
                    val endTs = genKey()
                    add("long $startTs = android.os.SystemClock.elapsedRealtime();")
                    add("System.out.println(String.valueOf($startTs));")
                    add("long $endTs = android.os.SystemClock.elapsedRealtime();")
                    add("System.out.println(String.valueOf($startTs - $endTs));")
                }
            }

            39 -> {
                mutableList.apply {
                    val clazz = genKey()
                    val method = genKey()
                    add("Class<?> $clazz = android.app.ActivityManager.class;\njava.lang.reflect.Method $method = $clazz.getMethod(\"isWindowMode\", new Class[]{android.app.Activity.class});".addTryCatch())
                }
            }

            40 -> {
                mutableList.apply {
                    val clsArray = genKey()
                    val clazz = genKey()
                    add("Class<?>[] $clsArray = new Class<?>[]{String.class};\nClass<?> $clazz = Class.forName(\"android.os.SystemProperties\");".addTryCatch())
                }
            }

            41 -> {
                mutableList.apply {
                    val tag = genKey()
                    add("\"$tag\".equalsIgnoreCase(android.os.Build.MANUFACTURER);")
                }
            }

            42 -> {
                mutableList.apply {
                    val k = genKey()
                    val str = genKey()
                    add("\"$str\".startsWith(\"$k\");".addTryCatch())
                }
            }

            43 -> {
                declareInnerField43(mutableList)
            }

            44 -> {
                declareInnerField44(mutableList)
            }

            45 -> {
                declareInnerField45(mutableList)
            }

            46 -> {
                declareInnerField46(mutableList)
            }

            47 -> {
                declareInnerField47(mutableList)
            }

            48 -> {
                declareInnerField48(mutableList)
            }

            else -> mutableList
        }
    }

    fun declareInnerField27(mutableList: MutableList<String>): MutableList<String> {
        return mutableList.apply {
            val intent = genKey()
            add("android.content.Intent ${intent} = new android.content.Intent();")
            add("if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {")
            add("$intent.setAction(\"${getActionSetting()}\");")
            add("$intent.setAction(\"${getActionSetting()}\");")
            add("}")
        }
    }

    fun declareInnerField28(mutableList: MutableList<String>): MutableList<String> {
        return mutableList.apply {
            val intent = genKey()
            add("android.content.Intent ${intent} = new android.content.Intent();")
            add("if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {")
            add("$intent.setAction(\"${getActionSetting()}\");")
            add("$intent.putExtra(\"app_package\", \"${genKey()}\");")
            add("}")
        }
    }


    fun declareInnerField29(mutableList: MutableList<String>): MutableList<String> {
        return mutableList.apply {
            val intent = genKey()

            add("android.content.Intent ${intent} = new android.content.Intent();")
            add("if (android.os.Build.VERSION.SDK_INT == android.os.Build.VERSION_CODES.KITKAT) {")
            add("$intent.setAction(${getProviderSettings()});")
            add("$intent.addCategory(${generateCategory()});")
            add("}")
        }
    }

    fun declareInnerField30(mutableList: MutableList<String>): MutableList<String> {
        return mutableList.apply {
            val intent = genKey()
            add("android.content.Intent ${intent} = new android.content.Intent();")
            add("$intent.addFlags(${generateActivityFlag()});")
            add("$intent.addFlags(${generateActivityFlag()});")

        }
    }


    fun declareInnerField43(mutableList: MutableList<String>): MutableList<String> {
        return mutableList.apply {
            val k = genKey()
            add("android.graphics.Matrix $k = new android.graphics.Matrix();")
            add("$k.setRotate(${(0..90).random()}, ${(100..200).random()}, ${(100..200).random()});")
            add("$k.postScale(${(1..100).random()}f, ${(1..100).random()}f);")
        }
    }

    fun declareInnerField44(mutableList: MutableList<String>): MutableList<String> {
        val k = genKey()
        val stringBuilder = StringBuilder()
        stringBuilder.apply {
            append("org.json.JSONObject $k = new org.json.JSONObject();")
            append("$k.put(\"${generateFunName()}\", \"${generateKey()}\");")
            append("$k.put(\"${generateFunName()}\", ${(0..99999).random()});")
            append("$k.put(\"${generateFunName()}\", \"${generateKey(10)}\");")
            append("String ${generateKey()} = ${k}.toString();")
        }
        return mutableList.apply {
            add(stringBuilder.toString().addTryCatch())
        }

    }

    fun declareInnerField45(mutableList: MutableList<String>): MutableList<String> {
        val channelConfig = generateFunName()
        val audioFormat = generateFunName()
        val sampleRate = genKey()
        val minBufferSize = generateFunName()
        val audioTrack = genKey()
        val stringBuilder = StringBuilder()
        val channel = when ((0..3).random()) {
            0 -> "android.media.AudioFormat.CHANNEL_OUT_MONO"
            1 -> "android.media.AudioFormat.CHANNEL_OUT_BACK_LEFT"
            2 -> "android.media.AudioFormat.CHANNEL_OUT_BACK_RIGHT"
            else -> "android.media.AudioFormat.CHANNEL_OUT_BACK_CENTER"
        }
        val bit =
            if ((0..1).random() == 0) "android.media.AudioFormat.ENCODING_PCM_16BIT" else "android.media.AudioFormat.ENCODING_PCM_8BIT"
        stringBuilder.apply {
            append("int $channelConfig = ${channel};")
            append("int $sampleRate = ${(44100..80000).random()};")
            append("int $audioFormat = $bit;")
            append("final int $minBufferSize = android.media.AudioTrack.getMinBufferSize($sampleRate, $channelConfig, android.media.AudioFormat.ENCODING_PCM_16BIT);")
            append("android.media.AudioTrack $audioTrack = new android.media.AudioTrack(new android.media.AudioAttributes.Builder().setUsage(android.media.AudioAttributes.USAGE_MEDIA).build(), new android.media.AudioFormat.Builder().setSampleRate($sampleRate).setEncoding($audioFormat)" + ".setChannelMask($channelConfig).build()," + "            $minBufferSize," + "            android.media.AudioTrack.MODE_STREAM," + "            android.media.AudioManager.AUDIO_SESSION_ID_GENERATE);")
            append("$audioTrack.play();")
        }
        return mutableList.apply {
            add(stringBuilder.toString().addTryCatch())
        }

    }

    fun declareInnerField46(mutableList: MutableList<String>): MutableList<String> {
        val stringBuilder = StringBuilder()
        val channelConfig = genKey()
        val audioFormat = genKey()
        val sampleRate = genKey()
        val minBufSize = genKey()
        val audioRecord = genKey()
        val data = genKey()
        val channel = when ((0..5).random()) {
            0 -> "android.media.AudioFormat.CHANNEL_IN_MONO"
            1 -> "android.media.AudioFormat.CHANNEL_IN_DEFAULT"
            2 -> "android.media.AudioFormat.CHANNEL_IN_BACK_PROCESSED"
            3 -> "android.media.AudioFormat.CHANNEL_IN_RIGHT"
            4 -> "android.media.AudioFormat.CHANNEL_IN_LEFT"
            else -> "android.media.AudioFormat.CHANNEL_IN_BACK"
        }
        val bit =
            if ((0..1).random() == 0) "android.media.AudioFormat.ENCODING_PCM_16BIT" else "android.media.AudioFormat.ENCODING_PCM_8BIT"

        stringBuilder.apply {
            append("int $channelConfig = $channel;")
            append("int $audioFormat = $bit;")
            append("int $sampleRate = ${(44100..80000).random()};")
            append("int $minBufSize = android.media.AudioRecord.getMinBufferSize($sampleRate, $channelConfig, $audioFormat);\n")
            append("@android.annotation.SuppressLint(\"MissingPermission\") ")
            append("android.media.AudioRecord $audioRecord = new android.media.AudioRecord(android.media.MediaRecorder.AudioSource.MIC, $sampleRate," + "$channelConfig, $audioFormat, $minBufSize);")
            append("final byte $data[] = new byte[$minBufSize];")
        }
        return mutableList.apply {
            add(stringBuilder.toString().addTryCatch())
        }

    }

    fun declareInnerField47(mutableList: MutableList<String>): MutableList<String> {
        val stringBuilder = StringBuilder()
        val set = genKey()
        val objecta = genKey()

        stringBuilder.apply {
            append("java.util.Set<java.lang.Object> $set = new java.util.HashSet<>();")
            repeat((2..6).random()) {
                append("$set.add(\"${genKey()}\");\n")
            }
            append("java.lang.Object[] $objecta = $set.toArray(new Object[$set.size()]);")
            append("java.util.Arrays.sort($objecta, new java.util.Comparator<Object> () {\n@Override\npublic int compare(Object o1, Object o2){return o1.hashCode() - o2.hashCode();}});")
        }
        return mutableList.apply {
            add(stringBuilder.toString())
        }

    }

    fun declareInnerField48(mutableList: MutableList<String>): MutableList<String> {
        val stringBuilder = StringBuilder()
        val nano = genKey()
        val objectKey = genKey()
        val mediaCodec = genKey()
        val width = "${genKey()}Width"
        val height = "${genKey()}Height"
        val color = "android.media.MediaCodecInfo.CodecCapabilities.${
            when ((1..10).random()) {
                1 -> "COLOR_FormatMonochrome"
                2 -> "COLOR_Format8bitRGB332"
                3 -> "COLOR_Format12bitRGB444"
                4 -> "COLOR_Format16bitARGB4444"
                5 -> "COLOR_Format16bitARGB1555"
                6 -> "COLOR_Format16bitRGB565"
                7 -> "COLOR_Format16bitBGR565"
                8 -> "COLOR_Format18bitRGB666"
                9 -> "COLOR_Format18bitARGB1665"
                else -> "COLOR_Format19bitARGB1666"
            }
        }"


        stringBuilder.apply {
            append("long $nano = System.nanoTime();")
            append("int $width = ${(640..1080).random()};")
            append("int $height = ${(720..1280).random()};")
            append("android.media.MediaFormat $objectKey = android.media.MediaFormat.createVideoFormat(\"video/avc\", $width, $height);")
            append("$objectKey.setInteger( android.media.MediaFormat.KEY_COLOR_FORMAT, $color);")
            append("$objectKey.setInteger( android.media.MediaFormat.KEY_FRAME_RATE, ${(20..30).random()});")
            append("$objectKey.setInteger( android.media.MediaFormat.KEY_BIT_RATE, ${width} * $height * ${(1..5).random()});")
            append("$objectKey.setInteger( android.media.MediaFormat.KEY_I_FRAME_INTERVAL, 1);")
            append("android.media.MediaCodec $mediaCodec = android.media.MediaCodec.createEncoderByType(\"video/avc\");")
            append("$mediaCodec.configure($objectKey, null, null, android.media.MediaCodec.CONFIGURE_FLAG_ENCODE);")
        }
        return mutableList.apply {
            add(
                stringBuilder.toString()
                    .addTryCatch("java.io.IOException | java.lang.IllegalArgumentException")
            )
        }

    }


    private fun declareValueString(): HashMap<String, String> {
        val map = HashMap<String, String>()
        val key = generateDeclareObjectKey()
        return when ((0..10).random()) {
            0 -> {
                map[key] = "public int $key = ${(0..50000).random()};"
                map
            }

            1 -> {
                val buffer = StringBuffer()
                buffer.append("public int[] $key = {")
                repeat((10..50).random()) {
                    buffer.append((0..9999).random()).append(",")
                }
                buffer.append("};")
                map[key] = buffer.toString()
                map
            }

            2 -> {
                map[key] = "private String  $key = \" ${generateDeclareObjectKey(40)}\";"
                map
            }

            3 -> {
                val buffer = StringBuffer()
                buffer.append("public String[] $key = {")
                repeat((10..50).random()) {
                    buffer.append("\"${generateDeclareObjectKey((4..30).random())}\",")
                }
                buffer.append("};")
                buffer.toString()
                map[key] = buffer.toString()
                map
            }

            4 -> {
                map[key] = "private boolean $key = true;"
                map
            }

            5 -> {
                map[key] = "private double  $key =  ${(0..50000).random()}.0d;"
                map
            }

            6 -> {
                val buffer = StringBuffer()
                buffer.append("public double[] $key = {")
                repeat((10..50).random()) {
                    buffer.append((0..9999).random()).append("d,")
                }
                buffer.append("};")
                buffer.toString()
                map[key] = buffer.toString()
                map
            }
            //新增
            7 -> {
                // private final int[][] f18177c34z7epw6hhdykh2o6dew8Ghv398s22ogme = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
                val time = (1..5).random()
                val buffer = StringBuffer()
                buffer.apply {
                    append("private final int[][] $key = {")
                    repeat(time) {
                        append("new int[]{${(Int.MIN_VALUE..Int.MAX_VALUE).random()}, ${(Int.MIN_VALUE..Int.MAX_VALUE).random()}}, ")
                    }
                    append("};")
                }
                map[key] = buffer.toString()
                map
            }

            8 -> {
                // private final float[][] adaasd = {new float[]{16842910f, 16842912f}, new float[]{16842910f, -16842912f}, new float[]{515f, 16842912f}, new float[]{-16842910f, -16842912f}};
                val time = (1..5).random()
                val buffer = StringBuffer()
                buffer.apply {
                    append("private final float[][] $key = {")
                    repeat(time) {
                        append("new float[]{${(0..6566).random()}f, ${(0..6526).random()}f}, ")
                    }
                    append("};")
                }
                map[key] = buffer.toString()
                map
            }

            9 -> {
                // private final float[][] adaasd = {new float[]{16842910f, 16842912f}, new float[]{16842910f, -16842912f}, new float[]{515f, 16842912f}, new float[]{-16842910f, -16842912f}};
                val time = (1..5).random()
                val buffer = StringBuffer()
                buffer.apply {
                    append("private final double[][] $key = {")
                    repeat(time) {
                        append("new double[]{${(0..6566).random()}d, ${(0..6526).random()}d}, ")
                    }
                    append("};")
                }
                map[key] = buffer.toString()
                map
            }

            10 -> {
                val buffer = StringBuffer()
                buffer.apply {
                    append("private String[] $key = new String[] {android.Manifest.permission.RECORD_AUDIO,\n           android.Manifest.permission.WRITE_EXTERNAL_STORAGE};")
                }
                map[key] = buffer.toString()
                map
            }

            11 -> {
                val buffer = StringBuffer()
                buffer.apply {
                    append("private List<String> $key = new ArrayList<>();")
                }
                map[key] = buffer.toString()
                map
            }

            else -> map
        }
    }

    private fun declareStaticValueString(): Map<String, String> {
        val map = HashMap<String, String>()
        val key = generateDeclareObjectKey()
        return when ((0..6).random()) {
            0 -> {
                val buffer = StringBuffer()
                buffer.append("public static final double[] $key = {")
                repeat((10..50).random()) {
                    buffer.append((0..9999).random()).append("d,")
                }
                buffer.append("};")
                buffer.toString()
                map[key] = buffer.toString()
                map
            }

            1 -> {
                val buffer = StringBuffer()
                buffer.append("public static final String[] $key = {")
                repeat((10..50).random()) {
                    buffer.append("\"${generateDeclareObjectKey((4..30).random())}\",")
                }
                buffer.append("};")
                buffer.toString()
                map[key] = buffer.toString()
                map
            }

            2 -> {
                val buffer = StringBuffer()
                buffer.append("public static final int[] $key = {")
                repeat((10..50).random()) {
                    buffer.append((0..9999).random()).append(",")
                }
                buffer.append("};")
                buffer.toString()
                map[key] = buffer.toString()
                map
            }
            //新增
            3 -> {
                val buffer = StringBuffer()
                buffer.append("public static float[] $key = new float[] {")
                repeat((10..20).random()) {
                    buffer.append((0..9999).random()).append(".f").append(",")
                }
                buffer.append("};")
                buffer.toString()
                map[key] = buffer.toString()
                map
            }

            4 -> {
                val buffer = StringBuffer()
                buffer.append("public static char[] $key = new char[] {")
                repeat((10..30).random()) {
                    buffer.append("\'").append(redRandomChar()).append("\'").append(",")
                }
                buffer.append("};")
                buffer.toString()
                map[key] = buffer.toString()
                map
            }

            5 -> {
                val buffer = StringBuffer()
                buffer.append("public static boolean[] $key = {")
                repeat((10..18).random()) {
                    if ((0..9999).random() % 10 == 0) {
                        buffer.append("true")
                    } else {
                        buffer.append("false")
                    }
                    buffer.append(",")
                }
                buffer.append("};")
                buffer.toString()
                map[key] = buffer.toString()
                map
            }

            else -> map

        }
    }

    fun generateLayoutFile(): String {
        val filePath = "./src/layout"
        val fileName = "activity_${generateLayoutId()}.xml"
        if (GenerateFileTools.generateFile(filePath, fileName)) {
            val file = File("$filePath/$fileName")
            layoutList.add(fileName)
            val str = when ((0..4).random()) {
                0 -> GenerateLayoutFun.generateRelativeLayoutView()
                1 -> GenerateLayoutFun.generateLinerLayoutView()
                2 -> GenerateLayoutFun.generateFrameLayoutView()
                3 -> GenerateLayoutFun.generateFrameLayoutView2()
                else -> GenerateLayoutFun.generateFrameLayoutView()
            }
            file.writeText(str)
        }
        return fileName.split(".")[0]

    }

    fun generateFragmentLayoutFile(): String {
        val filePath = "./src/layout"
        val fileName = "fragment_${generateLayoutId()}.xml"
        if (GenerateFileTools.generateFile(filePath, fileName)) {
            val file = File("$filePath/$fileName")
            layoutList.add(fileName)
            val str = when ((0..4).random()) {
                0 -> GenerateLayoutFun.generateRelativeLayoutView()
                1 -> GenerateLayoutFun.generateLinerLayoutView()
                2 -> GenerateLayoutFun.generateFrameLayoutView()
                3 -> GenerateLayoutFun.generateFrameLayoutView2()
                else -> GenerateLayoutFun.generateFrameLayoutView()
            }
            file.writeText(str)
        }
        return fileName.split(".")[0]

    }

    fun String.addTryCatch(exception: String = "java.lang.Exception"): String {
        val e = generateKey((5..9).random())
        return "try {$this} catch($exception $e) {$e.printStackTrace();}"
    }

    /**
     *         val r = (2..10).random()
     *         val stringBuilder = StringBuilder()
     *         repeat(r){
     *             stringBuilder.append("${(100 .. 5000).random()},")
     *         }
     *         val funName = "$stringFunName(new int[]{${stringBuilder.toString()}});"
     */
    fun newIntArray(start: Int = 2, end: Int = 10): String {
        val r = (start..end).random()
        val stringBuilder = StringBuilder()
        repeat(r) {
            stringBuilder.append("${(100..8000).random()},")
        }
        return "new int[]{${stringBuilder.toString()}}"
    }

    fun newStringArray(start: Int = 2, end: Int = 10): String {
        val r = (start..end).random()
        val stringBuilder = StringBuilder()
        repeat(r) {
            stringBuilder.append("${generateFunName()},")
        }
        return "new String[]{${stringBuilder.toString()}}"
    }

    fun newFloatArray(start: Int = 2, end: Int = 10): String {
        val r = (start..end).random()
        val stringBuilder = StringBuilder()
        repeat(r) {
            stringBuilder.append("${(100..8000).random()}f,")
        }
        return "new int[]{${stringBuilder.toString()}}"
    }

    fun newDoubleArray(start: Int = 2, end: Int = 10): String {
        val r = (start..end).random()
        val stringBuilder = StringBuilder()
        repeat(r) {
            stringBuilder.append("${(100..8000).random()}d,")
        }
        return "new int[]{${stringBuilder.toString()}}"
    }

    private fun getActionSetting(): String {
        return when((0..21).random()){
            0 -> "android.settings.APP_NOTIFICATION_SETTINGS"
            1 -> "android.settings.CONVERSATION_SETTINGS"
            2 -> "android.settings.ALL_APPS_NOTIFICATION_SETTINGS"
            3 -> "android.settings.NOTIFICATION_HISTORY"
            4 -> "android.settings.CONVERSATION_SETTINGS"
            5 -> "android.settings.PAIRING_SETTINGS"
            6 -> "android.settings.VOICE_CONTROL_DO_NOT_DISTURB_MODE"
            7 -> "android.settings.ZEN_MODE_EVENT_RULE_SETTINGS"
            8 -> "android.settings.ZEN_MODE_AUTOMATION_SETTINGS"
            9 -> "android.settings.SHOW_REGULATORY_INFO"
            10 -> "android.settings.CALL_METHOD_TRACK_GENERATION_KEY"
            11 -> "android.settings.BEDTIME_SETTINGS"
            12 -> "android.settings.MMS_MESSAGE_SETTING"
            13 -> "android.settings.extra.ENABLE_MMS_DATA_REQUEST_REASON"
            14 -> "android.settings.SHOW_RESTRICTED_SETTING_DIALOG"
            15 -> "android.settings.ENABLE_MMS_DATA_REQUEST"
            16 -> "android.settings.WIFI_TETHER_SETTINGS"
            17 -> "android.settings.TETHER_SETTINGS"
            18 -> "android.settings.MANAGE_DOMAIN_URLS"
            19 -> "android.settings.REQUEST_ENABLE_CONTENT_CAPTURE"
            20 -> "android.settings.STORAGE_VOLUME_ACCESS_SETTINGS"
            else -> "com.android.settings.Settings"
        }
    }

    private fun getProviderSettings(): String {
        val num = (0..21).random()
        return when(num){
            0 -> "android.provider.Settings.ACTION_SETTINGS"
            1 -> "android.provider.Settings.ACTION_APN_SETTINGS"
            2 -> "android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS"
            3 -> "android.provider.Settings.ACTION_LOCATION_CONTROLLER_EXTRA_PACKAGE_SETTINGS"
            4 -> "android.provider.Settings.ACTION_LOCATION_SCANNING_SETTINGS"
            5 -> "android.provider.Settings.ACTION_USER_SETTINGS"
            6 -> "android.provider.Settings.ACTION_WIRELESS_SETTINGS"
            7 -> "android.provider.Settings.ACTION_TETHER_PROVISIONING_UI"
            8 -> "android.provider.Settings.ACTION_TETHER_UNSUPPORTED_CARRIER_UI"
            9 -> "android.provider.Settings.ACTION_AIRPLANE_MODE_SETTINGS"
            10 -> "android.provider.Settings.ACTION_MOBILE_DATA_USAGE"

            11 -> "android.provider.Settings.ACTION_ONE_HANDED_SETTINGS"
            12 -> "android.provider.Settings.ACTION_VOICE_CONTROL_AIRPLANE_MODE"
            13 -> "android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS"
            14 -> "android.provider.Settings.ACTION_ACCESSIBILITY_DETAILS_SETTINGS"
            15 -> "android.provider.Settings.ACTION_REDUCE_BRIGHT_COLORS_SETTINGS"
            16 -> "android.provider.Settings.ACTION_CONDITION_PROVIDER_SETTINGS"
            17 -> "android.provider.Settings.ACTION_APP_OPEN_BY_DEFAULT_SETTINGS"
            18 -> "android.provider.Settings.ACTION_USAGE_ACCESS_SETTINGS"
            19 -> "android.provider.Settings.ACTION_SECURITY_SETTINGS"
            20 -> "android.provider.Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES"
            else -> "android.provider.Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM"
        }
    }

    private fun generateCategory(): String {
        val cate: String = when((0..20).random()) {
            0 -> "android.content.Intent.CATEGORY_DEFAULT"
            1 -> "android.content.Intent.CATEGORY_VOICE"
            2 -> "android.content.Intent.CATEGORY_ALTERNATIVE"
            3 -> "android.content.Intent.CATEGORY_SELECTED_ALTERNATIVE"
            4 -> "android.content.Intent.CATEGORY_TAB"
            5 -> "android.content.Intent.CATEGORY_LAUNCHER"
            6 -> "android.content.Intent.CATEGORY_LEANBACK_LAUNCHER"
            7 -> "android.content.Intent.CATEGORY_CAR_LAUNCHER"
            8 -> "android.content.Intent.CATEGORY_COMMUNAL_MODE"
            9 -> "android.content.Intent.CATEGORY_LEANBACK_SETTINGS"

            10 -> "android.content.Intent.CATEGORY_INFO"
            11 -> "android.content.Intent.CATEGORY_HOME"
            12 -> "android.content.Intent.CATEGORY_HOME_MAIN"
            13 -> "android.content.Intent.CATEGORY_SECONDARY_HOME"
            14 -> "android.content.Intent.CATEGORY_SETUP_WIZARD"
            15 -> "android.content.Intent.CATEGORY_LAUNCHER_APP"
            16 -> "android.content.Intent.CATEGORY_PREFERENCE"
            17 -> "android.content.Intent.CATEGORY_DEVELOPMENT_PREFERENCE"
            18 -> "android.content.Intent.CATEGORY_EMBED"
            19 -> "android.content.Intent.CATEGORY_APP_MARKET"
            else -> "android.content.Intent.CATEGORY_MONKEY"
        }
        return cate
    }

    private fun generateActivityFlag() :String {
        val flag: String = when((0..16).random()) {
            0 -> "android.content.Intent.FLAG_ACTIVITY_NEW_TASK"
            1 -> "android.content.Intent.FLAG_ACTIVITY_MATCH_EXTERNAL"
            2 -> "android.content.Intent.FLAG_ACTIVITY_NO_HISTORY"
            3 -> "android.content.Intent.FLAG_ACTIVITY_MULTIPLE_TASK"
            4 -> "android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP"
            5 -> "android.content.Intent.FLAG_ACTIVITY_FORWARD_RESULT"
            6 -> "android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION"
            7 -> "android.content.Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP"
            8 -> "android.content.Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT"
            9 -> "android.content.Intent.FLAG_ACTIVITY_NEW_DOCUMENT"
            10 -> "android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK"

            11 -> "android.content.Intent.FLAG_ACTIVITY_TASK_ON_HOME"
            12 -> "android.content.Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS"
            13 -> "android.content.Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT"
            14 -> "android.content.Intent.FLAG_ACTIVITY_REQUIRE_NON_BROWSER"
            15 -> "android.content.Intent.FLAG_ACTIVITY_REQUIRE_DEFAULT"
            else -> "android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT"

        }
        return flag
    }
}
