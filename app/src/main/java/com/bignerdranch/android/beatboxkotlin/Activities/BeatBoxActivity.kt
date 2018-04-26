package com.bignerdranch.android.beatboxkotlin.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.bignerdranch.android.beatboxkotlin.Fragments.BeatBoxFragment
import com.bignerdranch.android.beatboxkotlin.R

class BeatBoxActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return BeatBoxFragment.newInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}
