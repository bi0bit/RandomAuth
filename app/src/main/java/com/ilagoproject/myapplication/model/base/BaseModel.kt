package com.ilagoproject.myapplication.model.base

import android.content.SharedPreferences
import com.ilagoproject.myapplication.model.data.AccountData
import javax.inject.Inject

abstract class BaseModel {

    val isAuthSaved: Boolean
        get() = accountData != null

    var accountData: AccountData? = null

    var isRememberMe: Boolean = false
        protected set

    var isInit = false
        protected set

    open fun init() {
        if(isInit.not()){
            loadData()
            isInit = true
        }
    }

    abstract fun loadData()

    abstract fun saveData()

    abstract fun setIsRemember(isRemember: Boolean)

    abstract fun clearSavedData()


}