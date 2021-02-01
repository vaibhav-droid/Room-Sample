package com.sample.sampledbapplication.di.component

import com.sample.sampledbapplication.di.module.ContactModule
import com.sample.libraryapplication.dagger.module.RoomDatabaseModule
import com.sample.sampledbapplication.view.ui.activities.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RoomDatabaseModule::class, ContactModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}