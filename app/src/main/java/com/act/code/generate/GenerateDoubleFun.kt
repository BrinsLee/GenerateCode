package com.act.code.generate

import com.act.code.tools.generateFunName
import com.act.code.tools.generateLocalVar

object GenerateDoubleFun {


    fun generateDoubleFun(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static double ${stringFunName}(double[] dArr) {")
            add("double d = dArr[0];")
            add("for (int i = 0; i < dArr.length; i++) {")
            add("if (d < dArr[i]) {")
            add("d = dArr[i];")
            add("}")
            add("}")
            add("return d;")
            add("}")
        }
        val funName = "$stringFunName( new double[]{${(1000..2000).random()}.0d, ${(1000..2000).random()}.0d, ${(1000..2000).random()}.0d, ${(1000..2000).random()}.0d});"
        map[funName] = mutableList
        return map
    }

    fun generateDoubleFun2(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static double ${stringFunName}(double[] dArr) {")
            add("double d = 0.0d;")
            add("for (double d2 : dArr) {")
            add("d += d2;")
            add("}")
            add("return d;")
            add("}")

        }
        val funName = "$stringFunName(new double[]{${(1000..2000).random()}.0d, ${(1000..2000).random()}.0d});"
        map[funName] = mutableList
        return map
    }


    fun generateDoubleFun3(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val localVar1 = generateLocalVar(6)
        val localVar2 = generateLocalVar(6)
        val partitionX = generateLocalVar(5)
        val partitionY = generateLocalVar(5)
        val mutableList = mutableListOf<String>().apply {
            add("public static double ${stringFunName} (int[] num1, int[] num2) {")
            add("if( num1.length > num2.length ) {")
            add("return $stringFunName(num1, num2);")
            add("}")
            add("int $localVar1 = num1.length;")
            add("int $localVar2 = num2.length;")
            add("int low = 0, high = $localVar1;")
            add("while (low <= high) {")
            add("int $partitionX = (low + high) / 2;")
            add("int $partitionY = ($localVar1 + $localVar2 + 1) / 2 - $partitionX;")
            add("}")
            add("return new Double(${(20..51212).random()}d);")
            add("}")
        }
        val funName = "$stringFunName(new int[]{${(1000..2000).random()}, ${(1000..2000).random()}}, new int[]{${(1000..2000).random()}, ${(1000..2000).random()}});"
        map[funName] = mutableList
        return map
    }

    fun generateDoubleFun4(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static double ${stringFunName}(int[] nums1, int[] nums2) {")
            add("int length1 = nums1.length, length2 = nums2.length;\n")
            add("int totalLength = length1 + length2;")
            add("if (totalLength % 2 == 1) {")
            add("int midIndex = totalLength / 2;")
            add("double median = ${(52..51212).random()}d;")
            add("return median;")
            add("}")
            add("else {")
            add("int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;\n")
            add("double median = ${(554 ..25645).random()}d;\n")
            add("return median;")
            add("}")
            add("}")

        }
        val funName = "$stringFunName(new int[]{${(1000..2000).random()}, ${(1000..2000).random()}}, new int[]{${(1000..2000).random()}, ${(1000..2000).random()}});"
        map[funName] = mutableList
        return map
    }
}