package com.ilagoproject.myapplication.service

import com.ilagoproject.myapplication.model.data.AccountData
import kotlin.random.Random
import android.content.Context
import com.ilagoproject.myapplication.service.error.Disconnect
import com.ilagoproject.myapplication.utils.isOnline
import io.reactivex.rxjava3.core.Single

class RandomAuthorization(var context: Context, accountData: AccountData? = null) : Authorization(accountData) {
    override fun startAuthorization(): Single<Boolean> {
       return Single.fromCallable {
           Thread.sleep(3000)
           Random.nextInt(0, 100) % 2 == 0
       }
       .flatMap { // Error if connection was interrupt
            if(context.isOnline().not())
                Single.error<Disconnect>(Disconnect())
            Single.just(it)
       }
    }
}