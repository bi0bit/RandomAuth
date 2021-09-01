package com.ilagoproject.myapplication.viewmodel.base

import android.os.Bundle
import com.ilagoproject.myapplication.App
import com.ilagoproject.myapplication.model.AppModel

open class AppViewModelFragment : BaseViewModelFragment<AppModel>(){
    override fun onCreate(savedInstanceState: Bundle?) {
        App.modelComponent.inject(this)
        super.onCreate(savedInstanceState)
    }
}