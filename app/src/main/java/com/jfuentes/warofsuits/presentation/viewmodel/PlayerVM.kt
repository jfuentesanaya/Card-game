package com.jfuentes.warofsuits.presentation.viewmodel

import android.app.Application
import android.view.View
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import com.jfuentes.warofsuits.R
import com.jfuentes.warofsuits.domain.model.Player

/**
 * Created by Juan Fuentes on 08/08/2020.
 */
class PlayerVM(application: Application, val player: Player) : AndroidViewModel(application) {

    val winMessage = ObservableField(getApplication<Application>().getString(R.string.win))
    val winMessageVisibility = ObservableInt(View.INVISIBLE)
    val cardsWonText = ObservableField("")

    fun win() {
        winMessageVisibility.set(View.VISIBLE)
        cardsWonText.set(
            String.format(
                getApplication<Application>().getString(R.string.games_won),
                player.discardedCardsList.size
            )
        )
    }

    fun gameWinner() {
        winMessage.set(getApplication<Application>().getString(R.string.game_winner))
    }

    fun lose() {
        winMessageVisibility.set(View.INVISIBLE)
    }

    fun reset() {
        winMessage.set(getApplication<Application>().getString(R.string.win))
        winMessageVisibility.set(View.INVISIBLE)
        cardsWonText.set("")
    }
}