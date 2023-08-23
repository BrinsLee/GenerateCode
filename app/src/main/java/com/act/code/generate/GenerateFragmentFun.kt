package com.act.code.generate

import com.act.code.Config
import com.act.code.FileUtils
import com.act.code.FileUtils.listPackage


object GenerateFragmentFun {


    /**
     *     @Override
     *     public void onAttach(Context context) {
     *         super.onAttach(context);
     *     }
     */
    fun generateActOnAttach(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override // android.app.Fragment")
            add("public void onAttach(Context context) {")
            add("super.onAttach(context);")
            add("}")
            add("\n")
        }
        listPackage.add("import android.app.Fragment;\n" + "import android.content.Context;")
        return mutableList
    }


    /**
     *     @Override
     *     public void onCreate(Bundle savedInstanceState) {
     *         super.onCreate(savedInstanceState);
     *
     *     }
     */
    fun generateActOnCreate(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override // android.app.Fragment")
            add("public void onCreate(Bundle saveInstanceState) {")
            add("super.onCreate(saveInstanceState);")
            add("}")
            add("\n")
        }
        listPackage.add("import android.os.Bundle;")
        return mutableList
    }

    /**
     *     @Override
     *     public View onCreateView(LayoutInflater inflater, ViewGroup container,
     *                              Bundle savedInstanceState) {
     *         // Inflate the layout for this fragment
     *         return inflater.inflate(R.layout.fragment_blank, container, false);
     *     }
     */
    fun generateActOnCreateView(): MutableList<String> {
        val layoutName = FileUtils.generateFragmentLayoutFile()  // 布局文件
        val mutableList = mutableListOf<String>().apply {
            add(" @Override // android.app.Fragment")
            add("public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {")
            add("return inflater.inflate(R.layout.${layoutName}, container, false);")
            add("}")
            add("\n")
        }
        listPackage.add("import ${Config.applicationId}.R;")
        listPackage.add("import android.view.LayoutInflater;")
        listPackage.add("import android.view.View;\n" + "import android.view.ViewGroup;")
        return mutableList
    }


    /**
     *     @Override
     *     public void onViewCreated(View view, Bundle savedInstanceState) {
     *         super.onViewCreated(view, savedInstanceState);
     *     }
     */
    fun generateActOnViewCreated(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override // android.app.Fragment")
            add("public void onViewCreated(View view, Bundle savedInstanceState) {")
            add("super.onViewCreated(view, savedInstanceState);")
            add("}")
            add("\n")
        }
        return mutableList
    }


    /**
     *     @Override
     *     public void onActivityCreated(Bundle savedInstanceState) {
     *         super.onActivityCreated(savedInstanceState);
     *     }
     */
    fun generateActOnActivityCreated(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override // android.app.Fragment")
            add("public void onActivityCreated(Bundle savedInstanceState) {")
            add("super.onActivityCreated(savedInstanceState);")
            add("}")
            add("\n")
        }
        return mutableList
    }


    fun generateActOnStart(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override")
            add("public void onStart() {")
            add("super.onStart();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateActOnResume(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override")
            add("public void onResume() {")
            add("super.onResume();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateActOnPause(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override")
            add("public void onPause() {")
            add("super.onPause();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateActOnStop(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override")
            add("public void onStop() {")
            add("super.onStop();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateActOnDestroy(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override")
            add("public void onDestroy() {")
            add("super.onDestroy();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateActOnDestroyView(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add(" @Override")
            add("public void onDestroyView() {")
            add("super.onDestroyView();")
            add("}")
            add("\n")
        }
        return mutableList
    }
}