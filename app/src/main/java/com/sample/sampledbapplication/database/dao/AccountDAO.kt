package com.sample.libraryapplication.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sample.libraryapplication.database.entity.AccountEntity
import com.sample.libraryapplication.database.entity.ExtensionEntity

@Dao
interface AccountDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAccount(account: AccountEntity) : Long
}