package com.act.code.generate

import com.act.code.FileUtils
import com.act.code.tools.generateArgs
import com.act.code.tools.generateClassKey
import com.act.code.tools.generateFunName
import com.act.code.tools.redRandomChar
import kotlin.collections.HashMap

object GenerateStringFun {


    fun generateStringFun(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private static String ${stringFunName}(String str) {")
            add("if (str == null || str.length() == 0) {")
            add("return \"\";")
            add("}")
            add("char[] charArray = str.toCharArray();")
            add("int length = charArray.length;")
            add("for (int i = 0; i < length; i++) {")
            add(" if (charArray[i] == ' ') {")
            add("charArray[i] = ${(10000..20000).random()};")
            add("} else if ('!' > charArray[i] || charArray[i] > '~') {")
            add("charArray[i] = charArray[i];")
            add("} else {")
            add("charArray[i] = (char) (charArray[i] + ${(10000..20000).random()});")
            add("}")
            add("}")
            add("return new String(charArray);")
            add("}")
        }
        val funName = stringFunName + "(\"${generateClassKey()}\");"
        map[funName] = mutableList
        return map
    }

    fun generateStringFun2(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static String ${stringFunName}(String str) {")
            add("if (str == null) {")
            add("return \"\";")
            add("}")
            add("int length = str.length();")
            add("if (length <= 1) {")
            add("return str;")
            add("}")
            add("int i = length >> 1;")
            add("char[] charArray = str.toCharArray();")
            add("for (int i2 = 0; i2 < i; i2++) {")
            add("char c = charArray[i2];")
            add("int i3 = (length - i2) - 1;")
            add("charArray[i2] = charArray[i3];")
            add("charArray[i3] = c;")
            add("}")
            add("return new String(charArray);")
            add("}")
        }
        val funName = stringFunName + "(\"${generateClassKey()}\");"
        map[funName] = mutableList
        return map
    }


    fun generateStringFun3(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private static String ${stringFunName}(String str, String str2, String str3) {")
            add("if (str == null) {")
            add(" return null;")
            add("}")
            add("String lowerCase = str.toLowerCase();")
            add("String lowerCase2 = str2.toLowerCase();")
            add("int indexOf = lowerCase.indexOf(lowerCase2, 0);")
            add("if (indexOf < 0) {")
            add("return str;")
            add("}")
            add("char[] charArray = str.toCharArray();")
            add("char[] charArray2 = str3.toCharArray();")
            add("int length = str2.length();")
            add("StringBuffer stringBuffer = new StringBuffer(charArray.length);")
            add("stringBuffer.append(charArray, 0, indexOf);")
            add("stringBuffer.append(charArray2);")
            add("int i = indexOf + length;")
            add("while (true) {")
            add("int indexOf2 = lowerCase.indexOf(lowerCase2, i);")
            add("if (indexOf2 > 0) {")
            add("stringBuffer.append(charArray, i, indexOf2 - i);")
            add("stringBuffer.append(charArray2);")
            add("i = indexOf2 + length;")
            add("} else {")
            add("stringBuffer.append(charArray, i, charArray.length - i);")
            add("return stringBuffer.toString();")
            add("}")
            add("}")
            add("}")
        }
        val funName = stringFunName + "(\"${generateClassKey()}\",\"${generateClassKey()}\",\"${generateClassKey()}\");"
        map[funName] = mutableList
        return map
    }


    fun generateStringFun4(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private String ${stringFunName}(int i) {")
            add("Calendar instance = Calendar.getInstance();")
            add("instance.setTime(new Date());")
            add("instance.add(${(3..5).random()}, i);")
            add("int i2 = instance.get(7);")
            add("return i2 == 1 ? \"${generateClassKey()}\" : i2 == 2 ? \"${generateClassKey()}\" : i2 == 3 ? \"${generateClassKey()}\" : \"${generateClassKey()}\"  ;")
            add("}")

        }
        FileUtils.listPackage.add("import java.util.Date;")
        FileUtils.listPackage.add("import java.util.Calendar;")
        val funName = stringFunName + "(${(1000..2000).random()});"
        map[funName] = mutableList
        return map
    }


