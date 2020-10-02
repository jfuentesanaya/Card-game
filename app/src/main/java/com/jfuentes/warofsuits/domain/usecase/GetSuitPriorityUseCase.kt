package com.jfuentes.warofsuits.domain.usecase

import com.jfuentes.warofsuits.domain.model.Suit

/**
 * Created by Juan Fuentes on 02/10/2020.
 */
class GetSuitPriorityUseCase {

    fun getSuitPriority(): List<Suit> {
        return Suit.values().toMutableList().shuffled()
    }
}