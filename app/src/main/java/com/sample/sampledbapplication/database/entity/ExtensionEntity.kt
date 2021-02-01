package com.sample.libraryapplication.database.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "extensions_table", primaryKeys = ["account_id", "account_context_id"],
 foreignKeys = [ForeignKey(entity = ContactEntity::class, parentColumns = ["id"], childColumns = ["account_id"], onDelete = ForeignKey.CASCADE), ForeignKey(entity = AccountEntity::class, parentColumns = ["context_id"], childColumns = ["account_context_id"], onDelete = ForeignKey.CASCADE) ])
data class  ExtensionEntity(
    var account_id: Long,
    var account_context_id: String) {

}