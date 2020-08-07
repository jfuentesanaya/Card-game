package com.jfuentes.warofsuits.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfuentes.warofsuits.domain.usecase.GetSetOfCardsUseCase
import kotlinx.coroutines.launch

/**
 * Created by Juan Fuentes on 07/08/2020.
 */
class MainVM(private val getSetOfCardsUseCase: GetSetOfCardsUseCase) : ViewModel() {


    fun onClickStartGame() {
        viewModelScope.launch {
            val list = getSetOfCardsUseCase.getSetOfCardsShuffled()
            Log.d("Cards: ", list.toString())
        }
    }

}