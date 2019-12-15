package com.t1r.scd.presentation.searchtrack

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.t1r.scd.core.utils.extension.either
import com.t1r.scd.data.api.model.SearchedTrack
import com.t1r.scd.domain.searchtrack.SearchTrackInteractor
import com.t1r.scd.presentation.common.BaseViewModel
import com.t1r.scd.presentation.extension.launch
import javax.inject.Inject

class SearchTrackViewModel @Inject constructor(
    private val searchTrackInteractor: SearchTrackInteractor
) : BaseViewModel() {

    internal val list = MutableLiveData<List<Int>>()

    init {
        firstLoad()
    }

    private fun firstLoad() {
        launch {
            searchTrackInteractor.searchTrack("rhcp")
                .either(::handleFailure,::handleSearchedTrackResult)
        }
    }

    private fun handleSearchedTrackResult(result: SearchedTrack) {
        Log.d("dsad","$result")
    }
}