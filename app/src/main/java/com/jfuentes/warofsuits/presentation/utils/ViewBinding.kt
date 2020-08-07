package com.jfuentes.warofsuits.presentation.utils

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableInt

/**
 * Created by Juan Fuentes on 07/08/2020.
 */

@BindingAdapter("reverse_visibility")
fun View.reverseVisibility(visibility: ObservableInt) {
    this.visibility = if (visibility.get() == View.VISIBLE) View.INVISIBLE else View.VISIBLE
}