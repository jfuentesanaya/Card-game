package com.jfuentes.warofsuits.data

import com.jfuentes.warofsuits.data.local.CardDao
import com.jfuentes.warofsuits.data.model.CardEntity
import com.jfuentes.warofsuits.data.model.toCard
import com.jfuentes.warofsuits.domain.GameRepository
import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.domain.model.PokerSuit

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class GameRepositoryImpl(private val cardDao: CardDao) : GameRepository {

    override suspend fun getSetOfCardsListShuffled(): List<Card> {
        return getSetOfCardsList().shuffled()
    }

    override suspend fun createSetOfCards() {
        cardDao.insertAll(createSet())
    }

    override suspend fun getSetOfCardsList(): List<Card> {
        var cards = cardDao.getAll()
        if (cards.isEmpty()) {
            createSetOfCards()
            cards = cardDao.getAll()
        }

        return cards.map { it.toCard() }
    }

    fun createSet(): List<CardEntity> {
        return (MIN_CARD..MAX_CARD).map {
            PokerSuit.values().map { it2 -> CardEntity(it, it2.suitType) }
        }.flatten()
    }

    companion object {
        private const val MIN_CARD = 2
        private const val MAX_CARD = 14
    }
}