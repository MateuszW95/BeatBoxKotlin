package com.bignerdranch.android.beatboxkotlin.Models

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.AudioManager
import android.media.SoundPool
import android.util.Log
import java.io.IOException

/**
 * Created by mateusz on 24.04.18.
 */
class BeatBox(context: Context) {
    companion object {
        private const val TAG:String="BeatBox"
        private const val SOUNDS_FOLDER="sample_sounds"
        private const val MAX_SOUNDS:Int=5
    }

    private val mAssets:AssetManager=context.assets
    val mSounds=ArrayList<Sound>()
    private var  mSoundPool:SoundPool
    var mRange:Float=1.0f


    init {
        mSoundPool= SoundPool(MAX_SOUNDS,AudioManager.STREAM_MUSIC,0)
        loadSounds()
    }

    private fun loadSounds(){
        var soundNames:Array<String>
        try{
             soundNames= arrayOf(*mAssets.list(SOUNDS_FOLDER))
            Log.i(TAG,"Znaleziono "+soundNames.size+" dźwięków")
        }
        catch (e:Exception) {
            Log.e(TAG, "Błąd",e)
            return
        }
        for (i in soundNames){
            try {
                val sound=Sound("$SOUNDS_FOLDER/$i")
                load(sound)
                mSounds.add(sound)
            }
            catch (e:IOException){
                Log.e(TAG, "Błąd",e)
            }

        }
    }
    @Throws(IOException::class)
    private fun load(sound: Sound) {
        val afd:AssetFileDescriptor=mAssets.openFd(sound.mAssetPath)
        val soundId=mSoundPool.load(afd,1)
        sound.mSoundId=soundId
    }

    fun play(sound: Sound){
        val soundId: Int = sound.mSoundId ?: return

        mSoundPool.play(soundId!!,1.0f,1.0f,1,0,mRange)

    }

    fun release(){
        mSoundPool.release()
    }

}