    fun generateStringFun5(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private String ${stringFunName}(String str) {")
            add("String str2 = str.split(\"-\")[0];")
            add("String str3 = str.split(\"-\")[1];")
            add("String str4 = str.split(\"-\")[2];")
            add("Calendar instance = Calendar.getInstance();")
            add("instance.set(1, Integer.parseInt(str2));")
            add("instance.set(2, Integer.parseInt(str3) - 1);")
            add("instance.set(${(3..5).random()}, Integer.parseInt(str4));")
            add("switch (instance.get(7)) {")
            repeat(5) {
                add("case ${it}:")
                add("return \"${generateClassKey(20)}\";")
            }
            add("default:")
            add("return \"\";")
            add("}")
            add("}")
        }
        FileUtils.listPackage.add("import java.util.Date;")
        FileUtils.listPackage.add("import java.util.Calendar;")
        val funName = stringFunName + "(\"${generateArgs(3)}\");"
        map[funName] = mutableList
        return map
    }


    fun generateStringFun6(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public String ${stringFunName}() {")
            add("SimpleDateFormat simpleDateFormat = new SimpleDateFormat(\"yyyy-MM-dd\");")
            add("Calendar instance = Calendar.getInstance();")
            repeat((2..5).random()) {
                add("instance.add(${(1..5).random()}, ${(0..3).random()});")
            }
            add("return simpleDateFormat.format(instance.getTime());")
            add("}")
        }
        FileUtils.listPackage.add("import java.text.SimpleDateFormat;")
        FileUtils.listPackage.add("import java.util.Date;")
        FileUtils.listPackage.add("import java.util.Calendar;")
        val funName = "$stringFunName();"
        map[funName] = mutableList
        return map
    }


    fun generateStringFun7(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static String ${stringFunName}(long j, String str) {")
            add("if (!\"yyyy/MM/dd:hh:mm:ss\".equals(str)) {\n" + "            str = \"yyyy/MM/dd:hh:mm:ss\";\n" + "        }")
            add("return new SimpleDateFormat(str).format(Long.valueOf(j));")
            add("}")
        }
        FileUtils.listPackage.add("import java.text.SimpleDateFormat;")
        val funName = "$stringFunName(${System.currentTimeMillis()}L,\"${generateClassKey()}\");"
        map[funName] = mutableList
        return map
    }

    fun generateStringFun8(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public String  ${stringFunName}() {")
            add("SimpleDateFormat simpleDateFormat = new SimpleDateFormat(\"yyyy-MM-dd\");")
            add("Calendar instance = Calendar.getInstance();")
            repeat((1..4).random()) {
                add("instance.add(${(1..3).random()}, ${(0..2).random()});")
            }
            add("return simpleDateFormat.format(instance.getTime());")
            add("}")
        }
        FileUtils.listPackage.add("import java.text.SimpleDateFormat;")
        FileUtils.listPackage.add("import java.util.Date;")
        FileUtils.listPackage.add("import java.util.Calendar;")
        val funName = "$stringFunName();"
        map[funName] = mutableList
        return map
    }


    fun generateStringFun9(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public String ${stringFunName}(double d) {")
            add("return new DecimalFormat(\"##0.0\").format(d / 10000.0d);")
            add("}")
        }
        FileUtils.listPackage.add("import java.text.DecimalFormat;")
        val funName = "$stringFunName(${(200000..400000).random() * 1.0 / 10});"
        map[funName] = mutableList
        return map
    }

