package com.jfuentes.warofsuits.domain

import com.jfuentes.warofsuits.data.model.Card
import com.jfuentes.warofsuits.data.model.Suit

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
interface GameRepository {

    suspend fun getSetOfCardsList(): List<Card>
    suspend fun getSetOfCardsListShuffled(): List<Card>
    suspend fun getSuitPriority(): List<Suit>
}