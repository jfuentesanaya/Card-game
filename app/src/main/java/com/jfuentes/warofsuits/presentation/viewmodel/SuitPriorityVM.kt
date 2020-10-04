package com.jfuentes.warofsuits.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.jfuentes.warofsuits.domain.model.PokerSuit

/**
 * Created by Juan Fuentes on 08/08/2020.
 */
class SuitPriorityVM(prioritySuits: List<PokerSuit>) : ViewModel() {

    val firstImage = prioritySuits[0]
    val secondImage = prioritySuits[1]
    val thirdImage = prioritySuits[2]
    val fourthImage = prioritySuits[3]
}