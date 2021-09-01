package com.ilagoproject.myapplication.service.error

class Disconnect : Throwable() {
    override val message: String?
        get() = "Internet connection was interrupt"
}