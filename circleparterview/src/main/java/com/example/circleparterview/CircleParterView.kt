package com.example.circleparterview

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF
import android.content.Context
import android.app.Activity

val colors : Array<Int> = arrayOf(
    "#F44336",
    "#2196F3",
    "#8BC34A",
    "#3F51B5",
    "#FFEB3B"
).map {
    Color.parseColor(it)
}.toTypedArray()
val backColor : Int = Color.parseColor("#BDBDBD")
val strokeFactor : Float = 90f
val sizeFactor : Float = 3.4f
val delay : Long = 20
val arcs : Int = 6
val deg : Float = 300f
val fullDeg : Float = 360f
val parts : Int = arcs + 1
val scGap : Float = 0.02f / parts
