package com.t1r.scd.core.navigation

import com.t1r.scd.core.di.modules.ActivityNavigation
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class AppLauncher @Inject constructor(
    @ActivityNavigation private val mainRouter: Router
) {

    fun coldStart() {
        mainRouter.newRootScreen(Screens.SearchTrack)
    }
}