package com.ilagoproject.myapplication.service

import com.ilagoproject.myapplication.model.data.AccountData
import io.reactivex.rxjava3.core.Single

abstract class Authorization(var accountData: AccountData? = null) {
    open fun setAccountData(accountData: AccountData?) : Authorization
    {
        this.accountData = accountData
        return this
    }

    abstract fun startAuthorization() : Single<Boolean>
}