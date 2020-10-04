package com.jfuentes.warofsuits.domain.usecase

import com.jfuentes.warofsuits.domain.GameRepository
import com.jfuentes.warofsuits.domain.model.Card

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
class GetSetOfCardsUseCase(private val repository: GameRepository) {

    suspend fun getSetOfCardsSplit(): List<List<Card>> {
        val listShuffled = repository.getSetOfCardsListShuffled()
        val numHalfList = getHalfListNumber(listShuffled)

        val firstHalf = listShuffled.slice(0..numHalfList)
        val secondHalf = listShuffled.slice(firstHalf.size until listShuffled.size)

        return listOf(firstHalf, secondHalf)
    }

    private fun getHalfListNumber(listShuffled: List<Card>): Int {
        return (listShuffled.size - 1) / DIVIDER_NUM
    }

    companion object{
        private const val DIVIDER_NUM = 2
    }
}