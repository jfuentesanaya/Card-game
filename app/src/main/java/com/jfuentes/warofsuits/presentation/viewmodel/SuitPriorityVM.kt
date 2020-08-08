package com.jfuentes.warofsuits.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.jfuentes.warofsuits.domain.model.Suit
import com.jfuentes.warofsuits.domain.model.toImage

/**
 * Created by Juan Fuentes on 08/08/2020.
 */
class SuitPriorityVM(prioritySuits: List<Suit>) : ViewModel() {

    val firstImage = prioritySuits[0].toImage()
    val secondImage = prioritySuits[1].toImage()
    val thirdImage = prioritySuits[2].toImage()
    val fourthImage = prioritySuits[3].toImage()
}