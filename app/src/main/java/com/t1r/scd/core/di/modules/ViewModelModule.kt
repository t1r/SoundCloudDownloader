package com.t1r.scd.core.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.t1r.scd.core.di.key.ViewModelKey
import com.t1r.scd.core.factory.ViewModelOwnerFactory
import com.t1r.scd.presentation.searchtrack.SearchTrackViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelOwnerFactory(factory: ViewModelOwnerFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchTrackViewModel::class)
    abstract fun bindsSearchTrackViewModel(viewModel: SearchTrackViewModel): ViewModel
}