package com.jfuentes.warofsuits.domain.usecase

import com.jfuentes.warofsuits.domain.model.PokerSuit

/**
 * Created by Juan Fuentes on 02/10/2020.
 */
class GetSuitPriorityUseCase {

    fun getSuitPriority(): List<PokerSuit> {
        return PokerSuit.values().toMutableList().shuffled()
    }
}