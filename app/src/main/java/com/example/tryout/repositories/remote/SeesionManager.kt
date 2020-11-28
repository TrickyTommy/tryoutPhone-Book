package com.example.tryout.repositories.remote

import android.content.Context
import android.content.SharedPreferences
import com.example.tryout.R

class SeesionManager (context: Context){
    private var prefs: SharedPreferences=context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
}