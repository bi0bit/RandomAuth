package com.ilagoproject.myapplication.model

import com.ilagoproject.myapplication.model.base.BaseModel
import android.content.SharedPreferences
import com.ilagoproject.myapplication.model.data.AccountData

class AppModel(var sharedPreferences: SharedPreferences) : BaseModel() {

    override fun init() {
        if(isInit.not()){
            isRememberMe = sharedPreferences.getBoolean("isRemember", false)
            loadData()
            isInit = true
        }
    }

    override fun loadData() {
        val login = sharedPreferences.getString("login", null)
        val password = sharedPreferences.getString("password", null)

        isRememberMe = sharedPreferences.getBoolean("isRemember", false)

        if(login != null && password != null)
            accountData = AccountData(login, password)
    }

    override fun saveData() {
        if(accountData != null){
            sharedPreferences.edit()
                .putString("login", accountData?.login)
                .putString("password", accountData?.password)
                .apply()
        }
    }

    override fun setIsRemember(isRemember: Boolean) {
        isRememberMe = isRemember
        sharedPreferences.edit()
            .putBoolean("isRemember", isRememberMe)
            .apply()
    }

    override fun clearSavedData() {
        sharedPreferences.edit().clear().apply()
        accountData = null
    }

}