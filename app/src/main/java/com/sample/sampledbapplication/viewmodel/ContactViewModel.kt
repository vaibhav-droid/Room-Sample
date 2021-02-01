package com.sample.sampledbapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.libraryapplication.database.entity.ContactEntity
import com.sample.sampledbapplication.database.entity.ContactData
import com.sample.sampledbapplication.repository.ContactRepository

class ContactViewModel(private var contactRepository: ContactRepository) : ViewModel() {


    val allContactEntity: LiveData<List<ContactEntity>> = contactRepository.getContacts()

    fun getContactData(contactId: String): LiveData<ContactData> {
       return contactRepository.getContactsDetails(contactId)
    }
}