    fun generateStringFun10(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public String ${stringFunName}(String str) {")
            add("return Pattern.compile(\"[^a-zA-Z0-9]\").matcher(str).replaceAll(\"\").trim();")
            add("}")
        }
        FileUtils.listPackage.add("import java.util.regex.Pattern;")
        val funName = "$stringFunName(\"${System.currentTimeMillis()}\");"
        map[funName] = mutableList
        return map
    }


    fun generateStringFun11(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static String[] ${stringFunName}(String str, String str2) {")
            add("if (str == null) { return null; }")
            add("try {")
            add("StringTokenizer stringTokenizer = new StringTokenizer(str, str2);")
            add("String[] strArr = new String[stringTokenizer.countTokens()];")
            add("int i = 0;")
            add("while (stringTokenizer.hasMoreTokens()) {")
            add("String nextToken = stringTokenizer.nextToken();")
            add("if (!(nextToken == null || nextToken.trim().length() == 0)) {")
            add("i++;")
            add("strArr[i] = nextToken;")
            add("}}")
            add("return strArr;")
            add("} catch (Exception unused) {")
            add("return null;")
            add("}")
            add("}")
        }
        FileUtils.listPackage.add("import java.util.StringTokenizer;")
        val funName = "$stringFunName(\"${generateFunName()}\",\"${generateFunName()}\");"
        map[funName] = mutableList
        return map
    }

