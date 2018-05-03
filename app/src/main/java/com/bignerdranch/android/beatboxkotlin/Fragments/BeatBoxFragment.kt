package com.bignerdranch.android.beatboxkotlin.Fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bignerdranch.android.beatboxkotlin.Models.BeatBox
import com.bignerdranch.android.beatboxkotlin.Models.BeatBoxViewModel
import com.bignerdranch.android.beatboxkotlin.Models.Sound
import com.bignerdranch.android.beatboxkotlin.Models.SoundViewModel
import com.bignerdranch.android.beatboxkotlin.databinding.FragmentBeatBoxBinding
import com.bignerdranch.android.beatboxkotlin.R
import com.bignerdranch.android.beatboxkotlin.databinding.ListItemSoundBinding

/**
 * Created by mateusz on 24.04.18.
 */
class BeatBoxFragment: Fragment() {

    companion object {
        fun newInstance():BeatBoxFragment{
            return BeatBoxFragment()
        }
    }

    private lateinit var mBeatBox: BeatBox

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       var binding=DataBindingUtil.inflate<FragmentBeatBoxBinding>(inflater!!,R.layout.fragment_beat_box,container,false)
        var layoutManager=GridLayoutManager(activity,3)

        binding.recyclerView.layoutManager=(layoutManager)
        binding.recyclerView.adapter=SoundAdapter(mBeatBox.mSounds)
        binding.recyclerView.addItemDecoration(com.bignerdranch.android.beatboxkotlin.Models.DividerItemDecoration(2))

        binding.viewModel= BeatBoxViewModel(mBeatBox)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance=true
        mBeatBox= BeatBox(activity)
    }

    override fun onDestroy() {
        super.onDestroy()
        mBeatBox.release()
    }

    private inner class SoundHolder(binding:ListItemSoundBinding):RecyclerView.ViewHolder(binding.root){
        private var mBinding: ListItemSoundBinding = binding

        init {
            mBinding.viewModel= SoundViewModel(mBeatBox)
        }

        fun bind(sound: Sound){
            mBinding.viewModel!!.mSound=(sound)
            mBinding.executePendingBindings()
        }

    }

    private inner class SoundAdapter(sounds:ArrayList<Sound>):RecyclerView.Adapter<SoundHolder>(){
        private var mSounds=sounds


        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SoundHolder {
            val inflater=LayoutInflater.from(activity)
            val binding=DataBindingUtil.inflate<ListItemSoundBinding>(inflater,R.layout.list_item_sound,parent,false)

            return SoundHolder(binding)
        }

        override fun getItemCount(): Int {
             return mSounds.size
        }

        override fun onBindViewHolder(holder: SoundHolder?, position: Int) {
            holder!!.bind(mSounds[position])

        }

    }
}