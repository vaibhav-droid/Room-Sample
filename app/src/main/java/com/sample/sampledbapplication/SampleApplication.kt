package com.sample.sampledbapplication

import android.app.Application
import com.sample.sampledbapplication.di.component.AppComponent
import com.sample.libraryapplication.dagger.module.RoomDatabaseModule
import com.sample.sampledbapplication.di.component.DaggerAppComponent

open class SampleApplication: Application() {

    companion object {
        lateinit var instance: SampleApplication
    }
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent
            .builder()
            .roomDatabaseModule(RoomDatabaseModule(this))
            .build()
    }

}