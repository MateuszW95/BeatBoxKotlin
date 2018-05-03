package com.bignerdranch.android.beatboxkotlin.Models

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR

/**
 * Created by mateusz on 24.04.18.
 */
open class SoundViewModel(beatBox: BeatBox): BaseObservable() {

    var mSound: Sound= Sound("")
    @Bindable set(value) {field=value;notifyPropertyChanged(BR.title)}
    @Bindable get() =field

    private var mBeatBox: BeatBox=beatBox
//    fun setSound(sound: Sound){
//        mSound=sound
//        notifyChange()
//    }
    @Bindable
    fun getTitle():String{
        return mSound!!.mName
    }

    fun play(){
        mBeatBox.play(mSound)
    }

    fun playSound() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}