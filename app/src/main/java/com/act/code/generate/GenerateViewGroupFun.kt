package com.act.code.generate

import com.act.code.FileUtils


object GenerateViewGroupFun {

    val viewGroups = arrayListOf("ViewGroup","LinearLayout","RelativeLayout","FrameLayout", "GridLayout")

    fun generateConstruct(layoutName: String): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("public ${layoutName}(Context context) {")
            add("super(context);")
            add("}")
            add("\n")
        }
        FileUtils.listPackage.add("import android.content.Context;")
        return mutableList
    }

    fun generateSecondConstruct(layoutName: String): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("public ${layoutName}(Context context, AttributeSet attrs) {")
            add("super(context, attrs);")
            add("}")
            add("\n")
        }
        FileUtils.listPackage.add("import android.util.AttributeSet;")
        return mutableList
    }

    fun generateThirdConstruct(layoutName: String): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("public ${layoutName}(Context context, AttributeSet attrs, int defStyleAttr) {")
            add("super(context, attrs, defStyleAttr);")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateOnAttachedToWindow(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override")
            add("public void onAttachedToWindow () {")
            add("super.onAttachedToWindow();")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateOnMeasure(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override")
            add("public void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {")
            add("super.onMeasure(widthMeasureSpec, heightMeasureSpec);")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateOnLayout(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override")
            add("public void onLayout (boolean changed, int l, int t, int r, int b) {")
            add("}")
            add("\n")
        }
        return mutableList
    }

    fun generateOnDraw(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override")
            add("public void onDraw (Canvas canvas) {")
            add("super.onDraw(canvas);")
            add("}")
            add("\n")
        }
        FileUtils.listPackage.add("import android.graphics.Canvas;")

        return mutableList
    }

    fun generateOnDetachedFromWindow(): MutableList<String> {
        val mutableList = mutableListOf<String>().apply {
            add("@Override")
            add("public void onDetachedFromWindow () {")
            add("super.onDetachedFromWindow();")
            add("}")
            add("\n")
        }
        return mutableList
    }

}