package com.act.code.generate

import com.act.code.FileUtils

object GenerateServiceFun {

    fun generateConstruct(serviceName: String): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override")
            add("public ${serviceName}() {")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateOnBindFun(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override")
            add("public IBinder onBind(Intent intent) {")
            add("return null;")
            add("}")
            add("\n")
        }
        FileUtils.listPackage.add("import android.os.IBinder;")
        FileUtils.listPackage.add("import android.content.Intent;")
        return mutableList
    }

    fun generateOnCreate(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override")
            add("public void onCreate() {")
            add("super.onCreate();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateOnStartCommand(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override")
            add("public int onStartCommand(Intent intent, int flags, int startId) {")
            add("return super.onStartCommand(intent, flags, startId);")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateOnDestroy(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override")
            add("public void onDestroy() {")
            add("super.onDestroy();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateOnUnBind(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override")
            add("public boolean onUnbind(Intent intent) {")
            add("return super.onUnbind(intent);")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateOnReBind(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override")
            add("public void onRebind(Intent intent) {")
            add("super.onRebind(intent);")
            add("}")
            add("\n")
        }
        return mutableList
    }
}