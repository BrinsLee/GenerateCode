package com.act.code.generate

import com.act.code.FileUtils
import com.act.code.tools.generateArgs
import com.act.code.tools.generateFunName

object GenerateIntFun {

    fun generateIntFun(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private int ${stringFunName}(long j, long j2) {")
            add("Calendar instance = Calendar.getInstance();")
            add("Calendar instance2 = Calendar.getInstance();")
            add("instance.setTime(new Date(j));")
            add(" instance2.setTime(new Date(j2));")
            add("int i = instance.get(1);")
            add("int i2 = instance2.get(1);")
            add("if (i == i2) {")
            add("return Math.abs(instance.get(2) - instance2.get(2));")
            add("}")
            add("return (Math.abs((i2 - i) - 1) * 12) + (12 - (instance.get(2) + 1)) + instance2.get(2) + 1;")
            add("}")
        }
        FileUtils.listPackage.add("import java.util.Calendar;")
        FileUtils.listPackage.add("import java.util.Date;")

        val funName = "$stringFunName( ${(1000..2000).random()}L, ${(1000..2000).random()}L);"
        map[funName] = mutableList
        return map
    }

    fun generateIntFun2(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private int ${stringFunName}(long j, long j2) {")
            add("Calendar instance = Calendar.getInstance();")
            add("Calendar instance2 = Calendar.getInstance();")
            add("instance.setTime(new Date(j));")
            add(" instance2.setTime(new Date(j2));")
            add("int i = instance.get(1);")
            add("int i2 = instance2.get(1);")
            add("if (i == i2) {")
            add("return Math.abs(instance.get(2) - instance2.get(2));")
            add("}")
            add("return (Math.abs((i2 - i) - 1) * 12) + (12 - (instance.get(2) + 1)) + instance2.get(2) + 1;")
            add("}")
        }
        FileUtils.listPackage.add("import java.util.Calendar;")
        FileUtils.listPackage.add("import java.util.Date;")
        val funName = "$stringFunName( ${(1000..2000).random()}L, ${(1000..2000).random()}L);"
        map[funName] = mutableList
        return map
    }

    fun generateIntFun3(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private int ${stringFunName}(long j) {")
            add("Calendar instance = Calendar.getInstance();")
            add("instance.setTime(new Date(System.currentTimeMillis()));")
            add("instance.set(11, instance.getMinimum(11));")
            add("instance.set(12, instance.getMinimum(12));")
            add("instance.set(12, instance.getMinimum(13));")
            add("instance.set(12, instance.getMinimum(14));")
            add("Calendar instance2 = Calendar.getInstance();")
            add("instance2.setTime(new Date(j));")
            add("instance2.set(11, instance2.getMinimum(11));")
            add("instance2.set(12, instance2.getMinimum(12));")
            add("instance2.set(13, instance2.getMinimum(13));")
            add("instance2.set(14, instance2.getMinimum(14));")
            add("return (int) ((instance2.getTime().getTime() - instance.getTime().getTime()) / 86400000);")
            add("}")
        }
        FileUtils.listPackage.add("import java.util.Calendar;")
        FileUtils.listPackage.add("import java.util.Date;")
        val funName = "$stringFunName(${(2000..40900).random()}L);"
        map[funName] = mutableList
        return map
    }

    fun generateIntFun4(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(int[] iArr, int i) {")
            add("int length = iArr.length - 1;")
            add("int i2 = 0;")
            add("while (iArr[i2] < iArr[length]) {")
            add("int i3 = (i2 + length) / 2;")
            add("if (i > iArr[i3]) {")
            add("i2 = i3 + 1;")
            add("} else if (i >= iArr[i3]) {")
            add("return i3;")
            add("} else {")
            add("length = i3 - 1;")
            add("}")
            add("if (i2 < iArr.length) {")
            add(" if (length < 0) {")
            add("}")
            add("}")
            add("return -1;")
            add("}")
            add("return -1;")
            add("}")
        }

        val buffer = StringBuffer().apply {
            append("$stringFunName(")
            append("new int[]{")
            repeat((10..40).random()) {
                append("${(1000..5000).random()},")
            }
            append("}")
            append(",${(1000..5000).random()}")
            append(");")
        }


        val funName = buffer.toString()
        map[funName] = mutableList
        return map
    }

