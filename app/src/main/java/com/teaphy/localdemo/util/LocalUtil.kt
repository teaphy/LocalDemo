package com.teaphy.localdemo.util

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import android.util.Log
import com.teaphy.localdemo.R
import java.util.*


class LocalUtil {
    companion object {
        private const val TAG = "LocalManageUtil"

        /**
         * 获取系统的locale
         *
         * @return Locale对象
         */
        fun getSystemLocale(context: Context): Locale {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                LocaleList.getDefault()[0]
            } else {
                Locale.getDefault()
            }
        }

        fun getSelectLanguage(context: Context): String {
            return when (SPUtil.getInstance(context).selectLanguage) {
                0 -> context.getString(R.string.local_china)
                1 -> context.getString(R.string.local_english)
                2 -> context.getString(R.string.local_japan)
                else -> context.getString(R.string.local_china)
            }
        }

        /**
         * 获取选择的语言设置
         *
         * @param context
         * @return
         */
        fun getSetLanguageLocale(context: Context): Locale {
            return when (SPUtil.getInstance(context).selectLanguage) {
                0 -> Locale.CHINA
                1 -> Locale.ENGLISH
                2 -> Locale.JAPAN
                else -> Locale.CHINA
            }
        }

        fun setLocal(context: Context): Context {
           return updateResources(context, getSetLanguageLocale(context))
        }

        private fun updateResources(
            context: Context,
            locale: Locale
        ) : Context {

            Log.e("teaphy", "local: $locale")

//            Locale.setDefault(locale)

            val res: Resources = context.resources
            val config = res.configuration
            config.setLocale(locale)
            config.setLocales(LocaleList(locale))
            //            res.updateConfiguration(config, metrics)
            return context.createConfigurationContext(config);
        }

        /**
         * 保存系统语言
         * @param context
         * @param newConfig
         */
        fun saveSystemCurrentLanguage(
            context: Context?,
            newConfig: Configuration?
        ) {

        }

        fun saveSelectLanguage(context: Context, select: Int) {
            SPUtil.getInstance(context).saveLanguage(select)
            setLocal(context)
        }
    }
}