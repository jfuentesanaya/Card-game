package com.jfuentes.warofsuits.presentation.viewmodel

import android.app.Application
import android.util.Log
import android.view.View
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfuentes.warofsuits.R
import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.domain.model.Player
import com.jfuentes.warofsuits.domain.usecase.GetHighestCardUseCase
import com.jfuentes.warofsuits.domain.usecase.GetSetOfCardsUseCase
import kotlinx.coroutines.launch
import org.koin.dsl.koinApplication

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
class GameVM(
    private val appication:Application,
    private val getSetOfCardsUseCase: GetSetOfCardsUseCase,
    private val getHighestCardUseCase: GetHighestCardUseCase
) : AndroidViewModel(appication) {

    val player1 = Player("Player 1")
    val player2 = Player("Player 2")

    val cardToPlay1 = ObservableField<Card>()
    val cardToPlay2 = ObservableField<Card>()

    val player1WinMessageVisibility = ObservableInt(View.INVISIBLE)
    val buttonEnable = ObservableBoolean(true)

    val player1CardsWon = ObservableField("")
    val player2CardsWon = ObservableField("")

    init {


        viewModelScope.launch {
            val listOfSplitCards = getSetOfCardsUseCase.getSetOfCardsSplit()
            player1.playCardsList = listOfSplitCards.first().toMutableList()
            player2.playCardsList = listOfSplitCards.last().toMutableList()
            nextRound()
        }
    }

    fun onNextRoundClick() {
        if (player1.playCardsList.isNotEmpty() && player2.playCardsList.isNotEmpty()) {
            nextRound()
        } else {
            buttonEnable.set(false)
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
                player1.discardedCardsList.add(card1)
                player1WinMessageVisibility.set(View.VISIBLE)
                player1CardsWon.set(String.format(getText(R.string.games_won), player1.discardedCardsList.size))
            }
            card2 -> {
                player2.discardedCardsList.add(card2)
                player1WinMessageVisibility.set(View.INVISIBLE)
                player2CardsWon.set(String.format(getText(R.string.games_won), player2.discardedCardsList.size))
            }
            else -> Log.e("Error", "This case shouldn't happen, some player has to win")
        }
    }

    val getSuitPriority =  getText(R.string.sut_priority) + getSetOfCardsUseCase.getSuitPriority().toString()


    private fun getText(@StringRes idRes: Int): String {
        return appication.baseContext.getString(idRes)
    }
}

@BindingAdapter("reverse_visibility")
fun View.reverseVisibility(visibility: ObservableInt) {
    this.visibility = if (visibility.get() == View.VISIBLE) View.INVISIBLE else View.VISIBLE
}