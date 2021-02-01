package com.sample.libraryapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sample.libraryapplication.database.dao.ContactDAO
import com.sample.libraryapplication.database.dao.AccountDAO
import com.sample.libraryapplication.database.dao.ExtensionDAO
import com.sample.libraryapplication.database.entity.AccountEntity
import com.sample.libraryapplication.database.entity.ContactEntity
import com.sample.libraryapplication.database.entity.ExtensionEntity

@Database(entities = [ContactEntity::class, ExtensionEntity::class, AccountEntity::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun getContactDao(): ContactDAO
    abstract fun getExtensionDao(): ExtensionDAO
    abstract fun getAccountDao(): AccountDAO
}