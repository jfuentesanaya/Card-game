package com.jfuentes.warofsuits.data

import com.jfuentes.warofsuits.data.model.Card
import com.jfuentes.warofsuits.data.model.Suit
import com.jfuentes.warofsuits.domain.GameRepository

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class GameRepositoryImpl : GameRepository {

    override suspend fun getSetOfCardsList(): List<Card> {
        return createSet()
    }

    override suspend fun getSetOfCardsListShuffled(): List<Card> {
        return createSet().shuffled()
    }

    override suspend fun getSuitPriority(): List<Suit> {
        return Suit.values().toMutableList().shuffled()
    }


    private fun createSet(): MutableList<Card> {
        val listOfCards = mutableListOf<Card>()

        for (num in 2..14) {
            Suit.values().forEach { listOfCards.add(
                Card(num, it)
            ) }
        }
        return listOfCards
    }
}