package com.sample.sampledbapplication.di.module

import com.sample.libraryapplication.database.ContactDatabase
import com.sample.sampledbapplication.repository.ContactRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContactModule {

    @Singleton
    @Provides
    fun providesContactRepository(database: ContactDatabase): ContactRepository {
        return ContactRepository(database)
    }

}