package com.act.code.generate

import com.act.code.tools.generateClassKey
import com.act.code.tools.generateFunName

object GenerateBooleanFun {

    fun generateBooleanFun(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private static boolean ${stringFunName}(String str) {")
            add("if (str == null) {")
            add("return true;")
            add("}")
            add("int length = str.length();")
            add("for (int i = 0; i < length; i++) {")
            add(" if (!Character.isWhitespace(str.charAt(i))) {")
            add("return false;")
            add("}")
            add("}")
            add("return true;")
            add("}")
        }
        val funName = "$stringFunName(\"${generateClassKey()}\");"
        map[funName] = mutableList
        return map
    }

    fun generateBooleanFun2(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private static boolean ${stringFunName}(String str) {")
            add("return str == null || str.trim().length() == 0;")
            add("}")
        }
        val funName = "$stringFunName(\"${generateClassKey()}\");"
        map[funName] = mutableList
        return map
    }


    fun generateBooleanFun3(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static boolean ${stringFunName}(CharSequence charSequence, CharSequence charSequence2) {")
            add("int length;")
            add("if (charSequence == charSequence2) {")
            add("return true;")
            add("}")
            add("if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {")
            add("return false;")
            add("}")
            add("if ((charSequence instanceof String) && (charSequence2 instanceof String)) {")
            add("return charSequence.equals(charSequence2);")
            add("}")
            add("for (int i = 0; i < length; i++) {")
            add("if (charSequence.charAt(i) != charSequence2.charAt(i)) {")
            add("return false;")
            add("}")
            add("}")
            add("return true;")
            add("}")
        }
        val funName = "$stringFunName(\"${generateClassKey()}\",\"${generateClassKey()}\");"
        map[funName] = mutableList
        return map
    }

//    public static boolean evhGEyUIgdl(CharSequence charSequence, CharSequence charSequence2) {  return charSequence == null && charSequence2 == null; }

