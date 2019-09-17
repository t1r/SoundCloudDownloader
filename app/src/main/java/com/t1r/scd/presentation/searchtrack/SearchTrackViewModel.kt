package com.t1r.scd.presentation.searchtrack

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.t1r.scd.presentation.common.BaseViewModel
import java.util.*
import javax.inject.Inject

class SearchTrackViewModel @Inject constructor() : BaseViewModel() {

    internal val list = MutableLiveData<List<Int>>()

    init {
        firstLoad()
    }

    private fun firstLoad() {
        val item = Random().nextInt()
        Log.d("TAG", item.toString())
        list.value = listOf(item)
    }
}