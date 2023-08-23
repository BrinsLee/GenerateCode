package com.act.code.generate

import com.act.code.tools.generateColorValue
import com.act.code.tools.generateEllipsize
import com.act.code.tools.generateFunName
import com.act.code.tools.generateGravity
import com.act.code.tools.generateLayoutId
import com.act.code.tools.generateScaleType
import com.act.code.tools.generateVisible

object GenerateLayoutFun {

    private fun generateView(): String {
        return "<View android:id=\"@+id/view_${generateLayoutId()}\" android:layout_width=\"${(0..400).random()}dp\" android:layout_height=\"${(0..400).random()}dp\" android:layout_centerHorizontal=\"true\" android:layout_marginTop=\"${(0..400).random()}dp\" />"
    }

    private fun generateViewBackground(): String {
        return "<View android:id=\"@+id/view_${generateLayoutId()}\" android:layout_width=\"${(0..400).random()}dp\" android:layout_height=\"${(0..400).random()}dp\" android:layout_centerHorizontal=\"true\" android:layout_marginTop=\"${(0..400).random()}dp\" android:background=\"${generateColorValue()}\" />"
    }

    private fun generateViewBackgroundVisible(): String {
        return "<View android:id=\"@+id/view_${generateLayoutId()}\" android:layout_width=\"${(0..400).random()}dp\" android:layout_height=\"${(0..400).random()}dp\" android:layout_marginLeft=\"${(0..400).random()}dp\" android:background=\"${generateColorValue()}\" android:visibility=\"${generateVisible()}\" />"
    }

    private fun generateViewMarginHorizontal(): String {
        return "<View android:id=\"@+id/view_${generateLayoutId()}\" android:layout_width=\"${(0..400).random()}dp\" android:layout_height=\"${(0..400).random()}dp\" android:layout_centerHorizontal=\"true\" android:layout_marginBottom=\"${(0..400).random()}dp\" android:background=\"${generateColorValue()}\" android:layout_marginHorizontal=\"${(10..20).random()}dp\" />"
    }

    private fun generateViewMarginVertical(): String {
        return "<View android:id=\"@+id/view_${generateLayoutId()}\" android:layout_width=\"${(0..400).random()}dp\" android:layout_height=\"${(0..400).random()}dp\" android:layout_centerHorizontal=\"true\" android:background=\"${generateColorValue()}\" android:layout_marginVertical=\"${(10..20).random()}dp\" android:layout_marginHorizontal=\"${(10..20).random()}dp\" />"
    }

    public fun generateTextView(): String {
        return "<TextView android:id=\"@+id/text_view_${generateLayoutId()}\" android:layout_centerVertical=\"true\" android:gravity=\"${generateGravity()}\" android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" android:text=\"${generateFunName()}\" android:textColor=\"${generateColorValue()}\" android:textSize=\"${(14..40).random()}dp\" />"
    }

    private fun generateTextViewBackground(): String {
        return "<TextView android:id=\"@+id/text_view_${generateLayoutId()}\" android:layout_centerVertical=\"true\" android:background=\"${generateColorValue()}\" android:padding=\"${(0..50).random()}dp\" android:gravity=\"${generateGravity()}\" android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" android:text=\"${generateFunName()}\" android:textColor=\"${generateColorValue()}\" android:textSize=\"${(14..40).random()}dp\" />"
    }

    private fun generateTextViewGravity(): String {
        return "<TextView android:id=\"@+id/text_view_${generateLayoutId()}\" android:layout_centerVertical=\"true\" android:gravity=\"${generateGravity()}\" android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" android:text=\"${generateFunName()}\" android:textColor=\"#ffffff\" android:textSize=\"${(14..40).random()}dp\" />"
    }

    private fun generateTextViewMaxEms(): String {
        return "<TextView android:id=\"@+id/text_view_${generateLayoutId()}\" android:layout_centerVertical=\"true\" android:gravity=\"${generateGravity()}\" android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" android:text=\"${generateFunName()}\" android:textColor=\"${generateColorValue()}\" android:textSize=\"${(14..40).random()}dp\" android:maxEms=\"${(1..30).random()}\" android:maxLines=\"${(2..10).random()}\" />"
    }

