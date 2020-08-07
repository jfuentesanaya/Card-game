package com.jfuentes.warofsuits.domain.usecase

import com.jfuentes.warofsuits.domain.GameRepository
import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.domain.model.Suit

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class GetSetOfCardsUseCase(private val repository: GameRepository) {

    suspend fun getSetOfCardsShuffled(): List<Card> {
        return repository.getSetOfCardsListShuffled()
    }

    fun getSuitPriority(): List<Suit> {
        return Suit.values().toMutableList().shuffled()
    }
}