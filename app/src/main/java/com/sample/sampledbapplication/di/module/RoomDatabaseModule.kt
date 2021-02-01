package com.sample.libraryapplication.dagger.module

import android.app.Application
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sample.libraryapplication.database.ContactDatabase
import com.sample.libraryapplication.database.entity.AccountEntity
import com.sample.libraryapplication.database.entity.ContactEntity
import com.sample.libraryapplication.database.entity.ExtensionEntity
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
class RoomDatabaseModule(application: Application) {

    private var contactApplication = application
    private lateinit var contactDatabase: ContactDatabase

    private val databaseCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            CoroutineScope(Dispatchers.IO).launch {
                addSampleBooksToDatabase()
            }
        }
    }

    private fun addSampleBooksToDatabase() {
        val contact1 = ContactEntity(2, "48f3", "1196")
        val contact2 = ContactEntity(3, "3e47", "f1fe")
        val contact3 = ContactEntity(4, "2cac", "036e")

        val extension1 = ExtensionEntity(2, "Gmail")
        val extension2 = ExtensionEntity(3, "Gmail")
        val extension3 = ExtensionEntity(4, "Gmail1")

        val account1 = AccountEntity("1", "test_one@gmail.com","Gmail")
        val account2 = AccountEntity("0", "test_two@gmail.com","Gmail1")

        val contactDAO = contactDatabase.getContactDao()
        contactDAO.addContact(contact1)
        contactDAO.addContact(contact2)
        contactDAO.addContact(contact3)

        val accountDAO = contactDatabase.getAccountDao()
        accountDAO.addAccount(account1)
        accountDAO.addAccount(account2)

        val extensionDAO = contactDatabase.getExtensionDao()
        extensionDAO.addExtension(extension1)
        extensionDAO.addExtension(extension2)
        extensionDAO.addExtension(extension3)
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(): ContactDatabase {
        contactDatabase = Room.databaseBuilder(contactApplication, ContactDatabase::class.java, "contact_database")
            .fallbackToDestructiveMigration()
            .addCallback(databaseCallback)
            .build()
        return contactDatabase
    }

    @Singleton
    @Provides
    fun providesContactDAO(libraryDatabase: ContactDatabase) = libraryDatabase.getContactDao()

    @Singleton
    @Provides
    fun providesExtensionDAO(libraryDatabase: ContactDatabase) = libraryDatabase.getExtensionDao()

    @Singleton
    @Provides
    fun providesAccountDAO(libraryDatabase: ContactDatabase) = libraryDatabase.getAccountDao()
}