package com.t1r.scd.presentation.main

import android.graphics.Rect
import android.os.Bundle
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.t1r.scd.R
import com.t1r.scd.core.navigation.AppLauncher
import com.t1r.scd.core.utils.extension.doOnApplyWindowInsets
import com.t1r.scd.presentation.common.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var appLauncher: AppLauncher

    override val navigator: Navigator =
        object : SupportAppNavigator(this, supportFragmentManager, R.id.main_container) {
            override fun setupFragmentTransaction(
                command: Command,
                currentFragment: Fragment?,
                nextFragment: Fragment,
                fragmentTransaction: FragmentTransaction
            ) {
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) coldStart()
        applyInsets()
    }

    fun coldStart() = appLauncher.coldStart()

    private fun applyInsets() {
        main_container.doOnApplyWindowInsets { view, insets, initialPadding ->
            view.updatePadding(
                left = initialPadding.left + insets.systemWindowInsetLeft,
                right = initialPadding.right + insets.systemWindowInsetRight
            )
            insets.replaceSystemWindowInsets(
                Rect(
                    0,
                    insets.systemWindowInsetTop,
                    0,
                    insets.systemWindowInsetBottom
                )
            )
        }
    }
}