package com.sample.libraryapplication.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sample.libraryapplication.database.entity.ExtensionEntity

@Dao
interface ExtensionDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addExtension(extension: ExtensionEntity) : Long
}