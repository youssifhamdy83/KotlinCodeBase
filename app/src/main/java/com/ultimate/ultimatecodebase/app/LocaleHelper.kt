package com.ultimate.ultimatecodebase.app

import android.content.Context
import android.content.res.Configuration
import com.ultimate.ultimatecodebase.utils.AppPreference
import com.ultimate.ultimatecodebase.utils.Keys
import java.util.*


/**
 * Created by Youssif Hamdy on 2/1/2023.
 */
class LocaleHelper {

    companion object {

        fun setLocale(context: Context, appPreference: AppPreference): Context? {
            val language = appPreference.getSharedPreferenceString(
                context,
                Keys.LANGUAGE.keyString,
                Locale.getDefault().language
            )
            return language?.let { updateResources(context, it) }
        }

        private fun updateResources(context: Context, language: String): Context? {
            val locale = Locale(language)
            Locale.setDefault(locale)
            val res = context.resources
            val config = Configuration(res.configuration)
            config.setLocale(locale)
            return context.createConfigurationContext(config)
        }


    }



}