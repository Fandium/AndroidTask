package com.abba.androidtask.util

import android.content.Context
import android.content.SharedPreferences

class SSP {
    lateinit var sharedPreferences: SharedPreferences
    val PREFS_NAME = "AndroidTask"
    val value = "vip_value"

    fun getItemStatus(context: Context): Boolean {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(value, true)
    }

    fun setItemStatus(context: Context, boolean: Boolean) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean(value, boolean)
        editor.apply()
    }
}