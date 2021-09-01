package com.ilagoproject.myapplication.viewmodel.base

import com.ilagoproject.myapplication.model.base.BaseModel
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ilagoproject.myapplication.App
import javax.inject.Inject

abstract class BaseViewModelFragment<T> : Fragment() where T : BaseModel {

    @Inject
    lateinit var model: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model.init()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun goToPage(id: Int){
        findNavController().navigate(id)
    }
}