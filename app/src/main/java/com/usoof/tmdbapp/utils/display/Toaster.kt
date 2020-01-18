package com.usoof.tmdbapp.utils.display

import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.os.Build
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.usoof.tmdbapp.R

object Toaster {
    fun show(context: Context, text: CharSequence) {
        val toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            toast.view.background.colorFilter = BlendModeColorFilter(R.color.white, BlendMode.SRC_ATOP)
        } else {
            toast.view.background.setColorFilter(
                ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.SRC_IN
            )
        }

        val textView = toast.view.findViewById(android.R.id.message) as TextView
        textView.setTextColor(ContextCompat.getColor(context, R.color.black))
        toast.show()
    }
}