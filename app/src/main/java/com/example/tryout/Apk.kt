package com.example.tryout

import android.app.Application

class Apk : Application (){
    companion object {
        lateinit var instance: Apk
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
    }
}