package com.act.code.generate

import com.act.code.FileUtils
import com.act.code.FileUtils.newIntArray
import com.act.code.tools.generateFunName
import com.act.code.tools.generateKey

object GenerateVoidFun {

    fun generateVoidFun(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private static void ${stringFunName}(int[] iArr) {")
            add("int i = 0;")
            add("while (i < iArr.length - 1) {")
            add("int i2 = i + 1;")
            add("for (int i3 = i2; i3 < iArr.length; i3++) {")
            add("if (iArr[i] > iArr[i3]) {")
            add("int i4 = iArr[i3];")
            add("iArr[i3] = iArr[i];")
            add("iArr[i] = i4;")
            add("}")
            add("}")
            add("i = i2;")
            add("}")
            add("}")
        }
        val funName = "$stringFunName( new int[]{${(1000..2000).random()}, ${(1000..2000).random()}, ${(1000..2000).random()}, ${(1000..2000).random()}});"
        map[funName] = mutableList
        return map
    }

    fun generateVoidFun2(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private void ${stringFunName}(int[] iArr) {")
            add("for (int i = 0; i < iArr.length - 1; i++) {")
            add("int i2 = 0;")
            add("while (i2 < (iArr.length - 1) - i) {")
            add("int i3 = i2 + 1;")
            add("if (iArr[i2] > iArr[i3]) {")
            add("int i4 = iArr[i3];")
            add("iArr[i3] = iArr[i2];")
            add("iArr[i2] = i4;")
            add("}")
            add("i2 = i3;")
            add("}")
            add("}")
            add("}")
        }
        val funName = "$stringFunName( new int[]{${(1000..2000).random()}, ${(1000..2000).random()}, ${(1000..2000).random()}, ${(1000..2000).random()}});"
        map[funName] = mutableList
        return map
    }

    fun generateVoidFun3(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private static void ${stringFunName}(int[] iArr, int i, int i2) {")
            add("int i3 = i * 2;")
            add("while (i3 <= i2) {")
            add("if (i3 < i2) {")
            add("int i4 = i3 + 1;")
            add("if (iArr[i3] < iArr[i4]) {")
            add("i3 = i4;")
            add("}")
            add("}")
            add("if (iArr[0] >= iArr[i3]) {")
            add(" break;")
            add("}")
            add(" iArr[i] = iArr[i3];")
            add("i3 *= 2;")
            add("i = i3;")
            add("}")
            add("iArr[0] = iArr[0];")
            add("}")
        }
        val funName = "$stringFunName( new int[]{${(1000..2000).random()}, ${(1000..2000).random()}, ${(1000..2000).random()}, ${(1000..2000).random()}}, ${(1000..2000).random()}, ${(1000..2000).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateVoidFun4(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static void ${stringFunName}() {")
            add("long currentTimeMillis = System.currentTimeMillis();")
            add("if (System.currentTimeMillis() < currentTimeMillis) {")
            add("System.out.println(\"Time travelling, ${generateFunName()} woo hoo!\");")
            add("} else if (System.currentTimeMillis() == currentTimeMillis) {")
            add("System.out.println(\"Time ${generateFunName()} stood still!\");")
            add("} else {")
            add("System.out.println(\"Ok, ${generateFunName()} time still moving forward\");")
            add("}")
            add("}")
        }
        val funName = "$stringFunName();"
        map[funName] = mutableList
        return map
    }

    fun generateVoidFun5(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static void ${stringFunName}(int[] height) {")
            add("int l = 0, r = height.length - 1;")
            add("int answ = 0;")
            add("while(l < r) {")
            add("int area = Math.min(height[l], height[r]) * (r - l);")
            add("answ = Math.max(answ, area);")
            add("if (height[l] <= height[r]) {")
            add("++l;")
            add("}")
            add("else {")
            add("--r;")
            add("}")
            add("}")
            add("}")
        }
        val funName = "$stringFunName(new int[]{${(0..500).random()}, ${(0..500).random()}, ${(0..500).random()}});"
        map[funName] = mutableList
        return map
    }

    fun generateVoidFun6(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static void ${stringFunName}(String s) {")
            add("int n = s.length();")
            add("if (n % 2 == 1) {")
            add("return;")
            add("}")
            add("Map<Character, Character> pairs = new HashMap<Character, Character>(){{")
            add("put(')','(');")
            add("put(']','[');")
            add("put('}','{');")
            add("}};")
            add("        Deque<Character> stack = new LinkedList<Character>();\n")
            add("for (int i = 0; i < n; i++) {")
            add("char ch = s.charAt(i);")
            add("if (pairs.containsKey(ch)) {")
            add("if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {\n" + "                return;\n" + "            }")
            add("                stack.pop();\n")

            add("}")
            add("else {\n" + "                stack.push(ch);\n" + "            }")
            add("}")
            add("}")
        }
        FileUtils.listPackage.add("import java.util.Map;")
        FileUtils.listPackage.add("import java.util.HashMap;")
        FileUtils.listPackage.add("import java.util.Deque;")
        FileUtils.listPackage.add("import java.util.LinkedList;")
        val funName = "$stringFunName(\"${generateKey()}\");"
        map[funName] = mutableList
        return map
    }

    fun generateVoidFun7(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static void ${stringFunName}(int[] citations) {")
            add("java.util.Arrays.sort(citations);")
            add("int h = 0, i = citations.length - 1;")
            add("while(i >= 0 && citations[i] > h){")
            add("h++;")
            add("i--;")
            add("}")
            add("}")
        }
        val funName = "$stringFunName(${newIntArray()});"
        map[funName] = mutableList
        return map
    }
}