    fun generateBooleanFun4(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static boolean ${stringFunName}(CharSequence charSequence, CharSequence charSequence2) {  return charSequence == null && charSequence2 == null; }")
        }
        val funName = "$stringFunName(\"${generateClassKey()}\",\"${generateClassKey()}\");"
        map[funName] = mutableList
        return map
    }

    fun generateBooleanFun5(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static boolean $stringFunName(String s, int numRows) {")
            add("if (numRows <= 1 || s.length() <= numRows) {\n" + "return s.isEmpty();\n" + "}")
            add("char[][] zigzag = new char[numRows][s.length()];")
            add("int row = 0, col = 0;\n" + "        boolean goingDown = false;")
            add("for (char c : s.toCharArray()) {")
            add("zigzag[row][col] = c;")
            add("if (row == 0 || row == numRows - 1) {\n" + "                goingDown = !goingDown;\n" + "            }")
            add("row += goingDown ? 1 : -1;\n" + "            col++;")
            add("}")
            add("StringBuilder result = new StringBuilder();\n")
            add("for (char[] chars : zigzag) {")
            add("for (char c : chars) {")
            add("if (c != '\\0') {\n" + "result.append(c);\n}")
            add("}}")
            add("return result.substring(0).isEmpty();")
            add("}")
        }
        val funName = "$stringFunName(\"${generateClassKey()}\",${(1000..2000).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateBooleanFun6(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static boolean ${stringFunName}(int[] nums, int target) {")
            add("for (int i = 0; i < nums.length; i++) {")
            add("java.util.Map map = new java.util.HashMap();")
            add("int temp = target - nums[i];")
            add("if(map.containsKey(temp)){")
            add("return false;")
            add("}")
            add("map.put(nums[i], i);")
            add("}")
            add("return true;}")
        }
        val funName = "$stringFunName(new int[]{${(1000..2000).random()}, ${(1000..2000).random()},${(1000..2000).random()}},${(1000..2000).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateBooleanFun7(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static boolean ${stringFunName}(int l1, int l2) {")
            add("java.util.Queue<Integer> queue = new java.util.LinkedList<>();")
            add("java.util.List<Integer> list = new java.util.ArrayList<>();")
            add("while (l1 != 0 || l2 != 0) {")
            add("if(l1 != 0){")
            add("queue.offer(new Integer(l1));")
            add("l1 = 0;")
            add("}else {")
            add("queue.offer(new Integer(0));")
            add("}")
            add("if(l2 != 0){")
            add("queue.offer(new Integer(l2));")
            add("l2 = 0;")
            add("}else {")
            add("queue.offer(new Integer(0));")
            add("}")
            add("}")
            add("int temp = 0;")
            add("if(!queue.isEmpty()){")
            add("int a = queue.poll() + queue.poll() + temp;")
            add("return a >= ${(0 .. 100).random()};")
            add("}")
            add("else {")
            add("return false;")
            add("}")
            add("}")
        }
        val funName = "$stringFunName(${(0 .. 100).random()},${(0 .. 100).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateBooleanFun8(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static boolean ${stringFunName}(int[] nums, int target) {")
            add("for (int i =0; i < nums.length; i++) {")
            add("java.util.Map map = new java.util.HashMap();")
            add("int temp = target - nums[i];")
            add("if(map.containsKey(temp)){")
            add("return false;")
            add("}")
            add("map.put(nums[i], i);")
            add("}")
            add("return true;}")
        }
        val funName = "$stringFunName( new int[]{${(1000..2000).random()}, ${(1000..2000).random()}, ${(1000..2000).random()}, ${(1000..2000).random()}}, ${(1000..2000).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateBooleanFun9(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static boolean ${stringFunName}(int x) {")
            add("if (x < 0 || (x % 10 == 0 && x != 0)) {\n" + "            return false;\n" + "        }")
            add("        int revertedNumber = 0;\n")
            add("while (x > revertedNumber) {\n" + "                revertedNumber = revertedNumber * 10 + x % 10;\n" + "                x /= 10;\n" + "            }")
            add("        return x == revertedNumber || x == revertedNumber / 10;\n")
            add("}")
        }
        val funName = "$stringFunName(${(0..5000).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateBooleanFun10(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static boolean ${stringFunName}(String s, String p, int i, int j) {")
            add("if (i == 0) {\n" + "    return false;\n" + "}\n" + "if (p.charAt(j - 1) == '.') {\n" + "    return true;\n" + "}")
            add("        return s.charAt(i - 1) == p.charAt(j - 1);}\n")
        }
        val funName = "$stringFunName(\"${generateFunName()}\",\"${generateFunName()}\",${(0..5000).random()}, ${(0..5000).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateBooleanFun11(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static boolean ${stringFunName}(String s, String p) {")
            add("int m = s.length();\n" + "        int n = p.length();")
            add("        boolean[][] f = new boolean[m + 1][n + 1];\n")
            add("        f[0][0] = true;\n")
            add("for (int i = 0; i <= m; ++i) {")
            add("for (int j = 1; j <= n; ++j) {")
            add("if (p.charAt(j - 1) == '*') {")
            add("f[i][j] = f[i][j - 2];")
            add("}}}")
            add("return false;")
            add("}")
        }
        val funName = "$stringFunName(\"${generateFunName()}\",\"${generateFunName()}\");"
        map[funName] = mutableList
        return map
    }

    fun generateBooleanFun12(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static boolean ${stringFunName}(int[] nums) {")
            add("int n = nums.length;")
            add("int rightmost = 0;")
            add("for(int i = 0; i < n; i++){")
            add("if(i <= rightmost) {")
            add("rightmost = Math.max(rightmost, i + nums[i]);")
            add("if (rightmost >= n - 1) {")
            add("return true;")
            add("}")
            add("}")
            add("}")
            add("return false;")
            add("}")
        }

        val r = (2..10).random()
        val stringBuilder = StringBuilder()
        repeat(r){
            stringBuilder.append("${(100 .. 5000).random()},")
        }
        val funName = "$stringFunName(new int[]{${stringBuilder.toString()}});"
        map[funName] = mutableList
        return map
    }
}