    public fun generateTextViewEms(): String {
        return "<TextView android:id=\"@+id/text_view_${generateLayoutId()}\" android:layout_centerVertical=\"true\" android:gravity=\"${generateGravity()}\" android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" android:text=\"${generateFunName()}\" android:textColor=\"${generateColorValue()}\" android:textSize=\"${(14..40).random()}dp\" android:ems=\"${(1..30).random()}\" android:maxLines=\"${(2..10).random()}\" android:ellipsize=\"${generateEllipsize()}\" />"
    }

    private fun generateButtonView(): String {
        return "<Button android:id=\"@+id/betting_${generateLayoutId()}\" android:layout_width=\"${(140..240).random()}dp\"  android:text=\"${generateLayoutId()}\"  android:layout_height=\"${(64..140).random()}dp\" android:layout_alignParentBottom=\"true\" android:layout_marginEnd=\"${(30..60).random()}dp\" android:layout_alignParentEnd=\"true\"/>"
    }

    private fun generateButtonViewBackground(): String {
        return "<Button android:id=\"@+id/betting_${generateLayoutId()}\" android:layout_width=\"${(140..240).random()}dp\"  android:text=\"${generateLayoutId()}\"  android:layout_height=\"${(64..140).random()}dp\" android:background=\"${generateColorValue()}\" android:layout_marginTop=\"${(20..60).random()}dp\" android:layout_marginEnd=\"${(30..60).random()}dp\" android:layout_alignParentEnd=\"true\"/>"
    }

    private fun generateButtonViewLayoutGravity(): String {
        return "<Button android:id=\"@+id/betting_${generateLayoutId()}\" android:layout_width=\"${(140..240).random()}dp\"  android:text=\"${generateLayoutId()}\"  android:layout_height=\"${(64..140).random()}dp\" android:layout_alignParentBottom=\"true\" android:layout_marginBottom=\"${(30..60).random()}dp\" android:layout_gravity=\"${generateGravity()}\"/>"
    }

    fun generateButtonViewPadding(): String {
        return "<Button android:id=\"@+id/betting_${generateLayoutId()}\" android:layout_width=\"${(140..240).random()}dp\"  android:text=\"${generateLayoutId()}\"  android:layout_height=\"${(64..140).random()}dp\" android:paddingStart=\"${(10..30).random()}dp\" android:paddingEnd=\"${(10..30).random()}dp\"></Button>"
    }

    private fun generateButtonViewTextColor(): String {
        return "<Button android:id=\"@+id/betting_${generateLayoutId()}\" android:layout_width=\"${(140..240).random()}dp\"  android:text=\"${generateLayoutId()}\"  android:layout_height=\"${(64..140).random()}dp\" android:textColor=\"${generateColorValue()}\"/>"
    }

    private fun generateButtonViewTextHint(): String {
        return "<Button android:id=\"@+id/betting_${generateLayoutId()}\" android:layout_width=\"${(140..240).random()}dp\"  android:text=\"${generateLayoutId()}\"  android:layout_height=\"${(64..140).random()}dp\" android:textColor=\"${generateColorValue()}\" android:textColorHint=\"${generateColorValue()}\"/>"
    }

    private fun generateImageView(): String {
        return "<ImageView android:id=\"@+id/iv_${generateLayoutId()}\"  android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" android:layout_marginBottom=\"${(0..400).random()}dp\" android:src=\"@null\" android:visibility=\"gone\" />"
    }

    private fun generateImageViewBackground(): String {
        return "<ImageView android:id=\"@+id/iv_${generateLayoutId()}\"  android:background=\"${generateColorValue()}\" android:layout_width=\"${(20 .. 50).random()}dp\" android:layout_height=\"${(20 .. 50).random()}\" android:layout_marginBottom=\"${(0..400).random()}dp\" android:src=\"@android:drawable/ic_media_play\" android:visibility=\"${generateVisible()}\" />"
    }

    public fun generateImageViewScaleType(): String {
        return "<ImageView android:id=\"@+id/iv_${generateLayoutId()}\"  android:layout_width=\"wrap_content\" android:layout_height=\"${(20 .. 50).random()}dp\" android:layout_marginBottom=\"${(0..400).random()}dp\" android:src=\"@android:drawable/ic_delete\" android:scaleType=\"${generateScaleType()}\" />"
    }

