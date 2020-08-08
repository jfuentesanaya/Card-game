package com.jfuentes.warofsuits.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.jfuentes.warofsuits.R
import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.domain.model.Player
import com.jfuentes.warofsuits.domain.model.Suit
import com.jfuentes.warofsuits.domain.model.clearCards
import com.jfuentes.warofsuits.domain.usecase.GetHighestCardUseCase
import com.jfuentes.warofsuits.domain.usecase.GetSetOfCardsUseCase
import com.jfuentes.warofsuits.presentation.utils.DialogHelper.createDialog
import kotlinx.coroutines.launch

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
class GameVM(
    private val appication:Application,
    private val getSetOfCardsUseCase: GetSetOfCardsUseCase,
    private val getHighestCardUseCase: GetHighestCardUseCase
) : AndroidViewModel(appication) {

    private val player1 = Player("Player 1")
    private val player2 = Player("Player 2")

    val cardToPlay1 = ObservableField<Card>()
    val cardToPlay2 = ObservableField<Card>()

    val discardCardPlayer1Visibility = ObservableInt(View.INVISIBLE)
    val discardCardPlayer2Visibility = ObservableInt(View.INVISIBLE)

    val cardPlayerVisibility = ObservableInt(View.INVISIBLE)

    val buttonEnable = ObservableBoolean(true)

    val player1VM = PlayerVM(appication, player1)
    val player2VM = PlayerVM(appication, player2)

    var suitPriorityVM = ObservableField<SuitPriorityVM>()

    init {
       startGame()
    }

    private fun startGame() {
        viewModelScope.launch {
            suitPriorityVM.set(SuitPriorityVM(getSetOfCardsUseCase.getSuitPriority()))
            val listOfSplitCards = getSetOfCardsUseCase.getSetOfCardsSplit()
            player1.playCardsList = listOfSplitCards.first().toMutableList()
            player2.playCardsList = listOfSplitCards.last().toMutableList()
        }
    }

    fun onNextRoundClick(view: View) {
        if (player1.playCardsList.isNotEmpty() && player2.playCardsList.isNotEmpty()) {
            cardPlayerVisibility.set(View.VISIBLE)
            nextRound()
        } else {
            cardPlayerVisibility.set(View.INVISIBLE)
            buttonEnable.set(false)
            player1VM.gameWinner()
            player2VM.gameWinner()
            showRestartDialog(view.context)
        }
    }

    private fun nextRound() {
        getCardFromList(player1.playCardsList, cardToPlay1)
        getCardFromList(player2.playCardsList, cardToPlay2)
        getWinner()
    }

    private fun getCardFromList(
        playerList: MutableList<Card>,
        cardToPlay: ObservableField<Card>
    ) {
        playerList.first().apply {
            cardToPlay.set(this)
            playerList.remove(this)
        }
    }

    private fun getWinner() {
        val card1 = cardToPlay1.get()
        val card2 = cardToPlay2.get()
        if (card1 == null || card2 == null) {
            throw IllegalArgumentException("Both players has to have a card to play")
        } else {
            val winnerCard = getHighestCardUseCase.getHighestCard(
                card1,
                card2,
                getSetOfCardsUseCase.getSuitPriority()
            )

            setWinnerVisibility(winnerCard, card1, card2)
        }
    }

    private fun setWinnerVisibility(winnerCard: Card, card1: Card, card2: Card) {
        when (winnerCard) {
            card1 -> {
                winnerVisibility(player1, card1, discardCardPlayer1Visibility, true)
            }
            card2 -> {
                winnerVisibility(player2, card2, discardCardPlayer2Visibility, false)
            }
            else -> Log.e("Error", "This case shouldn't happen, some player has to win")
        }
    }

    private fun winnerVisibility(player: Player, card: Card, discardCardVisibility: ObservableInt, isPlayer1Winner: Boolean) {
        player.discardedCardsList.add(card)
        discardCardVisibility.set(View.VISIBLE)

        if (isPlayer1Winner) {
            player1VM.win()
            player2VM.lose()
        } else {
            player1VM.lose()
            player2VM.win()
        }
    }

    private fun showRestartDialog(context: Context) {
        context.createDialog(
            R.string.restart_game,
            R.string.yes,
            R.string.no,
            DialogInterface.OnClickListener { _, _ -> resetGame() },
            false
        ).show()
    }

    private fun resetGame() {
        player1.clearCards()
        player2.clearCards()
        buttonEnable.set(true)
        discardCardPlayer1Visibility.set(View.INVISIBLE)
        discardCardPlayer2Visibility.set(View.INVISIBLE)
        player1VM.reset()
        player2VM.reset()
        startGame()
    }
}