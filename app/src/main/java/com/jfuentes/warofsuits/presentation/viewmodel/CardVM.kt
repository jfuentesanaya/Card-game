package com.jfuentes.warofsuits.presentation.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jfuentes.warofsuits.domain.model.Card

/**
 * Created by Juan Fuentes on 08/08/2020.
 */
class CardVM (card: ObservableField<Card>): ViewModel(){


    val name = card.get()?.number.toString() ?:""
}