    fun generateStringFun12(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static String ${stringFunName}(String str, char c, char c2) { return str.length() > 0 ? str.replace(c, c2) : str;}")
        }
        val funName = "$stringFunName(\"${generateFunName()}\",\'${redRandomChar()}\','${redRandomChar()}');"
        map[funName] = mutableList
        return map
    }

    //新增
    fun generateStringFun13(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static String ${stringFunName}(String s) {")
            add("int len = s.length();")
            add("if (len < 2) {\n" + "            return s;\n" + "        }")
            add("int maxLen = 1;\n" + "        int begin = 0;")
            add("        boolean[][] dp = new boolean[len][len];\n")
            add("for (int i = 0; i < len; i++) {\n" + "            dp[i][i] = true;\n" + "        }")
            add("        char[] charArray = s.toCharArray();\n")
            add("for (int L = 2; L <= len; L++) {")
            add("for (int i = 0; i < len; i++) {")
            add("int j = L + i - 1;")
            add("if (j >= len) {\n" + "                    break;\n" + "                }")
            add("if (charArray[i] != charArray[j]) {\n" + "                dp[i][j] = false;\n" + "            }")
            add("else {\n" + "            if (j - i < 3) {\n" + "                dp[i][j] = true;\n" + "            } else {\n" + "                dp[i][j] = dp[i + 1][j - 1];\n" + "            }")
            add("                if (dp[i][j] && j - i + 1 > maxLen) {\n")
            add("maxLen = j - i + 1;")
            add("begin = i;\n")
            add("}}}")
            add("}")
            add("return s.substring(begin, begin + maxLen);")
            add("}")
        }
        val funName = "$stringFunName(\"${generateFunName()}\");"
        map[funName] = mutableList
        return map
    }

    fun generateStringFun14(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static String ${stringFunName}(String str) {")
            add("        int start = 0, end = -1;\n")
            add("        StringBuffer t = new StringBuffer(\"#\");\n")
            add("for (int i = 0; i < str.length(); ++i) {")
            add("t.append(str.charAt(i));\n" + "            t.append('#');")
            add("}")
            add("        t.append('#');\n")
            add("        str = t.toString();\n")
            add("        List<Integer> arm_len = new ArrayList<Integer>();\n")
            add("        int right = -1, j = -1;\n")
            add("for (int i = 0; i < str.length(); ++i) {")
            add("int cur_arm_len = 0;")
            add("if (right >= i) {")
            add("                int i_sym = j * 2 - i;\n")
            add("                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);\n")
            add("                cur_arm_len = Math.max(str.length(), i - min_arm_len);\n")
            add("} else {")
            add("}")
            add("arm_len.add(cur_arm_len);")
            add("if (i + cur_arm_len > right) {\n" + "                j = i;\n" + "                right = i + cur_arm_len;\n" + "            }")
            add("if (cur_arm_len * 2 + 1 > end - start) {\n" + "                start = i - cur_arm_len;\n" + "                end = i + cur_arm_len;\n" + "            }")
            add("}")
            add("        StringBuffer ans = new StringBuffer();\n")
            add("for (int i = start; i <= end; ++i) {\n" + "            if (str.charAt(i) != '#') {\n" + "                ans.append(str.charAt(i));\n" + "            }\n" + "        }\n" + "            return ans.toString();\n" + "        }")
        }
        FileUtils.listPackage.add("import java.util.List;")
        FileUtils.listPackage.add("import java.util.ArrayList;")
        val funName = "$stringFunName(\"${generateFunName()}\");"
        map[funName] = mutableList
        return map
    }

    fun generateStringFun15(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static String ${stringFunName}(String s, int numRows) {")
            add("int n = s.length(), r = numRows;\n")
            add("if (r == 1 || r >= n) {\n" + "            return s;\n" + "        }")
            add("int t = r * 2 - 2;")
            add("int c = (n + t - 1) / t * (r - 1);")
            add("char[][] mat = new char[r][c];")
            add("for (int i = 0, x = 0, y = 0; i < n; ++i) {")
            add("mat[x][y] = s.charAt(i);")
            add("if (i % t < r - 1) {\n" + "                ++x; \n" + "            } else {\n" + "                --x;\n" + "                ++y; \n" + "            }")
            add("}")
            add("        StringBuffer ans = new StringBuffer();\n")
            add("for (char[] row : mat) {\n" + "            for (char ch : row) {\n" + "            if (ch != 0) {\n" + "                ans.append(ch);\n" + "            }\n" + "        }\n" + "        }")
            add("        return ans.toString();\n")
            add("}")

        }
        val funName = "$stringFunName(\"${generateFunName()}\",${(1000..5000).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateStringFun16(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val s = generateFunName()
        val str = StringBuilder()
        repeat((2..10).random()){
            str.append("${(100 .. 1000).random()},")
        }
        val mutableList = mutableListOf<String>().apply {
            add("public static String ${stringFunName}(int num) {")
            add("int [] values = new int[]{$str};")
            add("StringBuffer $s = new StringBuffer();")
            add("for (int i = 0; i < values.length; ++i) {")
            add("int value = values[i];")
            add("String sym = \"${generateFunName()}\";")
            add("while(num > value) {")
            add("num -= value;")
            add("$s.append(sym);")
            add("}")
            add("if(num == 0) {")
            add("break;")
            add("}")
            add("}")
            add("return $s.toString();")
            add("}")
        }
        val funName = "$stringFunName(${(0..500).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateStringFun17(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()

        val mutableList = mutableListOf<String>().apply {
            add("public static String ${stringFunName}(int[] nums) {")
            add("int position = nums.length - 1;")
            add("int steps = 0;")
            add("while(position > 0) {")
            add("for (int i = 0; i < position; i++) {")
            add("if(i + nums[i] >= position) {")
            add("position = i;")
            add("steps++;")
            add("break;")
            add("}")
            add("}")
            add("}")
            add("return steps+\"\";")
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

    fun generateStringFun18(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()

        val mutableList = mutableListOf<String>().apply {
            add("public static String ${stringFunName}(int[] nums) {")
            add("int length = nums.length;")
            add("int end = 0;")
            add("int maxPosition = 0;")
            add("int steps = 0;")
            add("for (int i = 0; i < length - 1; i++) {")
            add("maxPosition = Math.max(maxPosition, i+ nums[i]);")
            add("if(i == end){")
            add("end = maxPosition;")
            add("steps++;")
            add("}")
            add("}")
            add("return steps+\"\";")
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