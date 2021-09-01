package com.ilagoproject.myapplication.viewmodel

import androidx.navigation.fragment.findNavController
import com.ilagoproject.myapplication.R
import com.ilagoproject.myapplication.viewmodel.base.AppViewModelFragment

open class AccountViewModelFragment : AppViewModelFragment(){
    open fun signOut() {
        model.clearSavedData()
        goToPage(R.id.authorizationFragment)
    }

}