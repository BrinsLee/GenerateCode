package com.act.code.generate

import com.act.code.Config
import com.act.code.FileUtils
import com.act.code.FileUtils.listPackage

object GenerateActivityFun {
    var stateCode = 0


    fun generateActOnBackPress(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override // android.app.Activity")
            add("public void onBackPressed() {")
            add("super.onBackPressed();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateActOnConfigurationChanged(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override // android.app.Activity, android.content.ComponentCallbacks")
            add("public void onConfigurationChanged(Configuration configuration) {")
            add("super.onBackPressed();")
            add("}")
            add("\n")
        }
        listPackage.add("import android.content.res.Configuration;")
        return mutableList
    }




    fun generateActOnCreate(): MutableList<String> {
        val layoutName = FileUtils.generateLayoutFile()  // 布局文件
        val mutableList = mutableListOf<String>().apply {
            add("@Override // android.app.Activity")
            add("protected void onCreate(@Nullable Bundle bundle) {")
            add("super.onCreate(bundle);")
            add("setContentView(R.layout.${layoutName});")
            add("}")
            add("\n")
        }
        listPackage.add("import ${Config.applicationId}.R;")
        listPackage.add("import android.app.Activity;")
        listPackage.add("import androidx.annotation.Nullable;")
        listPackage.add("import android.os.Bundle;")
        return mutableList
    }

    fun generateActOnNewIntent(list: List<String>? = null): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override // android.app.Activity")
            add("protected void onNewIntent(Intent intent) {")
            add("super.onNewIntent(intent);")
            list?.forEach {
                add("new ${it.split("->")[1].split(".")[0]}();")
            }
            add("}")
            add("\n")
        }
        listPackage.add("import android.content.Intent;")
        return mutableList
    }


    fun generateActOnRestart(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override // android.app.Activity")
            add("protected void onRestart() {")
            add("super.onRestart();")
            add("}")
            add("\n")
        }
        return mutableList
    }


    fun generateActOonRestoreInstanceState(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override // android.app.Activity")
            add("protected void onRestoreInstanceState(Bundle bundle) {")
            add("super.onRestoreInstanceState(bundle);")
            add("}")
            add("\n")
        }
        listPackage.add("import android.os.Bundle;")
        return mutableList
    }

    fun generateActOnStart(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override // android.app.Activity")
            add("protected void onStart() {")
            add("super.onStart();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    //新增
    fun generateActOnResume(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override // android.app.Activity")
            add("protected void onResume() {")
            add("super.onResume();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateActOnPause(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override // android.app.Activity")
            add("protected void onPause() {")
            add("super.onPause();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateActOnStop(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override // android.app.Activity")
            add("protected void onStop() {")
            add("super.onStop();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateActOnDestroy(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override // android.app.Activity")
            add("protected void onDestroy() {")
            add("super.onDestroy();")
            add("}")
            add("\n")
        }
        return mutableList
    }

}