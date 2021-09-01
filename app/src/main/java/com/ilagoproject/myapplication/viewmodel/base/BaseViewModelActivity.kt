package com.ilagoproject.myapplication.viewmodel.base

import com.ilagoproject.myapplication.model.base.BaseModel
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ilagoproject.myapplication.App
import javax.inject.Inject

abstract class BaseViewModelActivity<T> : AppCompatActivity() where T : BaseModel {

    @Inject
    lateinit var model: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model.init()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}