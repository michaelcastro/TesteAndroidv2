package com.teste.domain.model

import android.os.Parcel
import android.os.Parcelable

class UserAccount (val userId : Int, val name : String, val bankAccount : String, val agency : String, val balance : Float , var balanceFormatted: String = "") : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString()
    ) {
    }



    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(userId)
        parcel.writeString(name)
        parcel.writeString(bankAccount)
        parcel.writeString(agency)
        parcel.writeFloat(balance)
        parcel.writeString(balanceFormatted)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "UserAccount(userId=$userId, name='$name', bankAccount='$bankAccount', agency='$agency', balance=$balance, balanceFormatted='$balanceFormatted')"
    }

    companion object CREATOR : Parcelable.Creator<UserAccount> {
        override fun createFromParcel(parcel: Parcel): UserAccount {
            return UserAccount(parcel)
        }

        override fun newArray(size: Int): Array<UserAccount?> {
            return arrayOfNulls(size)
        }
    }
}