    fun generateIntFun5(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private int ${stringFunName}(String str, String str2) {")
            add("int i = 0;")
            add("int i2 = 0;")
            add("while (true) {")
            add("int indexOf = str.indexOf(str2, i);")
            add("if (indexOf < 0) {")
            add("return i2;")
            add("}")
            add("i2++;")
            add("i = indexOf + str2.length();")
            add("}")
            add("}")
        }
        val funName = "$stringFunName(\"${generateFunName()}\",\"${generateFunName()}\");"
        map[funName] = mutableList
        return map
    }

    fun generateIntFun6(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public int ${stringFunName}(double[] dArr) {")
            add("int i = 0;")
            add("for (int i2 = 0; i2 < dArr.length; i2++) {")
            add("if (dArr[i] > dArr[i2]) {")
            add("i = i2;")
            add("}")
            add("}")
            add("return i;")
            add("")
            add("}")
        }
        val buffer = StringBuffer().apply {
            append("$stringFunName(")
            append("new double[]{")
            repeat((10..40).random()) {
                append("${(1000..5000).random()}.0d,")
            }
            append("}")
            append(");")
        }
        val funName = buffer.toString()
        map[funName] = mutableList
        return map
    }

    fun generateIntFun7(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int[] ${stringFunName}(int[] iArr) {")
            add("int length = iArr.length;")
            add("while (true) {")
            add("length /= 2;")
            add("if (length < 1) {")
            add("return iArr;")
            add("}")
            add("for (int i = length; i < iArr.length; i++) {")
            add("int i2 = iArr[i];")
            add("int i3 = i - length;")
            add("while (i3 >= 0 && i2 < iArr[i3]) {")
            add("iArr[i3 + length] = iArr[i3];")
            add("i3 -= length;")
            add("}")
            add("iArr[i3 + length] = i2;")
            add("}")
            add("}")
            add("}")
        }
        val buffer = StringBuffer().apply {
            append("$stringFunName(")
            append("new int[]{")
            repeat((10..40).random()) {
                append("${(1000..5000).random()},")
            }
            append("}")
            append(");")
        }
        val funName = buffer.toString()
        map[funName] = mutableList
        return map
    }

    fun generateIntFun8(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int[] ${stringFunName}() {")
            val buffer = StringBuffer()
            buffer.append("int[] iArr = {")
            repeat((16..30).random()) {
                buffer.append("${(1000..5000).random()},")
            }
            buffer.append("};")
            add(buffer.toString())
            add("int i = 0;")
            add("while (i < 12) {")
            add("int i2 = iArr[i];")
            add("int i3 = i + 1;")
            add("int i4 = i;")
            add("for (int i5 = i3; i5 < 13; i5++) {")
            add("if (iArr[i5] < i2) {")
            add("i2 = iArr[i5];")
            add("i4 = i5;")
            add("}")
            add("}")
            add("if (i4 != i) {")
            add("iArr[i4] = iArr[i];")
            add("iArr[i] = i2;")
            add("}")
            add("i = i3;")
            add("}")
            add("return iArr;")
            add("")
            add("}")
        }
        val buffer = StringBuffer().apply {
            append("$stringFunName();")
        }
        val funName = buffer.toString()
        map[funName] = mutableList
        return map
    }

    fun generateIntFun9(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int[] ${stringFunName}(int[] iArr, int i) {")
            add("int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);")
            add("copyOf[copyOf.length - 1] = i;")
            add("return copyOf;")
            add("}")
        }
        FileUtils.listPackage.add("import java.util.Arrays;")
        val buffer = StringBuffer().apply {
            append("$stringFunName(")
            append("new int[]{")
            repeat((10..40).random()) {
                append("${(1000..5000).random()},")
            }
            append("}")
            append(",${(1000..5000).random()});")
        }
        val funName = buffer.toString()
        map[funName] = mutableList
        return map
    }


