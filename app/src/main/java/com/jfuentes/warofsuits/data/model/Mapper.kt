package com.jfuentes.warofsuits.data.model

import com.jfuentes.warofsuits.domain.model.Card
import com.jfuentes.warofsuits.domain.model.PokerSuit

/**
 * Created by Juan Fuentes on 06/08/2020.
 */
fun CardEntity.toCard() : Card{
    return Card(num, PokerSuit.valueOf(suit))
}