package com.ilagoproject.myapplication.di.component

import android.content.SharedPreferences
import com.ilagoproject.myapplication.di.module.ModelModule
import com.ilagoproject.myapplication.di.scope.AppScope
import com.ilagoproject.myapplication.viewmodel.base.AppViewModelActivity
import com.ilagoproject.myapplication.viewmodel.base.AppViewModelFragment
import dagger.BindsInstance
import dagger.Component
import kotlin.reflect.typeOf

@AppScope
@Component(modules = [ModelModule::class])
interface ModelComponent {

    fun inject(viewModel: AppViewModelActivity)
    fun inject(viewModel: AppViewModelFragment)

    @Component.Builder
    interface Builder{
        @BindsInstance fun setSharedPreference(sharedPreferences: SharedPreferences):Builder
        fun build():ModelComponent
    }
}