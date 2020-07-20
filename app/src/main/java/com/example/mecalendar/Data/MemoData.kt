package com.example.mecalendar.Data

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable

class MemoData : Parcelable {
    var time: String? = null

    var memo: String? = null
    var image:Bitmap?=null
    constructor()
    constructor(source: Parcel) : this()
    constructor(time: String?, memo: String?,im:Bitmap?) {
        this.time = time
        this.memo = memo
        this.image=im
    }


    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {}

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MemoData> = object : Parcelable.Creator<MemoData> {
            override fun createFromParcel(source: Parcel): MemoData = MemoData(source)
            override fun newArray(size: Int): Array<MemoData?> = arrayOfNulls(size)
        }
    }
}