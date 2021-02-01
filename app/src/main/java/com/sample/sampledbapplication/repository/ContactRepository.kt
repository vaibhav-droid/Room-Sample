package com.sample.sampledbapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sample.libraryapplication.database.ContactDatabase
import com.sample.libraryapplication.database.entity.ContactEntity
import com.sample.sampledbapplication.database.entity.ContactData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactRepository(contactDatabase: ContactDatabase) {

    private var contactDAO = contactDatabase.getContactDao()

    fun getContacts(): LiveData<List<ContactEntity>> {
        return contactDAO.getContacts()
    }

    fun getContactsDetails(contactId : String): LiveData<ContactData> {
        return contactDAO.getContactInfo(contactId)
    }
}