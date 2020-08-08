package com.jfuentes.warofsuits.data

import com.jfuentes.warofsuits.data.local.CardDao
import com.jfuentes.warofsuits.data.model.CardEntity
import com.jfuentes.warofsuits.data.model.toCard
import com.jfuentes.warofsuits.domain.GameRepository
import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.domain.model.Suit

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class GameRepositoryImpl(private val cardDao: CardDao) : GameRepository {

    override suspend fun getSetOfCardsList(): List<Card> {
        val cards = cardDao.getAll()
        if (cards.isEmpty()) {
            createSetOfCards()
        }

        return cards.map { it.toCard() }
    }

    override suspend fun getSetOfCardsListShuffled(): List<Card> {
        return getSetOfCardsList().shuffled()
    }

    override suspend fun createSetOfCards() {
        cardDao.insertAll(createSet())
    }

     fun createSet(): MutableList<CardEntity> {
        val listOfCards = mutableListOf<CardEntity>()

        for (num in 2..14) {
            Suit.values().forEach {
                listOfCards.add(
                    CardEntity(num, it.suitType)
                )
            }
        }
        return listOfCards
    }
}