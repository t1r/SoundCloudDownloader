package com.t1r.scd.presentation.searchtrack

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.t1r.scd.domain.searchtrack.SearchTrackInteractor
import com.t1r.scd.presentation.common.BaseViewModel
import java.util.*
import javax.inject.Inject

class SearchTrackViewModel @Inject constructor(
    private val searchTrackInteractor: SearchTrackInteractor
) : BaseViewModel() {

    internal val list = MutableLiveData<List<Int>>()

    init {
        firstLoad()
    }

    private fun firstLoad() {
//        searchTrackInteractor.searchTrack()
    }
}