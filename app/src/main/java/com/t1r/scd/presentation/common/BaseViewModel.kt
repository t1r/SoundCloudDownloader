package com.t1r.scd.presentation.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.t1r.scd.core.utils.type.Failure

abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
}