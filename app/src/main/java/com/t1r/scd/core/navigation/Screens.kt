package com.t1r.scd.core.navigation

import com.t1r.scd.presentation.searchtrack.SearchTrackFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object SearchTrack : SupportAppScreen() {
        override fun getFragment() = SearchTrackFragment()
    }
}