package com.example.fourrotlinearcview

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.content.Context
import android.app.Activity

val colors : Array<Int> = arrayOf(
        "#F44336",
        "#2196F3",
        "#8BC34A",
        "#FF9800",
        "#3F51B5"
).map {
    Color.parseColor(it)
}.toTypedArray()
val parts : Int = 4
val divs : Int = 2
val scGap : Float = 0.02f / (parts * 2)
val strokeFactor : Float = 90f
val sizeFactor : Float = 3.2f
val delay : Long = 20
