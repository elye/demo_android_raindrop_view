package com.elyeproj.rainrippleview

import android.graphics.Canvas
import android.graphics.Paint
import android.os.Parcel
import android.os.Parcelable

data class RainDrop(private val centerX: Float, private val centerY: Float, private val maxRadius: Float) : Parcelable {

    var currentRadius = 1f

    constructor(parcel: Parcel) : this(
            parcel.readFloat(),
            parcel.readFloat(),
            parcel.readFloat()) {
        currentRadius = parcel.readFloat()
    }

    fun draw(canvas: Canvas, paint: Paint) {
        paint.apply { alpha = ((maxRadius - currentRadius) / maxRadius * MAX_ALPHA).toInt() }
        canvas.drawCircle(centerX, centerY, currentRadius++, paint)
    }

    fun isValid() = currentRadius < maxRadius

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(centerX)
        parcel.writeFloat(centerY)
        parcel.writeFloat(maxRadius)
        parcel.writeFloat(currentRadius)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RainDrop> {
        private const val MAX_ALPHA = 255

        override fun createFromParcel(parcel: Parcel): RainDrop {
            return RainDrop(parcel)
        }

        override fun newArray(size: Int): Array<RainDrop?> {
            return arrayOfNulls(size)
        }
    }

}
