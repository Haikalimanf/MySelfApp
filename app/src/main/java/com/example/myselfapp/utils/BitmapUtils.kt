package com.example.myselfapp.utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.core.graphics.createBitmap

object BitmapUtils {
    fun drawableToBitmap(
        sourceDrawable: Drawable,
        flipX: Boolean = false,
        flipY: Boolean = false,
        @ColorInt tint: Int? = null,
    ): Bitmap {
        return if (sourceDrawable is BitmapDrawable) {
            sourceDrawable.bitmap
        } else {
            val constantState = sourceDrawable.constantState!!
            val drawable = constantState.newDrawable().mutate()
            val bitmap = createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight)
            tint?.let(drawable::setTint)
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            canvas.scale(
                if (flipX) -1f else 1f,
                if (flipY) -1f else 1f,
                canvas.width / 2f,
                canvas.height / 2f
            )
            drawable.draw(canvas)
            bitmap
        }
    }
}