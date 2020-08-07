package com.jfuentes.warofsuits.presentation.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.domain.model.Player
import com.jfuentes.warofsuits.domain.usecase.GetSetOfCardsUseCase
import kotlinx.coroutines.launch

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
class GameVM(private val getSetOfCardsUseCase: GetSetOfCardsUseCase) : ViewModel() {

    val player1 = Player("Player 1")
    val player2 = Player("Player 2")

    val cardToPlay1 = ObservableField("")
    val cardToPlay2 = ObservableField("")


    init {
        viewModelScope.launch {
            val listOfSplitCards = getSetOfCardsUseCase.getSetOfCardsSplit()
            player1.playCardsList = listOfSplitCards.first().toMutableList()
            player2.playCardsList = listOfSplitCards.last().toMutableList()
            nextRound()
        }
    }

    fun onNextRoundClick() {
        nextRound()
    }

    private fun nextRound() {
        getCardFromList(player1.playCardsList, cardToPlay1)
        getCardFromList(player2.playCardsList, cardToPlay2)
    }

    private fun getCardFromList(
        playerList: MutableList<Card>,
        cardToPlay: ObservableField<String>
    ) {
        playerList.first().apply {
            cardToPlay.set(this.toString())
            playerList.remove(this)
        }
    }
}