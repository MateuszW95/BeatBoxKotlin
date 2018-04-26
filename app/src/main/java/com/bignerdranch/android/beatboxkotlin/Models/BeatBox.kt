package com.bignerdranch.android.beatboxkotlin.Models

import android.content.Context
import android.content.res.AssetManager
import android.util.Log

/**
 * Created by mateusz on 24.04.18.
 */
class BeatBox(context: Context) {
    companion object {
        private val TAG:String="BeatBox"
        private val SOUNDS_FOLDER="sample_sounds"
    }

    private val mAssets:AssetManager=context.assets
    val mSounds=ArrayList<Sound>()

    init {
        loadSounds()
    }

    private fun loadSounds(){
        var soundNames:Array<String>
        try{
             soundNames= arrayOf(*mAssets.list(SOUNDS_FOLDER))
            Log.i(TAG,"Znaleziono "+soundNames.size+" dźwięków")
        }
        catch (e:Exception) {
            Log.e(TAG, "Błąd")
            return
        }
        for (i in soundNames){
            mSounds.add(Sound("$SOUNDS_FOLDER/$i"))
        }
    }

}