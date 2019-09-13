package com.t1r.scd.presentation.searchtrack

import android.os.Bundle
import com.t1r.scd.R
import com.t1r.scd.presentation.common.BaseFragment

class SearchTrackFragment : BaseFragment() {

    private lateinit var searchTrackViewModel: SearchTrackViewModel

    override fun layoutId(): Int = R.layout.fragment_search_track

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

    companion object{
        fun newInstance() : SearchTrackFragment = SearchTrackFragment()
    }
}