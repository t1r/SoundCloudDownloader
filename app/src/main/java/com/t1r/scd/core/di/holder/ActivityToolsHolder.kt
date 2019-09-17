package com.t1r.scd.core.di.holder

import com.t1r.scd.core.di.provider.MainActivityToolsProvider

interface ActivityToolsHolder {
    fun getActivityToolsProvider(): MainActivityToolsProvider
}
