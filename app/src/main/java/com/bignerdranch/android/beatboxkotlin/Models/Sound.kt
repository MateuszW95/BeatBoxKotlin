package com.bignerdranch.android.beatboxkotlin.Models

/**
 * Created by mateusz on 24.04.18.
 */
class Sound(assetPath:String) {
    var mAssetPath=assetPath
    var mSoundId:Int = 0
    var mName:String

    init {
        var components=(mAssetPath.split("/"))
        var fileName=components.get(components.lastIndex) as String
        mName=fileName.replace(".wav","")
    }


}