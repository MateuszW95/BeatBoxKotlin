package com.bignerdranch.android.beatboxkotlin.Models

import android.databinding.*
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import org.jetbrains.annotations.NotNull

class BeatBoxViewModel(var mBeatBox: BeatBox):BaseObservable() {


    var progress:Int=(mBeatBox.mRange*66.67).toInt()
    @Bindable set(value){field=value;notifyChange()}
    @Bindable get()=field

//    @NotNull
//    @InverseBindingAdapter(attribute = "progress")
//     fun  SeekBar.getProgress():Int{
//        return this.progress
//    }
//
//
//
//
//    @BindingAdapter(value = ["progressAttrChanged"])
//    fun setListeners(seekBar: SeekBar,inverseBindingListener: InverseBindingListener){
//        var listener=object: SeekBar.OnSeekBarChangeListener{
//            override fun onProgressChanged(seekBar: SeekBar?, Progress: Int, fromUser: Boolean) {
//                progress=Progress
//                mBeatBox.mRange=progress/66.67 as Float
//                inverseBindingListener.onChange()
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//
//            }
//        }
//        seekBar.setOnSeekBarChangeListener(listener)
//    }

    fun getEditListener():SeekBar.OnSeekBarChangeListener{
        var listener=object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, Progress: Int, fromUser: Boolean) {
                progress=Progress
                mBeatBox.mRange=(progress/66.67).toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        }
        return listener
    }


}