    fun generateIntFun10(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private static int ${stringFunName}(long j, long j2) {")
            add("Calendar instance = Calendar.getInstance();")
            add("Calendar instance2 = Calendar.getInstance();")
            add("instance.setTime(new Date(j));")
            add("instance2.setTime(new Date(j2));")
            add("int i = instance.get(1);")
            add("int i2 = instance2.get(1);")
            add("int i3 = instance.get(2) + 1;")
            add("int i4 = instance2.get(2) + 1;")
            add("int i5 = instance.get(5);")
            add("int i6 = instance2.get(5);")
            add("int i7 = i2 - i;")
            add("if (Math.abs(i7) <= 1) {")
            add("return 0;")
            add("}")
            add("int i8 = i4 - i3;")
            add("return i8 > 0 ? Math.abs(i7) : (i8 != 0 || i6 - i5 < 0) ? Math.abs(i7) - 1 : Math.abs(i7);")
            add("}")
        }
        FileUtils.listPackage.add("import java.util.Calendar;")
        FileUtils.listPackage.add("import java.util.Date;")
        val funName = "$stringFunName( ${(1000..2000).random()}L, ${(1000..2000).random()}L);"
        map[funName] = mutableList
        return map
    }


    fun generateIntFun11(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("private static int ${stringFunName}(String str) {")
            add("String str2 = str.split(\"-\")[0];")
            add("String str3 = str.split(\"-\")[1];")
            add("String str4 = str.split(\"-\")[2];")
            add("Calendar instance = Calendar.getInstance();")
            add("instance.set(1, Integer.parseInt(str2));")
            add("instance.set(2, Integer.parseInt(str3) - 1);")
            add("instance.set(5, Integer.parseInt(str4));")
            add("int i = instance.get(7);")
            add("if (i == 1) {")
            add("return 7;")
            add("}")
            add("if (i == 3) {")
            add("return 2;")
            add("}")
            add("if (i == 4) {")
            add("return 3;")
            add("}")
            add("if (i == 5) {")
            add("return 4;")
            add("}")
            add("if (i != 6) {")
            add("return i != 7 ? 1 : 6;")
            add("}")
            add("return 5;")
            add("}")
        }
        FileUtils.listPackage.add("import java.util.Calendar;")
        val funName = "$stringFunName(\"${generateArgs(3)}\");"
        map[funName] = mutableList
        return map
    }


    fun generateIntFun12(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(long j) {")
            add("if (j == 0) {")
            add("j = System.currentTimeMillis();")
            add("}")
            add("Calendar instance = Calendar.getInstance();")
            add("instance.setTime(new Date(j));")
            add("return instance.get(5);")
            add("}")
        }
        FileUtils.listPackage.add("import java.util.Calendar;")
        FileUtils.listPackage.add("import java.util.Date;")
        val funName = "$stringFunName( ${(1000..2000).random()}L);"
        map[funName] = mutableList
        return map
    }


    fun generateIntFun13(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int  ${stringFunName}(int[] iArr, int i, int i2) {")
            add("int i3 = i - 1;")
            add(" int i4 = 0;")
            add("while (i4 <= i3) {")
            add("int i5 = (i4 + i3) >>> 1;")
            add("int i6 = iArr[Math.min(iArr.length - 1, i5)];")
            add("if (i6 < i2) {")
            add("i4 = i5 + 1;")
            add("} else if (i6 <= i2) {")
            add(" return i5;")
            add(" } else {")
            add("i3 = i5 - 1;")
            add("}")
            add("}")
            add(" return i4 ^ -1;")
            add("}")
        }


        val buffer = StringBuffer().apply {
            append("$stringFunName(")
            append("new int[]{")
            repeat((10..40).random()) {
                append("${(1000..5000).random()},")
            }
            append("}")
            append(",${(1000..5000).random()},${(1000..5000).random()});")
        }


        val funName = buffer.toString()
        map[funName] = mutableList
        return map
    }


    //新增
    fun generateIntFun14(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public int ${stringFunName}(String s) {")
            add("java.util.Set<Character> characters = new java.util.HashSet<>();")
            add("int n = s.length();")
            add("int rk = -1, ans = 0;")
            add("for (int i = 0; i < n; ++i) {")
            add("if (i != 0) {\n System.out.println(i);\n}")
            add("while (rk + 1 < n) {")
            add("++rk;")
            add("}")
            add("ans = Math.max(ans, rk - i + 1);")
            add("}")
            add("return ans;")
            add("}")
        }
        val funName = "$stringFunName(\"${generateArgs(3)}\");"
        map[funName] = mutableList
        return map
    }

    fun generateIntFun15(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(int[] nums1, int[] nums2, int k) {")
            add("int length1 = nums1.length, length2 = nums2.length;\n")
            add("int index1 = 0, index2 = 0;\n")
            add("int kthElement = 0;")
            add("return kthElement;")
            add("}")

        }
        val buffer = StringBuffer().apply {
            append("$stringFunName(")
            append("new int[]{")
            repeat((10..20).random()) {
                append("${(1000..5000).random()},")
            }
            append("},")
            append("new int[]{")
            repeat((10..20).random()) {
                append("${(1000..5000).random()},")
            }
            append("},")
            append("${(1..19).random()});")
        }
        val funName = buffer.toString()
        map[funName] = mutableList
        return map
    }

    fun generateIntFun16(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(String str, int left, int right) {")
            add("while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {")
            add("--left;\n" + "            ++right;}")
            add("return right - left - 1;")
            add("}")
        }
        val funName = "$stringFunName(\"${generateFunName()}\",${(1000..5000).random()},${(1000..5000).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateIntFun17(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(String s, int left, int right) {")
            add("while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {")
            add("--left;\n" + "            ++right;}")
            add("return (right - left - 2) / 2;")
            add("}")
        }
        val funName = "$stringFunName(\"${generateFunName()}\",${(1000..5000).random()},${(1000..5000).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateIntFun18(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(int x) {")
            add("        int rev = 0;\n")
            add("while (x != 0) {")
            add("if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {")
            add("return 0;")
            add("}")
            add("int digit = x % 10;\n" + "            x /= 10;\n" + "            rev = rev * 10 + digit;")
            add("}")
            add("return rev;")
            add("}")
        }
        val funName = "$stringFunName(${(0..5000).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateIntFun19(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(String str) {")
            add("        if (str.isEmpty()) return 0;\n")
            add("        int index = 0, n = str.length(), sign = 1, res = 0;\n")
            add("while (index < n && str.charAt(index) == ' ') {\n" + "            ++index;\n" + "        }")
            add("if (index < n && (str.charAt(index) == '+' || str.charAt(index) == '-')) {\n" + "            sign = str.charAt(index++) == '+' ? 1 : -1;\n" + "        }")
            add("while (index < n ) {")
            add("int digit = str.charAt(index) - '0';\n" + "            \n" + "            if (res > (Integer.MAX_VALUE - digit) / 10) {\n" + "                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;\n" + "            }\n" + "            res = res * 10 + digit;\n" + "            ++index;")
            add("}")
            add("return res * sign;")
            add("}")

        }
        val funName = "$stringFunName(\"${generateFunName()}\");"
        map[funName] = mutableList
        return map
    }

    fun generateIntFun20(): HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(String str) {")
            add("Map<Character, Integer> map = new HashMap<Character, Integer>(){{")
            add("put('${generateFunName(1)}', ${(0..100).random()});")
            add("put('${generateFunName(1)}', ${(0..100).random()});")
            add("put('${generateFunName(1)}', ${(0..100).random()});")
            add("}};")
            add("int ans = 0;")
            add("int n = str.length();")
            add("for (int i = 0; i < n; ++i) {")
            add("int value = map.get(str.charAt(i));")
            add("if(i < n - 1 && value < map.get(str.charAt(i + 1))) {")
            add("ans -= value;")
            add("}")
            add("else {")
            add("ans += value;")
            add("}")
            add("}")
            add("return ans;")
            add("}")

        }
        FileUtils.listPackage.add("import java.util.Map;")
        FileUtils.listPackage.add("import java.util.HashMap;")
        val funName = "$stringFunName(\"${generateFunName()}\");"
        map[funName] = mutableList
        return map
    }


    fun generateIntFun21() : HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(int[] nums, int target) {")
            add("java.util.Arrays.sort(nums);")
            add("int n = nums.length;")
            add("int best = 100000000;")
            add("for(int i = 0; i < n; i++) {")
            add("if(i > 0 && nums[i] == nums[i - 1]) {")
            add("continue;")
            add("}")
            add("int j = i + 1, k = n - 1;")
            add("while (j < k) {")
            add("int sum = nums[i] + nums[j] + nums[k];\n" + "        if (sum == target) {\n" + "            return target;\n" + "        }")
            add("if (Math.abs(sum - target) < Math.abs(best - target)) {\n" + "            best = sum;\n" + "        }")
            add("if (sum > target) {\n" + "            // 如果和大于 target，移动 c 对应的指针\n" + "            int k0 = k - 1;\n" + "            while (j < k0 && nums[k0] == nums[k]) {\n" + "                --k0;\n" + "            }\n" + "            k = k0;\n" + "        }")
            add("else {\n" + "            // 如果和小于 target，移动 b 对应的指针\n" + "            int j0 = j + 1;\n" + "            while (j0 < k && nums[j0] == nums[j]) {\n" + "                ++j0;\n" + "            }\n" + "            j = j0;\n" + "        }")
            add("}")
            add("}")
            add("return best;")
            add("}")
        }


        val funName = "$stringFunName(new int[]{${(1000..5000).random()}, ${(1000..5000).random()}, ${(1000..5000).random()}}, ${(1000..5000).random()});"
        map[funName] = mutableList
        return map
    }

    fun generateIntFun22() : HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(int[] nums) {")
            add("int n = nums.length;")
            add("if(n <= 2) {")
            add("return n;")
            add("}")
            add("int slow = 2, fast = 2;")
            add("while(fast < n) {")
            add("if(nums[slow - 2] != nums[fast]) {")
            add("nums[slow] = nums[fast];")
            add("++slow;")
            add("}")
            add("++fast;")
            add("}")
            add("return slow;")
            add("}")
        }
        val r = (2..10).random()
        var stringBuilder = StringBuilder()
        repeat(r){
            stringBuilder.append("${(100 .. 5000).random()},")
        }
        val funName = "$stringFunName(new int[]{${stringBuilder.toString()}});"
        map[funName] = mutableList
        return map
    }

    fun generateIntFun23() : HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(int[] nums, int k) {")
            add("int n = nums.length;")
            add("int [] arra = new int[n];")
            add("for(int i = 0; i < n; i++){")
            add("arra[(i+k) % n] = nums[i];")
            add("}")
            add("return nums[0];")
            add("}")
        }
        val r = (2..10).random()
        var stringBuilder = StringBuilder()
        repeat(r){
            stringBuilder.append("${(100 .. 5000).random()},")
        }
        val funName = "$stringFunName(new int[]{${stringBuilder.toString()}}, ${(2..10).random()});"
        map[funName] = mutableList
        return map
    }


    fun generateIntFun24() : HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(int[] prices) {")
            add("int maxprofit = 0;")
            add("for (int i = 0; i < prices.length - 1; i++) {")
            add("for (int j = i + 1; j < prices.length; j++) {")
            add("int profit = prices[j] - prices[i];")
            add("if (profit > maxprofit) {")
            add("maxprofit = profit;")
            add("}")
            add("}")
            add("}")
            add("return maxprofit;")
            add("}")
        }
        val r = (2..10).random()
        var stringBuilder = StringBuilder()
        repeat(r){
            stringBuilder.append("${(100 .. 5000).random()},")
        }
        val funName = "$stringFunName(new int[]{${stringBuilder.toString()}});"
        map[funName] = mutableList
        return map
    }

    fun generateIntFun25() : HashMap<String, MutableList<String>> {
        val map = HashMap<String, MutableList<String>>()
        val stringFunName = generateFunName()
        val mutableList = mutableListOf<String>().apply {
            add("public static int ${stringFunName}(int[] prices) {")
            add("int n = prices.length;")
            add("int[][] dp = new int[n][2];")
            add("dp[0][0] = 0;")
            add("dp[0][1] = -prices[0];")
            add("for (int i = 1; i < n; ++i) {")
            add("dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);")
            add("dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);")
            add("}")
            add("return dp[n - 1][0];")
            add("}")
        }
        val r = (2..10).random()
        var stringBuilder = StringBuilder()
        repeat(r){
            stringBuilder.append("${(100 .. 5000).random()},")
        }
        val funName = "$stringFunName(new int[]{${stringBuilder.toString()}});"
        map[funName] = mutableList
        return map
    }


}