package io.github.orbitalno11.pokemonapimvp.adapter.base

import android.os.Parcel
import android.os.Parcelable
import kotlin.properties.Delegates

open class BaseItem() : Parcelable {

    var type by Delegates.notNull<Int>()

    constructor(parcel: Parcel) : this() {
        this.type = parcel.readInt()
    }

    constructor(type: Int) : this() {
        this.type = type
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(this.type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BaseItem> {
        override fun createFromParcel(parcel: Parcel): BaseItem {
            return BaseItem(parcel)
        }

        override fun newArray(size: Int): Array<BaseItem?> {
            return arrayOfNulls(size)
        }
    }
}