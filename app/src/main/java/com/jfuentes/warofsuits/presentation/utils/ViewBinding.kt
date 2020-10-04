package com.jfuentes.warofsuits.presentation.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableInt
import com.jfuentes.warofsuits.R
import com.jfuentes.warofsuits.domain.model.PokerSuit

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
fun ImageView.setImageViewResource(suit: PokerSuit?) {
    val resource = when (suit) {
        PokerSuit.CLUBS -> R.drawable.ic_club
        PokerSuit.DIAMONDS -> R.drawable.ic_diamond
        PokerSuit.HEARTS -> R.drawable.ic_heart
        PokerSuit.SPADES -> R.drawable.ic_spade
        else ->  R.drawable.ic_spade
    }
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