package com.jfuentes.warofsuits.domain.usecase

import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.domain.model.PokerSuit

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class GetHighestCardUseCase {

    fun getHighestCard(card1: Card, card2: Card, suitPriority: List<PokerSuit>): Card {
        return when {
            card1.number > card2.number -> card1
            card1.number < card2.number -> card2
            else -> getHighestSuit(card1, card2, suitPriority)
        }
    }

    private fun getHighestSuit(card1: Card, card2: Card, suitPriority: List<PokerSuit>): Card {
        return when {
            suitPriority.indexOf(card1.suit) < suitPriority.indexOf(card2.suit) -> card1
            else -> card2
        }
    }
}