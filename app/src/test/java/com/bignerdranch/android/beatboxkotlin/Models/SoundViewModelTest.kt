package com.bignerdranch.android.beatboxkotlin.Models

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.junit.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.junit.Before


import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SoundViewModelTest {

    lateinit var mBeatBox: BeatBox
    lateinit var mSound: Sound
    lateinit var subject:SoundViewModel
    @Before
    fun setUp() {
        mBeatBox= mock(BeatBox::class.java)
        mSound= Sound("assetPath")
        subject= SoundViewModel(mBeatBox)
        subject.mSound=mSound
    }
    @Test
    fun exposeSoundNameAsTitle(){
        assertThat(subject.getTitle(),`is`(mSound.mName))
    }

    @Test
    fun callsBeatBoxPlayButtonClicked(){
        subject.play()
        verify(mBeatBox).play(mSound)

    }
}