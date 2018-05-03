package com.bignerdranch.android.beatboxkotlin.Models

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class DividerItemDecoration(var space:Int):RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        outRect!!.bottom=space
        outRect!!.top=space
        outRect!!.left=space
        outRect!!.right=space
    }
}