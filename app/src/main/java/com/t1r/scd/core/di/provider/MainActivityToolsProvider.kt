package com.t1r.scd.core.di.provider

import android.view.Display
import androidx.lifecycle.ViewModelProvider

interface MainActivityToolsProvider {
    fun provideViewModelFactory(): ViewModelProvider.Factory
}
