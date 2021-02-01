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

@Entity(tableName = "contacts_table")
class ContactEntity() {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Long =0

    @ColumnInfo(name = "contact_id")
    var contactId: String? = null

    @ColumnInfo(name = "staging_id")
    var stagingId: String? = null

    constructor(id: Long, contactId: String?, stagingId: String?) : this() {
        this.id = id
        this.contactId = contactId
        this.stagingId = stagingId
    }

    override fun toString(): String {
        return contactId!!
    }
}