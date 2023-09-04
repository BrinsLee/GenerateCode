package com.act.code.tools

import com.act.code.generate.*
import java.io.File
import java.lang.Exception

object GenerateFileTools {
    // 创建文件
    fun generateFile(filePath: String, fileName: String): Boolean {
        try {
            val fp = File(filePath)
            fp.mkdirs()
            val file = File("$filePath/$fileName")
            if (!file.exists()) {
                file.createNewFile()
            }
            file.createNewFile()
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    // 随机获取其中的一个方法
    fun generateFunAction(): HashMap<String, MutableList<String>> {
        return when ((0..68).random()) {
            0 -> GenerateBooleanFun.generateBooleanFun()
            1 -> GenerateBooleanFun.generateBooleanFun2()
            2 -> GenerateBooleanFun.generateBooleanFun3()

            3 -> GenerateDoubleFun.generateDoubleFun()
            4 -> GenerateDoubleFun.generateDoubleFun2()

            5 -> GenerateIntFun.generateIntFun()
            6 -> GenerateIntFun.generateIntFun2()
            7 -> GenerateIntFun.generateIntFun3()
            8 -> GenerateIntFun.generateIntFun4()
            9 -> GenerateIntFun.generateIntFun5()
            10 -> GenerateIntFun.generateIntFun6()
            11 -> GenerateIntFun.generateIntFun7()
            12 -> GenerateIntFun.generateIntFun8()
            13 -> GenerateIntFun.generateIntFun9()
            14 -> GenerateIntFun.generateIntFun10()
            15 -> GenerateIntFun.generateIntFun11()
            16 -> GenerateIntFun.generateIntFun12()

            17 -> GenerateStringFun.generateStringFun()
            18 -> GenerateStringFun.generateStringFun2()
            19 -> GenerateStringFun.generateStringFun3()
            20 -> GenerateStringFun.generateStringFun4()
            21 -> GenerateStringFun.generateStringFun5()
            22 -> GenerateStringFun.generateStringFun6()
            23 -> GenerateStringFun.generateStringFun7()
            24 -> GenerateStringFun.generateStringFun8()
            25 -> GenerateStringFun.generateStringFun9()
            26 -> GenerateStringFun.generateStringFun10()

            27 -> GenerateVoidFun.generateVoidFun()
            28 -> GenerateVoidFun.generateVoidFun2()
            29 -> GenerateVoidFun.generateVoidFun3()

            30 -> GenerateIntFun.generateIntFun13()
            31 -> GenerateBooleanFun.generateBooleanFun4()
            32 -> GenerateStringFun.generateStringFun11()
            33 -> GenerateStringFun.generateStringFun12()

            //2023/8/14新增
            34 -> GenerateBooleanFun.generateBooleanFun5()
            35 -> GenerateBooleanFun.generateBooleanFun5()
            36 -> GenerateBooleanFun.generateBooleanFun6()
            37 -> GenerateBooleanFun.generateBooleanFun7()
            38 -> GenerateBooleanFun.generateBooleanFun8()
            39 -> GenerateBooleanFun.generateBooleanFun9()
            40 -> GenerateBooleanFun.generateBooleanFun10()
            41 -> GenerateBooleanFun.generateBooleanFun11()

            42 -> GenerateIntFun.generateIntFun14()
            43 -> GenerateIntFun.generateIntFun15()
            44 -> GenerateIntFun.generateIntFun16()
            45 -> GenerateIntFun.generateIntFun17()
            46 -> GenerateIntFun.generateIntFun18()
            47 -> GenerateIntFun.generateIntFun19()
            48 -> GenerateDoubleFun.generateDoubleFun3()
            49 -> GenerateDoubleFun.generateDoubleFun4()
            50 -> GenerateStringFun.generateStringFun13()
            51 -> GenerateStringFun.generateStringFun14()
            52 -> GenerateStringFun.generateStringFun15()
            53 -> GenerateVoidFun.generateVoidFun5()

            //2023/8/21新增
            54 -> GenerateStringFun.generateStringFun16()
            55 -> GenerateIntFun.generateIntFun20()
            56 -> GenerateIntFun.generateIntFun21()
            57 -> GenerateIntFun.generateIntFun22()
            58 -> GenerateIntFun.generateIntFun23()
            59 -> GenerateIntFun.generateIntFun24()
            60 -> GenerateBooleanFun.generateBooleanFun12()
            61 -> GenerateStringFun.generateStringFun17()
            62 -> GenerateStringFun.generateStringFun18()
            63 -> GenerateVoidFun.generateVoidFun6()
            64 -> GenerateIntFun.generateIntFun25()
            65 -> GenerateVoidFun.generateVoidFun7()
            66 -> GenerateStringFun.generateStringFun19()
            67 -> GenerateStringFun.generateStringFun20()

            else -> GenerateVoidFun.generateVoidFun4()
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {

        println("${generateArgs(3)}")
        repeat(35){
            val map = generate(it)
            println("=======================")
            map.forEach {map2->
                map2.value.forEach { str ->
                    println(str)
                }
            }


        }


    }

    fun generate(status :Int): HashMap<String, MutableList<String>> {
        return when (status) {
            0 -> GenerateBooleanFun.generateBooleanFun()
            1 -> GenerateBooleanFun.generateBooleanFun2()
            2 -> GenerateBooleanFun.generateBooleanFun3()

            3 -> GenerateDoubleFun.generateDoubleFun()
            4 -> GenerateDoubleFun.generateDoubleFun2()

            5 -> GenerateIntFun.generateIntFun()
            6 -> GenerateIntFun.generateIntFun2()
            7 -> GenerateIntFun.generateIntFun3()
            8 -> GenerateIntFun.generateIntFun4()
            9 -> GenerateIntFun.generateIntFun5()
            10 -> GenerateIntFun.generateIntFun6()
            11 -> GenerateIntFun.generateIntFun7()
            12 -> GenerateIntFun.generateIntFun8()
            13 -> GenerateIntFun.generateIntFun9()
            14 -> GenerateIntFun.generateIntFun10()
            15 -> GenerateIntFun.generateIntFun11()
            16 -> GenerateIntFun.generateIntFun12()

            17 -> GenerateStringFun.generateStringFun()
            18 -> GenerateStringFun.generateStringFun2()
            19 -> GenerateStringFun.generateStringFun3()
            20 -> GenerateStringFun.generateStringFun4()
            21 -> GenerateStringFun.generateStringFun5()
            22 -> GenerateStringFun.generateStringFun6()
            23 -> GenerateStringFun.generateStringFun7()
            24 -> GenerateStringFun.generateStringFun8()
            25 -> GenerateStringFun.generateStringFun9()
            26 -> GenerateStringFun.generateStringFun10()

            27 -> GenerateVoidFun.generateVoidFun()
            28 -> GenerateVoidFun.generateVoidFun2()
            29 -> GenerateVoidFun.generateVoidFun3()

            30 -> GenerateIntFun.generateIntFun13()
            31 -> GenerateBooleanFun.generateBooleanFun4()
            32 -> GenerateStringFun.generateStringFun11()
            33 -> GenerateStringFun.generateStringFun12()

            //2023/8/14新增
            34 -> GenerateBooleanFun.generateBooleanFun5()
            35 -> GenerateBooleanFun.generateBooleanFun5()
            36 -> GenerateBooleanFun.generateBooleanFun6()
            37 -> GenerateBooleanFun.generateBooleanFun7()
            38 -> GenerateBooleanFun.generateBooleanFun8()
            39 -> GenerateBooleanFun.generateBooleanFun9()
            40 -> GenerateBooleanFun.generateBooleanFun10()
            41 -> GenerateBooleanFun.generateBooleanFun11()

            42 -> GenerateIntFun.generateIntFun14()
            43 -> GenerateIntFun.generateIntFun15()
            44 -> GenerateIntFun.generateIntFun16()
            45 -> GenerateIntFun.generateIntFun17()
            46 -> GenerateIntFun.generateIntFun18()
            47 -> GenerateIntFun.generateIntFun19()
            48 -> GenerateDoubleFun.generateDoubleFun3()
            49 -> GenerateDoubleFun.generateDoubleFun4()
            50 -> GenerateStringFun.generateStringFun13()
            51 -> GenerateStringFun.generateStringFun14()
            52 -> GenerateStringFun.generateStringFun15()


            else -> GenerateVoidFun.generateVoidFun4()
        }
    }

}