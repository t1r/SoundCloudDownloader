package com.t1r.scd.core.di

import android.content.Context
import com.t1r.scd.core.di.provider.AppProvider

interface App {
    fun getApplicationContext(): Context
    fun getAppComponent(): AppProvider
}
