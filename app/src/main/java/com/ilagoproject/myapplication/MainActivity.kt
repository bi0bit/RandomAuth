package com.ilagoproject.myapplication

import android.os.Bundle
import com.ilagoproject.myapplication.viewmodel.base.AppViewModelActivity

class MainActivity : AppViewModelActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}