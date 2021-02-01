package com.sample.libraryapplication.database.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.sample.libraryapplication.database.entity.ContactEntity
import com.sample.sampledbapplication.database.entity.ContactData

@Dao
interface ContactDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addContact(contact: ContactEntity) : Long

    @Query("SELECT * FROM contacts_table")
    fun getContacts() : LiveData<List<ContactEntity>>

   /* @Transaction
    @Query("SELECT * FROM contacts_table WHERE contact_id= :contactId")
    fun getContactDetails(contactId: Long): LiveData<ContactData>*/

    @Query("select account_table.context_id as context_id, account_table.user_id as user_id, account_table.status as status, contacts_table.* from account_table LEFT OUTER JOIN extensions_table on extensions_table.account_context_id = account_table.context_id LEFT OUTER JOIN contacts_table on extensions_table.account_id = contacts_table.id WHERE contacts_table.contact_id = :contactId")
    fun getContactInfo(contactId: String): LiveData<ContactData>
}