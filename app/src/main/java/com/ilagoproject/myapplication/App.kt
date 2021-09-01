package com.ilagoproject.myapplication

import android.app.Application
import androidx.preference.PreferenceManager
import com.ilagoproject.myapplication.di.component.DaggerModelComponent
import com.ilagoproject.myapplication.di.component.ModelComponent


class App : Application() {

    companion object{
        lateinit var modelComponent:ModelComponent
    }

    override fun onCreate() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        modelComponent = DaggerModelComponent.builder()
            .setSharedPreference(sharedPreferences)
            .build()

        super.onCreate()
    }
}