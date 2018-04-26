package com.bignerdranch.android.beatboxkotlin.Models

/**
 * Created by mateusz on 24.04.18.
 */
class Sound(assetPath:String) {
    private var mAssetPath=assetPath
    var mName:String

    init {
        var components=(mAssetPath.split("/"))
        var fileName=components.get(components.lastIndex) as String
        mName=fileName.replace(".wav","")
    }


}