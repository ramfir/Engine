package com.example.engine

import android.content.res.Resources
import android.util.TypedValue

fun Number.toDp(): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )
}

fun Number.toSp(): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )
}

fun Number.toDpInt(): Int = toDp().toInt()
fun Number.toSpInt(): Int = toSp().toInt()