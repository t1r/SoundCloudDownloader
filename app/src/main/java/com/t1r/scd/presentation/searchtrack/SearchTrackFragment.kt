package com.t1r.scd.presentation.searchtrack

import android.os.Bundle
import com.t1r.scd.R
import com.t1r.scd.core.utils.Failure
import com.t1r.scd.presentation.common.BaseFragment
import com.t1r.scd.presentation.extension.observe
import com.t1r.scd.presentation.extension.failure
import com.t1r.scd.presentation.extension.viewModel
import kotlinx.android.synthetic.main.fragment_search_track.*

class SearchTrackFragment : BaseFragment() {

    private lateinit var searchTrackViewModel: SearchTrackViewModel

    override fun layoutId(): Int = R.layout.fragment_search_track

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        searchTrackViewModel = viewModel(viewModelFactory) {
            observe(list, ::displayItem)
            failure(failure, ::displayFailure)
        }
    }

    private fun displayItem(list: List<Int>?) {
        result.text = list.toString()
    }

    private fun displayFailure(failure: Failure?) {

    }

    companion object{
        fun newInstance() : SearchTrackFragment = SearchTrackFragment()
    }
}