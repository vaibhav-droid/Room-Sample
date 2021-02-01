package com.sample.libraryapplication.database.entity

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "account_table")
class AccountEntity() {

    @ColumnInfo(name = "status")
    var status: String? = null

    @ColumnInfo(name = "user_id")
    var userId: String? = null

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "context_id")
    var contextId: String = ""

    constructor(status: String?, userId: String?, contextId: String) : this() {
        this.status = status
        this.userId = userId
        this.contextId = contextId
    }
}