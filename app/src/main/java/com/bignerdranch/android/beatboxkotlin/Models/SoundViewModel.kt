package com.bignerdranch.android.beatboxkotlin.Models

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR

/**
 * Created by mateusz on 24.04.18.
 */
class SoundViewModel(beatBox: BeatBox): BaseObservable() {
    lateinit var mSound: Sound

    private var mBeatBox: BeatBox=beatBox
    fun setSound(sound: Sound){
        mSound=sound
        notifyChange()
    }
    @Bindable
    fun getTitle():String{
        return mSound!!.mName
    }
}