package com.t1r.scd.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.t1r.scd.R
import com.t1r.scd.presentation.searchtrack.SearchTrackFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchTrackFragment.newInstance())
                .commitNow()
        }
    }

}
