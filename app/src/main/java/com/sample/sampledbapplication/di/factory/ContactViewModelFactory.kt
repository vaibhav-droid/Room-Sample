package com.sample.libraryapplication.dagger.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.sampledbapplication.repository.ContactRepository
import com.sample.sampledbapplication.viewmodel.ContactViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactViewModelFactory @Inject
constructor(private var contactRepository: ContactRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ContactViewModel(contactRepository)  as T
    }
}