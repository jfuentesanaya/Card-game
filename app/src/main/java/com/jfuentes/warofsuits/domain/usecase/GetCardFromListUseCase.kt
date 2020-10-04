package com.jfuentes.warofsuits.domain.usecase

import com.jfuentes.warofsuits.domain.model.Card

/**
 * Created by Juan Fuentes on 04/10/2020.
 */
class GetCardFromListUseCase {

    fun getCardFromList(
        playerList: MutableList<Card>
    ): Card {
        playerList.first().let {
            playerList.remove(it)
            return it
        }
    }
}