    private fun generateImageViewMaxWidth(): String {
        val width = (50..100).random()
        return "<ImageView android:id=\"@+id/iv_${generateLayoutId()}\"  android:layout_width=\"${width - 10}\" android:layout_height=\"${width - 10}\" android:layout_marginTop=\"${(0..400).random()}dp\" android:src=\"@android:drawable/ic_media_ff\" android:maxWidth=\"$width\" />"
    }

    private fun generateImageViewAlpha(): String {
        return "<ImageView android:id=\"@+id/iv_${generateLayoutId()}\"  android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" android:layout_marginBottom=\"${(0..400).random()}dp\" android:src=\"@null\" android:alpha=\"0.${(1..9).random()}\" />"
    }

    private fun generateImageViewClickable(): String {
        return "<ImageView android:id=\"@+id/iv_${generateLayoutId()}\"  android:layout_width=\"${(50..70).random()}dp\" android:layout_height=\"wrap_content\" android:layout_marginLeft=\"${(0..400).random()}dp\" android:src=\"@android:drawable/ic_lock_silent_mode\" />"
    }

    private fun generateImageViewPadding(): String {
        return "<ImageView android:id=\"@+id/iv_${generateLayoutId()}\"  android:layout_width=\"${(50..70).random()}dp\" android:layout_height=\"${(50..70).random()}\" android:layout_marginLeft=\"${(0..400).random()}dp\" android:src=\"@android:drawable/ic_lock_silent_mode\" />"
    }

    private fun generateFrameLayout(): String {
        return "<FrameLayout android:id=\"@+id/fl_${generateLayoutId()}\"  android:layout_width=\"match_parent\" android:layout_height=\"wrap_content\" android:layout_weight=\"${(1..4).random()}\" />"
    }

    fun generateFrameLayoutContent(vararg acts: () -> String): String {
        val stringBuilder = StringBuilder()
        acts.forEach { act ->
            stringBuilder.append(act())
        }
        return "<FrameLayout android:id=\"@+id/fl_${generateLayoutId()}\" android:gravity=\"${generateGravity()}\" android:layout_width=\"match_parent\" android:layout_height=\"wrap_content\" android:background=\"${generateColorValue()}\" >$stringBuilder</FrameLayout>"
    }

    private fun generateLinearLayout(act: () -> String): String {
        return "<LinearLayout android:id=\"@+id/fl_${generateLayoutId()}\"  android:layout_width=\"match_parent\" android:layout_height=\"wrap_content\" android:background=\"${generateColorValue()}\" />"
    }

    private fun generateLinearLayoutContent(vararg acts: () -> String): String {
        val stringBuilder = StringBuilder()
        acts.forEach { act ->
            stringBuilder.append(act())
        }
        return "<LinearLayout android:id=\"@+id/fl_${generateLayoutId()}\"  android:layout_width=\"match_parent\" android:layout_height=\"wrap_content\" android:background=\"${generateColorValue()}\" >$stringBuilder</LinearLayout>"
    }

    private fun generateSeekBar(): String {
        return "<SeekBar android:id=\"@+id/sk_${generateLayoutId()}\" android:layout_width=\"${(100..260).random()}dp\" android:layout_height=\"${(40..80).random()}dp\" android:layout_alignParentLeft=\"true\" android:layout_marginLeft=\"${(14..50).random()}sp\" />"
    }

    private fun generateCheckBox(): String {
        return "<CheckBox android:id=\"@+id/ck_${generateLayoutId()}\" android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" android:text=\"${generateLayoutId()}\"/>"
    }

    private fun generateProgressBar(): String {
        return "<ProgressBar style=\"?android:attr/progressBarStyle\" android:layout_width=\"${(100..200).random()}dp\" android:layout_height=\"${(30..60).random()}dp\" android:id=\"@+id/pg_${generateLayoutId()}\"/>"
    }

    private fun generateEditText(): String {
        return "<EditText android:id=\"@+id/et_${generateLayoutId()}\" android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" android:ems=\"${(10..18).random()}\"  android:text=\"${generateLayoutId()}\" android:layout_marginTop=\"${(14..50).random()}dp\" android:layout_marginRight=\"${(14..50).random()}dp\" android:layout_marginLeft=\"${(14..50).random()}dp\" />"
    }


