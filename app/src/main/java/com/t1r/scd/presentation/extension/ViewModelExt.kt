package com.t1r.scd.presentation.extension

import androidx.lifecycle.viewModelScope
import com.t1r.scd.presentation.common.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

fun BaseViewModel.launch(block: suspend CoroutineScope.() -> Unit) =
    viewModelScope.launch { block.invoke(this) }

fun <T> BaseViewModel.async(block: suspend CoroutineScope.() -> T): Deferred<T> =
    viewModelScope.async { block.invoke(this) }
