package com.jfuentes.warofsuits.domain.usecase

import com.jfuentes.warofsuits.domain.GameRepository
import com.jfuentes.warofsuits.domain.model.Card

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class GetSetOfCardsUseCase(private val repository: GameRepository) {

    suspend fun getSetOfCardsSplit(): List<List<Card>> {
        val listShuffled = repository.getSetOfCardsListShuffled()
        val halfList = (listShuffled.size - 1) / 2

        val firstHalf = listShuffled.slice(0..halfList)
        val secondHalf = listShuffled.slice(halfList + 1 until listShuffled.size)

        return listOf(firstHalf, secondHalf)
    }
}