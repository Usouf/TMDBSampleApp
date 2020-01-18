package com.usoof.tmdbapp.ui.movies

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import androidx.recyclerview.widget.RecyclerView

class MovieRecyclerItemClickListener(
    context: Context,
    private val recyclerView: RecyclerView,
    private val listener: OnMovieRecyclerClickListener
) : RecyclerView.SimpleOnItemTouchListener() {

    var gestureDetectorCompat: GestureDetectorCompat

    init {
        gestureDetectorCompat = GestureDetectorCompat(context, object: GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
                val childView = recyclerView.findChildViewUnder(e!!.x, e.y)
                if (childView != null) {
                    listener.onMovieItemClick(childView, recyclerView.getChildAdapterPosition(childView))
                }
                return true
            }
        })
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean = gestureDetectorCompat.onTouchEvent(e)

    interface OnMovieRecyclerClickListener {
        fun onMovieItemClick(view: View, position: Int)
    }

}