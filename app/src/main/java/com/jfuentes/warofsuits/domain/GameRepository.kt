package com.jfuentes.warofsuits.domain

import com.jfuentes.warofsuits.domain.model.Card

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
interface GameRepository {

    suspend fun getSetOfCardsListShuffled(): List<Card>
    suspend fun getSetOfCardsList(): List<Card>
    suspend fun createSetOfCards()
}