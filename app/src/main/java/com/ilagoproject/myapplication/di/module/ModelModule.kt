package com.ilagoproject.myapplication.di.module

import android.content.SharedPreferences
import com.ilagoproject.myapplication.di.scope.AppScope
import com.ilagoproject.myapplication.model.AppModel
import dagger.Module
import dagger.Provides

@Module
class ModelModule {

    @AppScope
    @Provides
    fun provideModule(sharedPreferences: SharedPreferences) = AppModel(sharedPreferences)

}