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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawCircleParter(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / sizeFactor
    val sf : Float = scale.sinify()
    val sf2 : Float = sf.divideScale(arcs, parts)
    val gap : Float = deg / arcs
    val rot : Float = fullDeg / arcs
    save()
    translate(w / 2, h / 2)
    rotate(90f * sf2)
    for (j in 0..(arcs - 1)) {
        val sfj : Float = sf.divideScale(j, arcs)
        save()
        rotate(rot * j)
        drawArc(RectF(-size, -size, size, size), -gap * sfj * 0.5f, gap * sfj, false, paint)
        restore()
    }
    restore()
}

fun Canvas.drawCPNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawCircleParter(scale, w, h, paint)
}

class CircleParterView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}