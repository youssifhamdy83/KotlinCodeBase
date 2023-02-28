package com.ultimate.ultimatecodebase.utils

import android.content.Context
import javax.inject.Inject


/**
 * Created by Youssif Hamdy on 1/31/2023.
 */

class AppPreference @Inject constructor() {


    fun setSharedPreferenceString(context: Context, key: String?, value: String?) {
        val settings = context.getSharedPreferences(
            "PREF_FILE",
            0
        )
        val editor = settings.edit()
        editor.putString(key, value)
        editor.apply()
    }


    fun setSharedPreferenceInt(context: Context, key: String?, value: Int) {
        val settings = context.getSharedPreferences(
            "PREF_FILE",
            0
        )
        val editor = settings.edit()
        editor.putInt(key, value)
        editor.apply()
    }


    fun setSharedPreferenceBoolean(context: Context, key: String?, value: Boolean) {
        val settings = context.getSharedPreferences(
            "PREF_FILE",
            0
        )
        val editor = settings.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }


    fun getSharedPreferenceString(context: Context, key: String?, defValue: String?): String? {
        val settings = context.getSharedPreferences(
            "PREF_FILE",
            0
        )
        return settings.getString(key, defValue)
    }


    fun getSharedPreferenceInt(context: Context, key: String?, defValue: Int): Int {
        val settings = context.getSharedPreferences(
            "PREF_FILE",
            0
        )
        return settings.getInt(key, defValue)
    }


    fun getSharedPreferenceBoolean(context: Context, key: String?, defValue: Boolean): Boolean {
        val settings = context.getSharedPreferences(
            "PREF_FILE",
            0
        )
        return settings.getBoolean(key, defValue)
    }


}