    fun generateRelativeLayoutView(): String {
        val buffer = StringBuffer()
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
        buffer.append("<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\" xmlns:app=\"http://schemas.android.com/apk/res-auto\" android:id=\"@+id/${generateLayoutId()}\" android:layout_width=\"match_parent\" android:layout_height=\"match_parent\"> \n")

        repeat((3..13).random()) {
            val str = when ((0..11).random()) {
                0 -> generateView()
                1 -> generateTextView()
                2 -> generateButtonView()
                3 -> generateImageView()
                4 -> generateFrameLayout()
                5 -> generateSeekBar()
                6 -> generateCheckBox()
                7 -> generateProgressBar()
                8 -> generateEditText()
                9 -> generateTextViewEms()
                10 -> generateImageViewScaleType()
                else -> ""
            }
            buffer.append(str).append("\n")
        }
        buffer.append(" </RelativeLayout>")

        return buffer.toString()
    }


    fun generateLinerLayoutView(): String {
        val buffer = StringBuffer()
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
        buffer.append("<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"  android:orientation=\"vertical\" xmlns:app=\"http://schemas.android.com/apk/res-auto\" android:id=\"@+id/${generateLayoutId()}\" android:layout_width=\"match_parent\" android:layout_height=\"match_parent\"> \n")

        repeat((3..6).random()) {
            val str = when ((0..11).random()) {
                0 -> generateView()
                1 -> generateTextView()
                2 -> generateButtonView()
                3 -> generateImageView()
                4 -> generateFrameLayout()
                5 -> generateSeekBar()
                6 -> generateCheckBox()
                7 -> generateProgressBar()
                8 -> generateEditText()
                9 -> generateViewBackground()
                10 -> generateButtonViewLayoutGravity()
                11 -> generateFrameLayoutContent(::generateImageViewScaleType, :: generateTextViewEms, :: generateButtonViewPadding)
                else -> ""
            }
            buffer.append(str).append("\n")
        }
        buffer.append(" </LinearLayout>")

        return buffer.toString()
    }


    fun generateFrameLayoutView(): String {
        val buffer = StringBuffer()
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
        buffer.append("<FrameLayout xmlns:android=\"http://schemas.android.com/apk/res/android\" xmlns:app=\"http://schemas.android.com/apk/res-auto\" android:id=\"@+id/${generateLayoutId()}\" android:layout_width=\"match_parent\" android:layout_height=\"match_parent\"> \n")

        repeat((3..13).random()) {
            val str = when ((0..11).random()) {
                0 -> generateView()
                1 -> generateTextView()
                2 -> generateButtonView()
                3 -> generateImageView()
                4 -> generateFrameLayout()
                5 -> generateSeekBar()
                6 -> generateCheckBox()
                7 -> generateProgressBar()
                8 -> generateEditText()
                9 -> generateImageViewAlpha()
                10 -> generateImageViewClickable()
                11 -> generateViewMarginHorizontal()
                else -> ""
            }
            buffer.append(str).append("\n")
        }
        buffer.append(" </FrameLayout>")

        return buffer.toString()
    }

    fun generateFrameLayoutView2(): String {
        val buffer = StringBuffer()
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
        buffer.append("<FrameLayout xmlns:android=\"http://schemas.android.com/apk/res/android\" xmlns:app=\"http://schemas.android.com/apk/res-auto\" android:id=\"@+id/${generateLayoutId()}\" android:layout_width=\"match_parent\" android:layout_height=\"match_parent\"> \n")

        repeat((3..13).random()) {
            val str = when ((0..11).random()) {
                0 -> generateViewBackgroundVisible()
                1 -> generateTextViewEms()
                2 -> generateTextViewGravity()
                3 -> generateImageView()
                4 -> generateImageViewScaleType()
                5 -> generateFrameLayout()
                6 -> generateCheckBox()
                7 -> generateLinearLayoutContent(::generateButtonViewLayoutGravity, ::generateViewBackground)
                8 -> generateEditText()
                9 -> generateTextViewGravity()
                10 -> generateButtonViewPadding()
                11 -> generateTextViewBackground()
                else -> ""
            }
            buffer.append(str).append("\n")
        }
        buffer.append(" </FrameLayout>")

        return buffer.toString()
    }
}