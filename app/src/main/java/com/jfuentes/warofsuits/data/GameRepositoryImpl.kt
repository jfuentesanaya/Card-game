package com.jfuentes.warofsuits.data

import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.data.local.CardDao
import com.jfuentes.warofsuits.data.model.toCard
import com.jfuentes.warofsuits.data.model.toCardEntity
import com.jfuentes.warofsuits.domain.model.Suit
import com.jfuentes.warofsuits.domain.GameRepository

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class GameRepositoryImpl(private val cardDao: CardDao) : GameRepository {

    override suspend fun getSetOfCardsList(): List<Card> {
        return cardDao.getAll().map { it.toCard() }
    }

    override suspend fun getSetOfCardsListShuffled(): List<Card> {
        return getSetOfCardsList().shuffled()
    }

    override suspend fun createSetOfCards() {
        cardDao.insertAll(createSet().map { it.toCardEntity() })
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