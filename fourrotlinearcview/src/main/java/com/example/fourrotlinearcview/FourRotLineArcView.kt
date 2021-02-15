package com.example.fourrotlinearcview

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.content.Context
import android.graphics.RectF
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
val rot : Float = 90f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun  Canvas.drawFourRotLineArc(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / sizeFactor
    val sf : Float = scale.sinify()
    save()
    translate(w / 2, h / 2)
    for (j in 0..(parts -1)) {
        val sfj : Float = sf.divideScale(j, parts)
        val sfj1 : Float = sf.divideScale(0, divs)
        val sfj2 : Float = sf.divideScale(1, divs)
        save()
        rotate((360f / parts) * j)
        for (k in 0..1) {
            save()
            rotate(rot * k * sfj2)
            drawLine(0f, 0f, 0f, -size * sfj1, paint)
            restore()
        }
        drawArc(RectF(-size / 3, -size / 3, size / 3, size / 3), -rot, rot * sfj2, true, paint)
        restore()
    }
    restore()
}

fun Canvas.drawFRLANode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawFourRotLineArc(scale, w, h, paint)
}

class FourRotLineArcView(ctx : Context) : View(ctx) {

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