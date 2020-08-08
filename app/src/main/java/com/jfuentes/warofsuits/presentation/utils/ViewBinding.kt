package com.jfuentes.warofsuits.presentation.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableInt

/**
 * Created by Juan Fuentes on 07/08/2020.
 */

@BindingAdapter("reverse_visibility")
fun View.reverseVisibility(visibility: ObservableInt) {
    this.visibility = if (visibility.get() == View.VISIBLE) View.INVISIBLE else View.VISIBLE
}

@BindingAdapter("text_from_num_card")
fun TextView.textFromIntInt(number: Int) {
    if(number > 0) this.text = number.toCardString()
}

@BindingAdapter("image")
fun ImageView.setImageViewResource(resource: Int) {
    this.setImageResource(resource)
}

private fun Int.toCardString(): String {
    return when (this) {
        11 -> "J"
        12 -> "Q"
        13 -> "K"
        14 -> "A"
        else -> "$this"
    }
}